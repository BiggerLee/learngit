package com.xtli.controller.CGLIB;

import org.springframework.cglib.proxy.Enhancer;
/*
 * CGLib实现动态代理的一个示例
 */
public class MainTest {
	/* 生成代理对象在main方法中书写
	 * public static void main(String[] args) {
		Enhancer enhancer=new Enhancer();  
		//为代理对象设置父类，指定目标类
		enhancer.setSuperclass(ConcreteClassNoInterface.class);  
		//设置回调接口对象
		enhancer.setCallback(new ConcreteClassInterceptor());  
		ConcreteClassNoInterface ccni=(ConcreteClassNoInterface)enhancer.create();//生成CGLIB代理对象
	    ccni.getConcreteMethodA("shensy");  
	    ccni.getConcreteMethodB(0);  
	}*/
	
	/*
	 * 生成代理对象在代理类中书写
	 */
	public static void main(String[] args) {
		ConcreteClassInterceptor ccniProxy = new ConcreteClassInterceptor();
		ConcreteClassNoInterface ccni = (ConcreteClassNoInterface) ccniProxy.getInstance(new ConcreteClassNoInterface());//生成CGLIB代理对象
		ccni.getConcreteMethodA("shensy");
		ccni.getConcreteMethodB(0);
	}
}

