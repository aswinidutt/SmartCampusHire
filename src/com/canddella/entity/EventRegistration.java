package com.canddella.entity;

import java.time.LocalDate;

public class EventRegistration {
	private String regId;
	private College college;
	private Student student;
private Event event;
private LocalDate regDate;
public EventRegistration(String regId, College college, Student student, Event event, LocalDate regDate) {
	super();
	this.regId = regId;
	this.college = college;
	this.student = student;
	this.event = event;
	this.regDate = regDate;
}
public EventRegistration(Student student2) {
	// TODO Auto-generated constructor stub
}
public String getRegId() {
	return regId;
}
public void setRegId(String regId) {
	this.regId = regId;
}
public College getCollege() {
	return college;
}
public void setCollege(College college) {
	this.college = college;
}
public Student getStudent() {
	return student;
}
public void setStudent(Student student) {
	this.student = student;
}
public Event getEvent() {
	return event;
}
public void setEvent(Event event) {
	this.event = event;
}
public LocalDate getRegDate() {
	return regDate;
}
public void setRegDate(LocalDate regDate) {
	this.regDate = regDate;
}
	
	

}
