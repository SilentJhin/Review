package com.itheima.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.itheima.demo02_DBCP.DBCPUtils;

public class Test_DBCPUtils {
	@Test
	public void query() throws SQLException{
		Connection conn = DBCPUtils.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from category");
		while(rs.next()) {
			String cid = rs.getString("cid");
			String cname = rs.getString("cname");
			System.out.println("DBCPUtils:"+cid+"  "+cname);
		}
		DBCPUtils.closeAll(conn, st, rs);
	}
}
