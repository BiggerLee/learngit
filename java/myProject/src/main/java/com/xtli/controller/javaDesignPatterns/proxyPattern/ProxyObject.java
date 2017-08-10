package com.xtli.controller.javaDesignPatterns.proxyPattern;
/*
 * Proxy:代理对象，与RealSubject实现共同的接口，
 * 从而在访问RealSubject时，可以用Proxy代替。
 */
public class ProxyObject implements Object {

    Object obj;
    
    public ProxyObject(Object obj) {
        System.out.println("这是代理类");
        this.obj = obj;
    }
    
    public void action() {
        System.out.println("代理开始");
        obj.action();
        System.out.println("代理结束");
    }
}
