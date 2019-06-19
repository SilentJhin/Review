package com.itheima.proxy;

/*
 * 经纪公司对签约艺人的标准
 */
public interface IActor {
	/*
	 * 基本演出
	 */
	public void basicAct(float money);
	
	/*
	 * 危险演出
	 */
	public void dangerAct(float money);
}
