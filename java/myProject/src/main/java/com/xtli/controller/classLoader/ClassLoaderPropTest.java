package com.xtli.controller.classLoader;


import java.util.*;

import java.net.*;

import java.io.*;

/**
 * Description: 测试类加载器
 *
 * All Rights Reserved.
 * @version 1.0  Jun 8, 2017 9:05:58 AM  by 李幸涛（xt.li02@zuche.com）创建
 */

public class ClassLoaderPropTest
{

	public static void main(String[] args)
		throws IOException
	{
		// 获取系统类加载器
		ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
		System.out.println("系统类加载器：" + systemLoader);
		/*
		获取系统类加载器的加载路径——通常由CLASSPATH环境变量指定
		如果操作系统没有指定CLASSPATH环境变量，默认以当前路径作为
		系统类加载器的加载路径
		*/
		Enumeration<URL> em1 = systemLoader.getResources("");
		while(em1.hasMoreElements())
		{
			System.out.println(em1.nextElement());
		}
		// 获取系统类加载器的父类加载器：得到扩展类加载器
		ClassLoader extensionLader = systemLoader.getParent();
		System.out.println("扩展类加载器：" + extensionLader);
		System.out.println("扩展类加载器的加载路径：" + System.getProperty("java.ext.dirs"));
		System.out.println("扩展类加载器的parent: " + extensionLader.getParent());
	}

}



