package com.canddella.service;

import java.util.List;

import com.canddella.entity.Status;

public interface StatusService {
	
	public void saveStatus(Status status);
	
	public Status getStatus(String statusId);
	
	public List<Status> displayStatus();
	
	public void deleteStatus(String statusId);
	
	public Status receiveStatus(String statusId);
	
	public void updateStatus(String column_name,String newValue,String statusId );

}
