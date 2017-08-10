package com.xtli.controller.javaDesignPatterns.strategyPattern;
/*
 * Context 
 */
public class Context {

    Strategy stra;
    
    public Context(Strategy stra) {
        this.stra = stra;
    }
    
    public void doMethod() {
        stra.method();
    }
}
