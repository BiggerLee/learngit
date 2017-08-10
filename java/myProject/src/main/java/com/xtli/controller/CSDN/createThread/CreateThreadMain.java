package com.xtli.controller.CSDN.createThread;

import java.io.IOException;
/*
 * 创建线程的方式
 */

//方式1:继承Thread类
public class CreateThreadMain {
	public static void main(String[] args) throws IOException {
		//启动第一个线程
		CreateThread my1 = new CreateThread();
		my1.start();
		//启动第二个线程
		CreateThread my2 = new CreateThread();
		my2.start();
	}
}


class CreateThread extends Thread {
	public void run() {
		System.out.println(this.getName()+"线程启动啦");//Thread中实现了getName()方法，可以直接使用
	}
}

