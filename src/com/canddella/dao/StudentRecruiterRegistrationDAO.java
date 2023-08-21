package com.canddella.dao;

import java.util.List;

import com.canddella.entity.RecruiterRegistration;
import com.canddella.entity.Skill;
import com.canddella.entity.Student;
import com.canddella.entity.StudentRecruiterRegistration;

public interface StudentRecruiterRegistrationDAO {

	
	public  List<StudentRecruiterRegistration> skillSetBased(Skill skill,RecruiterRegistration recruiterRegistration);
	
	public List<StudentRecruiterRegistration> skillAndCGPABased(Skill skill,Student student);

}
