package uuu.gfs.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.gfs.exception.VGBException;

public class RDBConnection {
	private static final String DRIVER; //"com.mysql.cj.jdbc.Driver"; //MySQL 8.0.x
	private static final String URL; //"jdbc:mysql://localhost:3306/testDB";
	private static final String USER_ID; //"root";
	private static final String PWD; //"1234";
	
	static {
		// From properties file
		ResourceBundle bundle = ResourceBundle.getBundle("uuu.gfs.service.mysql_jdbc");
		DRIVER = bundle.getString("jdbc.driver");
		URL = bundle.getString("jdbc.url");
		USER_ID = bundle.getString("jdbc.userid");
		PWD = bundle.getString("jdbc.pwd");
		// For test
//		System.out.printf("DRIVER : %s\n", DRIVER);
//		System.out.printf("URL : %s\n", URL);
//		System.out.printf("USER_ID : %s\n", USER_ID);
//		System.out.printf("PWD : %s\n", PWD);
	}
	
	public static Connection getConnection() throws VGBException{
		//1. 載入JDBC Driver
		try {
			Class.forName(DRIVER);
			//2. 建立連線
			try {
				Connection connection = DriverManager.getConnection(URL, USER_ID, PWD);
				return connection;
			} catch (SQLException e) {
				throw new VGBException("建立連線失敗", e);
			}
		} catch (ClassNotFoundException e) {
			throw new VGBException("無法載入JDBC Driver", e);
		}
	}
	
}
