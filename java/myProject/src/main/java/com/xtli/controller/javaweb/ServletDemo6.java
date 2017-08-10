package com.xtli.controller.javaweb;



import java.io.IOException;

import java.io.PrintWriter;



import javax.servlet.ServletContext;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



public class ServletDemo6 extends HttpServlet {



//servletContext示例

	public void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		//得到servletContext

		ServletContext context=this.getServletConfig().getServletContext();

		ServletContext context2=this.getServletContext();

		String data="aaaaa";

		context.setAttribute("data", data);

	}

}

