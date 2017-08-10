package com.xtli.controller.javaBase;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/*
 * 测试byte，int类型转换，以及 & 0xff 操作
 */
public class TypeTranferMain {
	  public static void main(String[] args) throws Exception {
	   
	    byte a = -17;
	    System.out.println(a);
	    System.out.println((int) a);
	    System.out.println(a & 0xff);
	    System.out.println(Integer.toBinaryString((int) a));
	    System.out.println(Integer.toBinaryString(a & 0xff));
	  }
	}
