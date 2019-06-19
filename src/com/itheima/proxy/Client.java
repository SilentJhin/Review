package com.itheima.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * 剧组
 */

public class Client {
	public static void main(String[] args) {
		final Actor actor = new Actor();
//		actor.basicAct(100f);
//		actor.dangerAct(500f);
		IActor proxyActor = (IActor)Proxy.newProxyInstance(actor.getClass().getClassLoader(), 
				actor.getClass().getInterfaces(), 
				new InvocationHandler() {
			
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Object rtValue = null;
						//1 取出执行方法的参数：给的多少钱
						Float money = (Float)args[0];
						//2 判断当前执行的方法
						if("basicAct".equals(method.getName())) {
							//基本演出
							if(money > 10000) {
								//执行方法
								rtValue = method.invoke(actor, money);
							}
						}
						if("dangerAct".equals(method.getName())) {
							//危险演出
							if(money > 50000) {
								//执行方法
								rtValue = method.invoke(actor, money);
							}
						}
						return rtValue;
					}
			
		});
		proxyActor.basicAct(10001);
	}
	
}
