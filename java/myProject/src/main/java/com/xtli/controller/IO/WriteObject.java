package com.xtli.controller.IO;


import java.io.*;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */

public class WriteObject
{
//	public static void main(String[] args)
//	{
//		try(
//			// 创建一个ObjectOutputStream输出流
//			ObjectOutputStream oos = new ObjectOutputStream(
//				new FileOutputStream("D:\\java\\java疯狂讲义\\codes\\15\\15.8\\object.txt")))
//		{
//			Person per = new Person("孙悟空", 500);
//			Person per2 = new Person("唐僧", 100);
//			// 将per对象写入输出流
//			oos.writeObject(per);
//			oos.writeObject(per2);
//		}
//		catch (IOException ex)
//		{
//			ex.printStackTrace();
//		}
//
//	}
	public static void main(String[] args) throws Exception
	{
		try(
			// 创建一个ObjectOutputStream输出流
			ObjectInputStream oos = new ObjectInputStream(
				new FileInputStream("D:\\java\\java疯狂讲义\\codes\\15\\15.8\\object.txt")))
		{
			//Person per = new Person("孙悟空", 500);
			// 将per对象写入输出流
			Object a = oos.readObject();
			Object b = oos.readObject();
			if(a instanceof Person) {
				System.out.println(((Person) a).getAge());
				System.out.println(((Person) a).getName());
			} else {
				System.out.println("异常");
			}
			if(b instanceof Person) {
				System.out.println(((Person) b).getAge());
				System.out.println(((Person) b).getName());

			}
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}

	}

}



