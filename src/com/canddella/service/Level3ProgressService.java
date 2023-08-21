package com.canddella.service;

import java.util.List;

import com.canddella.entity.Level2Progress;
//import com.canddella.entity.Level2Progress;
import com.canddella.entity.Level3Progress;
import com.canddella.entity.Status;
import com.canddella.entity.Student;

public interface Level3ProgressService {

	public void saveProgress3(Level3Progress level3Progress);
	
	public void searchProgress3(int progress3Id);
	
	public List<Level3Progress> displayAllProgress3();
	
	public void update3(Student student,Status status);
	
	public List<Level3Progress>displayUpdatedOnly3(Status status);
}
