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

public class RandomAccessFileTest

{

	public static void main(String[] args)

	{

		try(

			RandomAccessFile raf =  new RandomAccessFile(

				"D:\\java\\java疯狂讲义\\codes\\15\\15.7\\RandomAccessFileTest.java" , "rw"))

		{

			// 获取RandomAccessFile对象文件指针的位置，初始位置是0

			System.out.println("RandomAccessFile的文件指针的初始位置："

				+ raf.getFilePointer());

			// 移动raf的文件记录指针的位置

			raf.seek(300);

			byte[] bbuf = new byte[1024];

			// 用于保存实际读取的字节数

			int hasRead = 0;

			// 使用循环来重复“取水”过程

			while ((hasRead = raf.read(bbuf)) > 0 )

			{

				// 取出“竹筒”中水滴（字节），将字节数组转换成字符串输入！

				System.out.print(new String(bbuf , 0 , hasRead ));
				 //raf.write(bbuf , 0 , hasRead );
			}

		}

		catch (IOException ex)

		{

			ex.printStackTrace();

		}

	}

}
