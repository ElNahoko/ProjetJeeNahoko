package com.mvc.util;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class DBConnection {
protected static Connection cx ;
	
	public static Connection createConnection() {
		
		if(cx != null) {
			
			return cx ;
		}
		
		InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("/db.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
			String driver  = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password =properties.getProperty("password");
			Class.forName(driver);
			cx = DriverManager.getConnection(url, user, password);
			System.out.println("Ca Marche");
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		return cx;		
	}	
	public static void Disconnect() {
		
		if(cx== null) {
			
			return ;
		}
		try {
			cx.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		 
	}
}
