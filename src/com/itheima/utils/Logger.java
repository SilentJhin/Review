package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/*
 * 用于记录日志
 */

public class Logger {
	
	/*
	 * 前置通知
	 */
	public void beforePrintLog() {
		System.out.println("前置通知:开始记录日志");
	}
	
	/*
	 * 后置通知
	 */
	public void afterReturningPrintLog() {
		System.out.println("后置通知:开始记录日志");
	}

	/*
	 * 异常通知
	 */
	public void afterThrowingPrintLog() {
		System.out.println("异常通知:开始记录日志");
	}
	
	/*
	 * 最终通知
	 */
	public void afterPrintLog() {
		System.out.println("最终通知:开始记录日志");
	}
	
	/*
	 * 环绕通知
	 */
	public Object aroundPrintLog(ProceedingJoinPoint pjp) {
		Object rtValue = null;
		try {
			System.out.println("环绕通知:开始记录日志_前置");
			rtValue = pjp.proceed();
			System.out.println("环绕通知:开始记录日志_后置");
		} catch (Throwable e) {
			System.out.println("环绕通知:开始记录日志_异常");
		} finally {
			System.out.println("环绕通知:开始记录日志_最终");
		}
		return rtValue;
	}
}
