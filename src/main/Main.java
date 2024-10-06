package main;

import java.util.ArrayList;
import java.util.Scanner;

import models.People;

public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList<People> people = new ArrayList<>();
	
	private void addPeople() {
		String name;
		do {
			System.out.print("Input your name [3 - 15 characters]: ");
			name = scan.nextLine();
			// between 3 & 15
		} while (!(name.length() > 3 && name.length() < 15));
	
		Integer age;
		do {
			System.out.print("Input your age [min 16]: ");
			age = scan.nextInt(); scan.nextLine();
		} while (!(age > 16));
		
		String role;
		do {
			System.out.print("Input your role [Student | Lecturer]: ");
			role = scan.nextLine();
		} while (!(role.equals("Student") || role.equals("Lecturer")));
	}
	
	public Main() {
		int choice = 0;
		while(true) {
			System.out.println("1. Add People");
			System.out.println("2. View People");
			System.out.println("3. Remove People");
			System.out.println("4. Update People");
			System.out.println("5. Exit");
			choice = scan.nextInt(); scan.nextLine();
			
			if(choice == 1) {
				addPeople();
			} else if (choice == 2) {
				
			} else if (choice == 3) {
				
			} else if (choice == 4) {
				
			} else if (choice == 5) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
