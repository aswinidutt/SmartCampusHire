package com.canddella.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Status;
import com.canddella.service.StatusServiceImpl;

public class StatusUtility {

	public static void main(String[] args) {
	
		statusMenu();

	}

	public static void statusMenu() {
		
		Scanner scanner =new Scanner(System.in);
		int ch;
		char choice='y';
		do
		{
		System.out.println("1.saveStatus  2.getStatus  3.displayStatus  4.updateStatus  5.deleteStatus\n");
		System.out.println("Enter your choice");
		ch=scanner.nextInt();
		
		switch(ch)
		{
		case 1:saveStatus();
			break;
		case 2:getStatus();
			break;
		case 3:displayStatus();
			break;
		case 4:updateStatus();
			break;
		case 5:deleteStatus();
			break;
			
		}
		}while((choice=='y')||(choice=='y'));
		
	}


	private static void saveStatus() {
		Scanner scanner =new Scanner(System.in);
		Status status=null;
		
		System.out.println("Enter the status id");
		String statusId=scanner.nextLine();
		System.out.println("Enter the status name");
		String statusName=scanner.nextLine();
		 status=new Status(statusId,statusName);
		
		StatusServiceImpl statusServiceImpl=new StatusServiceImpl();
		statusServiceImpl.saveStatus(status);
		
	}

	private static void getStatus() {
		Scanner scanner =new Scanner(System.in);
		
		System.out.println("Enter the status id");
		String statusId=scanner.nextLine();
		StatusServiceImpl statusServiceImpl=new StatusServiceImpl();
	Status status=statusServiceImpl.getStatus(statusId);
		
	System.out.println("Status Id:   "+status.getStatusId()+"\n"+"Status Name:    "+status.getStatusName()+"\n");
		
	}
	//private static void displayStatus() {
	public static void displayStatus() {
		List<Status>statusList=new ArrayList<>();
		StatusServiceImpl statusServiceImpl=new StatusServiceImpl();
		 statusList=statusServiceImpl.displayStatus();
	for(Status st:statusList)
	{
		System.out.println("Status Id:   "+st.getStatusId()+"\n"+"Status Name:    "+st.getStatusName()+"\n");	
	}
		
	}

	private static void deleteStatus() {
Scanner scanner =new Scanner(System.in);
		
		System.out.println("Enter the status id");
		String statusId=scanner.nextLine();
		StatusServiceImpl statusServiceImpl=new StatusServiceImpl();
	statusServiceImpl.deleteStatus(statusId);
	
		
	}
	
	private static void updateStatus() {
Scanner scanner =new Scanner(System.in);
	

int ch;
char choice='y';
do
{
		System.out.println("Enter the status id");
		String statusId=scanner.nextLine();
		StatusServiceImpl statusServiceImpl=new StatusServiceImpl();
		Status status=statusServiceImpl.receiveStatus(statusId);
//		int ch;
//		char choice='y';
		String  column_name;
		String newValue;
//		do
//		{
			System.out.println("1.Status Name\n");
			System.out.println("Enter your choice");
			ch=scanner.nextInt();
			switch(ch)
			{
			case 1:column_name="status_name";
			System.out.println("Enter the new status");
			scanner.nextLine();
		 newValue=scanner.nextLine();
		 statusServiceImpl.updateStatus(column_name, newValue, statusId);
		
			break;
			
			}
		}while((choice=='y')||(choice=='y'));
		
		
	
	}

}
