package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Event;
import com.canddella.entity.Hire;
import com.canddella.entity.Level1Progress;
import com.canddella.entity.Status;
import com.canddella.entity.Student;
import com.canddella.service.Level1ProgressServiceImpl;

public class Level1ProgressUtility {

	public static void main(String[] args) {
		progress1Menu();

	}

	public static List<Level1Progress> progress1Menu() {

		List<Level1Progress> level1ProgressList = new ArrayList();
		List<Level1Progress>level1ProgressList1=new ArrayList<>();
		int ch;
		char choice = 'y';
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println(
					"1.Save Progress   2. Search Progress  3.DisplayAllProgress   4.Update Progress   5.Display Updated Only   6.Pass values to Level    7.Get the Count of Students \n");
			System.out.println("Enter your choice:");
			ch = scanner.nextInt();
			switch (ch) {
			case 1:
				saveProgress();
				break;
			case 2:
				searchProgress();
				break;

			case 3:
				displayAllProgress();
				break;

			case 4:
				update();
				break;

			case 5:
				displayUpdatedOnly();
				break;

			case 6:
				level1ProgressList = passOnlevel2();
				break;

			case 7:int numberOfStudents;
			 numberOfStudents= getNumberOfStudents();
				break;
			}
			System.out.println("Do you want to continue");
			choice = scanner.next().charAt(0);
		} while ((choice == 'y') || (choice == 'Y'));

		return level1ProgressList;

	}

	

	public static int getNumberOfStudents() {
		
		List<Level1Progress> progressList = new ArrayList<>();
	    Level1ProgressServiceImpl level1ProgressServiceImpl = new Level1ProgressServiceImpl();
	    progressList = level1ProgressServiceImpl.displayAllProgress();
	    //ProgressList= level1ProgressServiceImpl.displayAllProgress();
	    
	    int numberOfStudents = progressList.size();
	   // System.out.println("The number of Students are:"+numberOfStudents);
	    return numberOfStudents;
	}

	private static List<Level1Progress> passOnlevel2() {

		List<Level1Progress> level1ProgressList = new ArrayList();

		Scanner scanner = new Scanner(System.in);

		System.out.println("**************************");
		StatusUtility.displayStatus();
		System.out.println("**************************");

		Status status = new Status();
		System.out.println("Enter the required status Id");
		String statusId = scanner.nextLine();
		status.setStatusId(statusId);

		Level1ProgressServiceImpl level1ProgressServiceImpl = new Level1ProgressServiceImpl();
		level1ProgressList = level1ProgressServiceImpl.passOnLevel2(status);

		for (Level1Progress progress : level1ProgressList) {
			System.out.println("Level 1 Id:" + " " + progress.getLevel1Id() + " " + "Student Id:" + " "
					+ progress.getStudent().getStudent_id());
		}
		return level1ProgressList;

	}

	private static void saveProgress() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the progress id");
		int progress1Id = scanner.nextInt();

//		System.out.println("**************************************************************************");
//		StudentUtility.displayAll();
//		System.out.println("**************************************************************************");
//		Student student=new Student();
//		System.out.println("Enter the Student id");
//		String studId=scanner.nextLine();
//		student.setStudent_id(studId);

		System.out.println("**********************");
		StatusUtility.displayStatus();
		System.out.println("******************************");
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

		System.out.println("************************************");
		HiringUtility.displayHire();
		System.out.println("************************************");
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

//		Student student1=new Student();
//		System.out.println("Enter the Student id");
//			String studId=scanner.nextLine();
//			student1.setStudent_id(studId);
//		

		List<Student> studentList = new ArrayList<>();

		studentList = Utility.sortMenu();

		for (Student student : studentList)

		{
			Level1Progress level1Progress = new Level1Progress(progress1Id, student, status, event, hire, start_Date,
					end_Date, skillDesc);

			Level1ProgressServiceImpl level1ProgressServiceImpl = new Level1ProgressServiceImpl();
			level1ProgressServiceImpl.saveProgress(level1Progress);

		}

//		
//	Level1Progress level1Progress =new Level1Progress(progress1Id,student,status,hire,start_Date, end_Date,skillDesc);
//		
//		Level1ProgressServiceImpl level1ProgressServiceImpl=new Level1ProgressServiceImpl();
//		level1ProgressServiceImpl.saveProgress( level1Progress);
//		
	}

	private static void searchProgress() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the progress id");
		int progress1Id = scanner.nextInt();

		Level1ProgressServiceImpl level1ProgressServiceImpl = new Level1ProgressServiceImpl();
		level1ProgressServiceImpl.searchProgress(progress1Id);

	}

	public static List<Level1Progress> displayAllProgress() {

		List<Level1Progress> progressList = new ArrayList<>();
		Level1ProgressServiceImpl level1ProgressServiceImpl = new Level1ProgressServiceImpl();
		return progressList = level1ProgressServiceImpl.displayAllProgress();

	}

	private static void update() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("**************************");
		displayAllProgress();
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

		Level1ProgressServiceImpl level1ProgressServiceImpl = new Level1ProgressServiceImpl();
		level1ProgressServiceImpl.update(student, status);
	}

	private static void displayUpdatedOnly() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("**************************");
		StatusUtility.displayStatus();
		System.out.println("**************************");

		Status status = new Status();
		System.out.println("Enter the required Status Id");
		String statusId = scanner.nextLine();
		status.setStatusId(statusId);

		List<Level1Progress> level1ProgressList = new ArrayList();

		Level1ProgressServiceImpl level1ProgressServiceImpl = new Level1ProgressServiceImpl();
		level1ProgressList = level1ProgressServiceImpl.displayUpdatedOnly(status);

		for (Level1Progress st : level1ProgressList) {
			System.out.println("Student Id:" + st.getStudent().getStudent_id());

		}

	}

}
