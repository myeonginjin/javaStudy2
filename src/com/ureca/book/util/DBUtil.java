package com.ureca.book.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/urecadb?serverTimezone=UTC";
	private static final String ID = "ureca";
	private static final String PASSWORD = "ureca";
	
	private static DBUtil instance = new DBUtil(); 
			
	private DBUtil() {
		
		//이제는 이거 안해줘도됨 Class.forName
//		try {
//			Class.forName(DRIVER);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	};
	
	public static DBUtil getInstance () {
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL,ID,PASSWORD);
	}	
	
	public void close(AutoCloseable... ac) {
		for(AutoCloseable a :ac) {
			try {
				if(a!=null) a.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

}
