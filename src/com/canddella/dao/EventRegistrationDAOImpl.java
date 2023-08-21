package com.canddella.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.College;
import com.canddella.entity.Event;
import com.canddella.entity.EventRegistration;
import com.canddella.entity.Student;

public class EventRegistrationDAOImpl implements EventRegistrationDAO {
	DataSource ds = DBConnectionPool.getDataSource();
	//private String regDate;

	@Override
	public void saveRegistration(EventRegistration eventRegistration) {

		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into registration (reg_id,college_id,student_id,event_id,registration_date) values (?,?,?,?,?)");
			statement.setString(1, eventRegistration.getRegId());
			statement.setString(2, eventRegistration.getCollege().getCollegeId());
			statement.setString(3, eventRegistration.getStudent().getStudent_id());
			statement.setString(4, eventRegistration.getEvent().getEvent_id());

			Date regDate = Date.valueOf(eventRegistration.getRegDate());
			statement.setDate(5, regDate);

			int count = 0;
			count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Updated Successfully");
			} else {
				System.out.println(" Not Updated Successfully");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<EventRegistration> displayRegistration() {
		List<EventRegistration> eventRegistrationList = new ArrayList<>();

		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select*from registration");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				String registrationId = resultSet.getString("reg_id");

				College college = new College();
				String collegeId = resultSet.getString("college_id");
				college.setCollegeId(collegeId);

				Student student = new Student();
				// String studentId=resultSet.getString(student.getStudent_id());
				String studentId = resultSet.getString("student_id");
				student.setStudent_id(studentId);

				Event event = new Event();
				// String eventId=resultSet.getString(event.getEvent_id());
				String eventId = resultSet.getString("event_id");
				event.setEvent_id(eventId);

				Date date = resultSet.getDate("registration_date");
				LocalDate registrationDate = date.toLocalDate();

				EventRegistration eventRegistration = null;
				eventRegistration = new EventRegistration(registrationId, college, student, event, registrationDate);
				eventRegistrationList.add(eventRegistration);

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return eventRegistrationList;

	}

	@Override
	public void searchRegistration(String regId) {

		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from registration where reg_id=?");
			statement.setString(1, regId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				System.out.println("Registration Id:" + resultSet.getString("reg_id") + "\n" + "College Id:"
						+ resultSet.getString("college_id") + "\n" + "Student Id:"
						+ resultSet.getString("student_id") + "\n" + "Event Id:" + resultSet.getString("event_id") + "\n"
								+ "Registration Date:" + resultSet.getString("registration_date")+"\n");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
