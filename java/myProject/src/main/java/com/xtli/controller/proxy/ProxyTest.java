package com.xtli.controller.proxy;


import java.lang.reflect.*;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */

interface Person
{
	void walk();
	void sayHello(String name);
}

class ChinaPerson implements Person {

	@Override
	public void walk() {
		System.out.println("i am walking");
	}

	@Override
	public void sayHello(String name) {
		System.out.println(name + ":hello");		
	}
} 

class MyInvokationHandler implements InvocationHandler
{
    private Object target = null;
    
    public MyInvokationHandler(Object target) {
    	this.target = target;
    }
    
	/*
	执行动态代理对象的所有方法时，都会被替换成执行如下的invoke方法
	其中：
	proxy：代表动态代理对象,代理类的实例
	method：代表正在执行的方法
	args：代表调用目标方法时传入的实参。
	*/

	public Object invoke(Object proxy, Method method, Object[] args) throws Exception, Exception, Exception
	{
		/*
		 * 执行System.out.println(proxy) 方法时，报错java.lang.StackOverflowError。proxy属于$Proxy0类。（参考http://chaisencs.iteye.com/blog/1649826）
		 * proxy.toString()递归调用InvocationHandler的invoke方法，导致堆栈溢出。可以参考$Proxy0的源码
		 *
		 *
		 *
		 */
		//System.out.println(proxy);
		System.out.println(this);
		System.out.println("----正在执行的方法:" + method);
		method.invoke(target, args);
		if (args != null)
		{
			System.out.println("下面是执行该方法时传入的实参为：");
			for (Object val : args)
			{
				System.out.println(val);
			}
		}
		else
		{
			System.out.println("调用该方法没有实参！");
		}
		return null;
	}
}

public class ProxyTest
{
	public static void main(String[] args)
		throws Exception
	{
		ChinaPerson target = new ChinaPerson();
		// 创建一个InvocationHandler对象
		InvocationHandler handler = new MyInvokationHandler(target);
		// 使用指定的InvocationHandler来生成一个动态代理对象
		Person p = (Person)Proxy.newProxyInstance(Person.class.getClassLoader()
			, new Class[]{Person.class}, handler);
		// 调用动态代理对象的walk()和sayHello()方法
		p.walk();
		p.sayHello("孙悟空");
	}
}

