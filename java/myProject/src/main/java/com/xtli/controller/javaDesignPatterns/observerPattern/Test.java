package com.xtli.controller.javaDesignPatterns.observerPattern;

/*
 * 测试观察者模式
 */
public class Test{

    public static void main(String[] args) {
    	Student xiaoMing = new ClassStudent("小明");
    	Student xiaoHong = new ClassStudent("小红");
    	Student daNiu = new ClassStudent("大牛");
        Teacher tc = new YuWenTeacher();
        tc.register(xiaoMing);
        tc.register(xiaoHong);
        tc.register(daNiu);
        
        tc.sendMessage("上课");
        System.out.println("======上课中======");
        tc.sendMessage("下课");
        
    }
}
