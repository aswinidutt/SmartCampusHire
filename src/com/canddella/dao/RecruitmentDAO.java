package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Recruitment;
//import com.canddella.entity.Skill;

public interface RecruitmentDAO {
	
	public Recruitment findSkillId(String skillName);

	public List<Recruitment> getStudents(int skill);
}
