package com.canddella.service;

import java.util.List;

import com.canddella.entity.RecruiterRegistration;

public interface RecruiterRegistrationService {

	public void saveRecruiter(RecruiterRegistration  recruiterRegistration);
	
	public RecruiterRegistration getRecruiter(String recruiterId);
	
	public List<RecruiterRegistration> displayRecruiters();
}
