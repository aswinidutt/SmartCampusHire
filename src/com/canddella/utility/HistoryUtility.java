package com.canddella.utility;

import java.util.Scanner;

import com.canddella.entity.Event;
import com.canddella.entity.History;
import com.canddella.entity.RecruiterRegistration;
import com.canddella.service.HistoryServiceImpl;

public class HistoryUtility {

	public static void main(String[] args) {
		historyMenu();

	}

	private static void historyMenu() {
		int ch;
		char choice = 'y';
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println(
					"1.History Registration    3. Search Registration   3.DisplayAllRegistrations   \n");
			System.out.println("Enter your choice:");
			ch = scanner.nextInt();
			switch (ch) {
			case 1:
				saveHistory();
				break;
			case 3://searchHistory();
			break;
			case 2:
				//displayHistory();
				break;
			
		}
			System.out.println("Do you want to continue");
			choice = scanner.next().charAt(0);
		} while ((choice == 'y') || (choice == 'Y'));
	}

	private static void  saveHistory() {
		Scanner scanner=new Scanner(System.in);	
		
		System.out.println("Enter the Recruitment History Id");	
		String historyId=scanner.nextLine();
		
		RecruiterRegistrationUtility.displayRecruiters();
		
		RecruiterRegistration  recruiterRegistration=new RecruiterRegistration();
		 System.out.println("Enter the Recruiter Id");
		 String recruiterId=scanner.nextLine();
		 recruiterRegistration.setRecruiter_id(recruiterId);
		
		
		 
		 System.out.println("**********************************");
			EventUtility.displayAllEvents();
			System.out.println("**********************************");

			Event event = new Event();
			System.out.println("Enter the EventId");
			String eventId = scanner.nextLine();
			event.setEvent_id(eventId);
			
			
			int appeared= Level1ProgressUtility.getNumberOfStudents();
			
			
			int level1Progress= Level2ProgressUtility.getNumberOfStudents();
			
			int level2Progress=	Level3ProgressUtility.getNumberOfStudents();
			
			int totalSelected=	Level3ProgressUtility.displayUpdatedOnly3();
			
			History history=new History( historyId,recruiterRegistration,event,appeared,level1Progress,level2Progress,totalSelected);
			
			HistoryServiceImpl historyServiceImpl=new HistoryServiceImpl();
			 historyServiceImpl.saveHistory(history);
		
			
		
	}

	




		
	}


