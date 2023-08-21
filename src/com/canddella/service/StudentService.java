package com.canddella.service;

import java.util.List;

import com.canddella.entity.Student;

public interface StudentService {
	
	
	public void saveStudent(Student student);
	
	public List<Student>displayAll();
	
	public void deleteStudent(String studentId);
	
	public Student selectStudent(String studentId);
	
	public Student getStudent(String studentId);
	
	public void updateStudent(String column_name,String newValue,String studentId);


}
