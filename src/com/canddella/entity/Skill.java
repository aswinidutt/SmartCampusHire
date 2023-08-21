package com.canddella.entity;

public class Skill {
	
	private int skillId;
	private String skillName;
	public Skill(int skillId, String skillName) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
	}
	public Skill() {
		// TODO Auto-generated constructor stub
	}
	public Skill(int skillId2) {
		// TODO Auto-generated constructor stub
	}
	public int getSkillId() {
		return skillId;
	}
	public Skill setSkillId(int skillId) {
		this.skillId = skillId;
		return null;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	
	
}