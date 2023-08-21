package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Event;
import com.canddella.entity.Hire;
import com.canddella.entity.RecruiterRegistration;

public class RecruiterRegistrationDAOImpl implements RecruiterRegistrationDAO {
	DataSource ds = DBConnectionPool.getDataSource();

	@Override
	public void saveRecruiter(RecruiterRegistration recruiterRegistration) {
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into recruiter_registration (recruiter_id,hiring_id,event_id,vacancies,skill_description) values(?,?,?,?,?)");
			// statement.executeUpdate();

			statement.setString(1, recruiterRegistration.getRecruiter_id());
			statement.setString(2, recruiterRegistration.getHire().getHire_id());
			statement.setString(3, recruiterRegistration.getEvent().getEvent_id());
			statement.setInt(4, recruiterRegistration.getVacancies());
			statement.setString(5, recruiterRegistration.getSkillDescription());

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
	public RecruiterRegistration getRecruiter(String recruiterId) {
		RecruiterRegistration recruiterRegistration=null;
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select * from recruiter_registration where recruiter_id=?");
			statement.setString(1, recruiterId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				Hire hire=new Hire();
				String hire_Id=resultSet.getString(2);
				hire.setHire_id(hire_Id);
				
				Event event=new Event();
				String event_id=resultSet.getString(3);
				event.setEvent_id(event_id);
				
				 recruiterRegistration = new RecruiterRegistration(resultSet.getString(1),
						hire, event,resultSet.getInt(4),resultSet.getString(5));
//				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return  recruiterRegistration;
	}

	@Override
	public List<RecruiterRegistration> displayRecruiters() {
		
		List<RecruiterRegistration> recruiterRegistrationList=new ArrayList<>();
		
		RecruiterRegistration recruiterRegistration=null;
		
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select * from recruiter_registration ");
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				Hire hire=new Hire();
				String hire_Id=resultSet.getString(2);
				hire.setHire_id(hire_Id);
				
				Event event=new Event();
				String event_id=resultSet.getString(3);
				event.setEvent_id(event_id);
				
				 recruiterRegistration = new RecruiterRegistration(resultSet.getString(1),
						hire, event,resultSet.getInt(4),resultSet.getString(5));
				 recruiterRegistrationList.add(recruiterRegistration);
				 
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return  recruiterRegistrationList;
		
	}

}
