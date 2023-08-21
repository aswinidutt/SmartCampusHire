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
import com.canddella.entity.Level3Progress;
import com.canddella.entity.Status;
import com.canddella.entity.Student;

public class Level3ProgressDAOImpl implements Level3ProgressDAO {
	DataSource ds = DBConnectionPool.getDataSource();

	@Override
	public void saveProgress3(Level3Progress level3Progress) {

		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into level_3_progress (level2_id,level1_id,student_id,status_id,event_id,hiring_id,startdate,enddate,skill3_description) values (?,?,?,?,?,?,?,?,?)");

			statement.setInt(1, level3Progress.getLevel2Progress().getLevel2Id());
			statement.setInt(2, level3Progress.getLevel1Progress().getLevel1Id());
			statement.setString(3, level3Progress.getStudent().getStudent_id());

			statement.setString(4, level3Progress.getStatus().getStatusId());
			statement.setString(5, level3Progress.getEvent().getEvent_id());
			statement.setString(6, level3Progress.getHire().getHire_id());

			Date startDate = Date.valueOf(level3Progress.getStart_date());
			statement.setDate(7, startDate);

			Date endDate = Date.valueOf(level3Progress.getEnd_date());
			statement.setDate(8, endDate);

			statement.setString(9, level3Progress.getSkill_Description());

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
	public void searchProgress3(int progress3Id) {
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select* from level_3_progress where level3_id=?");
			statement.setInt(1, progress3Id);
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
	public List<Level3Progress> displayAllProgress3() {
		List<Level3Progress> level3ProgressList=new ArrayList<>();
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select* from level_3_progress");

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				System.out.println("Level 3 Id :"+" "+resultSet.getInt("level3_id") +"\n"+"Level 2 Id :"+" "+resultSet.getInt("level2_id") +"\n"+"Level 1 Id:" + " " + resultSet.getString("level1_id") + "\n" + "Student Id :" + "  "
					+ resultSet.getString("student_id") + "\n " + "Status Id:" + " "
						+ resultSet.getString("status_id") + " \n" + "Hiring Id:" + " "
						+ resultSet.getString("hiring_id"));
				
				int level3Id = resultSet.getInt("level3_id");

				Level2Progress level2Progress = new Level2Progress();
				int level2Id = resultSet.getInt("level2_id");
				level2Progress.setLevel2Id(level2Id);
				
				

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

				Level3Progress level3Progress = new Level3Progress(level3Id,level2Progress,

						level1Progress, student,

						 event, hire);

				level3ProgressList.add(level3Progress);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return level3ProgressList;
	}

	public void update3(Student student, Status status) {
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("update level_3_progress set status_id=? where student_id=?");
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
	public List<Level3Progress> displayUpdatedOnly3(Status status) {
		List<Level3Progress> level3ProgressList = new ArrayList();

	try {
		Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select*from level_3_progress where status_id=?");

			statement.setString(1, status.getStatusId());

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

			Student student = new Student();
				String studentId = resultSet.getString("student_id");
				student.setStudent_id(studentId);
				
				
				Level3Progress level3Progress=new Level3Progress(student);
				
				 level3ProgressList.add(level3Progress);	

			}
	}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
	return level3ProgressList;
	
		
	
	}
}




