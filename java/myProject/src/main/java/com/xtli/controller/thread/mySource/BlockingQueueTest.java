package com.xtli.controller.thread.mySource;

import java.util.LinkedList;
//实现一个阻塞队列
public class BlockingQueueTest {
	LinkedList<String> BQList = new LinkedList<String>();
	private int size = 0;//队列大小
	private int count = 0;//队列计数器
	private Object obj = new Object();//同步对象
	public BlockingQueueTest(int size) {
		this.size = size;
	}
	
	public void inQueue(String str) {
		synchronized(obj) {
			System.out.println("线程"+Thread.currentThread().getName()+":"+str+"准备进入队列。。");
			if(this.size == count) {
				try {
					System.out.println("线程"+Thread.currentThread().getName()+":"+"队列已满，阻塞。。");
					obj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			BQList.add(str);
			count++;
			System.out.println("线程"+Thread.currentThread().getName()+":"+str+"成功进入队列。。");
			System.out.println("当前队列中的值为:"+BQList.toString());
			obj.notifyAll();
		}
	}
	public String outQueue() {
		synchronized(obj) {
			System.out.println("线程"+Thread.currentThread().getName()+":"+"准备从队列中取值。。");
			if(this.count == 0) {
				try {
					System.out.println("线程"+Thread.currentThread().getName()+":"+"队列已空，阻塞。。");
					obj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			count--;
			String str = BQList.pollFirst();
			System.out.println("线程"+Thread.currentThread().getName()+":"+str+"成功出队列。。");
			System.out.println("当前队列中的值为:"+BQList.toString());
			obj.notifyAll();
			return str;
		}
	}
}
