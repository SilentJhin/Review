package com.itheima.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.itheima.demo01_JDBC.JDBCUtils;
import com.itheima.demo02_DBCP.DBCPUtils;

public class Test_02_DBJPUtils {
	@Test
	public void test() throws Exception{
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//1 加载驱动
			//2 获取连接
			conn = DBCPUtils.getConnection();
			//3 获取执行SQL的对象
			String sql = "select * from category";
			psmt = conn.prepareStatement(sql);
			//4	执行SQL
			rs = psmt.executeQuery();
			//5 处理结果
			while(rs.next()) {
				String cid = rs.getString("cid");
				String cname = rs.getString("cname");
				System.out.println("DBCPUtils:"+cid+"  "+cname);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			//6 关闭资源
			JDBCUtils.closeAll(conn, psmt, rs);
		}
	}
}
