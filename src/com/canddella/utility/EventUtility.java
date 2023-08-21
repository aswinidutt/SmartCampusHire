package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Event;
import com.canddella.service.EventServiceImpl;

public class EventUtility {

	public static void main(String[] args) {

		eventMenu();

	}

	public static void eventMenu() {
		char choice = 'y';
		do {
			Scanner scanner = new Scanner(System.in);

			System.out.println("1.Insert Event 2.DisplayAllEvents 3. Delete Event 4. Search Event 5.Update Event\n");
			System.out.println("Enter the choice");
			int ch = scanner.nextInt();

			switch (ch) {
			case 1:
				insertEvent();
				break;
			case 2:
				displayAllEvents();
				break;
			case 3:
				deleteEvent();
				break;
			case 4:
				searchEvent();
				break;
			case 5:updateEvent();
			break;

			}
			System.out.println("Do you want to continue");
			choice=scanner.next().charAt(0);
		} while ((choice == 'y') || (choice == 'Y'));
	}

	
	private static void insertEvent() {

		Scanner scanner = new Scanner(System.in);
		Event event = null;

		System.out.println("Enter the EventId:");
		String eventId = scanner.nextLine();
		System.out.println("Enter the EventName:");
		String eventName = scanner.nextLine();
		System.out.println("Enter the EventVenue:");
		String eventVenue = scanner.nextLine();
		// Read the date as a string and then parse it into a LocalDate object:
		System.out.println("Enter the StartDate:");
		String startDate = scanner.nextLine();// entered value can be stored in string only

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate start_Date = LocalDate.parse(startDate, dateFormatter);

		System.out.println("Enter the EndDate:");
		String endDate = scanner.nextLine();
		DateTimeFormatter date_Formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate end_Date = LocalDate.parse(endDate, date_Formatter);

		event = new Event(eventId, eventName, eventVenue, start_Date, end_Date);

		EventServiceImpl eventServiceImpl = new EventServiceImpl();
		eventServiceImpl.insertEvent(event);
	}

	public static List<Event> displayAllEvents() {

		EventServiceImpl eventServiceImpl = new EventServiceImpl();

		List<Event> eventList = eventServiceImpl.displayAllEvents();
		// System.out.println(eventList);
		for (Event evnt : eventList) {
			System.out.println("Event Id:" + evnt.getEvent_id() + "\n" + "Event Name:" + evnt.getEvent_name() + "\n"
					+ "Event Venue:" + evnt.getEvent_venue() + "\n" + "Start Date:" + evnt.getStart_date() + "\n"
					+ "End Date:" + evnt.getEnd_date() + "\n");
			System.out.println("..............................................................................");

		}
		return eventList;
	}

	private static void deleteEvent() {

		EventServiceImpl eventServiceImpl = new EventServiceImpl();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the event id to delete the row");
		String eventId = scanner.nextLine();
		eventServiceImpl.deleteEvent(eventId);

	}

	private static void searchEvent() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the event id to be serached:");
		String eventId = scanner.nextLine();

		EventServiceImpl eventServiceImpl = new EventServiceImpl();
		Event event = eventServiceImpl.searchEvent(eventId);
		System.out.println("Event Id :" + event.getEvent_id() + "\n" + "Event Name:" + event.getEvent_name() + "\n"
				+ "Event Venue:" + event.getEvent_venue() + "\n" + "Start Date:" + event.getStart_date() + "\n"
				+ "End Date:" + event.getEnd_date() + "\n");

	}
	private static void updateEvent() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the event id to be updated:");
		String eventId = scanner.nextLine();
		EventServiceImpl eventServiceImpl = new EventServiceImpl();
		
Event event=eventServiceImpl.getEvent(eventId );
char choice = 'y';
int ch;
do {
	
String column_name,newValue;

	System.out.println("1.Event Name 2.Event Location 3. Event Start Date 4. Event End Date \n");
	System.out.println("Enter the choice");
	 ch = scanner.nextInt();
switch(ch)
{
case 1:column_name="event_name";
System.out.println("Enter the new event name:");
scanner.nextLine();
newValue=scanner.nextLine();
eventServiceImpl.updateEvent(column_name,newValue,eventId);
	break;
case 2:column_name="event_venue";
System.out.println("Enter the new event location:");
scanner.nextLine();
newValue=scanner.nextLine();
eventServiceImpl.updateEvent(column_name,newValue,eventId);
	break;
case 3:column_name="start_date";
System.out.println("Enter the new start date");//the value we enter can be taken as string only not as date or local date
scanner.nextLine();
newValue=scanner.nextLine();	
eventServiceImpl.updateEvent(column_name,String.valueOf(newValue),eventId);//convert string to date
break;
case 4:column_name="end_date";
System.out.println("Enter the new end date");//the value we enter can be taken as string only not as date or local date
scanner.nextLine();
newValue=scanner.nextLine();	
eventServiceImpl.updateEvent(column_name,String.valueOf(newValue),eventId);
	break;
}
System.out.println("Do you want to continue");
choice=scanner.next().charAt(0);
		
	}while ((choice == 'y') || (choice == 'Y'));

	
}
}
