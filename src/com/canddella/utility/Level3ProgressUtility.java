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
import com.canddella.entity.Level3Progress;
import com.canddella.entity.Status;
import com.canddella.entity.Student;
import com.canddella.service.Level2ProgressServiceImpl;
import com.canddella.service.Level3ProgressServiceImpl;

public class Level3ProgressUtility {

	public static void main(String[] args) {
		progress3Menu();

	}

	public static List<Student> progress3Menu() {

		int ch;
		char choice = 'y';
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println(
					"1.Save Progress3   2. Search Progress3  3.DisplayAllProgress3   4.Update Progress3  5.Display Updated level 3 Students  6.Get the Count of Students \n");
			System.out.println("Enter your choice:");
			ch = scanner.nextInt();
			switch (ch) {
			case 1:
				saveProgress3();
				break;
			case 2:
				searchProgress3();
				break;

			case 3:
				displayAllProgress3();
				break;

			case 4:
				update3();
				break;

			case 5:int numberOfStudents;
			 numberOfStudents=displayUpdatedOnly3();
				break;
			case 6:int numberOfStudents1;
				numberOfStudents1 = getNumberOfStudents();
				break;

				

			}
			System.out.println("Do you want to continue");
			choice = scanner.next().charAt(0);
		} while ((choice == 'y') || (choice == 'Y'));

		List<Student> studentList = new ArrayList<>();

		return studentList;
	}

	public static int getNumberOfStudents() {

		List<Level3Progress> progressList = new ArrayList<>();
		Level3ProgressServiceImpl level3ProgressServiceImpl = new Level3ProgressServiceImpl();
		progressList = level3ProgressServiceImpl.displayAllProgress3();
		int numberOfStudents1 = progressList.size();
		System.out.println("The number of Students who progressed to third level:" + numberOfStudents1);
		return numberOfStudents1;
	}

	private static void saveProgress3() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the level 3 id");
		int progress3Id = scanner.nextInt();// auto increment

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

		List<Level2Progress> studentList3 = new ArrayList<>();

		studentList3 = Level2ProgressUtility.progress2Menu();
		;

		for (Level2Progress progress3 : studentList3)

		{

			Level2Progress level2Progress = new Level2Progress();
			int level2Id = progress3.getLevel2Id();
			level2Progress.setLevel2Id(level2Id);

			Level1Progress level1Progress = new Level1Progress();
			int level1Id = progress3.getLevel1Progress().getLevel1Id();
			level1Progress.setLevel1Id(level1Id);

			Student student = new Student();
			String studentI = progress3.getStudent().getStudent_id();
			student.setStudent_id(studentI);

			Level3Progress level3Progress = new Level3Progress(progress3Id, level2Progress, level1Progress, student,
					status, event, hire, start_Date, end_Date, skillDesc);

			Level3ProgressServiceImpl level3ProgressServiceImpl = new Level3ProgressServiceImpl();
			level3ProgressServiceImpl.saveProgress3(level3Progress);

		}

	}

	private static void searchProgress3() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the level3 id");
		int progress3Id = scanner.nextInt();

		Level3ProgressServiceImpl level3ProgressServiceImpl = new Level3ProgressServiceImpl();
		level3ProgressServiceImpl.searchProgress3(progress3Id);

	}

	private static void displayAllProgress3() {

		List<Level3Progress> progressList = new ArrayList<>();
		Level3ProgressServiceImpl level3ProgressServiceImpl = new Level3ProgressServiceImpl();
		progressList = level3ProgressServiceImpl.displayAllProgress3();
		// level2ProgressList= level2ProgressServiceImpl.displayAllProgress2();

//		 for(Level2Progress level2:level2ProgressList)
//		 {
//			 System.out.println("Level 2 Id :"+" "+level2.get +"\n"+"Level 1 Id:" + " " + level2.getLevel1Progress().getLevel1Id() + "\n" + "Student Id :" + "  "
//					+ resultSet.getString("student_id") + "\n " + "Status Id:" + " "
//						+ resultSet.getString("status_id") + " \n" + "Hiring Id:" + " "
//						+ resultSet.getString("hiring_id"));
//		 }

	}

	private static void update3() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("**************************");
		displayAllProgress3();
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

		Level3ProgressServiceImpl level3ProgressServiceImpl = new Level3ProgressServiceImpl();
		level3ProgressServiceImpl.update3(student, status);
	}

	public static int displayUpdatedOnly3() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("**************************");
		StatusUtility.displayStatus();
		System.out.println("**************************");

		Status status = new Status();
		System.out.println("Enter the required Status Id");
		String statusId = scanner.nextLine();
		status.setStatusId(statusId);

		List<Level3Progress> level3ProgressList = new ArrayList();

		Level3ProgressServiceImpl level3ProgressServiceImpl = new Level3ProgressServiceImpl();
		level3ProgressList = level3ProgressServiceImpl.displayUpdatedOnly3(status);

//		for (Level3Progress st : level3ProgressList) {
//			System.out.println("Student Id:" + st.getStudent().getStudent_id());
//
//		}
		
		int numberOfStudents = level3ProgressList.size();
		    System.out.println("The number of Students are:"+numberOfStudents);
		    return numberOfStudents;

	}

}
