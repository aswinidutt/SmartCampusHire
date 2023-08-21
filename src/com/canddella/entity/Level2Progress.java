package com.canddella.entity;

import java.time.LocalDate;

public class Level2Progress {

	private int level2Id;
	private Level1Progress level1Progress;

	private Student student;
	private Status status;
	private Event event;
	private Hire hire;
	private LocalDate start_date;
	private LocalDate end_date;
	private String skill_Description;
	
	



public Level2Progress(int level2Id, Level1Progress level1Progress, Student student, Status status, Event event,
			Hire hire, LocalDate start_date, LocalDate end_date, String skill_Description) {
		super();
		this.level2Id = level2Id;
		this.level1Progress = level1Progress;
		this.student = student;
		this.status = status;
		this.event = event;
		this.hire = hire;
		this.start_date = start_date;
		this.end_date = end_date;
		this.skill_Description = skill_Description;
	}
	public Level2Progress(Student student, Level1Progress level1Progress, int level2Id) {

	this.student=student;
		this.level1Progress=level1Progress;
		this.level2Id=level2Id;
	}





public Level2Progress() {
		// TODO Auto-generated constructor stub
	}

public Level2Progress(int level2Id, Level1Progress level1Progress, Student student, Event event, Hire hire) {
	this.level2Id=level2Id;
}
public int getLevel2Id() {
	return level2Id;
}





public void setLevel2Id(int level2Id) {
	this.level2Id = level2Id;
}





public Level1Progress getLevel1Progress() {
	return level1Progress;
}





public void setLevel1Progress(Level1Progress level1Progress) {
	this.level1Progress = level1Progress;
}





public Student getStudent() {
	return student;
}





public void setStudent(Student student) {
	this.student = student;
}





public Status getStatus() {
	return status;
}





public void setStatus(Status status) {
	this.status = status;
}





public Event getEvent() {
	return event;
}





public void setEvent(Event event) {
	this.event = event;
}





public Hire getHire() {
	return hire;
}





public void setHire(Hire hire) {
	this.hire = hire;
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





public String getSkill_Description() {
	return skill_Description;
}





public void setSkill_Description(String skill_Description) {
	this.skill_Description = skill_Description;
}


	


	

}
