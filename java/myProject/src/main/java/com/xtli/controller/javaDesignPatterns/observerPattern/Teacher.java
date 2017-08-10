package com.xtli.controller.javaDesignPatterns.observerPattern;

import java.util.ArrayList;
/*
 * Subject(抽象目标者)角色:Subject中可以有任意多个Observer，并提供注册和删除观察者的接口。
 * Subject中维持一个状态属性，当状态发生变化时通知观察者。
 * 
 */
public abstract class Teacher {
    
    ArrayList<Student> studs = new ArrayList<Student>();
    
    String status = "";
    
	public void setStatus(String status) {
		this.status = status;
	}
	   
	public String getStatus() {
		return this.status;
	}
    
    public void register(Student stud) {
    	this.studs.add(stud);
    }

    public void unRegister(Student stud) {
        this.studs.remove(stud);
    }
    
    abstract void sendMessage(String status);

}
