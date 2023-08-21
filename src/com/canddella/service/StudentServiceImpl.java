package com.canddella.service;

import java.util.List;

import com.canddella.dao.StudentDAOImpl;
import com.canddella.entity.Student;

public class StudentServiceImpl implements StudentService {

	public void saveStudent(Student student) {
		
		StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
	studentDAOImpl.saveStudent(student);
	
	}

	@Override
	public List<Student> displayAll() {
		List<Student>studentList=null;
		StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
		studentList=studentDAOImpl.displayAll();
		return studentList;
	}

	@Override
	public void deleteStudent(String studentId) {
		
		StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
		 studentDAOImpl.deleteStudent(studentId);
		
	}

	@Override
	public Student selectStudent(String studentId) {
		StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
		Student student= studentDAOImpl.selectStudent(studentId);
		return student;
		
	}

	@Override
	public Student getStudent(String studentId) {
		StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
		Student student= studentDAOImpl.getStudent(studentId);
		return student;
		
		
	}

	@Override
	public void updateStudent(String column_name, String newValue, String studentId) {
	
		StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
		studentDAOImpl.updateStudent(column_name, newValue, studentId);
		
	}

	
	
}
