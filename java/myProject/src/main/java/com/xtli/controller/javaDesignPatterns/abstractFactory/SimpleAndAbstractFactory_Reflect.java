package com.xtli.controller.javaDesignPatterns.abstractFactory;
/*
 * 使用反射改进抽象工厂模式
 */
abstract class BenzCarv2{  
    private String name;  
      
    public abstract void drive();  
      
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
}  
class BenzSportCarv2 extends BenzCarv2{  
    public void drive(){  
        System.out.println(this.getName()+"----BenzSportCarv2-----------------------");  
    }  
}  
class BenzBusinessCarv2 extends BenzCarv2{  
    public void drive(){  
        System.out.println(this.getName()+"----BenzBusinessCarv2-----------------------");  
    }  
}  

abstract class BmwCarv2{  
    private String name;  
      
    public abstract void drive();  
      
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
}  
class BmwSportCarv2 extends BmwCarv2{  
    public void drive(){  
        System.out.println(this.getName()+"----BmwSportCarv2-----------------------");  
    }  
}  
class BmwBusinessCarv2 extends BmwCarv2{  
    public void drive(){  
        System.out.println(this.getName()+"----BmwBusinessCarv2-----------------------");  
    }  
}  

abstract class AudiCarv2{  
    private String name;  
      
    public abstract void drive();  
      
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
}  
class AudiSportCarv2 extends AudiCarv2{  
    public void drive(){  
        System.out.println(this.getName()+"----AudiSportCarv2-----------------------");  
    }  
}  
class AudiBusinessCarv2 extends AudiCarv2{  
    public void drive(){  
        System.out.println(this.getName()+"----AudiBusinessCarv2-----------------------");  
    }  
}  


/** 
 * 简单工厂通过反射改进抽象工厂及其子工厂 
 * @author Administrator 
 * 
 */  
class Driver3v2{  
    public static BenzCar createBenzCar(String car) throws Exception {  
        return (BenzCar) Class.forName(car).newInstance();  
    }  
      
    public static BmwCar createBmwCar(String car) throws Exception {  
        return (BmwCar) Class.forName(car).newInstance();  
    }  
      
    public static AudiCar createAudiCar(String car) throws Exception {  
        return (AudiCar) Class.forName(car).newInstance();  
    }  
}  
//客户端  
public class SimpleAndAbstractFactory_Reflect {  

    public static void main(String[] args) throws Exception {  

        AudiCar car = Driver3v2.createAudiCar("com.xtli.controller.javaDesignPatterns.abstractFactory.AudiSportCar");  
        car.setName("AudiSportCar");
        car.drive();  
    }  
}  
