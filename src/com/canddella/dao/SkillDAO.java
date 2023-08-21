package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Skill;


public interface SkillDAO {
	
	
	public void saveSkill(Skill skill);
	public List<Skill>displayAllSkill();
	public void deleteSkill(int skillId);
	public void searchSkill(int skillId);
	public Skill getSkill(int skillId);//to get a college
	public void updateSkill(String coloumn_name, String newvalue,int skillId);

}
