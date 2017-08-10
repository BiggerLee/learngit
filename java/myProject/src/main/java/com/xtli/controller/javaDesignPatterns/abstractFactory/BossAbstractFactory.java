package com.xtli.controller.javaDesignPatterns.abstractFactory;
/*
 * 产品族： 位于不同产品等级结构中，功能相关联的产品组成的家族
 * 图中的BmwCar和BenzCar就是两个产品树（产品层次结构）；而如图所示的BenzSportsCar和BmwSportsCar就是一个产品族。
 * 他们都可以放到跑车家族中，因此功能有所关联。同理BmwBussinessCar和BenzBusinessCar也是一个产品族。
 * 可以这么说，它和工厂方法模式的区别就在于需要创建对象的复杂程度上。而且抽象工厂模式是三个里面最为抽象、最具一般性的。
 * 抽象工厂模式的用意为：给客户端提供一个接口，可以创建多个产品族中的产品对象。
 * 而且使用抽象工厂模式还要满足一下条件：
 * 1.系统中有多个产品族，而系统一次只可能消费其中一族产品
 * 2.同属于同一个产品族的产品以其使用。
 * 
 * 
 * 来看看抽象工厂模式的各个角色（和工厂方法的如出一辙）：
 * 抽象工厂角色： 这是工厂方法模式的核心，它与应用程序无关。是具体工厂角色必须实现的接口或者必须继承的父类。
 * 在java中它由抽象类或者接口来实现。
 * 具体工厂角色：它含有和具体业务逻辑有关的代码。由应用程序调用以创建对应的具体产品的对象。在java中它由具体的类来实现。
 * 抽象产品角色：它是具体产品继承的父类或者是实现的接口。在java中一般有抽象类或者接口来实现。
 * 具体产品角色：具体工厂角色所创建的对象就是此角色的实例。在java中由具体的类来实现。
 */
//=====================================================================================
//抽象产品（Bmw和Audi同理）  
abstract class BenzCar{  
    private String name;  
      
    public abstract void drive();  
      
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
}  
//具体产品（Bmw和Audi同理）  
class BenzSportCar extends BenzCar{  
    public void drive(){  
        System.out.println(this.getName()+"----BenzSportCar-----------------------");  
    }  
}  
class BenzBusinessCar extends BenzCar{  
    public void drive(){  
        System.out.println(this.getName()+"----BenzBusinessCar-----------------------");  
    }  
}  

abstract class BmwCar{  
    private String name;  
      
    public abstract void drive();  
      
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
}  
class BmwSportCar extends BmwCar{  
    public void drive(){  
        System.out.println(this.getName()+"----BmwSportCar-----------------------");  
    }  
}  
class BmwBusinessCar extends BmwCar{  
    public void drive(){  
        System.out.println(this.getName()+"----BmwBusinessCar-----------------------");  
    }  
}  

abstract class AudiCar{  
    private String name;  
      
    public abstract void drive();  
      
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
}  
class AudiSportCar extends AudiCar{  
    public void drive(){  
        System.out.println(this.getName()+"----AudiSportCar-----------------------");  
    }  
}  
class AudiBusinessCar extends AudiCar{  
    public void drive(){  
        System.out.println(this.getName()+"----AudiBusinessCar-----------------------");  
    }  
}  


//抽象工厂  
abstract class Driver3{  
    public abstract BenzCar createBenzCar(String car) throws Exception;  
      
    public abstract BmwCar createBmwCar(String car) throws Exception;  
      
    public abstract AudiCar createAudiCar(String car) throws Exception;  
}  
//具体工厂  
class SportDriver extends Driver3{  
    public BenzCar createBenzCar(String car) throws Exception {  
        return new BenzSportCar();  
    }  
    public BmwCar createBmwCar(String car) throws Exception {  
        return new BmwSportCar();  
    }  
    public AudiCar createAudiCar(String car) throws Exception {  
        return new AudiSportCar();  
    }  
}  
class BusinessDriver extends Driver3{  
    public BenzCar createBenzCar(String car) throws Exception {  
        return new BenzBusinessCar();  
    }  
    public BmwCar createBmwCar(String car) throws Exception {  
        return new BmwBusinessCar();  
    }  
    public AudiCar createAudiCar(String car) throws Exception {  
        return new AudiBusinessCar();  
    }  
}  

//老板  
public class BossAbstractFactory {  

    public static void main(String[] args) throws Exception {  
          
        Driver3 d = new BusinessDriver();  
        AudiCar car = d.createAudiCar("Audi");
        car.setName("Audi");
        car.drive();  
    }  
}  

/**
 * 其中：BenzSportCar和BenzBusinessCar属于产品树；同理BmwSportCar和BmwBusinessCar。
 * 而BenzSportCar和BmwSportCar和AudiSportCar属于产品族。
 * 所以抽象工厂模式一般用于具有产品树和产品族的场景下。
 * 抽象工厂模式的缺点：如果需要增加新的产品树，那么就要新增三个产品类，比如VolvoCar，VolvoSportCar,VolvoSportCar，
 * 并且要修改三个工厂类。这样大批量的改动是很丑陋的做法。
 * 所以可以用简单工厂配合反射来改进抽象工厂(见SimpleAndAbstractFactory_Reflect)
 *
 **/


