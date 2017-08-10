package com.xtli.controller.CGLIB;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class ConcreteClassInterceptor implements MethodInterceptor{ 
	
	private Object target;
	
	@Override
	public Object intercept(Object obj, Method method, Object[] arg,
			MethodProxy proxy) throws Throwable {
		System.out.println("Before:" + method);    
        Object object=proxy.invokeSuper(obj, arg);  
        System.out.println("After:" + method);   
        return object;  
	}
	
	public Object getInstance(Object target) {
		this.target = target;
		Enhancer enhancer=new Enhancer();  
		//为代理对象设置父类，指定目标类
		enhancer.setSuperclass(this.target.getClass());  
		//设置回调接口对象
		enhancer.setCallback(this);  
		return enhancer.create();//生成CGLIB代理对象
	}
} 