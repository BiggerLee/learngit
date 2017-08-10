package com.xtli.controller.javaweb;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//获取配置文件中的初始化参数<init_param>
		/*System.out.println(this.getServletConfig().getInitParameter("data"));
		OutputStream out = res.getOutputStream();
		out.write("myServlet".getBytes());
		out.close();*/
		
		//获取<ContextParam>标签中的配置的value
		//System.out.println(this.getServletContext().getInitParameter("data"));
		
		//转发请求
		String data="aaaaaaaaaa";
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/1.jsp");
		rd.forward(req, res);	
	}

}
