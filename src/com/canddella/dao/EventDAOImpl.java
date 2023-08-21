package com.canddella.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Event;

public class EventDAOImpl implements EventDAO {
	
	DataSource ds=DBConnectionPool.getDataSource();
	
	@Override
	public void insertEvent(Event event) {
		
		try
		{
			Connection connection=ds.getConnection();
			PreparedStatement statement=connection.prepareStatement("insert into event (event_id,event_name,event_venue,start_date,end_date) values (?,?,?,?,?)");
			statement.setString(1,event.getEvent_id());
			statement.setString(2,event.getEvent_name());
			statement.setString(3,event.getEvent_venue());
			//the value received is LocalDate convert it to date format
		
			
			Date startDate= Date.valueOf(event.getStart_date());//converted local date to date
			statement.setDate(4,startDate );
			
			Date endDate= Date.valueOf(event.getEnd_date());
			statement.setDate(5, endDate);
			//statement.executeUpdate();
			int count=0;
			count=statement.executeUpdate();
			if(count>0)
				
			{
				System.out.println("Updated successfully");
			}
			connection.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	

	public List<Event> displayAllEvents() {
		
		List<Event>eventList=new ArrayList<>();

		try
		{
		Connection connection=ds.getConnection();//to create connection
		PreparedStatement statement=connection.prepareStatement("select*from event");//to provide the statement to be executed
//		PreparedStatement statement=connection.prepareStatement("alter table event"
//				"ADD CONSTRAINT start_date"
//				"CHECK (start_date >= CURRENT_DATE)");
		ResultSet resultSet=statement.executeQuery();
		
		while(resultSet.next())//is boolean check if result set is empty or not
		{
		String event_id=resultSet.getString("event_id");
		String event_name=resultSet.getString("event_name");
	String event_venue=	resultSet.getString("event_venue");
	//below two lines convert date to local date as we can pass in java as local date only but in db it is date..so this
	//frequent conversion occurs
	Date start_date=	resultSet.getDate("start_date");
	LocalDate startDate = start_date.toLocalDate();
	
	Date end_date=resultSet.getDate("end_date");
	LocalDate endDate = end_date.toLocalDate();
		
  Event	event=new Event(event_id,event_name,event_venue,startDate , endDate);
			
  eventList.add(event);
		
		}
		}catch(Exception e)
		{
		System.out.println(e.getMessage());	
		}
		
		
		return eventList;
	}



	@Override
	public void deleteEvent(String eventId) {
	try
	{
		Connection connection=ds.getConnection();
		PreparedStatement statement=connection.prepareStatement("delete from event where event_id=?");
		statement.setString(1,eventId);
		//statement.executeUpdate();
		//The executeUpdate() method returns an integer value, which represents the number of rows affected by the SQL statement
		
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



	@Override
	public Event searchEvent(String eventId) {
		Event event=null;
		try
		{
		Connection connection=ds.getConnection();
		PreparedStatement statement=connection.prepareStatement("select * from event where event_id=?");
		statement.setString(1,eventId);
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next())
		{
			String eventId1=resultSet.getString("event_id");
	String eventNmae=resultSet.getString("event_name");
	String eventLocation=resultSet.getString("event_venue");
	
	Date startDate=	resultSet.getDate("start_date");
	LocalDate start_Date=startDate.toLocalDate();
	
	Date endDate=resultSet.getDate("end_date");
	LocalDate end_Date=endDate.toLocalDate();
	event=new Event(eventId1,eventNmae,eventLocation,start_Date,end_Date);
	
		}
	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return event;
	}



	@Override
	public Event getEvent(String eventId) {
		Event event=null;
		try
		{
		Connection connection=ds.getConnection();
PreparedStatement statement=connection.prepareStatement("select * from event where event_id=?");
statement.setString(1,eventId);
ResultSet resultSet=statement.executeQuery();
while(resultSet.next())
{
String eventId1=resultSet.getString("event_id");
String eventName=resultSet.getString("event_name");
String eventVenue=resultSet.getString("event_venue");

Date startDate=resultSet.getDate("start_date");
LocalDate start_Date=startDate.toLocalDate();

Date endDate=resultSet.getDate("end_date");
LocalDate end_Date=startDate.toLocalDate();

event=new Event(eventId1,eventName,eventVenue,start_Date,end_Date);

}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return event;
	}



	@Override
	public void updateEvent(String column_name, String newValue, String eventId) {
		
		try
		{
			Connection connection=ds.getConnection();
		PreparedStatement statement=	connection.prepareStatement("update event set "+column_name +" = ? where event_id = ? ");
		statement.setString(1,newValue);
		statement.setString(2,eventId);
		int count=0;
	count=	statement.executeUpdate();
	if(count>0)
	{
		System.out.println("Updated Successfully");
	}
		
	connection.close();		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	

}
