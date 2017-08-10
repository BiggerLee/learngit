package com.xtli.controller.javaDesignPatterns.observerPattern;
/*
 * Observer(抽象观察者)角色:根据Subject，采取行动，提供一个行动接口。
 */
public interface Student {
	//根据Subject采取行动
    void actionByTeacher(Teacher tc);
}
