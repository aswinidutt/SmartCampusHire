package com.canddella.dao;

import java.util.List;

import com.canddella.entity.RecruiterRegistration;

public interface RecruiterRegistrationDAO {
	
	public void saveRecruiter(RecruiterRegistration  recruiterRegistration);

	
	public  RecruiterRegistration getRecruiter(String recruiterId);
	
	
	public List<RecruiterRegistration> displayRecruiters();
}
