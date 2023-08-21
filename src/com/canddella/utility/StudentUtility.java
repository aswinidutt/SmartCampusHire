package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Skill;
import com.canddella.entity.Student;
import com.canddella.service.StudentServiceImpl;

public class StudentUtility {

	public static void main(String[] args) {

		studentMenu();

	}

	public static void studentMenu() {
		Scanner scanner = new Scanner(System.in);
		int ch;
		char choice = 'y';
		do {
			System.out.println("1.Save Student 2.displayAll 3.delete Student 4.Select Student 5.Update\n");
			System.out.println("Enter your choice");
			ch = scanner.nextInt();
			switch (ch) {
			case 1:
				saveStudent();
				break;
			case 2:
				displayAll();
				break;
			case 3:
				deleteStudent();
				break;
			case 4:
				selectStudent();
				break;
			case 5:
				updateStudent();
				break;

			}
			System.out.println("Do you want to continue:");
			choice = scanner.next().charAt(0);
		} while ((choice == 'y') || (choice == 'Y'));

	}

	private static void saveStudent() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the Student Id:");
		String studentId = scanner.nextLine();

		System.out.println("Enter the Student First Name:");
		String firstName = scanner.nextLine();

		System.out.println("Enter the Student Last Name:");
		String lastName = scanner.nextLine();

		System.out.println("Enter the Student Email Id:");
		String mailId = scanner.nextLine();

		System.out.println("Enter the Student Phone Number:");
		long phNumber = scanner.nextLong();

		System.out.println("Enter the student Address:");
		String address = scanner.nextLine();
		scanner.nextLine();
		System.out.println("Enter the student DOB:");// we cant scan as date so take it as string and then convert
		String dob = scanner.nextLine();
		DateTimeFormatter date_Formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dob1 = LocalDate.parse(dob, date_Formatter);

		System.out.println("Enter the student Gender:");
		String gender = scanner.nextLine();

		System.out.println("Enter the student University:");
		String university = scanner.nextLine();

		System.out.println("Enter the student Stream :");
		String stream = scanner.nextLine();

		System.out.println("Enter the student Graduation Year:");
		int gradYr = scanner.nextInt();

		System.out.println("Enter the student CGPA:");
		double cgpa = scanner.nextDouble();
		
		SkillUtility.displayAllSkill();
		Skill skill=new Skill();
	System.out.println("Enter the student skill id:");
		int skillId=scanner.nextInt();
		skill.setSkillId(skillId);
		
		
		
		

		Student student = new Student(studentId, firstName, lastName, mailId, phNumber, address, dob1, gender,
				university, stream, gradYr, cgpa,skill);
		StudentServiceImpl studentServiceImpl = new StudentServiceImpl();

		studentServiceImpl.saveStudent(student);
	}

	//private static void displayAll() {
	public static void displayAll() {
		List<Student> studentList = new ArrayList<>();

		StudentServiceImpl studentServiceImpl = new StudentServiceImpl();

		studentList = studentServiceImpl.displayAll();
		for (Student stud : studentList) {
			System.out
					.println("Student Id :" + stud.getStudent_id() + "\n" + "Student first name:" + stud.getFirstName()
							+ "\n" + "Student last name:" + stud.getLastName() + "\n" + "Email:" + stud.getEmail()
							+ "\n" + "PhoneNumber:" + stud.getPhnumber() + "\n" + "Address:" + stud.getAddress() + "\n"
							+ "Date Of Birth:" + stud.getDateOfBirth() + "\n" + "Gender:" + stud.getGender() + "\n"
							+ "University:" + stud.getUniversity() + "\n" + "Stream:" + stud.getStream() + "\n"
							+ "Graduation Year:" + stud.getPassOutYr() + "\n" + "CGPA:" + stud.getCgpa() + "\n"+"Skill Id: "+stud.getSkill().getSkillId()+"\n");
		}

		// System.out.println(studentList);
		// Giving the above line simply wont give out but give address because we havent
		// overrided it with to string

	}

	private static void deleteStudent() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the student id to delete a row");
		String studentId = scanner.nextLine();

		StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
		studentServiceImpl.deleteStudent(studentId);

	}

	private static void selectStudent() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the student id to select a row");
		String studentId = scanner.nextLine();

		StudentServiceImpl studentServiceImpl = new StudentServiceImpl();

		Student student = studentServiceImpl.selectStudent(studentId);

		System.out.println(
				"Student Id :" + student.getStudent_id() + "\n" + "Student first name:" + student.getFirstName() + "\n"
						+ "Student last name:" + student.getLastName() + "\n" + "Email:" + student.getEmail() + "\n"
						+ "PhoneNumber:" + student.getPhnumber() + "\n" + "Address:" + student.getAddress() + "\n"
						+ "Date Of Birth:" + student.getDateOfBirth() + "\n" + "Gender:" + student.getGender() + "\n"
						+ "University:" + student.getUniversity() + "\n" + "Stream:" + student.getStream() + "\n"
						+ "Graduation Year:" + student.getPassOutYr() + "\n" + "CGPA:" + student.getCgpa() + "Skill Id"+student.getSkill().getSkillId()+"\n");

	}

	private static void updateStudent() {
		
		Scanner scanner=new Scanner(System.in);
		char choice='y'; 
		String column_name;
		String newValue;
		System.out.println("Enter the student id to update a row");
		String studentId=scanner.nextLine();
		
		StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
		Student student= studentServiceImpl.getStudent( studentId);
		do
		{
		System.out.println(
				"1.Student First Name 2. Student Last Name 3.Email 4.PhoneNumber 5.Address 6.Date Of Birth 7.Gender 8. University  9.Stream 10. Graduation Year 11.CGPA\n");
		System.out.println("Enter your choice");
		int ch=scanner.nextInt();
		switch(ch)
		{
		case 1:column_name="first_name";
		System.out.println("Enter the new value of first name");
		scanner.nextLine();
		newValue=scanner.nextLine();
		studentServiceImpl.updateStudent(column_name,newValue,studentId);
			break;
		case 2:column_name="last_name";
		System.out.println("Enter the new value of last name");
		scanner.nextLine();
		newValue=scanner.nextLine();
		studentServiceImpl.updateStudent(column_name,newValue,studentId);
			break;
		case 3:column_name="email";
		System.out.println("Enter the new value of Email Id");
		scanner.nextLine();
		newValue=scanner.nextLine();
		studentServiceImpl.updateStudent(column_name,newValue,studentId);
			break;
		case 4:column_name="phonenumber";
		System.out.println("Enter the new Phone Number");
		//scanner.nextLine();
	Long l=scanner.nextLong();
	newValue=Long.toString(l);//we convert phnumber to String before passing
		studentServiceImpl.updateStudent(column_name,newValue,studentId);
			break;
		case 5:column_name="address";
		System.out.println("Enter the new value of Address");
		scanner.nextLine();
		newValue=scanner.nextLine();
		studentServiceImpl.updateStudent(column_name,newValue,studentId);
			break;
		case 6:column_name="date_of_birth";
		System.out.println("Enter the new Date Of Birth");
//		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		 LocalDate dateOfBirth = sdf.parseDate(sdf);
		 newValue=scanner.nextLine();

		
//     newValue=scanner.nextLine();
//		
//		newValue=scanner.nextLine();
	//	studentServiceImpl.updateStudent(column_name,String.valueOf(newValue),studentId);
		studentServiceImpl.updateStudent(column_name,newValue,studentId);
			break;
		case 7:column_name="gender";
		System.out.println("Enter the new value Gender");
		scanner.nextLine();
		newValue=scanner.nextLine();
		studentServiceImpl.updateStudent(column_name,newValue,studentId);
			break;
		case 8:column_name="university";
		System.out.println("Enter the new University");
		scanner.nextLine();
		newValue=scanner.nextLine();
		studentServiceImpl.updateStudent(column_name,newValue,studentId);
			break;
		case 9:column_name="stream";
		System.out.println("Enter the new Stream");
		scanner.nextLine();
		newValue=scanner.nextLine();
		studentServiceImpl.updateStudent(column_name,newValue,studentId);
			break;
		case 10:column_name="graduation_year";
		System.out.println("Enter the new Graduation year");
		//scanner.nextLine();
		int year=scanner.nextInt();
		
		newValue=Integer.toString(year);//convert integer to string to pass as parameter as it is string at the receiving end
		studentServiceImpl.updateStudent(column_name,newValue,studentId);
			break;
		case 11:column_name="cgpa";
		System.out.println("Enter the new CGPA");
	//	scanner.nextLine();
		double d=scanner.nextDouble();
		
		newValue=String.valueOf(d);
		studentServiceImpl.updateStudent(column_name,newValue,studentId);
			break;
		}
		System.out.println("Do you want to continue:");
		choice=scanner.next().charAt(0);
		}while((choice=='y')||(choice=='Y'));
	}

}
