package com.xtli.controller.javaDesignPatterns.decoratorPattern;
/*
 * ConcreteComponent:定义一个对象，可以给这个对象添加一些职责。
 */
public class Man implements Person {

	public void eat() {
		System.out.println("男人在吃");
	}
}
