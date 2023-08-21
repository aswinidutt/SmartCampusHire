package com.canddella.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.RecruiterRegistration;
import com.canddella.entity.Skill;
import com.canddella.entity.Student;
import com.canddella.entity.StudentRecruiterRegistration;
import com.canddella.service.StudentRecruiterRegistrationServiceImpl;

public class Utility {
	public static void main(String[] args) {

		sortMenu();

	}

	public static List<Student> sortMenu() {
		List<Student>studentList=new ArrayList<>();
		int ch;
		char choice = 'y';
		do {

			Scanner scanner = new Scanner(System.in);

			System.out.println("Available criterias are:");
			System.out.println("\n");
			System.out.println("1.Skill Set  2. Skill Set and CGPA\n");
			System.out.println("Enter your choice");
			ch = scanner.nextInt();

			switch (ch) {

			case 1:
				studentList=skillSetBased();
				break;
			case 2:
				studentList=skillAndCGPABased();
				break;
			case 3:// displaySkillSetBased();
				break;
			case 4://displaySkillSetAndCgpaBased();
				break;
			}
			System.out.println("Do you want to continue:");
			choice = scanner.next().charAt(0);
		} while ((choice == 'y') || (choice == 'Y'));
		
		
return studentList;
	}

private static List<Student> skillSetBased() {
	
	List<Student>studentList=new ArrayList<>();

		RecruiterRegistration recruiterRegistration = new RecruiterRegistration();
		String skill_description = "Skill Set";
		recruiterRegistration.setSkillDescription(skill_description);

		System.out.println("Skill_description:" + "  " + recruiterRegistration.getSkillDescription());
		System.out.println("\n");

		Scanner scanner = new Scanner(System.in);

		SkillUtility.displayAllSkill();

		System.out.println("Enter the desired skill Id:");
		int skillId = scanner.nextInt();
		Skill skill = new Skill();
		skill.setSkillId(skillId);

		StudentRecruiterRegistrationServiceImpl studentRecruiterRegistrationServiceImpl = new StudentRecruiterRegistrationServiceImpl();
		List<StudentRecruiterRegistration> studentRecruiterRegistrationList = studentRecruiterRegistrationServiceImpl
				.skillSetBased(skill, recruiterRegistration);
//
//		System.out.println("+------------+-------------------+------------------+");
//
//		System.out.printf("| %-9s | %-17s | %-16s | \n",
//
//				"Student Id", "First Name", "Last Name");
//		System.out.println("+------------+-------------------+------------------+");
//
//		for (StudentRecruiterRegistration stud : studentRecruiterRegistrationList) {
//
//			
//
//			System.out.printf("| %-9s | %-17s | %-16s | \n",
//
//					stud.getStudent().getStudent_id(), stud.getStudent().getFirstName(),
//					stud.getStudent().getLastName());
//			System.out.println("+------------+---------------------------------------+");
		for (StudentRecruiterRegistration stud : studentRecruiterRegistrationList) {
		
			System.out.println(stud.getStudent().getStudent_id());
String student_id=stud.getStudent().getStudent_id();
			
			Student student=new Student();
			student.setStudent_id(student_id);
			studentList.add(student);
		
		
		}
return studentList;
	}

	private static List<Student> skillAndCGPABased() {
		
		List<Student>studentList=new ArrayList<>();

		
		RecruiterRegistration recruiterRegistration = new RecruiterRegistration();
		String skill_description = "Skill Set and CGPA";
		recruiterRegistration.setSkillDescription(skill_description);

		System.out.println("Skill_description:" + " " + recruiterRegistration.getSkillDescription());
		System.out.println("\n");

		Scanner scanner = new Scanner(System.in);

		SkillUtility.displayAllSkill();

		System.out.println("Enter the desired skill Id:");
		int skillId = scanner.nextInt();
		Skill skill = new Skill();
		skill.setSkillId(skillId);

		System.out.println("Enter the desired CGPA");
		double cgpa = scanner.nextDouble();
		Student student = new Student();
		student.setCgpa(cgpa);

		StudentRecruiterRegistrationServiceImpl studentRecruiterRegistrationServiceImpl = new StudentRecruiterRegistrationServiceImpl();
		List<StudentRecruiterRegistration> studentRecruiterRegistrationList1 = studentRecruiterRegistrationServiceImpl
				.skillAndCGPABased(skill, student);

//		System.out.println("+------------+-------------------+------------------+");
//
//		System.out.printf("| %-9s | %-17s | %-16s | \n",
//
//				"Student Id", "First Name", "Last Name");
//		System.out.println("+------------+-------------------+------------------+");
//
//		for (StudentRecruiterRegistration stud : studentRecruiterRegistrationList1) {
//
//
//			System.out.printf("| %-9s | %-17s | %-16s | \n",
//
//					stud.getStudent().getStudent_id(), stud.getStudent().getFirstName(),
//					stud.getStudent().getLastName());
//			System.out.println("+------------+---------------------------------------+");
		
		for (StudentRecruiterRegistration stud : studentRecruiterRegistrationList1) {
			
			System.out.println(stud.getStudent().getStudent_id());
			
			String student_id=stud.getStudent().getStudent_id();
			student.setStudent_id(student_id);
//			double cgpa_=stud.getStudent().getCgpa();
//			student.setCgpa(cgpa_);
//			
			studentList.add(student);
			}
		
//	private static void displaySkillSetBased() {
//		StudentRecruiterRegistrationServiceImpl studentRecruiterRegistrationServiceImpl = new StudentRecruiterRegistrationServiceImpl();
//		studentRecruiterRegistrationServiceImpl.displaySkillSetBased();
//		
//		
//	}
return studentList;
				}
}
