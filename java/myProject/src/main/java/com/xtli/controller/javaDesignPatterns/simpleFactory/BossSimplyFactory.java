package com.xtli.controller.javaDesignPatterns.simpleFactory;

import java.io.IOException;

/* 简单工厂模式: 创建型设计模式，为了创建对象使用.
 * 这个模式本身很简单而且使用在业务较简单的情况下。一般用于小项目或者具体产品很少扩展的情况（这样工厂类才不用经常更改）。
 * 它由三种角色组成：
 * 工厂类角色：这是本模式的核心，含有一定的商业逻辑和判断逻辑，根据逻辑不同，产生具体的工厂产品。如例子中的Driver类。
 * 抽象产品角色：它一般是具体产品继承的父类或者实现的接口。由接口或者抽象类来实现。如例中的Car接口。
 * 具体产品角色：工厂类所创建的对象就是此角色的实例。在java中由一个具体类实现，如例子中的Benz、Bmw类。
 * 
 */
//==========================================================================================

//抽象产品  
abstract class Car{  
    private String name;  
      
    public abstract void drive();  
      
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
}  
//具体产品  
class Benz extends Car{  
    public void drive(){  
        System.out.println(this.getName()+"----go-----------------------");  
    }  
}  
  
class Bmw extends Car{  
    public void drive(){  
        System.out.println(this.getName()+"----go-----------------------");  
    }  
}  
  
//简单工厂  
class Driver{  
    public static Car createCar(String car){  
        Car c = null;  
        if("Benz".equalsIgnoreCase(car))  
            c = new Benz();  
        else if("Bmw".equalsIgnoreCase(car))  
            c = new Bmw();  
        return c;  
    }  
}  
  
//老板  
public class BossSimplyFactory {  
  
    public static void main(String[] args) throws IOException {  
        //老板告诉司机我今天坐奔驰  
        Car car = Driver.createCar("benz");  
        car.setName("benz");  
         //司机开着奔驰出发  
        car.drive();  
    }
}

/*
 * 这便是简单工厂模式了。那么它带了了什么好处呢？
 * 首先，符合现实中的情况；而且客户端免除了直接创建产品对象的责任，而仅仅负责“消费”产品（正如暴发户所为）。
 * 下面我们从开闭原则上来分析下简单工厂模式。当暴发户增加了一辆车的时候，只要符合抽象产品制定的合同，
 * 那么只要通知工厂类知道就可以被客户使用了。（即创建一个新的车类，继承抽象产品Car）那么 对于产品部分来说，
 * 它是符合开闭原则的——对扩展开放、对修改关闭；但是工厂类不太理想，因为每增加一辆车，都要在工厂类中增加相应的商业逻辑和判 断逻辑，
 * 这显自然是违背开闭原则的。
 * 而在实际应用中，很可能产品是一个多层次的树状结构。由于简单工厂模式中只有一个工厂类来对应这些产品，所以这可能会把我们的上帝类坏了。
 * 正如我前面提到的简单工厂模式适用于业务简单的情况下或者具体产品很少增加的情况。而对于复杂的业务环境可能不太适应了。
 * 这就应该由工厂方法模式来出场了！！
 * 
 * 
 */
