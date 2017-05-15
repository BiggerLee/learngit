package com.xtli.controller;

class B extends A{
	B(){
		super();
		System.out.print("B");
	}
	B(int i){
		super(i);
		System.out.print("BB   ");
	}
}
