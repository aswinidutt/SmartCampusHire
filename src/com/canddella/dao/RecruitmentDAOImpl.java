package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Recruitment;
import com.canddella.entity.Skill;
import com.canddella.entity.Student;

public class RecruitmentDAOImpl implements RecruitmentDAO {
	DataSource ds = DBConnectionPool.getDataSource();

	@Override
	public Recruitment findSkillId(String skillName) {
		Recruitment recruitment = null;
		try {

			Connection connection = ds.getConnection();
			// PreparedStatement statement=connection.prepareStatement("select
			// first_name,last_name from student join skill on
			// student.skill_id=skill.skill_id");
			PreparedStatement statement = connection.prepareStatement("select *from skill");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				Skill skill = new Skill();
				String skillName1 = resultSet.getString("skill_name");
				skill.setSkillName(skillName1);

				int skillId = resultSet.getInt("skill_id");
				skill.setSkillId(skillId);

				if (skillName1.equalsIgnoreCase(skillName)) {

					recruitment = new Recruitment(skill);

				}

			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return recruitment;

	}

	@Override
	public List<Recruitment> getStudents(int skillId) {
	
		List<Recruitment> recruitmentList = new ArrayList<>();
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select *from student");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Student student = new Student();
				Recruitment recruitment = new Recruitment(student);
				int skillId1 = resultSet.getInt("skill_id");
				student.setSkillId(skillId1);

				if (skillId1 == skillId) {

					String first_name = resultSet.getString("first_name");
					student.setFirstName(first_name);
					String last_name = resultSet.getString("last_name");
					student.setLastName(last_name);

					

					recruitmentList.add(recruitment);

				}

			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return recruitmentList;

	}

}
