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
import com.canddella.entity.Skill;

public class SkillDAOImpl implements SkillDAO {
	
	@Override
	public void saveSkill(Skill skill) {
		DataSource ds = DBConnectionPool.getDataSource();

		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into skill(skill_id,skill_name) values(?,?)");
			statement.setInt(1, skill.getSkillId());
			statement.setString(2, skill.getSkillName());
			

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
	public List<Skill> displayAllSkill() {

		DataSource ds = DBConnectionPool.getDataSource();
		Skill skill = null;
		List<Skill> skillList = new ArrayList<>();

		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from skill");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int skillId = resultSet.getInt("skill_id");
				String skillName = resultSet.getString("skill_name");
				

				skill = new Skill(skillId, skillName);
				skillList.add(skill);
			}

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return skillList;
	}

	@Override
	public void deleteSkill(int skillId) {
		DataSource ds = DBConnectionPool.getDataSource();
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("delete from skill where skill_id=?");
			statement.setInt(1, skillId);
			statement.executeUpdate();
			System.out.println("Deleted");

			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void searchSkill(int skillId) {

		DataSource ds = DBConnectionPool.getDataSource();
		Skill college = null;
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from skill where skill_id =?");
			statement.setInt(1, skillId);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int skillId1 = resultSet.getInt("skill_id");
				String skillName = resultSet.getString("skill_name");
				
				college = new Skill(skillId1, skillName);
				System.out.println("Skill Id:" + college.getSkillId() + "\n" + "Skill_Name:"
						+ college.getSkillName() + "\n" );
			}

			// statement.executeUpdate();
			// System.out.println("");

			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public Skill getSkill(int skillId) {
		
		DataSource ds = DBConnectionPool.getDataSource();
		Skill college = null;
		

		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select  * from skill where skill_id=?");
		statement.setInt(1,skillId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int skillId1 = resultSet.getInt("skill_id");
				String skillName = resultSet.getString("skill_name");
				

				college = new Skill(skillId1, skillName);
//				collegeList.add(college);
			}

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return college;
	}

	

	@Override
	public void updateSkill(String coloumn_name, String newvalue,int skillId) {
	
		DataSource ds = DBConnectionPool.getDataSource();
		//College college = null;
		

		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("update skill set "+ coloumn_name +" = ? where skill_name = ? ");
		statement.setString(1,newvalue);
		statement.setInt(2,skillId);
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
