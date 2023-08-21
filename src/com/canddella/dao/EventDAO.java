package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Event;

public interface EventDAO {
	
	public void  insertEvent(Event event);
	
	public List<Event> displayAllEvents();
	
	public void deleteEvent(String eventId);
	
	public Event searchEvent(String eventId);
	
	public Event getEvent(String eventId);
	
	public void updateEvent(String column_name,String newValue,String eventId);
}
