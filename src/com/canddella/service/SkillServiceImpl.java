package com.canddella.service;

import java.util.List;

import com.canddella.dao.SkillDAOImpl;
import com.canddella.entity.Skill;


public class SkillServiceImpl implements SkillService {
	SkillDAOImpl collegeDAOImpl=new SkillDAOImpl();
	@Override
	public void saveSkill(Skill skill) {
		
		//CollegeDAOImpl collegeDAOImpl=new CollegeDAOImpl();
		collegeDAOImpl.saveSkill(skill);
		
	}

	@Override
	public List<Skill> displayAllSkill() {
		//CollegeDAOImpl collegeDAOImpl=new CollegeDAOImpl();
		List<Skill> skillList= collegeDAOImpl.displayAllSkill();
		return skillList;
	}

	@Override
	public void deleteSkill(int skillId) {
		collegeDAOImpl.deleteSkill(skillId);
		
	}

	@Override
	public void searchSkill(int skillId) {
		//CollegeDAOImpl collegeDAOImpl=new CollegeDAOImpl();
		collegeDAOImpl.searchSkill(skillId);
		
	}

	
	@Override
	public void updateSkill(String coloumn_name, String newvalue,int skillId)
	{
		//CollegeDAOImpl collegeDAOImpl=new CollegeDAOImpl(collegeName,columnname,collegeId);
		collegeDAOImpl.updateSkill(coloumn_name, newvalue,skillId);
		
	}

	@Override
	public Skill getSkill(int skillId) {
		//CollegeDAOImpl collegeDAOImpl=new CollegeDAOImpl();
		Skill skill=collegeDAOImpl.getSkill( skillId);
		return skill;
	}

	
	

}
