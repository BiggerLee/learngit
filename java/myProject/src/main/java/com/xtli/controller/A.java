package com.xtli.controller;

public class A {
	public static void main(String args[]){
		A a = new A(1);
		//System.out.print(a);
	}
	A(){
		System.out.print("A   ");
		
	}
	
	A(int i) {
		this();
		System.out.print("AA   ");
	}

}
