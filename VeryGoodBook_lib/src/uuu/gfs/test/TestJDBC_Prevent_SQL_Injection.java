package uuu.gfs.test;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.gfs.entity.Customer;
import uuu.gfs.entity.VIP;

public class TestJDBC_Prevent_SQL_Injection {
	
	private static final String DRIVER;  //"com.mysql.cj.jdbc.Driver"; //MySQL 8.0.x
	private static final String URL;     //"jdbc:mysql://localhost:3306/testDB";
	private static final String USER_ID; //"root";
	private static final String PWD;     //"1234";
	
	static {
		// From properties file
		ResourceBundle bundle = ResourceBundle.getBundle("uuu.gfs.service.mysql_jdbc");
		DRIVER = bundle.getString("jdbc.driver");
		URL = bundle.getString("jdbc.url");
		USER_ID = bundle.getString("jdbc.userid");
		PWD = bundle.getString("jdbc.pwd");
		
//		System.out.printf("DRIVER : %s\n", DRIVER);
//		System.out.printf("URL : %s\n", URL);
//		System.out.printf("USER_ID : %s\n", USER_ID);
//		System.out.printf("PWD : %s\n", PWD);
	}
	
	private static final String SELECT_CUSTOMER_BY_ID="SELECT id, email, phone, password, name, gender, birthday,"
			+ " address, subscribed, discount FROM customers \r\n"
			+ "WHERE id=? OR email=? OR phone=? AND password=?";
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("請輸入id:");
		String id = scanner.next();
		System.out.println("請輸入密碼");
		String password = scanner.next();
		scanner.close();
		
		//final String SELECT_CUSTOMER_BY_ID = String.format(TestJDBC_Prevent_SQL_Injection.SELECT_CUSTOMER_BY_ID, id, password);
		
		//SQL Injection: 'OR''='
		
		//完成JDBC來查詢客戶
		//1. 載入JDBC Driver
		try {
			Class.forName(DRIVER);
			
			//2. 建立連線Connection
			try {
				Connection connection = DriverManager.getConnection(URL, USER_ID, PWD);
				//System.out.printf("connection: %s\n", connection.getCatalog()); //顯示connection的資料庫名稱
				
				//3. 建立Statement指令物件，改用PreparedStatement以避免SQL Injection攻擊
				PreparedStatement pstmt = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
				//3.1 傳入?的值
				pstmt.setString(1, id);
				pstmt.setString(2, id);
				pstmt.setString(3, id);
				pstmt.setString(4, password);
				
				//4. 執行SELECT指令
				ResultSet rs = pstmt.executeQuery();
				
				//5. 處理rs中得到的結果
				while(rs.next()) {
					Customer c;
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
					
					System.out.println(c);
				}
				
				//6. close各物件
				rs.close();
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				//System.err.println("建立連線失敗");
				Logger.getLogger("").log(Level.SEVERE, "建立連線失敗", e);
			}
			
		} catch (ClassNotFoundException e) {
			//System.err.println("無法載入JDBC Driver: " + DRIVER);
			Logger.getLogger("").log(Level.SEVERE, "無法載入JDBC Driver", e);
		}
		
		
	}

}
