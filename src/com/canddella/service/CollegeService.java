package com.canddella.service;

import java.util.List;

import com.canddella.entity.College;

public interface CollegeService {

	public void saveCollege(College college);
	public List<College>displayAllCollege();
	public void deleteCollege(String collegeId);
	public void searchCollege(String collegeId);
	public College getCollege(String collegeId);//to get a college
	public void updateCollege(String coloumn_name,String newvalue,String collegeId);
}
