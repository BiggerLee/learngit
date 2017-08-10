package com.xtli.controller.CGLIB;
public class ConcreteClassNoInterface {  
    public String getConcreteMethodA(String str){  
        System.out.println("ConcreteMethod A ... "+str);  
        return str;  
    }  
    public int getConcreteMethodB(int n){  
        System.out.println("ConcreteMethod B ... "+n);  
        return n+10;  
    }  
}  