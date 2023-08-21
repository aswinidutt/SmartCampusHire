package com.canddella.service;

import java.util.ArrayList;
import java.util.List;

import com.canddella.dao.EventRegistrationDAOImpl;
import com.canddella.entity.EventRegistration;

public class EventRegistrationServiceImpl implements EventRegistrationService {
	
	EventRegistrationDAOImpl eventRegistartionDAOImpl =new EventRegistrationDAOImpl ();
	@Override
	public void saveRegistration(EventRegistration eventRegistration) {
		eventRegistartionDAOImpl.saveRegistration(eventRegistration);
		
	}
	@Override
	public List<EventRegistration> displayRegistration() {
		List<EventRegistration>eventRegistartionList= new ArrayList<>();
		
		eventRegistartionList=eventRegistartionDAOImpl.displayRegistration();
	return eventRegistartionList;	
	}
	@Override
	public void searchRegistration(String regId) {
		eventRegistartionDAOImpl.searchRegistration(regId);	
		
	}

}
