package com.canddella.service;

import com.canddella.dao.HistoryDAOImpl;
import com.canddella.entity.History;

public class HistoryServiceImpl implements HistoryService {

	@Override
	public void saveHistory(History history) {
		HistoryDAOImpl  historyDAOImpl =new HistoryDAOImpl ();
		 historyDAOImpl.saveHistory(history);
		
		
	}

}
