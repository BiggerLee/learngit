package com.xtli.controller.classLoader;

//通过debug ClassLoader的loadClass方法可知，运行‘run application’时，首先加载ClassLoaderTest依赖的类以及引用到的关联类。
//然后寻找main方法，并执行。在System.out.println("System类初始化，并加载类")处，系统会初始化System类(先加载此类)

class Tester
{
	static
	{
		System.out.println("Tester类的静态初始化块...");
	}
	public void methodOne() {
		System.out.println("这是方法methodOne");
	}
}

public class ClassLoaderTest
{
	public static void main(String[] args)
		throws ClassNotFoundException
	{
		System.out.println("System类初始化，并加载类");//1：调用类的静态方法，引起类的初始化，并加载类 
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		// 2:下面语句仅仅是加载Tester类,对比4处
		cl.loadClass("com.xtli.controller.classLoader.Tester");
		
		System.out.println("系统加载Tester类");//3：调用类的静态方法，引起类的初始化，不再进行类加载(1处已载入过)
		// 4:下面语句才会初始化Tester类，对比2处
		Class<?> a = Class.forName("com.xtli.controller.classLoader.Tester");
		if(Tester.class.equals(a)) {
			try {
				Tester tester = (Tester) a.newInstance();
				tester.methodOne();
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}
}



