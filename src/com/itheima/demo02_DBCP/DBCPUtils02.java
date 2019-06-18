package com.itheima.demo02_DBCP;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

/*
 * DBCP连接池
 */

public class DBCPUtils02 {
	
	private static DataSource ds = null;
	
	static {
		try {
			Properties ps = new Properties();
			ps.load(DBCPUtils02.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
			ds = BasicDataSourceFactory.createDataSource(ps);
		} catch (Exception e) {
			// TODO: handle exception
		}
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










