package com.canddella.service;

import java.util.List;

import com.canddella.dao.StudentRecruiterRegistrationDAOImpl;
import com.canddella.entity.RecruiterRegistration;
import com.canddella.entity.Skill;
import com.canddella.entity.Student;
import com.canddella.entity.StudentRecruiterRegistration;

public class StudentRecruiterRegistrationServiceImpl implements StudentRecruiterRegistrationService {

	@Override
	public  List<StudentRecruiterRegistration> skillSetBased(Skill skill,RecruiterRegistration recruiterRegistration) {

		StudentRecruiterRegistrationDAOImpl studentRecruiterRegistrationDAOImpl = new StudentRecruiterRegistrationDAOImpl();
		 List<StudentRecruiterRegistration> studentRecruiterRegistrationList=	studentRecruiterRegistrationDAOImpl.skillSetBased(skill,recruiterRegistration);
		return studentRecruiterRegistrationList;

	}

	@Override
	public List<StudentRecruiterRegistration> skillAndCGPABased(Skill skill, Student student) {

		StudentRecruiterRegistrationDAOImpl studentRecruiterRegistrationDAOImpl = new StudentRecruiterRegistrationDAOImpl();
		return studentRecruiterRegistrationDAOImpl.skillAndCGPABased(skill,student);
		
	}

}
