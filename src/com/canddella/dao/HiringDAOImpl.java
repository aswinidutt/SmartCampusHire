package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Hire;
import com.canddella.entity.Status;

public class HiringDAOImpl implements HiringDAO {
	DataSource ds = DBConnectionPool.getDataSource();
	@Override
	public void saveHire(Hire hire) {
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into hiredetails(hiring_id,company_name) values(?,?)");
			statement.setString(1, hire.getHire_id());
			statement.setString(2, hire.getCompany_name());
			

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
	public Hire getHire(String hireId) {
		Hire hire=null;
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select *from hiredetails where hiring_id=?");	
			statement.setString(1,hireId);
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next())
		{
			hire=new Hire(resultSet.getString("hiring_id"),resultSet.getString("company_name"));	
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());	
		}
		return hire;
		
	}

	@Override
	public List<Hire> displayHire() {
		List<Hire> hiringList=new ArrayList<>();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select *from hiredetails");	
			
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next())
		{
			Hire hire=new Hire(resultSet.getString("hiring_id"),resultSet.getString("company_name"));	
			hiringList.add(hire);
		}
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());	
		}
		return hiringList;
		
	}

	@Override
	public void deleteHire(String hireId) {
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("delete from hiredetails where hiring_id=?");	
			statement.setString(1,hireId);
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
	public Hire receiveHire(String HireId) {
		Hire hire=null;
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select* from hiredetails where hiring_id=?");	
			statement.setString(1,HireId);
			int count=0;
ResultSet resultSet=statement.executeQuery();
		while(resultSet.next())
		{
			hire=new Hire(resultSet.getString("hiring_id"),resultSet.getString("company_name"));
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());	
		}
		return  hire;
		
	
	}

	@Override
	public void updateHire(String column_name, String newValue, String HireId) {
	
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("update hiredetails set "+ column_name+"= ? where hiring_id=?");	
			statement.setString(1, newValue);
			statement.setString(2, HireId);
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
