package com.itmeima.dataSource;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.itmeima.utils.JDBCUtil;
import com.mysql.jdbc.Connection;

/*
 * 自定义连接池
 */
public class MyDataSource {
	//定义一个池，用于存放连接
	private static List<Connection> pool = 
			Collections.synchronizedList(new ArrayList<Connection>());
	//使用静态代码块给池中加入连接
	static {
		for(int i=0;i<10;i++) {
			Connection conn = (Connection) JDBCUtil.getConnection();
			pool.add(conn);
		}
	}
	 
	//获取连接
	public static Connection getConnection() {
		final Connection conn = pool.remove(0);
		//创建代理对象
		Connection proxyConn = (Connection)Proxy.newProxyInstance(
				conn.getClass().getClassLoader(), new Class[] { Connection.class }, 
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Object reValue = null;
						if("close".equals(method.getName())) {
							//不能直接关闭
							pool.add(conn);
						} else {
							reValue = method.invoke(conn, args);
						}
						return reValue;
					}
				});
		return proxyConn;
	}
	
	//获取池中连接数
	public static int getPoolSize() {
		return pool.size();
	}
	

}
