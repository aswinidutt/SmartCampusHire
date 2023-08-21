package com.canddella.service;

import java.util.List;

import com.canddella.entity.Level1Progress;
import com.canddella.entity.Level2Progress;
import com.canddella.entity.Status;
import com.canddella.entity.Student;

public interface Level2ProgressService {

	public void saveProgress2(Level2Progress level2Progress);
	
	public void searchProgress2(int progress2Id);
	
	public List<Level2Progress> displayAllProgress2();
	
	public void update2(Student student,Status status);
	
	
	public List<Level2Progress> passOnLevel3(Status status);
}
