package com.canddella.service;

import java.util.List;

import com.canddella.dao.Level2ProgressDAOImpl;
import com.canddella.dao.Level3ProgressDAOImpl;
import com.canddella.entity.Level2Progress;
import com.canddella.entity.Level3Progress;
import com.canddella.entity.Status;
import com.canddella.entity.Student;

public class Level3ProgressServiceImpl implements Level3ProgressService {

	@Override
	public void saveProgress3(Level3Progress level3Progress) {
		
		Level3ProgressDAOImpl level3ProgressDAOImpl=new Level3ProgressDAOImpl();
		level3ProgressDAOImpl.saveProgress3(level3Progress);
		
	}

	@Override
	public void searchProgress3(int progress3Id) {
		Level3ProgressDAOImpl level3ProgressDAOImpl=new Level3ProgressDAOImpl();
		level3ProgressDAOImpl.searchProgress3(progress3Id);
		
		
	}

	@Override
	public List<Level3Progress> displayAllProgress3() {
		Level3ProgressDAOImpl level3ProgressDAOImpl=new Level3ProgressDAOImpl();
		 return level3ProgressDAOImpl.displayAllProgress3();
	}

	public void update3(Student student, Status status) {
		
		Level3ProgressDAOImpl level3ProgressDAOImpl=new Level3ProgressDAOImpl();
		level3ProgressDAOImpl.update3(student,status);
		
	}



	@Override
	public List<Level3Progress> displayUpdatedOnly3(Status status) {
		Level3ProgressDAOImpl level3ProgressDAOImpl=new Level3ProgressDAOImpl();
		return level3ProgressDAOImpl.displayUpdatedOnly3(status);	
		
	}
}
