package com.xtli.controller.javaDesignPatterns.decoratorPattern;
/*
 * ConcreteDecorator：继续扩展对象职责
 */
public class ManDecoratorB extends Decorator {
    
    public void eat() {
        super.eat();
        reeatAgain();
        System.out.println("ManDecoratorB类");
    }
    
    public void reeatAgain() {
    	System.out.println("吃第三顿饭");
    }
    
}
