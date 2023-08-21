package com.canddella.entity;


public class Recruitment {
	private Student student;
	private Skill skill;
	
	public Recruitment(Student student, Skill skill) {
		super();
		this.student = student;
		this.skill = skill;
	}
	public Recruitment(Skill skill) {
		this.skill = skill;
	}
	

	public Recruitment(Student student) {
		this.student = student;	
	}
	public Recruitment(String firstName) {
		
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	
	}
