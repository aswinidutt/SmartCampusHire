package com.canddella.dao;

import java.util.List;

import com.canddella.entity.EventRegistration;

public interface EventRegistrationDAO {
	
	public void saveRegistration(EventRegistration eventRegistration);
	
	public List<EventRegistration> displayRegistration();
	
	public void searchRegistration(String regId);

}
