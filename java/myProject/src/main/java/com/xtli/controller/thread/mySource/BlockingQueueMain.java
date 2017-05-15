package com.xtli.controller.thread.mySource;

public class BlockingQueueMain {
	static BlockingQueueTest BQ = new BlockingQueueTest(3);
	static class BlockingQueueInQueue extends Thread {
		public void run() {
			for(int i=0;i<6;i++) {
				BQ.inQueue(String.valueOf(i));
			}
		}
	}
	
	static class BlockingQueueOutQueue extends Thread {
		public void run() {
			for(int i=0;i<5;i++) {
				BQ.outQueue();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		/*final BlockingQueueTest BQ = new BlockingQueueTest(3);
		BQ.inQueue("1");
		BQ.inQueue("2");
		BQ.inQueue("3");
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				BQ.inQueue("4");
				BQ.inQueue("5");
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				String str1 = BQ.outQueue();
				System.out.println(str1);
				String str2 = BQ.outQueue();
				System.out.println(str2);
			}
		});
		t1.start();
		Thread.sleep(1000);
		t2.start();*/
		
		new BlockingQueueInQueue().start();
		new BlockingQueueOutQueue().start();
	}
}
