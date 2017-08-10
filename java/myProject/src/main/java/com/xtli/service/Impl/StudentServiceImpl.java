package com.xtli.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xtli.dao.StudentDao;
import com.xtli.pojo.Student;
import com.xtli.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	@Override
	@Transactional(readOnly = false, rollbackFor = Throwable.class)
	public Student getStudentById(Integer id) {
		return studentDao.getStudentById(id);
	}
}
