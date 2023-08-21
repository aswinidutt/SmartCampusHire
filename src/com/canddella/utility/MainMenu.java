package com.canddella.utility;

import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args) {
		int ch;
		char choice='y';
Scanner scanner=new Scanner(System.in);
do
{
		System.out.println(
				"1. College\n   2.Student\n   3.Event\n   4.Event Registration\n   5.Status Table\n  6.Skill Table\n  7.Hiring Table\n  8.Recruiter Registration\n  9.Level 1 Progress\n  10.Level 2 Progres\n  11.Level 3 Progress\n  12.Recruitment History\n");
		System.out.println("Enter your choice");
		ch=scanner.nextInt();
		switch(ch)
		{
		case 1:CollegeUtility.collegeMenu();
			break;
		case 2:StudentUtility.studentMenu();
			break;
		case 3:EventUtility.eventMenu();
			break;
		case 4:EventRegistrationUtility.eventRegistrationMenu();;
			break;
		case 5:StatusUtility.statusMenu();
			break;
		case 6:SkillUtility.skillMenu();
			break;
		case 7: HiringUtility.hiringMenu();
			break;
		case 8:RecruiterRegistrationUtility.recruiterRegistrationMenu();
			break;
		case 9:Level1ProgressUtility.progress1Menu();
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			break;
		}	
			System.out.println("Do you want to continue:");
			choice = scanner.next().charAt(0);
		} while ((choice == 'y') || (choice == 'Y'));

		
		
	}


}

