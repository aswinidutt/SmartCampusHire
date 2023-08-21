package com.canddella.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Skill;
import com.canddella.entity.Student;

public class StudentDAOImpl implements StudentDAO {
	DataSource ds = DBConnectionPool.getDataSource();

	@Override
	public void saveStudent(Student student) {

		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into student (student_id,first_name,last_name,email,phonenumber,address,date_of_birth,gender,university,stream,graduation_year,cgpa,skill_id) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			statement.setString(1, student.getStudent_id());
			statement.setString(2, student.getFirstName());
			statement.setString(3, student.getLastName());
			statement.setString(4, student.getEmail());
			statement.setLong(5, student.getPhnumber());
			statement.setString(6, student.getAddress());

			LocalDate localDate = student.getDateOfBirth();
			Date date_Of_Birth = Date.valueOf(localDate);// convert localdate to date
			statement.setDate(7, date_Of_Birth);

			statement.setString(8, student.getGender());
			statement.setString(9, student.getUniversity());
			statement.setString(10, student.getStream());
			statement.setInt(11, student.getPassOutYr());
			statement.setDouble(12, student.getCgpa());
			statement.setInt(13,student.getSkill().getSkillId());

			int count = 0;
			count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Updated Successfully");
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<Student> displayAll() {
		List<Student> studentList = new ArrayList<>();
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from student");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

				// resultSet.getString(7);//DBT
				LocalDate dob = LocalDate.parse(resultSet.getString(7), formatter);// DBT//we use getString to take date
																				// from DB
				Skill skill=new Skill();
				int skillId=resultSet.getInt("skill_id");
				skill.setSkillId(skillId);
				
				
			Student student = new Student(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4), resultSet.getLong(5), resultSet.getString(6), dob,
						resultSet.getString(8), resultSet.getString(9), resultSet.getString(10), resultSet.getInt(11),
						resultSet.getDouble(12),skill);
				studentList.add(student);
				

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return studentList;
	}

	@Override
	public void deleteStudent(String studentId) {

		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("delete from student where student_id=?");
			statement.setString(1, studentId);
			int count = 0;

			count = statement.executeUpdate();
			if (count > 0)

			{
				System.out.println("Deleted");
			}

			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public Student selectStudent(String studentId) {
		Student student=null;
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from student where student_id=?");
			statement.setString(1, studentId);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				
			String student_Id=resultSet.getString("student_id");
	String firstName=resultSet.getString("first_name");
				
	String lastName=resultSet.getString("last_name");
	String email=resultSet.getString("email");
				long  phoneNumber=resultSet.getLong("phonenumber");
				String address=resultSet.getString("address");
				
				Date date=resultSet.getDate("date_of_birth");
				LocalDate dateOfBirth=date.toLocalDate();
				
				String gender=resultSet.getString("gender");
				
				String university=resultSet.getString("university");
				
	
				String stream=resultSet.getString("stream");
				
				int graduationYr=resultSet.getInt("graduation_year");
				
				double cgpa=resultSet.getDouble("cgpa");
				
				int skillId=resultSet.getInt("skill_id");
				
					Skill skill=new Skill();
					student =new Student(student_Id,firstName,lastName,email,phoneNumber,address,dateOfBirth,gender,university,stream,graduationYr,cgpa,skill);
				
			}
			

			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return student;
		
		
		
	}

	@Override
	public Student getStudent(String studentId) {
		Student student=null;
		try
		{
		 Connection connection=ds.getConnection();	
	PreparedStatement statement=connection.prepareStatement("select * from student where student_id = ?");
	statement.setString(1,studentId);
ResultSet resultSet=statement.executeQuery();
while(resultSet.next())
{
	
	String student_Id=resultSet.getString("student_id");
String firstName=resultSet.getString("first_name");
		
String lastName=resultSet.getString("last_name");
String email=resultSet.getString("email");
		//String phoneNumber=resultSet.getString("phonenumber");
long phoneNumber=resultSet.getLong("phonenumber");
		String address=resultSet.getString("address");
		
		Date date=resultSet.getDate("date_of_birth");
		LocalDate dateOfBirth=date.toLocalDate();
		
		String gender=resultSet.getString("gender");
		
		String university=resultSet.getString("university");
		String stream=resultSet.getString("stream");
		int graduationYr=resultSet.getInt("graduation_year");
		double cgpa=resultSet.getDouble("cgpa");
		
		Skill skill=new Skill();
		int skillId=resultSet.getInt("skill_id");
		
		
		
			student =new Student(student_Id,firstName,lastName,email,phoneNumber,address,dateOfBirth,gender,university,stream,graduationYr,cgpa,skill);
			
}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return student;
	}

	@Override
	public void updateStudent(String column_name, String newValue, String studentId) {
	
		try
		{
		 Connection connection=ds.getConnection();	
	PreparedStatement statement=connection.prepareStatement("update student set "+column_name+" = ? where student_id = ?");
	statement.setString(1,newValue);
	statement.setString(2,studentId);
//	statement.executeQuery();
	int count=0;
	
	count=statement.executeUpdate();
	if(count>0)
	{
		System.out.println("Updated Successfully");
	}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	

}
