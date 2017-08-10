package com.xtli.controller;

import java.io.IOException;
/*
 * 创建线程的方式
 */

//方式1:继承Thread类
public class TestMain {
	public static void main(String[] args) throws IOException {
		/*//启动第一个线程
		CreateThread2 my1 = new CreateThread2();
		my1.start();
		//启动第二个线程
		MyThread my2 = new MyThread();
		my2.start();*/
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("线程启动啦1");
			}
		});
		t1.start();
	}
}

class CreateThread2 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// System.out.println(this.getName()+"线程启动啦");
	}
	
}
