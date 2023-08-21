package com.canddella.service;

import java.util.List;

import com.canddella.entity.Level1Progress;
import com.canddella.entity.Status;
import com.canddella.entity.Student;

public interface Level1ProgressService {

	public void saveProgress(Level1Progress level1Progress);
	
	public void searchProgress(int progressId);
	
	public List<Level1Progress> displayAllProgress();
	
	public void update(Student student,Status status);
	
	public List<Level1Progress>displayUpdatedOnly(Status status);
	
	public List<Level1Progress> passOnLevel2(Status status);
}
