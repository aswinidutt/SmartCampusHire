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
import com.canddella.entity.Level2Progress;
import com.canddella.entity.Status;
import com.canddella.entity.Student;

public class Level2ProgressDAOImpl implements Level2ProgressDAO {
	DataSource ds = DBConnectionPool.getDataSource();

	@Override
	public void saveProgress2(Level2Progress level2Progress) {

		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into level_2_progress (level1_id,student_id,status_id,event_id,hiring_id,startdate,enddate,skill2_description) values (?,?,?,?,?,?,?,?)");

			statement.setInt(1, level2Progress.getLevel1Progress().getLevel1Id());
			statement.setString(2, level2Progress.getStudent().getStudent_id());

			statement.setString(3, level2Progress.getStatus().getStatusId());
			statement.setString(4, level2Progress.getEvent().getEvent_id());
			statement.setString(5, level2Progress.getHire().getHire_id());

			Date startDate = Date.valueOf(level2Progress.getStart_date());
			statement.setDate(6, startDate);

			Date endDate = Date.valueOf(level2Progress.getEnd_date());
			statement.setDate(7, endDate);

			statement.setString(8, level2Progress.getSkill_Description());

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
	public void searchProgress2(int progress2Id) {
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select* from level_2_progress where level2_id=?");
			statement.setInt(1, progress2Id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				System.out.println("Level 2 Id :" + " " + resultSet.getInt("level2_id") + "\n" + "Level 1 Id:" + " "
						+ resultSet.getString("level1_id") + "\n" + "Student Id :" + "  "
						+ resultSet.getString("student_id") + "\n " + "Status Id:" + " "
						+ resultSet.getString("status_id") + " \n" + "Hiring Id:" + " "
						+ resultSet.getString("hiring_id"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<Level2Progress> displayAllProgress2() {
		List<Level2Progress> level2ProgressList = new ArrayList<>();
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select* from level_2_progress");

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				System.out.println("Level 2 Id :" + " " + resultSet.getInt("level2_id") + "\n" + "Level 1 Id:" + " "
						+ resultSet.getString("level1_id") + "\n" + "Student Id :" + "  "
						+ resultSet.getString("student_id") + "\n " + "Status Id:" + " "
						+ resultSet.getString("status_id") + " \n" + "Hiring Id:" + " "
						+ resultSet.getString("hiring_id"));

				int level2Id = resultSet.getInt("level2_id");

				Level1Progress level1Progress = new Level1Progress();
				int level1Id = resultSet.getInt("level1_id");
				level1Progress.setLevel1Id(level1Id);

				Student student=new Student();
				String studentId= resultSet.getString("student_id");
				student.setStudent_id(studentId);
				

				Event event=new Event();
				String eventId= resultSet.getString("event_id");
				event.setEvent_id(eventId);
				

				Hire hire =new Hire();
				String hiringId=resultSet.getString("hiring_id");
				hire.setHire_id(hiringId);

				Level2Progress level2Progress = new Level2Progress(level2Id,

						level1Progress, student,

						 event, hire);

				level2ProgressList.add(level2Progress);

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return level2ProgressList;
	}

	public void update2(Student student, Status status) {
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("update level_2_progress set status_id=? where student_id=?");
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
	public List<Level2Progress> passOnLevel3(Status status) {
		List<Level2Progress> level2ProgressList = new ArrayList();
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select*from level_2_progress where status_id=?");

			statement.setString(1, status.getStatusId());

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				if (status.getStatusId() == resultSet.getString("status_id"))
					;
				{
					Student student = new Student();
					String studentId = resultSet.getString("student_id");
					student.setStudent_id(studentId);

					int level2Id = resultSet.getInt("level2_id");

					Level1Progress level1Progress = new Level1Progress();
					int level1Id = resultSet.getInt("level1_id");
					level1Progress.setLevel1Id(level1Id);

					Level2Progress level2Progress = null;
					level2Progress = new Level2Progress(student, level1Progress, level2Id);
					level2ProgressList.add(level2Progress);

				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return level2ProgressList;

	}

//	@Override
//	public List<Level2Progress> displayUpdatedOnly2(Status status) {
//
//		List<Level2Progress> level2ProgressList = new ArrayList();
//
//		try {
//			Connection connection = ds.getConnection();
//			PreparedStatement statement = connection.prepareStatement("select*from level_2_progress where status_id=?");
//
//			statement.setString(1, status.getStatusId());
//
//			ResultSet resultSet = statement.executeQuery();
//
//			while (resultSet.next()) {
//
//				Student student = new Student();
//				String studentId = resultSet.getString("student_id");
//				student.setStudent_id(studentId);
//
//				Level2Progress level2Progress = null;
//				// level2Progress = new Level2Progress(student);
//				level2ProgressList.add(level2Progress);
//
//			}
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		return level2ProgressList;
//
//	}

}
