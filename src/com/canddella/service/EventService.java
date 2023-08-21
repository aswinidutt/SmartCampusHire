package com.canddella.service;

import java.util.List;

import com.canddella.entity.Event;

public interface EventService {

	public void  insertEvent(Event event);

	List<Event> displayAllEvents();
	
	public void deleteEvent(String eventId);
	
	public Event searchEvent(String eventId);
	
	public Event getEvent(String eventId);
	
	public void updateEvent(String column_name,String newValue,String eventId);

}
