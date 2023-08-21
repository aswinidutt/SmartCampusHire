package com.canddella.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Recruitment;
import com.canddella.service.RecruitmentServiceImpl;

public class RecruitmentUtility {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int ch;
		char choice = 'y';
		do {

			System.out.println("***********************The available skills are*****************");
			System.out.println("1.Core Java   2.Spring Boot  3.HTML  4.JavaScript  5.Python  6.Verilog\n");
			System.out.println("Enter your choice");
			ch = scanner.nextInt();

			// List<Skill>skillList=SkillUtility.displayAllSkill();

			System.out.println("Enter the corresponding skill name:");
			scanner.nextLine();
			String skillName = scanner.nextLine();
			
			RecruitmentServiceImpl recruitmentServiceImpl = new RecruitmentServiceImpl();

			Recruitment recruitment = recruitmentServiceImpl.findSkillId(skillName);
			
			System.out.println("The Skill Id is:"+recruitment.getSkill().getSkillId());
			
			int skillId=recruitment.getSkill().getSkillId();

			List<Recruitment> recruitmentList=new ArrayList<>();
			recruitmentList=getStudents(skillId);
			 for(Recruitment rec: recruitmentList)
			 {
				 System.out.println("The Student are:");
				 System.out.println(rec.getStudent().getFirstName()+" "+rec.getStudent().getLastName());
			 }

			
			System.out.println("Do you want to continue:");
			choice = scanner.next().charAt(0);
		} while ((choice == 'y') || (choice == 'Y'));

	}

	private static List<Recruitment> getStudents(int skillId) {
		List<Recruitment> recruitmentList=new ArrayList<>();
		RecruitmentServiceImpl recruitmentServiceImpl = new RecruitmentServiceImpl();
		 return recruitmentList= recruitmentServiceImpl.getStudents(skillId);
		

	}

}
