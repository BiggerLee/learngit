package com.xtli.controller.other;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;  
  
  
public class App  
{  
    public static void main(String[] args) throws Exception  
    {  
        AtomicReferenceFieldUpdater<Dog, String> updater=AtomicReferenceFieldUpdater.newUpdater(Dog.class,String.class,"name");  
        Dog dog1=new Dog();  
        updater.compareAndSet(dog1,dog1.name,"test") ;  
        System.out.println(dog1.name);  
    }  
  
}  
  
 class Dog  
{  
     volatile  String name="dog1";   
} 