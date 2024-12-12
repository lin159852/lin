package uuu.mod11.service;

import java.util.ResourceBundle;

public class RDBConnection {
	private static final String DRIVER; //"com.mysql.cj.jdbc.Driver"; //MySQL 8.0.x
	private static final String URL; //"jdbc:mysql://localhost:3306/testDB";
	private static final String USER_ID; //"root";
	private static final String PWD; //"1234";
	
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
	
}
