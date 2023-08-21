package com.canddella.entity;

public class StudentRecruiterRegistration {
	
	private Student student;
	private RecruiterRegistration   recruiterRegistration;
	private Skill skill;
	public StudentRecruiterRegistration(Student student, RecruiterRegistration recruiterRegistration, Skill skill) {
		super();
		this.student = student;
		this.recruiterRegistration = recruiterRegistration;
		this.skill = skill;
	}
	
	public StudentRecruiterRegistration(Student student) {
		
		this.student=student;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public RecruiterRegistration getRecruiterRegistration() {
		return recruiterRegistration;
	}
	public void setRecruiterRegistration(RecruiterRegistration recruiterRegistration) {
		this.recruiterRegistration = recruiterRegistration;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	
	
//	public StudentRecruiterRegistration(Student student, RecruiterRegistration recruiterRegistration) {
//		super();
//		this.student = student;
//		this.recruiterRegistration = recruiterRegistration;
//	}
//	public StudentRecruiterRegistration(Student student) {
//		// TODO Auto-generated constructor stub
//		this.student=student;
//	}
//	public Student getStudent() {
//		return student;
//	}
//	public void setStudent(Student student) {
//		this.student = student;
//	}
//	public RecruiterRegistration getRecruiterRegistration() {
//		return recruiterRegistration;
//	}
//	public void setRecruiterRegistration(RecruiterRegistration recruiterRegistration) {
//		this.recruiterRegistration = recruiterRegistration;
//	}
	
	
	
	

}
