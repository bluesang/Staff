package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private final String driverClassName = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://127.0.0.1:3306/staff?useUnicode=true&characterEncoding=euckr";
	private final String username = "root";
	private final String password = "java0000";
	
	public Connection getConnection(){	
		Connection conn = null;
		try{
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url,username,password);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(conn + "<--BoardDao getConnection()");
		return conn;
	}
}
