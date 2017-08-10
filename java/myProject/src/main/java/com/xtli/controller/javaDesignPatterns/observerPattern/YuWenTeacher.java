package com.xtli.controller.javaDesignPatterns.observerPattern;

/*
 * ConcreteSubject(具体目标)角色:设置ConcreteSubject状态，并将本身引用(包括角色状态)存入ConcreteObserver中，当它的状态发生变化时，向它的各个观察者发出通知。
 */
public class YuWenTeacher extends Teacher {
	
    public void sendMessage(String status) {
        this.setStatus(status);
        System.out.println("YuWenTeacher:" + status);
        for(int i = 0; i < studs.size(); i++) {
            Student stu = (Student) studs.get(i);
            //通知学生上课/下课
            stu.actionByTeacher(this);
        }
    }
}
