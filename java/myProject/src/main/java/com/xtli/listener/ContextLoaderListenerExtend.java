package com.xtli.listener;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;
/*
 * 自定义ContextLoaderListener监听器。
 */
public class ContextLoaderListenerExtend extends ContextLoaderListener{
	
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("contextInitialized前");
		super.contextInitialized(event);
	}
	
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("contextDestroyed前");
		super.contextDestroyed(event);
	}
}

