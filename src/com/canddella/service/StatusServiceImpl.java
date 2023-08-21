package com.canddella.service;

import java.util.ArrayList;
import java.util.List;

import com.canddella.dao.StatusDAOImpl;
import com.canddella.entity.Status;

public class StatusServiceImpl implements StatusService {

	@Override
	public void saveStatus(Status status) {
		StatusDAOImpl statusDAOImpl=new StatusDAOImpl();
		statusDAOImpl.saveStatus( status);
		
	}

	@Override
	public Status getStatus(String statusId) {
		StatusDAOImpl statusDAOImpl=new StatusDAOImpl();
	Status	status=statusDAOImpl.getStatus( statusId);
		
		return status ;
	}

	@Override
	public List<Status> displayStatus() {
		
		List<Status>statusList=new ArrayList<>();
		StatusDAOImpl statusDAOImpl=new StatusDAOImpl();
			statusList=statusDAOImpl.displayStatus();
		
		return statusList;
	}

	@Override
	public void deleteStatus(String statusId) {
		StatusDAOImpl statusDAOImpl=new StatusDAOImpl();
		statusDAOImpl.deleteStatus(statusId);
	
		
	}

	@Override
	public Status receiveStatus(String statusId) {
		StatusDAOImpl statusDAOImpl=new StatusDAOImpl();
//		Status status=statusDAOImpl.receiveStatus(statusId);
//		return status;
		Status status=null;
		return	status=statusDAOImpl.receiveStatus(statusId);
	}

	@Override
	public void updateStatus(String column_name, String newValue, String statusId) {
		StatusDAOImpl statusDAOImpl=new StatusDAOImpl();
	statusDAOImpl.updateStatus(column_name,newValue,statusId);	
		
	}

}
