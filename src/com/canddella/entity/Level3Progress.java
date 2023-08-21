package com.canddella.entity;

import java.time.LocalDate;

public class Level3Progress {

	private int level3Id;
	private Level2Progress level2Progress;
private Level1Progress level1Progress;
	private Student student;
	private Status status;
	private Event event;
	private Hire hire;
	private LocalDate start_date;
	private LocalDate end_date;
	private String skill_Description;
	public Level3Progress(int level3Id, Level2Progress level2Progress, Level1Progress level1Progress, Student student,
			Status status, Event event, Hire hire, LocalDate start_date, LocalDate end_date, String skill_Description) {
		super();
		this.level3Id = level3Id;
		this.level2Progress = level2Progress;
		this.level1Progress = level1Progress;
		this.student = student;
		this.status = status;
		this.event = event;
		this.hire = hire;
		this.start_date = start_date;
		this.end_date = end_date;
		this.skill_Description = skill_Description;
	}
	public Level3Progress(int level3Id, Level2Progress level2Progress, Level1Progress level1Progress,
			Student student, Event event, Hire hire) {
		this.level3Id = level3Id;//no need to give the rest as they are foreign keys
	}
	public Level3Progress(Student student) {

this.student=student;
	}
	public int getLevel3Id() {
		return level3Id;
	}
	public void setLevel3Id(int level3Id) {
		this.level3Id = level3Id;
	}
	public Level2Progress getLevel2Progress() {
		return level2Progress;
	}
	public void setLevel2Progress(Level2Progress level2Progress) {
		this.level2Progress = level2Progress;
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
