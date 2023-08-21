package com.canddella.entity;

import java.time.LocalDate;

public class Event {
	private String event_id;
	private String event_name;
	private String event_venue;
	private LocalDate start_date;
	private LocalDate end_date;
	public Event(String event_id, String event_name, String event_venue, LocalDate start_date, LocalDate end_date) {
		super();
		this.event_id = event_id;
		this.event_name = event_name;
		this.event_venue = event_venue;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	public Event() {
		// TODO Auto-generated constructor stub
	}
	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getEvent_venue() {
		return event_venue;
	}
	public void setEvent_venue(String event_venue) {
		this.event_venue = event_venue;
	}
	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	public LocalDate getEnd_date() {
		return end_date;
	}
	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}
	
}
