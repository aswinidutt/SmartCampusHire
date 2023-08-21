package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Skill;
import com.canddella.service.SkillServiceImpl;

public class SkillUtility {

	public static void main(String[] args) {
		skillMenu();

	}

	

	public static void skillMenu() {
		char choice;
		do
		{
		Scanner scanner=new Scanner(System.in);
		System.out.println("1.InsertSkill 2.DisplayAllSkills 3. DeleteSkill 4. Search Skill 5.Update\n");
		System.out.println("Enter your choice:");
		int ch=scanner.nextInt();
		if(ch==1)
		{
			saveSkill();
			
		}
		else if(ch==2)
		{
			displayAllSkill();
		}
		else if(ch==3)
		{
		deleteSkill();	
		}
		else if(ch==4)
		{
			searchSkill();
		}
		else if(ch==5)
		{
		updateSkill();	
		}
		System.out.println("Do you want to continue");
		choice=scanner.next().charAt(0);
		
		}while((choice=='y')||(choice=='Y'));
	}

	

	private static void updateSkill() {
		Scanner scanner=new Scanner(System.in);
		SkillServiceImpl skillServiceImpl = new SkillServiceImpl ();	
		System.out.println("Enter the skill id you want to update:");
		int skillId=scanner.nextInt();
		Skill skill=skillServiceImpl.getSkill(skillId);
		char choice = 'y';
		if(skill!=null)
			do
			{
		
			int ch;
			System.out.println("1.Skill Name \n");
			System.out.println("Enter the choice");
			ch=scanner.nextInt();
			String coloumn_name ;
			String newvalue;
			
			if (ch==1)
			{
			 coloumn_name="skill_name";
			System.out.println("Enter the new skill name");
			scanner.nextLine();
			 newvalue=scanner.nextLine();
			skillServiceImpl.updateSkill(coloumn_name, newvalue,skillId);
			}
			System.out.println("Do you want to continue changing the fields:");
			choice=scanner.next().charAt(0);
		}while((choice=='y')||(choice=='Y'));
		
}


	private static void searchSkill() {
		
		Scanner scanner=new Scanner(System.in);
		SkillServiceImpl skillServiceImpl = new SkillServiceImpl ();
		System.out.println("Enter the skill id you want to search:");
		int skillId=scanner.nextInt();
		skillServiceImpl. searchSkill(skillId);
		
	}

	private static void deleteSkill() {
		Scanner scanner= new Scanner(System.in);
		SkillServiceImpl skillIdServiceImpl = new SkillServiceImpl ();
		System.out.println("Enter the id of  skill to delete the row:");
		int skillId = scanner.nextInt();
		
		skillIdServiceImpl.deleteSkill(skillId);
		
	}

//	private static void displayAllSkill() {
  public	static List<Skill> displayAllSkill() {
		SkillServiceImpl skillServiceImpl = new SkillServiceImpl ();
		List<Skill> skillList=null;
		 skillList = skillServiceImpl.displayAllSkill();
		for (Skill skl : skillList)
			if(skl!=null)
		{
			System.out.println("Skill Id:" + skl.getSkillId() + "\n" + "Skill  Name:"
					+ skl.getSkillName() + "\n" ); 
					
			System.out.println("**********************************************************");
		}
		return skillList;	
		
		
	}

	private static void saveSkill() {
		
		Skill skill =null;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the SkillId:");
	int skillId=scanner.nextInt();
		System.out.println("Enter the SkillName:");
		scanner.nextLine();
		String skillName=scanner.nextLine();
		
		skill =new Skill(skillId, skillName);
		
		SkillServiceImpl skillServiceImpl = new SkillServiceImpl ();
		skillServiceImpl.saveSkill(skill);
		
	}


}
