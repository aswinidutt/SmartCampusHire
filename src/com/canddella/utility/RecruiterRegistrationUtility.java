package com.canddella.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Event;
import com.canddella.entity.Hire;
import com.canddella.entity.RecruiterRegistration;
import com.canddella.entity.Skill;
import com.canddella.entity.Student;
import com.canddella.service.RecruiterRegistrationServiceImpl;

public class RecruiterRegistrationUtility {

	public static void main(String[] args) {
		
		
		recruiterRegistrationMenu();
		
		
	}

	
public static void recruiterRegistrationMenu() {
		char choice='y';
		do
		{
			 Scanner scanner=new Scanner(System.in);
			 System.out.println("1.Save Recruiter  2.Get Recruiter  3.Display Recruiter\n");
			 System.out.println("Enter your choice");
			 int ch=scanner.nextInt();
			 switch(ch)
			 {
			 case 1:saveRecruiter();
				 break;
			 case 2:getRecruiter();
				 break;
			 case 3:displayRecruiters();
				 break;
				 
			 }
			 
			 
			 
			 System.out.println("Do you want to continue:");
			 choice=scanner.next().charAt(0);
		}while((choice=='y')|(choice=='Y'));
		
	}
	
	

	



	private static void saveRecruiter() {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter the Recruiter Id");
		String recruiterId=scanner.next();
		
		
		System.out.println("*******************************************************");
		HiringUtility.displayHire();
		System.out.println("*******************************************************");
		Hire hire=new Hire();
		System.out.println("Enter the hiring Id");
		String hireId=scanner.next();
		hire.setHire_id(hireId);
		
		
		
		System.out.println("*******************************************************");
		EventUtility.displayAllEvents();
		System.out.println("*******************************************************");
		Event event=new Event();
		System.out.println("Enter the Event Id");
		String event_id=scanner.next();
		event.setEvent_id(event_id);
		
		System.out.println("Enter the available vacancies");
		int vacancy=scanner.nextInt();
		
		
		System.out.println("Enter the Skill Description");
		scanner.nextLine();
		String skillDescription=scanner.nextLine();
		
		RecruiterRegistration  recruiterRegistration=new RecruiterRegistration(recruiterId,hire,event,vacancy,skillDescription);
		
		RecruiterRegistrationServiceImpl  recruiterRegistrationServiceImpl=new RecruiterRegistrationServiceImpl (); 
		recruiterRegistrationServiceImpl.saveRecruiter( recruiterRegistration);
		
	}
	
private static void getRecruiter() {
	
	Scanner scanner=new Scanner(System.in);
	RecruiterRegistration recruiterRegistration=null;
	
	System.out.println("Enter the Recruiter Id");
	String recruiterId=scanner.next();
	
	RecruiterRegistrationServiceImpl  recruiterRegistrationServiceImpl=new RecruiterRegistrationServiceImpl ();
	recruiterRegistration=recruiterRegistrationServiceImpl.getRecruiter(recruiterId) ;
	
	System.out.println("+-----------+-------------------+------------------+----------------+------------------+");

    System.out.printf("| %-9s | %-17s | %-16s | %-14s | %-16s | \n",

            "Recruiter Id", "Hiring Id", "Event Id", "Vacancies", "Skill Description");

   System.out.println("+-----------+-------------------+------------------+----------------+------------------+");
	
   System.out.printf("| %-9s | %-17s | %-16s | %-14s | %-16s | \n",

		   recruiterRegistration.getRecruiter_id() ,recruiterRegistration.getHire().getHire_id(), recruiterRegistration.getEvent().getEvent_id(),

		   recruiterRegistration.getVacancies(), recruiterRegistration.getSkillDescription()
	
           );

System.out.println("+-----------+-------------------+------------------+----------------+------------------+");
		
	}

public static void displayRecruiters() {
	
	RecruiterRegistrationServiceImpl  recruiterRegistrationServiceImpl=new RecruiterRegistrationServiceImpl ();
	
	List<RecruiterRegistration>recruiterRegistrationList=new ArrayList<>();
	
	RecruiterRegistration recruiterRegistration=null;
	
	recruiterRegistrationList=recruiterRegistrationServiceImpl.displayRecruiters();	
	
	System.out.println("+-----------+-------------------+------------------+----------------+------------------+");

    System.out.printf("| %-9s | %-17s | %-16s | %-14s | %-16s | \n",

            "Recruiter Id", "Hiring Id", "Event Id", "Vacancies", "Skill Description");

   System.out.println("+-----------+-------------------+------------------+----------------+------------------+");
	
	for(RecruiterRegistration rec:recruiterRegistrationList)
	{
		
		
	   System.out.printf("| %-9s | %-17s | %-16s | %-14s | %-16s | \n",

			   rec.getRecruiter_id() ,rec.getHire().getHire_id(), rec.getEvent().getEvent_id(),

			   rec.getVacancies(), rec.getSkillDescription()
		
	           );

	System.out.println("+-----------+-------------------+------------------+----------------+------------------+");
				
	}
	
}
}
