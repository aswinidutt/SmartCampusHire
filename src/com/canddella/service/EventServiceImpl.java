package com.canddella.service;

import java.util.List;

import com.canddella.dao.EventDAOImpl;
import com.canddella.entity.Event;

public class EventServiceImpl implements EventService {
	EventDAOImpl eventDAOImpl=new EventDAOImpl(); 

	@Override
	public void insertEvent(Event event) {
		eventDAOImpl.insertEvent( event);
		
	}
	

	@Override
	public List<Event> displayAllEvents() {
		EventDAOImpl eventDAOImpl=new EventDAOImpl(); 
		
		List<Event> eventList=eventDAOImpl.displayAllEvents();
				
		
		return eventList;
	}


	public void deleteEvent(String eventId) {
		EventDAOImpl eventDAOImpl=new EventDAOImpl(); 
		eventDAOImpl.deleteEvent(eventId);
		
	}


	@Override
	public Event searchEvent(String eventId) {
		EventDAOImpl eventDAOImpl=new EventDAOImpl();
		Event event=eventDAOImpl.searchEvent(eventId);
		return event;
		
		
	}


	@Override
	public Event getEvent(String eventId) {
		EventDAOImpl eventDAOImpl=new EventDAOImpl();
		Event event=eventDAOImpl.getEvent(eventId);
		return event;
		
		
	}


	@Override
	public void updateEvent(String column_name, String newValue, String eventId) {
		EventDAOImpl eventDAOImpl=new EventDAOImpl();
		eventDAOImpl.updateEvent(column_name, newValue, eventId);
		
		
	}


	

	
}
