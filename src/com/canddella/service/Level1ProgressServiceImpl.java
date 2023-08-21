package com.canddella.service;

import java.util.List;

import com.canddella.dao.Level1ProgressDAOImpl;
import com.canddella.entity.Level1Progress;
import com.canddella.entity.Status;
import com.canddella.entity.Student;

public class Level1ProgressServiceImpl implements Level1ProgressService {

	@Override
	public void saveProgress(Level1Progress level1Progress) {
		
		Level1ProgressDAOImpl level1ProgressDAOImpl=new Level1ProgressDAOImpl();
		level1ProgressDAOImpl.saveProgress(level1Progress);
		
	}

	@Override
	public void searchProgress(int progressId) {
		Level1ProgressDAOImpl level1ProgressDAOImpl=new Level1ProgressDAOImpl();
		level1ProgressDAOImpl.searchProgress(progressId);
		
		
	}

	@Override
	public List<Level1Progress> displayAllProgress() {
		Level1ProgressDAOImpl level1ProgressDAOImpl=new Level1ProgressDAOImpl();
		 return level1ProgressDAOImpl.displayAllProgress();
	}

	public void update(Student student, Status status) {
		
		Level1ProgressDAOImpl level1ProgressDAOImpl=new Level1ProgressDAOImpl();
		level1ProgressDAOImpl.update(student,status);
		
	}

	@Override
	public List<Level1Progress> displayUpdatedOnly(Status status) {
		Level1ProgressDAOImpl level1ProgressDAOImpl=new Level1ProgressDAOImpl();
		return level1ProgressDAOImpl.displayUpdatedOnly(status);	
		
	}

	@Override
	public List<Level1Progress> passOnLevel2(Status status) {
		
		Level1ProgressDAOImpl level1ProgressDAOImpl=new Level1ProgressDAOImpl();
		return level1ProgressDAOImpl.passOnLevel2( status);	
		
	}

	

	

}
