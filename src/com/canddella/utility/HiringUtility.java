package com.canddella.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Hire;
import com.canddella.entity.Status;
import com.canddella.service.HiringServiceImpl;

public class HiringUtility {

	public static void main(String[] args) {
		hiringMenu();

		}

		public static void hiringMenu() {
			
			Scanner scanner =new Scanner(System.in);
			int ch;
			char choice='y';
			do
			{
			System.out.println("1.Save Hire  2.Get Hire  3.Display All  Hire  4.Update Hire  5.Delete Hire\n");
			System.out.println("Enter your choice");
			ch=scanner.nextInt();
			
			switch(ch)
			{
			case 1:saveHire();
				break;
			case 2:getHire();
				break;
			case 3:displayHire();
				break;
			case 4:updateHire();
				break;
			case 5:deleteHire();
				break;
				
			}
			}while((choice=='y')||(choice=='y'));
			
		}


		private static void saveHire() {
			Scanner scanner =new Scanner(System.in);
			Hire hire=null;
			
			System.out.println("Enter the hire id");
			String hireId=scanner.nextLine();
			System.out.println("Enter the company name");
			String companyName=scanner.nextLine();
			hire=new Hire(hireId,companyName);
			
			HiringServiceImpl hireServiceImpl=new HiringServiceImpl();
			hireServiceImpl.saveHire(hire);
			
		}

		private static void getHire() {
			Scanner scanner =new Scanner(System.in);
			HiringServiceImpl hiringServiceImpl=new HiringServiceImpl();
			
			System.out.println("Enter the hire id");
			String hireId=scanner.nextLine();
			
			Hire hire=hiringServiceImpl.getHire(hireId);
			
		System.out.println("Hire Id:   "+hire.getHire_id()+"\n"+"Hire Name:    "+hire.getCompany_name()+"\n");
			
		}
		//private static void displayHire() {
		public static void displayHire() {
			List<Hire>hiringList=new ArrayList<>();
			HiringServiceImpl hiringServiceImpl=new HiringServiceImpl();
			hiringList=hiringServiceImpl.displayHire();
		for(Hire st: hiringList)
		{
			System.out.println("hiring Id:   "+st.getHire_id()+"\n"+"Company Name:    "+st.getCompany_name()+"\n");	
		}
			
		}

		private static void deleteHire() {
	Scanner scanner =new Scanner(System.in);
			
			System.out.println("Enter the hiring id");
			String hiringId=scanner.nextLine();
			HiringServiceImpl hiringServiceImpl=new HiringServiceImpl();
			hiringServiceImpl.deleteHire(hiringId);
		
			
		}
		private static void updateHire() {
	Scanner scanner =new Scanner(System.in);
			
			System.out.println("Enter the Hire id");
			String hiringId=scanner.nextLine();
			HiringServiceImpl hiringServiceImpl=new HiringServiceImpl();
			Hire hiring=hiringServiceImpl.receiveHire(hiringId);
			int ch;
			char choice='y';
			String  column_name;
			String newValue;
			do
			{
				System.out.println("1.Company Name\n");
				System.out.println("Enter your choice");
				ch=scanner.nextInt();
				switch(ch)
				{
				case 1:column_name="company_name";
				System.out.println("Enter the new company name");
				scanner.nextLine();
			 newValue=scanner.nextLine();
			 hiringServiceImpl.updateHire(column_name, newValue, hiringId);
			
				break;
				
				}
			}while((choice=='y')||(choice=='y'));
			
			
		
		}


	}


