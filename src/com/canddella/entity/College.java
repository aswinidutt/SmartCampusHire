package com.canddella.entity;

public class College {
	
	private String collegeId;
	private String collegeName;
	private String location;
	private String accrediationDetails;
	private int establishedYr;
	public College(String collegeId, String collegeName, String location, String accrediationDetails,
			int establishedYr) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.location = location;
		this.accrediationDetails = accrediationDetails;
		this.establishedYr = establishedYr;
	}
	public College() {
		// TODO Auto-generated constructor stub
	}
	public String getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAccrediationDetails() {
		return accrediationDetails;
	}
	public void setAccrediationDetails(String accrediationDetails) {
		this.accrediationDetails = accrediationDetails;
	}
	public int getEstablishedYr() {
		return establishedYr;
	}
	public void setEstablishedYr(int establishedYr) {
		this.establishedYr = establishedYr;
	}
	
	
	
	

}
