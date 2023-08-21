package com.canddella.service;

import java.util.List;

import com.canddella.dao.RecruiterRegistrationDAOImpl;
import com.canddella.entity.RecruiterRegistration;

public class RecruiterRegistrationServiceImpl implements RecruiterRegistrationService {

	@Override
	public void saveRecruiter(RecruiterRegistration recruiterRegistration) {
		
	RecruiterRegistrationDAOImpl recruiterRegistrationDAOImpl=new RecruiterRegistrationDAOImpl();
	recruiterRegistrationDAOImpl.saveRecruiter(recruiterRegistration);
		
	}

	@Override
	public RecruiterRegistration getRecruiter(String recruiterId) {
		
		RecruiterRegistrationDAOImpl recruiterRegistrationDAOImpl=new RecruiterRegistrationDAOImpl();
		return recruiterRegistrationDAOImpl.getRecruiter(recruiterId);
	}

	@Override
	public List<RecruiterRegistration> displayRecruiters() {
		List<RecruiterRegistration> recruiterRegistrationList=null;
		
		RecruiterRegistrationDAOImpl recruiterRegistrationDAOImpl=new RecruiterRegistrationDAOImpl();
		
		return recruiterRegistrationList=recruiterRegistrationDAOImpl.displayRecruiters();
		
	}


}
