package com.xtli.controller.interview;

import java.io.IOException;
/**
 * Description: "=="与equals区别
 * "=="：可以比较基本数据类型也可以比较引用数据类型。比较基本数据类型时，比较的是两者的值；比较引用数据类型时，比较的是引用的内存地址是否相同。
 * equals：比较的是两个对象的内容是否相同。
 * All Rights Reserved.
 */
public class EqualsAndEE {
	public static void main(String[] args) throws IOException {
		String a = "a";
		String b = new String("a");
		System.out.println(a.equals(b));
		System.out.println(a==b);
		Integer c = 12;
		Integer d = new Integer(12);
		System.out.println(c.equals(d));
		System.out.println(c==d);
	}
}

