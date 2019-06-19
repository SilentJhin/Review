动态代理：
	作用：不改变源码的基础上对原有方法增强；AOP思想的实现技术；
	分类：
		基于接口的动态代理：
			要求：被代理类最少实现一个接口；
			提供者：JDK官方
			类和方法：Proxy.newProxyInstance(ClassLoader,Class[],InvocationHandler)
				ClassLoader:类加载器，要和被代理对象使用相同的类加载器；一般是固定写法；
				Class[]:被代理类实现的接口；一般是固定写法；
				InvocationHandler:用于我们提供增强代码的，一般写一个该接口的实现类，可以是匿名内部类；
					它的含义是：如何代理，此处的代码只能是谁用谁提供；
				public Object invoke(Object arg0, Method arg1, Object[] arg2)
					执行被代理对象的任何方法都会经过该方法，该方法有拦截功能；
					Object proxy:代理对象的引用
					Method method:当前执行的方法
					Object[] args:当前执行方法所需的参数
		基于子类的动态代理：
			要求：被代理类不能是最终类，不能被final修饰；
			提供者：第三方CGLib
			涉及的类：Enhancer
			创建代理对象的方法：create(Class,Callback);
				Class:被代理对象的字节码
				Callback:如何代理，它和InvocationHandler的作用是一样的，也是一个接口
					我们一般使用该接口的子接口MethodInterceptor
						