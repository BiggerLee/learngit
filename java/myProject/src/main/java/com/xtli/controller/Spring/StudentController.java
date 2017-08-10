package com.xtli.controller.Spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xtli.pojo.Student;
import com.xtli.service.StudentService;

@Controller
@RequestMapping(value="/studentController")
public class StudentController {
	 private static final String STUDENT = "/xtli/student/studentList.jsp";
	 
	 @Autowired
	 private StudentService studentService;
	 
	 /**
	  * 测试MyBatis
	  */
	 @RequestMapping(value="/getStudent")  
     public ModelAndView getStudent(HttpServletRequest request) { 
		 ModelAndView mv = new ModelAndView(STUDENT);
		 Integer id = 1;
		 Student student = studentService.getStudentById(id);
		return mv.addObject("student", student);
     }  
}
