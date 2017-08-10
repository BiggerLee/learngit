package com.xtli.dao;

import org.springframework.stereotype.Repository;

import com.xtli.pojo.Student;
/*
 * 测试MyBatisDao
 */
@Repository
public interface StudentDao {
	public Student getStudentById(Integer id);
}
