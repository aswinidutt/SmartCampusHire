package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.College;
import com.canddella.service.CollegeServiceImpl;

public class CollegeUtility {

	public static void main(String[] args) {
		collegeMenu();

	}

	public static void collegeMenu() {
		char choice;
		do
		{
		Scanner scanner=new Scanner(System.in);
		System.out.println("1.InsertCollege 2.DisplayAllCollege 3. DeleteCollege 4. Search College 5.Update\n");
		System.out.println("Enter your choice:");
		int ch=scanner.nextInt();
		if(ch==1)
		{
			saveCollege();
			
		}
		else if(ch==2)
		{
			displayAllCollege();
		}
		else if(ch==3)
		{
		deleteCollege();	
		}
		else if(ch==4)
		{
			searchCollege();
		}
		else if(ch==5)
		{
		updateCollege();	
		}
		System.out.println("Do you want to continue");
		choice=scanner.next().charAt(0);
		
		}while((choice=='y')||(choice=='Y'));
	}

	

	private static void updateCollege() {
		Scanner scanner=new Scanner(System.in);
		CollegeServiceImpl collegeServiceImpl = new CollegeServiceImpl ();	
		System.out.println("Enter the college id you want to update:");
		String collegeId=scanner.nextLine();
		College college=collegeServiceImpl.getCollege(collegeId);
		char choice = 'y';
		if(college!=null)
			do
			{
		
			int ch;
			System.out.println("1.College Name 2.Location 3.Accrediation Details 4.Established Year\n");
			ch=scanner.nextInt();
			String coloumn_name,newvalue;
			switch(ch)
			
			{
			case 1:
			 coloumn_name="college_name";
			System.out.println("Enter the new college name");
			scanner.nextLine();
			 newvalue=scanner.nextLine();
			collegeServiceImpl.updateCollege(coloumn_name, newvalue,collegeId);
			break;
			
			case 2: coloumn_name="location";
			scanner.nextLine();
			System.out.println("Enter the new college location");
		   newvalue=scanner.nextLine();
			collegeServiceImpl.updateCollege(coloumn_name, newvalue,collegeId);
			break;
			
			case 3:coloumn_name="accrediation_details";
			scanner.nextLine();
			System.out.println("Enter the new college Accrediation Details");
		   newvalue=scanner.nextLine();
			collegeServiceImpl.updateCollege(coloumn_name, newvalue,collegeId);
				
			break;
			case 4:  coloumn_name="established_year";
			scanner.nextLine();
			System.out.println("Enter the new college Established Year");
		newvalue=scanner.nextLine();
			collegeServiceImpl.updateCollege(coloumn_name, newvalue,collegeId);
			break;
			
			}
			System.out.println("Do you want to continue changing the fields:");
			choice=scanner.next().charAt(0);
		}while((choice=='y')||(choice=='Y'));
		
}


	private static void searchCollege() {
		
		Scanner scanner=new Scanner(System.in);
		CollegeServiceImpl collegeServiceImpl = new CollegeServiceImpl ();
		System.out.println("Enter the college id you want to search:");
		String collegeId=scanner.nextLine();
		collegeServiceImpl. searchCollege(collegeId);
		
	}

	private static void deleteCollege() {
		Scanner scanner= new Scanner(System.in);
		CollegeServiceImpl collegeServiceImpl = new CollegeServiceImpl ();
		System.out.println("Enter the id of  college to delete the row:");
		String collegeId = scanner.nextLine();
		
		collegeServiceImpl.deleteCollege(collegeId);
		
	}

	//private static void displayAllCollege() { - change this to public to displayAll in Utility of registration table
		public static void displayAllCollege() {
		CollegeServiceImpl collegeServiceImpl = new CollegeServiceImpl ();
		List<College> collegeList=null;
		 collegeList = collegeServiceImpl.displayAllCollege();
		for (College clg : collegeList)
			if(clg!=null)
		{
			System.out.println("College Id:" + clg.getCollegeId() + "\n" + "College Name:"
					+ clg.getCollegeName() + "\n" + "College Location:" + clg.getLocation() + "\n"
					+ "Accrediation Details:" + clg.getAccrediationDetails() +"\n"+ "Established Year:"+clg.getEstablishedYr());
			System.out.println("**********************************************************");
		}	
		
		
	}

	private static void saveCollege() {
		
		College college =null;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the CollegeId:");
		String collegeId=scanner.nextLine();
		System.out.println("Enter the CollegeName:");
		String collegeName=scanner.nextLine();
		System.out.println("Enter the College Location:");
		String location=scanner.nextLine();
		System.out.println("Enter the Accrediation Details:");
		String acc=scanner.nextLine();
		System.out.println("Enter the Established Year:");
		int establishYr=scanner.nextInt();
		college =new College(collegeId,collegeName, location,acc,establishYr);
		
		CollegeServiceImpl collegeServiceImpl = new CollegeServiceImpl ();
		collegeServiceImpl.saveCollege(college);
		
	}


}
