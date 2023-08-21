package com.canddella.dao;

import java.util.List;

import com.canddella.entity.College;


public interface CollegeDAO {
	
	public void saveCollege(College college);
	public List<College>displayAllCollege();
	public void deleteCollege(String collegeId);
	public void searchCollege(String collegeId);
	//to update the table u need two functions as listed below
	public College getCollege(String collegeId);//to get a college
	public void updateCollege(String coloumn_name,String newvalue,String collegeId);

}
