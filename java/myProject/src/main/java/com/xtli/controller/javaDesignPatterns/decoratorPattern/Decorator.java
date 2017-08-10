package com.xtli.controller.javaDesignPatterns.decoratorPattern;
/*
 * Decorator:维持一个指向Component对象的指针，并定义一个与Component接口一致的接口。
 */
public abstract class Decorator implements Person {

    protected Person person;
    
    public void setPerson(Person person) {
        this.person = person;
    }
    
    public void eat() {
        person.eat();
    }
}
