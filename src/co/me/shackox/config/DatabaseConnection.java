package co.me.shackox.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {
	public Connection getConnection() throws Exception {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.1.17:1521:XE";
			Properties access = new Properties();
			access.put("user", "HR");
			access.put("password", "hr");
			Connection conn = DriverManager.getConnection(url, access);
			System.out.println("Corrected connection to database \n info: " + conn);
			return conn;
		} catch (Exception e) {
			throw e;
		}
	}
}
