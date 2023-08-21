package com.canddella.service;

import java.util.List;

import com.canddella.dao.RecruitmentDAOImpl;
import com.canddella.entity.Recruitment;
//import com.canddella.entity.Skill;
import com.canddella.entity.Student;

public class RecruitmentServiceImpl implements RecruitmentService {

	@Override
	public Recruitment findSkillId(String skillName) {
		
		RecruitmentDAOImpl recruitmentDAOImpl =new RecruitmentDAOImpl ();
		 return recruitmentDAOImpl.findSkillId(skillName);
		
	}

	public List<Recruitment>getStudents(int skillId) {
		
		RecruitmentDAOImpl recruitmentDAOImpl =new RecruitmentDAOImpl ();
		 return recruitmentDAOImpl.getStudents(skillId);
		
	}

	

}
