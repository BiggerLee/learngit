package com.xtli.controller.mySynchronized;

public class MyMain {
	private MyMain(){}
	/*public static void main(String[] args) {
	    MyJvm jvm1 = MyJvm.getInstance();
	    MyJvm jvm2 = MyJvm.getInstance();
	    System.out.println(jvm1);
	    System.out.println(jvm2);
	}*/
	/*
	 * 多线程测试:
	 */
	public static void main(String[] args) {
	    MyJvmThread thread1 = new MyJvmThread();
	    MyJvmThread thread2 = new MyJvmThread();
	    thread1.start();
	    thread2.start();
	}
}
