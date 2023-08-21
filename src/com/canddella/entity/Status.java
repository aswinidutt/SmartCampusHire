package com.canddella.entity;

public class Status {

	private String statusId;
	private String statusName;
	public Status(String statusId, String statusName) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
	}
	public Status() {//constructor created because of new Status in utility
		// TODO Auto-generated constructor stub
	}
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	
}
