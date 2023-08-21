package com.canddella.service;

import java.util.List;

import com.canddella.entity.EventRegistration;

public interface EventRegistrationService {

	public void saveRegistration(EventRegistration eventRegistration);
	
	public List<EventRegistration> displayRegistration();
	
	public void searchRegistration(String regId);

}
