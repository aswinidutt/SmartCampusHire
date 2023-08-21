package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.College;
import com.canddella.entity.Event;
import com.canddella.entity.EventRegistration;
import com.canddella.entity.Student;
import com.canddella.service.EventRegistrationServiceImpl;

public class EventRegistrationUtility {

	public static void main(String[] args) {

		eventRegistrationMenu();

	}

	public static void eventRegistrationMenu() {
		int ch;
		char choice = 'y';
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println(
					"1.Save Registration 2.DisplayAllRegistrations  3. Search Registration \n");
			System.out.println("Enter your choice:");
			ch = scanner.nextInt();
			switch (ch) {
			case 1:
				saveRegistration();
				break;
			case 2:
				displayRegistration();
				break;
			
			case 3:searchRegistration();
				break;
				

			}
			System.out.println("Do you want to continue");
			choice = scanner.next().charAt(0);
		} while ((choice == 'y') || (choice == 'Y'));
	}



	private static void saveRegistration() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the reg Id:");
		String regId = scanner.nextLine();

		System.out.println("**************************************************************************");
		CollegeUtility.displayAllCollege();
		System.out.println("**************************************************************************");
		College college = new College();
		System.out.println("Enter the College Id:");
		String collegeId = scanner.nextLine();
		college.setCollegeId(collegeId);
		System.out.println("**************************************************************************");

		StudentUtility.displayAll();
		System.out.println("**************************************************************************");
		Student student = new Student();
		System.out.println("Enter the Student Id:");
		String studentId = scanner.nextLine();
		student.setStudent_id(studentId);

		System.out.println("**************************************************************************");
		Event event=new Event();
		LocalDate today = LocalDate.now();
		List<Event> evenList=EventUtility.displayAllEvents();
		System.out.println("Upcoming Events are:\n");
		System.out.println("+-----------+-------------------+------------------+----------------+--------------+");

        System.out.printf("| %-9s | %-17s | %-16s | %-14s | %-12s | \n",

                "Event Id", "Event Name", "Event Venue", "Start Date", "End Date");

       System.out.println("+-----------+-------------------+------------------+----------------+--------------+");
		
		for(Event event1: evenList)
//			if(event!=null)
//			{
		{
			if (event1.getStart_date().isAfter(today) || event1.getStart_date().isEqual(today)) {
				System.out.printf("| %-9s | %-17s | %-16s | %-14s | %-12s | \n",

	                    event1.getEvent_id(), event1.getEvent_name(), event1.getEvent_venue(),

	                    event1.getStart_date(), event1.getEnd_date()
				
	                    );

            System.out.println("+-----------+-------------------+------------------+----------------+--------------+");
//                System.out.println("Event Id: " + event1.getEvent_id());
//                System.out.println("Event Name: " + event1.getEvent_name());
//                System.out.println("Event Venue: " + event1.getEvent_venue());
//                System.out.println("Start Date: " + event1.getStart_date());
//                System.out.println("End Date: " + event1.getEnd_date());
//                System.out.println("-----------------------------------");
            }
		}
		// List<Event> eventList=EventUtility.displayAllEvents();
		
		System.out.println("**************************************************************************");
		//Event event = new Event(); // here we have to create a default constructor or non parameterized constructor
		// we need to set only the eventid of the object event, dont need to change all
		// the other Member variables
		System.out.println("Enter the Event Id:");
		String eventId = scanner.nextLine();
		event.setEvent_id(eventId);

		System.out.println("Enter the Registration Date");
		String regDate = scanner.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate registrationDate = LocalDate.parse(regDate, formatter);

		EventRegistration eventRegistration = new EventRegistration(regId, college, student, event, registrationDate);

		EventRegistrationServiceImpl eventRegistrationServiceImpl = new EventRegistrationServiceImpl();
		eventRegistrationServiceImpl.saveRegistration(eventRegistration);
	}

	private static void displayRegistration() {

		Scanner scanner = new Scanner(System.in);
		EventRegistrationServiceImpl eventRegistrationServiceImpl = new EventRegistrationServiceImpl();
		List<EventRegistration> eventRegistrationList = new ArrayList<>();

		eventRegistrationList = eventRegistrationServiceImpl.displayRegistration();
		
		System.out.println("+-----------+-------------------+------------------+----------------+-------------------------------+");

        System.out.printf("| %-15s | %-17s | %-16s | %-14s | %-29s | \n",

                "Registration Id", "College Id", "Student Id", "Event Id", "Date Of Registration");

       System.out.println("+-----------------+-------------------+------------------+----------------+-------------------------------+");
		
		
		for (EventRegistration reg : eventRegistrationList) {
			
			
			{
					
						System.out.printf("| %-15s | %-17s | %-16s | %-14s | %-29s | \n",

			                    reg.getRegId(),  reg.getCollege().getCollegeId(),  reg.getStudent().getStudent_id(),

						 reg.getEvent().getEvent_id(),  reg.getRegDate()
						
			                    );

		            System.out.println("+-----------------+-------------------+------------------+----------------+-------------------------------+");
			}
//
//			System.out.println("Registration Id:" + reg.getRegId() + "\n" + " College Id:"
//					+ reg.getCollege().getCollegeId() + "\n" + "Student Id:" + reg.getStudent().getStudent_id() + "\n"
//					+ "Event Id:" + reg.getEvent().getEvent_id()+"\n"+"Date Of Registration:"+reg.getRegDate()+"\n");
			
}
			
		}
	private static void searchRegistration() {
		
		Scanner scanner = new Scanner(System.in);
		EventRegistrationServiceImpl eventRegistrationServiceImpl = new EventRegistrationServiceImpl();	
		System.out.println("Enter the Registration Id:");
		String regId = scanner.nextLine();
		 eventRegistrationServiceImpl.searchRegistration(regId);
		
		
	}

}
