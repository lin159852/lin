package uuu.vgb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ResourceBundle;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VIP;
import uuu.vgb.exception.VGBDataInvalidException;
import uuu.vgb.exception.VGBException;

class CustomersDAO {
	private static final String SELECT_CUSTOMER_BY_ID;
	private static final String INSERT_CUSTOMER;
	
	static {
			ResourceBundle bundle = ResourceBundle.getBundle("uuu.vgb.service.mysql_jdbc");
			SELECT_CUSTOMER_BY_ID = bundle.getString("jdbc.select_customer_by_id"); //密碼在CustomerService中確認
			INSERT_CUSTOMER = bundle.getString("jdbc.insert_customer");
	}
	
	Customer selectCustomerById(String id_email_phone) throws VGBException {
		
//		try {
//			Class.forName(DRIVER); //1. 改放在RDBConnection
			
			//2. 建立連線Connection
			try(
					Connection connection = RDBConnection.getConnection(); //建立連線的代入值改到RDBConnection中代入
					//System.out.printf("connection: %s\n", connection.getCatalog()); //顯示connection的資料庫名稱
					//3. 建立Statement指令物件，改用PreparedStatement以避免SQL Injection攻擊
					PreparedStatement pstmt = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
			) {
					//3.1 傳入?的值
					pstmt.setString(1, id_email_phone);
					pstmt.setString(2, id_email_phone);
					pstmt.setString(3, id_email_phone);
					try(
						//4. 執行SELECT指令
						ResultSet rs = pstmt.executeQuery();
					){
						Customer c = null;
						//5. 處理rs中得到的結果
						while(rs.next()) {
							int discount = rs.getInt("discount");
							if(discount>0) {
								c = new VIP();
								((VIP)c).setDiscount(discount);
							}else {
								c = new Customer();
							}
							
							c.setId(rs.getString("id"));
							c.setEmail(rs.getString("email"));
							c.setPhone(rs.getString("phone"));
							c.setPassword(rs.getString("password"));
							c.setName(rs.getString("name"));
							c.setGender(rs.getString("gender").charAt(0));
							c.setBirthday(rs.getString("birthday"));
							c.setAddress(rs.getString("address"));
							c.setSubscribed(rs.getBoolean("subscribed"));
							
							//System.out.println(c); //for testing
						}
						
						//6. close各物件，回傳c
						//rs.close();         //靠try-with-resources的自動finally子句關閉
						//pstmt.close();      //靠try-with-resources的自動finally子句關閉
						//connection.close(); //靠try-with-resources的自動finally子句關閉
						return c;
					 }
				} catch (SQLException e) {
				throw new VGBException("登入失敗, id或email或電話不正確", e);
			}
			
//		} catch (ClassNotFoundException e) {
//			System.err.println("無法載入JDBC Driver: " + DRIVER);
//			Logger.getLogger("").log(Level.SEVERE, "無法載入JDBC Driver", e);
//		}
			
	}
	
	void insert(Customer c) throws VGBException{
		try(
				//1. 載入Driver   2. 建立連線
				Connection connection = RDBConnection.getConnection();
				//3. 建立Statement指令物件，改用PreparedStatement以避免SQL Injection攻擊
				PreparedStatement pstmt = connection.prepareStatement(INSERT_CUSTOMER);
		) {
				//3.1 傳入?的值
				pstmt.setString(1, c.getId());
				pstmt.setString(2, c.getEmail());
				pstmt.setString(3, c.getPhone());
				pstmt.setString(4, c.getPassword());
				pstmt.setString(5, c.getName());
				pstmt.setString(6, String.valueOf(c.getGender()));
				pstmt.setString(7, String.valueOf(c.getBirthday()));
				
				pstmt.setString(8, c.getAddress());
				pstmt.setBoolean(9, c.isSubscribed());
				
				//4. 執行INSERT指令
				pstmt.executeUpdate();
			} catch (SQLIntegrityConstraintViolationException e) {
				if (e.getMessage().lastIndexOf("PRIMARY")>0) {
					throw new VGBDataInvalidException("身份證號已重複或為空值", e);
				} else if (e.getMessage().lastIndexOf("email_UNIQUE")>0) {
					throw new VGBDataInvalidException("Email已重複或為空值", e);
				} else if (e.getMessage().lastIndexOf("phone_UNIQUE")>0) {
					throw new VGBDataInvalidException("手機號碼已重複或為空值", e);
				} else
					throw new VGBException("新增客戶失敗", e);
			} catch (SQLException e) {
				throw new VGBException("新增客戶失敗", e);
			}
	}
}
