package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.History;

public class HistoryDAOImpl implements HistoryDAO {
	DataSource ds = DBConnectionPool.getDataSource();
	@Override
	public void saveHistory(History history) {
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into registration (reg_id,college_id,student_id,event_id,registration_date) values (?,?,?,?,?)");
		//	statement.setString(1, );
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
