package com.canddella.entity;

import java.time.LocalDate;

public class Level1Progress {
	
	private int level1Id;
	private Student student;
	private Status status;
	private Event event;
	private Hire hire;
	private LocalDate  start_date ;
	private LocalDate end_date;
	private String skill_Description;
	public Level1Progress(int level1Id, Student student, Status status, Event event, Hire hire, LocalDate start_date,
			LocalDate end_date, String skill_Description) {
		super();
		this.level1Id = level1Id;
		this.student = student;
		this.status = status;
		this.event = event;
		this.hire = hire;
		this.start_date = start_date;
		this.end_date = end_date;
		this.skill_Description = skill_Description;
	}
	public Level1Progress(Student student) {
		this.student = student;
	}
	public Level1Progress() {
		//this.level1Progress=level1Progress;
	}
	public Level1Progress(Student student, int level1Id) {
		//this.level1Progress=level1Progress;
		this.student=student;
		this.level1Id=level1Id;
	}
	public Level1Progress(int level1Id, Student student, Status status, Event event, Hire hire) {
		this.level1Id=level1Id;
//		this.student=student;
//		this.status=status;
//		this.event=event;
//		this.hire=hire;
		
		// TODO Auto-generated constructor stub
	}
	public int getLevel1Id() {
		return level1Id;
	}
	public void setLevel1Id(int level1Id) {
		this.level1Id = level1Id;
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
