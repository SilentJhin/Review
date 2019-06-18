package com.itheima.demo03_C3P0;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * C3P0连接池
 */
public class C3P0Utils {
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	
	static {
		try {
			ds.setDriverClass("com.mysql.jdbc.Driver");
			ds.setJdbcUrl("jdbc:mysql://localhost:3306/day04");
			ds.setUser("root");
			ds.setPassword("admin");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	public static void closeAll(Connection conn,Statement st,ResultSet rs){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
