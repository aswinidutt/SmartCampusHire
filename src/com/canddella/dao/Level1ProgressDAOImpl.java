package com.canddella.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Event;
import com.canddella.entity.Hire;
import com.canddella.entity.Level1Progress;
import com.canddella.entity.Status;
import com.canddella.entity.Student;

public class Level1ProgressDAOImpl implements Level1ProgressDAO {
	DataSource ds = DBConnectionPool.getDataSource();

	@Override
	public void saveProgress(Level1Progress level1Progress) {

		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into level_1_progress (student_id,status_id,hiring_id,start_date,end_date,skill1_description) values (?,?,?,?,?,?,?)");

			statement.setString(1, level1Progress.getStudent().getStudent_id());

			statement.setString(2, level1Progress.getStatus().getStatusId());
			statement.setString(3, level1Progress.getEvent().getEvent_id());
			statement.setString(4, level1Progress.getHire().getHire_id());

			Date startDate = Date.valueOf(level1Progress.getStart_date());
			statement.setDate(5, startDate);

			Date endDate = Date.valueOf(level1Progress.getEnd_date());
			statement.setDate(6, endDate);

			statement.setString(7, level1Progress.getSkill_Description());

			int count = 0;
			count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Updated Successfully");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void searchProgress(int progressId) {
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select* from level_1_progress where level1_id=?");
			statement.setInt(1, progressId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				System.out.println("Level 1 Id:" + " " + resultSet.getInt("level1_id") + "\n" + "Student Id :" + "  "
						+ resultSet.getString("student_id") + "\n " + "Status Id:" + " "
						+ resultSet.getString("status_id") + "Event Id:" + " " + resultSet.getString("event_id") + " \n"
						+ "Hiring Id:" + " " + resultSet.getString("hiring_id"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<Level1Progress> displayAllProgress() {
		
		List<Level1Progress>level1ProgressList=new ArrayList<>();

		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select* from level_1_progress");

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

			System.out.println("Level 1 Id:" + " " + resultSet.getInt("level1_id") + "\n" + "Student Id :" + "  "
					+ resultSet.getString("student_id") + "\n " + "Status Id:" + " "
					+ resultSet.getString("status_id") + " \n" + "Event Id:" + "  "
						+ resultSet.getString("event_id") + " \n" + "Hiring Id:" + " "
						+ resultSet.getString("hiring_id"));
			
				int level1Id= resultSet.getInt("level1_id");
			
				Student student=new Student();
				String studentId= resultSet.getString("student_id");
				student.setStudent_id(studentId);
				
				Status status=new Status();
				String statusId= resultSet.getString("status_id");
				status.setStatusId(statusId);
				
				Event event=new Event();
				String eventId= resultSet.getString("event_id");
				event.setEvent_id(eventId);
				
				Hire hire =new Hire();
				String hiringId=resultSet.getString("hiring_id");
				hire.setHire_id(hiringId);
				
				Level1Progress  level1Progress =new Level1Progress (level1Id,student,status,event,hire);
				
				
				level1ProgressList.add(level1Progress);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return level1ProgressList;
	}

	public void update(Student student, Status status) {
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("update level_1_progress set status_id=? where student_id=?");
			statement.setString(1, status.getStatusId());
			statement.setString(2, student.getStudent_id());

			int count = 0;
			count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Updated Successfully");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<Level1Progress> displayUpdatedOnly(Status status) {

		List<Level1Progress> level1ProgressList = new ArrayList();

		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select*from level_1_progress where status_id=?");

			statement.setString(1, status.getStatusId());

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				Student student = new Student();
				String studentId = resultSet.getString("student_id");
				student.setStudent_id(studentId);

				Level1Progress level1Progress = null;
				level1Progress = new Level1Progress(student);
				level1ProgressList.add(level1Progress);

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return level1ProgressList;

	}

	@Override
	public List<Level1Progress> passOnLevel2(Status status) {

		List<Level1Progress> level1ProgressList = new ArrayList();
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select*from level_1_progress where status_id=?");

			statement.setString(1, status.getStatusId());

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				if (status.getStatusId() == resultSet.getString("status_id"))
					;
				{
					Student student = new Student();
					String studentId = resultSet.getString("student_id");
					student.setStudent_id(studentId);

					int level1Id = resultSet.getInt("level1_id");

					Level1Progress level1Progress = null;
					level1Progress = new Level1Progress(student, level1Id);
					level1ProgressList.add(level1Progress);

				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return level1ProgressList;

	}

}
