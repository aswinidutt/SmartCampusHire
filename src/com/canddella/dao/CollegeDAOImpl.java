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

public class CollegeDAOImpl implements CollegeDAO {
	// DataSource ds=DBConnectionPool.getDataSource();
	@Override
	public void saveCollege(College college) {
		DataSource ds = DBConnectionPool.getDataSource();

		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into college(college_id,college_name,location,accrediation_details,established_year) values(?,?,?,?,?)");
			statement.setString(1, college.getCollegeId());
			statement.setString(2, college.getCollegeName());
			statement.setString(3, college.getLocation());
			statement.setString(4, college.getAccrediationDetails());
			statement.setInt(5, college.getEstablishedYr());

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
	public List<College> displayAllCollege() {

		DataSource ds = DBConnectionPool.getDataSource();
		College college = null;
		List<College> collegeList = new ArrayList<>();

		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from college");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				String collegeId = resultSet.getString("college_id");
				String collegeName = resultSet.getString("college_name");
				String location = resultSet.getString("location");

				String accrediationDetails = resultSet.getString("accrediation_details");

				int establishedyear = resultSet.getInt("established_year");

				college = new College(collegeId, collegeName, location, accrediationDetails, establishedyear);
				collegeList.add(college);
			}

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return collegeList;
	}

	@Override
	public void deleteCollege(String collegeId) {
		DataSource ds = DBConnectionPool.getDataSource();
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("delete from college where college_id=?");
			statement.setString(1, collegeId);
			statement.executeUpdate();
			System.out.println("Deleted");

			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void searchCollege(String collegeId) {

		DataSource ds = DBConnectionPool.getDataSource();
		College college = null;
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from college where college_id =?");
			statement.setString(1, collegeId);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String collegeId1 = resultSet.getString("college_id");
				String collegeName = resultSet.getString("college_name");
				String location = resultSet.getString("location");
				String accrediation_details = resultSet.getString("accrediation_details");
				int established_year = resultSet.getInt("established_year");

				college = new College(collegeId1, collegeName, location, accrediation_details, established_year);
				System.out.println("College Id:" + college.getCollegeId() + "\n" + "College_Name:"
						+ college.getCollegeName() + "\n" + "College_location:" + college.getLocation() + "\n"
						+ "Accrediation Details:" + college.getAccrediationDetails() + "\n" + "Established Year:"
						+ college.getEstablishedYr() + "\n");
			}

			// statement.executeUpdate();
			// System.out.println("");

			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public College getCollege(String collegeId) {
		
		DataSource ds = DBConnectionPool.getDataSource();
		College college = null;
		

		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select  * from college where college_id=?");
		statement.setString(1,collegeId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				String collegeId1 = resultSet.getString("college_id");
				String collegeName = resultSet.getString("college_name");
				String location = resultSet.getString("location");

				String accrediationDetails = resultSet.getString("accrediation_details");

				int establishedyear = resultSet.getInt("established_year");

				college = new College(collegeId1, collegeName, location, accrediationDetails, establishedyear);
//				collegeList.add(college);
			}

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return college;
	}

	

	@Override
	public void updateCollege(String coloumn_name,String newvalue,String collegeId) {
	
		DataSource ds = DBConnectionPool.getDataSource();
		//College college = null;
		

		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("update college set "+ coloumn_name +" = ? where college_id=?");
		statement.setString(1,newvalue);
		statement.setString(2,collegeId);
		 statement.executeUpdate();
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

}
