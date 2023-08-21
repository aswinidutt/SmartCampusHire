package com.canddella.service;

import java.util.List;

import com.canddella.dao.CollegeDAOImpl;
import com.canddella.entity.College;


public class CollegeServiceImpl implements CollegeService {
	CollegeDAOImpl collegeDAOImpl=new CollegeDAOImpl();
	@Override
	public void saveCollege(College college) {
		
		//CollegeDAOImpl collegeDAOImpl=new CollegeDAOImpl();
		collegeDAOImpl.saveCollege(college);
		
	}

	@Override
	public List<College> displayAllCollege() {
		//CollegeDAOImpl collegeDAOImpl=new CollegeDAOImpl();
		List<College> collegeList= collegeDAOImpl.displayAllCollege();
		return collegeList;
	}

	@Override
	public void deleteCollege(String collegeId) {
		collegeDAOImpl.deleteCollege(collegeId);
		
	}

	@Override
	public void searchCollege(String collegeId) {
		//CollegeDAOImpl collegeDAOImpl=new CollegeDAOImpl();
		collegeDAOImpl.searchCollege(collegeId);
		
	}

	
	@Override
	public void updateCollege(String coloumn_name,String newvalue,String collegeId)
	{
		//CollegeDAOImpl collegeDAOImpl=new CollegeDAOImpl(collegeName,columnname,collegeId);
		collegeDAOImpl.updateCollege(coloumn_name, newvalue,collegeId);
		
	}

	@Override
	public College getCollege(String collegeId) {
		//CollegeDAOImpl collegeDAOImpl=new CollegeDAOImpl();
		College college=collegeDAOImpl.getCollege( collegeId);
		return college;
	}

	
	

}
