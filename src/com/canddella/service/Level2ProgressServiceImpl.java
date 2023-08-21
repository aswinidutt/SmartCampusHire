package com.canddella.service;

import java.util.List;

import com.canddella.dao.Level1ProgressDAOImpl;
import com.canddella.dao.Level2ProgressDAOImpl;
import com.canddella.entity.Level1Progress;
import com.canddella.entity.Level2Progress;
import com.canddella.entity.Status;
import com.canddella.entity.Student;

public class Level2ProgressServiceImpl implements Level2ProgressService {

	@Override
	public void saveProgress2(Level2Progress level2Progress) {
		
		Level2ProgressDAOImpl level2ProgressDAOImpl=new Level2ProgressDAOImpl();
		level2ProgressDAOImpl.saveProgress2(level2Progress);
		
	}

	@Override
	public void searchProgress2(int progress2Id) {
		Level2ProgressDAOImpl level2ProgressDAOImpl=new Level2ProgressDAOImpl();
		level2ProgressDAOImpl.searchProgress2(progress2Id);
		
		
	}

	@Override
	public List<Level2Progress> displayAllProgress2() {
		Level2ProgressDAOImpl level2ProgressDAOImpl=new Level2ProgressDAOImpl();
		 return level2ProgressDAOImpl.displayAllProgress2();
	}

	public void update2(Student student, Status status) {
		
		Level2ProgressDAOImpl level2ProgressDAOImpl=new Level2ProgressDAOImpl();
		level2ProgressDAOImpl.update2(student,status);
		
	}

	@Override
	public List<Level2Progress> passOnLevel3(Status status) {
		Level2ProgressDAOImpl level2ProgressDAOImpl=new Level2ProgressDAOImpl();
		return level2ProgressDAOImpl.passOnLevel3(status);
	}

//	@Override
//	public List<Level2Progress> displayUpdatedOnly2(Status status) {
//		Level2ProgressDAOImpl level2ProgressDAOImpl=new Level2ProgressDAOImpl();
//	 level2ProgressDAOImpl.displayUpdatedOnly3(status);
//		
//	}

	





	

	

}
