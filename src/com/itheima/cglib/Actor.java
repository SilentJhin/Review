package com.itheima.cglib;

import com.itheima.proxy.IActor;

/*
 * 演员
 */

public class Actor implements IActor {
	/*
	 * 基本演出
	 */
	public void basicAct(float money) {
		System.out.println("get money,start basic act:"+money);
	}
	
	/*
	 * 危险演出
	 */
	public void dangerAct(float money) {
		System.out.println("get money,start danger act:"+money);
	}
	
	
}
