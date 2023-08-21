package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.RecruiterRegistration;
import com.canddella.entity.Skill;
import com.canddella.entity.Student;
import com.canddella.entity.StudentRecruiterRegistration;

public class StudentRecruiterRegistrationDAOImpl implements StudentRecruiterRegistrationDAO {
	DataSource ds = DBConnectionPool.getDataSource();

	@Override
	public List<StudentRecruiterRegistration> skillSetBased(Skill skill, RecruiterRegistration recruiterRegistration) {

		List<StudentRecruiterRegistration> StudentRecruiterRegistrationList = new ArrayList<>();
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select*from student where skill_id=?");
			statement.setInt(1, skill.getSkillId());
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				int skill_Id = resultSet.getInt("skill_id");

				if (skill_Id == skill.getSkillId()) {
//					System.out.println("+------------+-------------------+------------------+");
//
//					System.out.printf("| %-9s | %-17s | %-16s | \n",
//
//							"Student Id", "First Name", "Last Name");
//
//					System.out.println("+------------+-------------------+------------------+");
//					System.out.printf("| %-9s | %-17s | %-16s | \n",
//
//							resultSet.getString("student_id"), resultSet.getString("first_name"),
//							resultSet.getString("last_name"));
//					System.out.println("+------------+---------------------------------------+");
					Student student = new Student();
					String studentId = resultSet.getString("student_id");
					student.setStudent_id(studentId);
					if (studentId != null) {

						String firstName = resultSet.getString("first_name");
						student.setFirstName(firstName);

						String lastName = resultSet.getString("last_name");
						student.setLastName(lastName);

						StudentRecruiterRegistration studentRecruiterRegistration = null;
						studentRecruiterRegistration = new StudentRecruiterRegistration(student);
						StudentRecruiterRegistrationList.add(studentRecruiterRegistration);

					}

				}
			}

			connection.close();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		return StudentRecruiterRegistrationList;

	}

	@Override
	public List<StudentRecruiterRegistration> skillAndCGPABased(Skill skill, Student student) {

		List<StudentRecruiterRegistration> StudentRecruiterRegistrationList = new ArrayList<>();

		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select*from student where skill_id=?");

			statement.setInt(1, skill.getSkillId());

			// double cgpa = student.getCgpa();

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				int skill_Id = resultSet.getInt("skill_id");

				double cgpa = resultSet.getDouble("cgpa");

//				if (skill_Id == skill.getSkillId() && (student.getCgpa() >= cgpa)) {
				if (skill_Id == skill.getSkillId() && (cgpa >= student.getCgpa())) {

//					System.out.println("+------------+-------------------+------------------+");
//
//					System.out.printf("| %-9s | %-17s | %-16s | \n",
//
//							"Student Id", "First Name", "Last Name");
//
//					System.out.println("+------------+-------------------+------------------+");
//					System.out.printf("| %-9s | %-17s | %-16s | \n",
//
//							resultSet.getString("student_id"), resultSet.getString("first_name"),
//							resultSet.getString("last_name"));
//					System.out.println("+------------+---------------------------------------+");

					Student student1 = new Student();
					String studentId = resultSet.getString("student_id");
					student1.setStudent_id(studentId);

					// double cgpa = resultSet.getDouble("cgpa");
					student1.setCgpa(cgpa);

					String firstName = resultSet.getString("first_name");
					student1.setFirstName(firstName);

					String lastName = resultSet.getString("last_name");
					student1.setLastName(lastName);

					StudentRecruiterRegistration studentRecruiterRegistration = null;
					studentRecruiterRegistration = new StudentRecruiterRegistration(student1);
//					List<StudentRecruiterRegistration> StudentRecruiterRegistrationList = new ArrayList<>();
					StudentRecruiterRegistrationList.add(studentRecruiterRegistration);

				}

			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return StudentRecruiterRegistrationList;
	}
}
