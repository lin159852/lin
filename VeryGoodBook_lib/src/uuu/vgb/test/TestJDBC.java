package uuu.vgb.test;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.vgb.entity.Customer;

/**
 * 本測試程式僅提供測試參考，未完成SQL Injection防範及各種錯誤處理拋出
 */
public class TestJDBC {
	
	private static final String DRIVER;  //"com.mysql.cj.jdbc.Driver"; //MySQL 8.0.x
	private static final String URL;     //"jdbc:mysql://localhost:3306/testDB";
	private static final String USER_ID; //"root";
	private static final String PWD;     //"1234";
	
	static {
		// From properties file
		ResourceBundle bundle = ResourceBundle.getBundle("uuu.vgb.service.mysql_jdbc");
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
			+ "WHERE email='%s' AND password='%s'";
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("請輸入email:");
		String email = scanner.next();
		System.out.println("請輸入密碼");
		String password = scanner.next();
		scanner.close();
		
		final String SELECT_CUSTOMER_BY_ID = String.format(TestJDBC.SELECT_CUSTOMER_BY_ID, email, password);
		
		//SQL Injection: 'OR''='
		
		//完成JDBC來查詢客戶
		//1. 載入JDBC Driver
		try {
			Class.forName(DRIVER);
			
			//2. 建立連線Connection
			try {
				Connection connection = DriverManager.getConnection(URL, USER_ID, PWD);
				//System.out.printf("connection: %s\n", connection.getCatalog()); //顯示connection的資料庫名稱
				
				//3. 建立Statement指令物件
				Statement stmt = connection.createStatement();
				
				//4. 執行SELECT指令
				ResultSet rs = stmt.executeQuery(SELECT_CUSTOMER_BY_ID);
				
				//5. 處理rs中得到的結果
				while(rs.next()) {
					Customer c = new Customer();
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
				stmt.close();
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
