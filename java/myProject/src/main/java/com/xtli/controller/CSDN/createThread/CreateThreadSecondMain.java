package com.xtli.controller.CSDN.createThread;

import java.io.IOException;
/*
 * 创建线程的方式
 */

//方式2:实现Runnable接口
public class CreateThreadSecondMain {
 
 //不共享target实例
 public static void main(String[] args) throws IOException {
		//启动第一个线程
		CreateThreadSecond my1 = new CreateThreadSecond();
		new Thread(my1).start();//my1为target
		//启动第二个线程
		CreateThreadSecond my2 = new CreateThreadSecond();
		new Thread(my2).start();//my2为target
	}
 
}

class CreateThreadSecond implements Runnable {
	private int i;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// System.out.println(this.getName()+"线程启动啦"); //不能使用this.getName()来获取当前线程名称，因为接口中只能有抽象方法和常量，不能提供getName()方法的实现
		synchronized(this) {//多个线程共用同一个target时，共享变量是否需要加锁？？
			System.out.println(i++);
		}
		System.out.println(Thread.currentThread().getName()+"线程启动啦");
	}
}
