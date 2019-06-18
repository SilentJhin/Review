package com.itheima.demo02_DBCP;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;

/*
 * DBCP连接池
 */

public class DBCPUtils {
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/day04";
	private static String username = "root";
	private static String password = "admin";
	
	private static BasicDataSource ds = new BasicDataSource();
	
	static {
		ds.setDriverClassName(driverName);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
	}
	
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	public static void closeAll(Connection conn,Statement st,ResultSet rs) {
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}










