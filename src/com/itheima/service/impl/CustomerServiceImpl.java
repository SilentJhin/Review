package com.itheima.service.impl;

import com.itheima.service.ICustomerService;
import com.itheima.utils.Logger;

/*
 * 模拟一个客户的业务层实现
 */

public class CustomerServiceImpl implements ICustomerService {

	@Override
	public void saveCustomer() {
//		new Logger().printLog();
		System.out.println("保存了客户");
	}

	@Override
	public void updateCustomer(int i) {
		System.out.println("更新了客户:"+i );
	}

	@Override
	public int deleteCustomer() {
		System.out.println("删除了客户");
		return 0;
	}

}
