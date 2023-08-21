package com.canddella.service;

import java.util.List;

import com.canddella.entity.Recruitment;
//import com.canddella.entity.Skill;

public interface RecruitmentService {
	
	public Recruitment findSkillId(String skillName);
	
	public List<Recruitment>getStudents(int skill);

}
