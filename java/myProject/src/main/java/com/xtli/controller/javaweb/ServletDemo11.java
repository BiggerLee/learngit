package com.xtli.controller.javaweb;



import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import java.io.InputStream;

import java.io.PrintWriter;

import java.util.Properties;



import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



/*

 servletContext域：1，是一个容器 2。作用范围是应用程序范围

 */

public class ServletDemo11 extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		//test5();	

		File file=new File("");

		response.getOutputStream().write(file.getAbsolutePath().getBytes());

		

	}

	private void test5() throws IOException {

		//得到绝对路径

		String path=this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");

		String filename=path.substring(path.lastIndexOf("\\"));

		FileInputStream in2=new FileInputStream(path);

		Properties props=new Properties();

		props.load(in2);

	}

	private void test4() throws IOException {

		//in2的相对路径是tomcat的bin目录，所以这种方法要在该目录下建立文件夹classes，并把文件放在这里
		FileInputStream in2=new FileInputStream("classes/db.properties");
		Properties props=new Properties();
		props.load(in2);
		System.out.println(props.getProperty("url"));

	}

	private void test3() throws IOException {

		InputStream in=this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");

		Properties props=new Properties();

		props.load(in);

		System.out.println(props.getProperty("url"));

	}



}

