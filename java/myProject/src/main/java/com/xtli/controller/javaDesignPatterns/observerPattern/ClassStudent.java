package com.xtli.controller.javaDesignPatterns.observerPattern;

/*
 * ConcreteObserver(具体观察者)角色 ：实现Observer接口，根据Subject不同的状态，采取不同行动，保持状态与Subject一致
 */

public class ClassStudent implements Student {
    	
	String name = "";
    
	public ClassStudent(String name) {
		this.name = name;
	}
	
    public void actionByTeacher(Teacher tc) {
    	if("上课".equals(tc.getStatus())) {
    		System.out.println(name+": 上课啦，去教室");
    	}
    	if("下课".equals(tc.getStatus())) {
    		System.out.println(name+": 下课啦，去玩咯");
    	}
    }
}
