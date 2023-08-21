package com.canddella.entity;

import java.time.LocalDate;

public class Student {
	private String student_id;
	private String firstName;
	private String lastName;
	private String email;
	
	private long phnumber;
	private String address;
	private LocalDate dateOfBirth;
	private String gender;
	private String university;
	private String stream;
	private int passOutYr;
	private double cgpa;
	private Skill skill;
	public Student(String student_id, String firstName, String lastName, String email, long phnumber, String address,
			LocalDate dateOfBirth, String gender, String university, String stream, int passOutYr, double cgpa,
			Skill skill) {
		super();
		this.student_id = student_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phnumber = phnumber;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.university = university;
		this.stream = stream;
		this.passOutYr = passOutYr;
		this.cgpa = cgpa;
		this.skill = skill;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhnumber() {
		return phnumber;
	}
	public void setPhnumber(long phnumber) {
		this.phnumber = phnumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public int getPassOutYr() {
		return passOutYr;
	}
	public void setPassOutYr(int passOutYr) {
		this.passOutYr = passOutYr;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	public void setSkillId(int skillId1) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
