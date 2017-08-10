package com.xtli.controller.javaDesignPatterns.decoratorPattern;

/*
 * ConcreteDecorator:向组件添加职责。 
 */
public class ManDecoratorA extends Decorator {

    public void eat() {
        super.eat();
        reEat();
        System.out.println("ManDecoratorA类");
    }

    public void reEat() {
        System.out.println("再吃一顿饭");
    }
}
