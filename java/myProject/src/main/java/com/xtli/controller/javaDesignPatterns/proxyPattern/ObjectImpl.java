package com.xtli.controller.javaDesignPatterns.proxyPattern;

/*
 * RealSubject:实际访问的对象
 */
public class ObjectImpl implements Object {

    public void action() {
        System.out.println("========");
        System.out.println("========");
        System.out.println("这是被代理的类");
        System.out.println("========");
        System.out.println("========");
    }
}
