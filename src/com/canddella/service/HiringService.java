package com.canddella.service;

import java.util.List;

import com.canddella.entity.Hire;


public interface HiringService {
	
public void saveHire(Hire hire);
	
	public Hire getHire(String hireId);
	
	public List<Hire> displayHire();
	
	public void deleteHire(String hireId);
	
	public Hire receiveHire(String HireId);
	
	public void updateHire(String column_name,String newValue,String HireId );

}
