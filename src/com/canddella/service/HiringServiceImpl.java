package com.canddella.service;

import java.util.ArrayList;
import java.util.List;

import com.canddella.dao.HiringDAOImpl;
import com.canddella.dao.StatusDAOImpl;
import com.canddella.entity.Hire;
import com.canddella.entity.Status;

public class HiringServiceImpl implements HiringService {

	@Override
	public void saveHire(Hire hire) {
		HiringDAOImpl hiringDAOImpl=new HiringDAOImpl();
		hiringDAOImpl.saveHire( hire);
		
	}

	@Override
	public Hire getHire(String hireId) {
		HiringDAOImpl hiringDAOImpl=new HiringDAOImpl();
		Hire	hire=hiringDAOImpl.getHire( hireId);
			
			return hire;
		
	}

	@Override
	public List<Hire> displayHire() {
		List<Hire>hiringList=new ArrayList<>();
		HiringDAOImpl hiringDAOImpl=new HiringDAOImpl();
		hiringList=hiringDAOImpl.displayHire();
		
		return hiringList;
		
	}

	@Override
	public void deleteHire(String HireId) {
		
		HiringDAOImpl hiringDAOImpl=new HiringDAOImpl();
		hiringDAOImpl.deleteHire(HireId);
		
	}

	@Override
	public Hire receiveHire(String HireId) {
		HiringDAOImpl hiringDAOImpl=new HiringDAOImpl();
		Hire hire=null;
			hire=hiringDAOImpl.receiveHire(HireId);
			return hire;
	
	}

	@Override
	public void updateHire(String column_name, String newValue, String HireId) {
		HiringDAOImpl hiringDAOImpl=new HiringDAOImpl();
		hiringDAOImpl.updateHire(column_name,newValue,HireId);
		
	}

	

}
