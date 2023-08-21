package com.canddella.entity;

public class Hire {
private String hire_id;
private String company_name;
public Hire(String hire_id, String company_name) {
	super();
	this.hire_id = hire_id;
	this.company_name = company_name;
}
public Hire() {
	// TODO Auto-generated constructor stub
}
public String getHire_id() {
	return hire_id;
}
public void setHire_id(String hire_id) {
	this.hire_id = hire_id;
}
public String getCompany_name() {
	return company_name;
}
public void setCompany_name(String company_name) {
	this.company_name = company_name;
}



}
