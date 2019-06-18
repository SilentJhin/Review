package com.itheima.demo01_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * JDBCUtils 连接池
 */

public class JDBCUtils {
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/day04";
	private static String username = "root";
	private static String password = "admin";
	private static ArrayList<Connection> conns = new ArrayList<Connection>();
	//静态代码块加载驱动
	static {
		// 加载驱动
		try {
			Class.forName(driverName);
			for(int i=0;i<10;i++) {
				Connection conn = DriverManager.getConnection(url, username, password);
				conns.add(conn);
			}
		} catch (Exception e) {
			throw new RuntimeException("驱动加载失败，请检查驱动");
		}
	}
	
	//获取连接
	public static Connection getConnection() throws Exception{
		Connection conn = conns.remove(0);
		return conn;
	}
	
	//关闭资源
	public static void closeAll(Connection conn, Statement st, ResultSet rs) {
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
