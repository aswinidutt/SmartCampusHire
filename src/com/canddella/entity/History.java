package com.canddella.entity;

public class History {
	
	private String historyId;
	private RecruiterRegistration  recruiterRegistration;
	private Event event;
	private int appeared;
	private int level1Passed;
	private int level2Passed;
	private int totalSelected;
	public History(String historyId, RecruiterRegistration recruiterRegistration, Event event, int appeared,
			int level1Passed, int level2Passed, int totalSelected) {
		super();
		this.historyId = historyId;
		this.recruiterRegistration = recruiterRegistration;
		this.event = event;
		this.appeared = appeared;
		this.level1Passed = level1Passed;
		this.level2Passed = level2Passed;
		this.totalSelected = totalSelected;
	}
	public String getHistoryId() {
		return historyId;
	}
	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}
	public RecruiterRegistration getRecruiterRegistration() {
		return recruiterRegistration;
	}
	public void setRecruiterRegistration(RecruiterRegistration recruiterRegistration) {
		this.recruiterRegistration = recruiterRegistration;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public int getAppeared() {
		return appeared;
	}
	public void setAppeared(int appeared) {
		this.appeared = appeared;
	}
	public int getLevel1Passed() {
		return level1Passed;
	}
	public void setLevel1Passed(int level1Passed) {
		this.level1Passed = level1Passed;
	}
	public int getLevel2Passed() {
		return level2Passed;
	}
	public void setLevel2Passed(int level2Passed) {
		this.level2Passed = level2Passed;
	}
	public int getTotalSelected() {
		return totalSelected;
	}
	public void setTotalSelected(int totalSelected) {
		this.totalSelected = totalSelected;
	}
	
	

}
