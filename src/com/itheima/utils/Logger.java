package com.itheima.utils;

/*
 * 用于记录日志
 */

public class Logger {
	
	/*
	 * 记录日志的操作
	 * 计划让其在业务核心方法（切入点方法）执行之前执行
	 */
	public void printLog() {
		System.out.println("开始记录日志");
	}

}
