package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * 用于记录日志
 */

@Component("logger")
@Aspect
public class Logger {
	
	@Pointcut("execution(* com.itheima.service.impl.*.*(..))")
	private void pt1() {}
	
	/*
	 * 前置通知
	 */
//	@Before("pt1()")
	public void beforePrintLog() {
		System.out.println("前置通知:开始记录日志");
	}
	
	/*
	 * 后置通知
	 */
	@AfterReturning("pt1()")
	public void afterReturningPrintLog() {
		System.out.println("后置通知:开始记录日志");
	}

	/*
	 * 异常通知
	 */
	@AfterThrowing("pt1()")
	public void afterThrowingPrintLog() {
		System.out.println("异常通知:开始记录日志");
	}
	
	/*
	 * 最终通知
	 */
	@After("pt1()")
	public void afterPrintLog() {
		System.out.println("最终通知:开始记录日志");
	}
	
	/*
	 * 环绕通知
	 */
//	@Around("pt1()")
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
