package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Status;

public class StatusDAOImpl implements StatusDAO {
	DataSource ds = DBConnectionPool.getDataSource();
	@Override
	public void saveStatus(Status status) {
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into status(status_id,status_name) values(?,?)");
			statement.setString(1, status.getStatusId());
			statement.setString(2, status.getStatusName());
			

			int count = 0;
			count = statement.executeUpdate();
			if (count > 0) {
				System.out.println("Updated Successfully");
			}
			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	@Override
	public Status getStatus(String statusId) {
		Status status=null;
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select *from status where status_id=?");	
			statement.setString(1,statusId);
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next())
		{
			status=new Status(resultSet.getString("status_id"),resultSet.getString("status_name"));	
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());	
		}
		return status;
	}
	@Override
	public List<Status> displayStatus() {
		List<Status> statusList=new ArrayList<>();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select *from status");	
			
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next())
		{
			Status status=new Status(resultSet.getString("status_id"),resultSet.getString("status_name"));	
			statusList.add(status);
		}
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());	
		}
		return statusList;
	}
	@Override
	public void deleteStatus(String statusId) {
		
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("delete from status where status_id=?");	
			statement.setString(1,statusId);
			int count=0;
count=	statement.executeUpdate();
		if(count>0)
		{
			System.out.println("Deleted");
		}
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());	
		}	
	}
	@Override
	public Status receiveStatus(String statusId) {
		Status status=null;
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select* from status where status_id=?");	
			statement.setString(1,statusId);
			int count=0;
ResultSet resultSet=statement.executeQuery();
		while(resultSet.next())
		{
			 status=new Status(resultSet.getString("status_id"),resultSet.getString("status_name"));
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());	
		}
		return  status;
		
		
		
	}
	@Override
	public void updateStatus(String column_name, String newValue, String statusId) {
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("update status set "+ column_name+"= ? where status_id=?");	
			statement.setString(1, newValue);
			statement.setString(2, statusId);
			int count=0;
			count=statement.executeUpdate();
			if(count>0)
			{
				System.out.println("Updated Successfully");	
			}
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());	
		}
		
		
		
		
	}
	

}
