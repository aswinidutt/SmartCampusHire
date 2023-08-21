package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Event;
import com.canddella.entity.Hire;
import com.canddella.entity.Level1Progress;
import com.canddella.entity.Level2Progress;
import com.canddella.entity.Status;
import com.canddella.entity.Student;
import com.canddella.service.Level1ProgressServiceImpl;
import com.canddella.service.Level2ProgressServiceImpl;

public class Level2ProgressUtility {

	public static void main(String[] args) {
		progress2Menu();

	}

	public static List<Level2Progress> progress2Menu() {

		List<Level2Progress> level2ProgressList = new ArrayList();
		int ch;
		char choice = 'y';
		do {
			Scanner scanner = new Scanner(System.in);
			System.out
					.println("1.Save Progress2   2. Search Progress2  3.DisplayAllProgress2   4.Update Progress2  5.Pass On Level 3   6.Get the count Of Students \n");
			System.out.println("Enter your choice:");
			ch = scanner.nextInt();
			switch (ch) {
			case 1:
				saveProgress2();
				break;
			case 2:
				searchProgress2();
				break;

			case 3:
				displayAllProgress2();
				break;

			case 4:
				update2();
				break;

//			case 5:// displayUpdatedOnly2();
//				break;
			case 5:
				level2ProgressList = passOnlevel3();
				break;
				
			case 6:int numberOfStudents;
			 numberOfStudents= getNumberOfStudents();
				break;

			}
			System.out.println("Do you want to continue");
			choice = scanner.next().charAt(0);
		} while ((choice == 'y') || (choice == 'Y'));
		return level2ProgressList;

	}

	public static int getNumberOfStudents() {
		
		List<Level2Progress> progressList = new ArrayList<>();
		Level2ProgressServiceImpl level2ProgressServiceImpl = new Level2ProgressServiceImpl();
		progressList = level2ProgressServiceImpl.displayAllProgress2();
		int numberOfStudents = progressList.size();
		  System.out.println("The number of Students are:"+numberOfStudents);
		    return numberOfStudents;
		
	}

	private static List<Level2Progress> passOnlevel3() {
		
List<Level2Progress> level2ProgressList = new ArrayList();
		
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("**************************");
		StatusUtility.displayStatus();
		System.out.println("**************************");
		
		
		
		Status status=new Status();
		System.out.println("Enter the required status Id");
		String statusId=scanner.nextLine();
		status.setStatusId(statusId);
		
		Level2ProgressServiceImpl level2ProgressServiceImpl = new Level2ProgressServiceImpl();
	level2ProgressList=level2ProgressServiceImpl.passOnLevel3(status);	
		
		
	
		for (Level2Progress progress3 : level2ProgressList)
		{
			System.out.println("Level 2 Id:"+ " "+progress3.getLevel2Id()+"\n "+"Level 1 Id:"+ " "+progress3.getLevel1Progress().getLevel1Id()+"\n "+"Student Id:"+ " "+progress3.getStudent().getStudent_id());
		}
		return level2ProgressList;
		
	}

	private static void saveProgress2() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the progress2 id");
		int progress2Id = scanner.nextInt();// auto increment

		System.out.println("**************************************************************************");
		StatusUtility.displayStatus();
		System.out.println("**************************************************************************");

		Status status = new Status();
		System.out.println("Enter the Status id");
		scanner.nextLine();
		String stadId = scanner.nextLine();
		status.setStatusId(stadId);

		System.out.println("**********************************");
		EventUtility.displayAllEvents();
		System.out.println("**********************************");

		Event event = new Event();
		System.out.println("Enter theEventId");
		String eventId = scanner.nextLine();
		event.setEvent_id(eventId);

		System.out.println("**************************************************************************");
		HiringUtility.displayHire();
		System.out.println("**************************************************************************");

		Hire hire = new Hire();
		System.out.println("Enter the Hiring Id");
		String hireId = scanner.nextLine();
		hire.setHire_id(hireId);

		System.out.println("Enter the Start Date");
		String startDate = scanner.nextLine();// entered value can be stored in string only
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate start_Date = LocalDate.parse(startDate, dateFormatter);

		System.out.println("Enter the End Date");
		String endDate = scanner.nextLine();// entered value can be stored in string only
		DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate end_Date = LocalDate.parse(startDate, dateFormatter1);

		System.out.println("Enter the Skill Description");
		String skillDesc = scanner.nextLine();

		List<Level1Progress> studentList1 = new ArrayList<>();

		studentList1 = Level1ProgressUtility.progress1Menu();
		;

		for (Level1Progress progress2 : studentList1)

		{
			Level1Progress level1Progress = new Level1Progress();
			int level1Id = progress2.getLevel1Id();
			level1Progress.setLevel1Id(level1Id);

			Student student = new Student();
			String studentI = progress2.getStudent().getStudent_id();
			student.setStudent_id(studentI);

			Level2Progress level2Progress = new Level2Progress(progress2Id, level1Progress, student, status, event,
					hire, start_Date, end_Date, skillDesc);

			Level2ProgressServiceImpl level2ProgressServiceImpl = new Level2ProgressServiceImpl();
			level2ProgressServiceImpl.saveProgress2(level2Progress);

		}

	}

	private static void searchProgress2() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the level2 id");
		int progress2Id = scanner.nextInt();

		Level2ProgressServiceImpl level2ProgressServiceImpl = new Level2ProgressServiceImpl();
		level2ProgressServiceImpl.searchProgress2(progress2Id);

	}

	private static void displayAllProgress2() {

		List<Level2Progress> progressList = new ArrayList<>();
		Level2ProgressServiceImpl level2ProgressServiceImpl = new Level2ProgressServiceImpl();
		progressList = level2ProgressServiceImpl.displayAllProgress2();
		// level2ProgressList= level2ProgressServiceImpl.displayAllProgress2();

//		 for(Level2Progress level2:level2ProgressList)
//		 {
//			 System.out.println("Level 2 Id :"+" "+level2.get +"\n"+"Level 1 Id:" + " " + level2.getLevel1Progress().getLevel1Id() + "\n" + "Student Id :" + "  "
//					+ resultSet.getString("student_id") + "\n " + "Status Id:" + " "
//						+ resultSet.getString("status_id") + " \n" + "Hiring Id:" + " "
//						+ resultSet.getString("hiring_id"));
//		 }

	}

	private static void update2() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("**************************");
		displayAllProgress2();
		System.out.println("**************************");

		// String columnName="status_id";

		Student student = new Student();
		System.out.println("Enter the student id you want to update");
		String studentId = scanner.nextLine();
		student.setStudent_id(studentId);

		System.out.println("**************************");
		StatusUtility.displayStatus();
		System.out.println("**************************");

		Status status = new Status();
		System.out.println("Enter the status id to which you want to change");
		String statusId = scanner.nextLine();
		status.setStatusId(statusId);

		Level2ProgressServiceImpl level2ProgressServiceImpl = new Level2ProgressServiceImpl();
		level2ProgressServiceImpl.update2(student, status);
	}
//	private static void displayUpdatedOnly2() {
//		
//		Scanner scanner=new Scanner(System.in);
//		
//		System.out.println("**************************");
//		StatusUtility.displayStatus();
//		System.out.println("**************************");
//		
//		Status status=new Status();
//		System.out.println("Enter the required Status Id");
//		String statusId=scanner.nextLine();
//		status.setStatusId(statusId);
//		
//		
//		List<Level2Progress> level2ProgressList = new ArrayList();
//
//				Level2ProgressServiceImpl level2ProgressServiceImpl = new Level2ProgressServiceImpl();
//				level2ProgressList=level2ProgressServiceImpl.displayUpdatedOnly2(status);
//				
//				for(Level2Progress st:level2ProgressList)
//				{
//					System.out.println("Student Id:" +st.getStudent().getStudent_id());
//					
//				}
//		
//	}
//
//	
//	
}
