package com.xtli.controller.mySynchronized;

class MyJvmThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->创建："+MyJvm.getInstance());
    }
}
