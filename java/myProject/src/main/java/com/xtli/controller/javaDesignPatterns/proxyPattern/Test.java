package com.xtli.controller.javaDesignPatterns.proxyPattern;
public class Test {
    public static void main(String[] args) {
    	Object obj = new ProxyObject(new ObjectImpl());
        obj.action();
    }
}
