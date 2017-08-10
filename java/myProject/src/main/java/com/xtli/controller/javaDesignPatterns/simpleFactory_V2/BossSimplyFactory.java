package com.xtli.controller.javaDesignPatterns.simpleFactory_V2;


/* 
 * 简单工厂模式（工厂使用反射实现）:
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
    public static Object createCar(String car) throws Exception {
    	Class<?> c = Class.forName(car);
    	return c.newInstance();
    	
    /*    Car c = null;  
        if("Benz".equalsIgnoreCase(car))  
            c = new Benz();  
        else if("Bmw".equalsIgnoreCase(car))  
            c = new Bmw();  
        return c;*/  
    }  
}  
  
//老板  
public class BossSimplyFactory {  
  
    public static void main(String[] args) throws Exception {  
        //老板告诉司机我今天坐奔驰  
        Car car = (Car) Driver.createCar("com.xtli.controller.javaDesignPatterns.simpleFactory_V2.Benz");  
        car.setName("benz");  
         //司机开着奔驰出发  
        car.drive();  
        
        //老板告诉司机我今天坐宝马
        Car car2 = (Car) Driver.createCar("com.xtli.controller.javaDesignPatterns.simpleFactory_V2.Bmw");  
        car2.setName("BMW");  
         //司机开着奔驰出发  
        car2.drive();  
    }
}

