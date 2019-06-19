package com.itmeima.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itmeima.dataSource.MyDataSource;
import com.mysql.jdbc.Connection;

public class DataSourceTest {
	public static void main(String[] args) throws SQLException {
		int size = MyDataSource.getPoolSize();
		System.out.println(size);
		for(int i=0;i<10;i++) {
			Connection conn = MyDataSource.getConnection();
//			System.out.println(conn);
			conn.close();// 此时应该把连接放回池里
		}
		int size2 = MyDataSource.getPoolSize();
		System.out.println(size2);
	}
}








