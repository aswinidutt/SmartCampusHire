package com.canddella.entity;


public class RecruiterRegistration {
	private String recruiter_id;
	private Hire hire;
	private Event event;
	private int vacancies;
	private String skillDescription;
	public RecruiterRegistration(String recruiter_id, Hire hire, Event event, int vacancies, String skillDescription) {
		super();
		this.recruiter_id = recruiter_id;
		this.hire = hire;
		this.event = event;
		this.vacancies = vacancies;
		this.skillDescription = skillDescription;
	}
	public RecruiterRegistration() {
		// TODO Auto-generated constructor stub
	}
	public String getRecruiter_id() {
		return recruiter_id;
	}
	public void setRecruiter_id(String recruiter_id) {
		this.recruiter_id = recruiter_id;
	}
	public Hire getHire() {
		return hire;
	}
	public void setHire(Hire hire) {
		this.hire = hire;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public int getVacancies() {
		return vacancies;
	}
	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
	}
	public String getSkillDescription() {
		return skillDescription;
	}
	public void setSkillDescription(String skillDescription) {
		this.skillDescription = skillDescription;
	}
	
	

}
