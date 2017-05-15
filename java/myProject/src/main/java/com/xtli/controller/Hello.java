package com.xtli.controller;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Hello{
	 
	 private static final String HELLO = "/xtli/hello/hello.jsp";
	 
	 @AnnotationMyTest(value = "1", age = 12)
	 @RequestMapping(value="/hello")  
     public ModelAndView helloWorld(HttpServletRequest request){ 
		 ModelAndView mv = new ModelAndView(HELLO);
		 System.out.println("hello");
		 //AnnotationMyTest am = (AnnotationMyTest) 
		 mv.addObject("message","Hello World!!!");  
         return mv;  
     }  
	 /**
	  * Description: 测试注解
	  *
	  * @Version1.0 2017-3-17 下午2:25:21 by 李幸涛（xt.li02@zuche.com）创建
	  * @param args
	  */
	 public static void main(String args[]) {
		 Method[] ms = Hello.class.getMethods();
		 for(Method m : ms) {
			 System.out.println(m);
			 if(m.isAnnotationPresent(AnnotationMyTest.class)){
				 AnnotationMyTest at = m.getAnnotation(AnnotationMyTest.class);
				 System.out.println(at);
				 System.out.println(at.value());
				 System.out.println(at.age());
			 }
		 }
	 }
}
