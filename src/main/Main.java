package main;

import java.util.ArrayList;
import java.util.Scanner;

import models.Lecturer;
import models.People;
import models.Student;

public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList<People> peoples = new ArrayList<>();
	
	private void addPeople() {
		String name;
		do {
			System.out.print("Input your name [3 - 15 characters]: ");
			name = scan.nextLine();
		} while (!(name.length() > 3 && name.length() < 15));
	
		Integer age; 
		do {
			System.out.print("Input your age [min 16]: ");
			
			while(!scan.hasNextInt()) {
				System.out.print("Input your age [min 16] Please use numeric : ");
				scan.next();
			}
			
			age = scan.nextInt(); scan.nextLine();
		} while (!(age > 16));
		
		String role;
		do {
			System.out.print("Input your role [Student | Lecturer]: ");
			role = scan.nextLine();
		} while (!(role.equals("Student") || role.equals("Lecturer")));
		
		if(role.equals("Student")) {
			Double gpa;
			do {
				System.out.print("Input Gpa [0 - 4]: ");
				if(!scan.hasNextDouble()) {
					System.out.println("Please input a double!");
				}
				
				gpa = scan.nextDouble(); scan.nextLine();
			} while (!(gpa > 0 && gpa < 4));
			
			peoples.add(new Student(name, age, gpa));
		} else if(role.equals("Lecturer")) {
			Integer salary;
			do {
				System.out.print("Input salary [min 4000000]: ");
				salary = scan.nextInt(); scan.nextLine();
			} while (!(salary > 4000000));
			
			peoples.add(new Lecturer(name, age, salary));
		}
	}
	
	void viewAll() {
		if(peoples.size() == 0) {
			System.out.println("Theres no people in the classroom");
			return;
			
		}
		
		int count = 1;
		for (People people : peoples) {
			System.out.print(count + ". ");
			people.sayInfo();
			System.out.println();
			count++;
		}
	}
	
	void removePeople() {
		viewAll();
		System.out.println();
		
		int index;
		System.out.print("Input index : ");
		index = scan.nextInt(); scan.nextLine();
		
		peoples.remove(index - 1);
	}
	
	void updatePeople() {
		int index;
		System.out.print("Please choose index to update: ");
		index = scan.nextInt(); 
		scan.nextLine();

		// Get the person to update
		People person = peoples.get(index - 1);

		// Update name
		String name;
		do {
		    System.out.println("Current name: " + person.getName());
		    System.out.print("Input your name [3 - 15 characters]: ");
		    name = scan.nextLine();

		    if (name.equals("-1")) return;
		} while (!(name.length() >= 3 && name.length() <= 15));

		if (!name.equals("-1")) {
		    person.setName(name);
		}

		// Update age
		Integer age; 
		do {
		    System.out.print("Input your age [min 16]: ");
		    while (!scan.hasNextInt()) {
		        System.out.print("Invalid input. Please use a numeric value for age [min 16]: ");
		        scan.next();
		    }

		    age = scan.nextInt(); 
		    scan.nextLine();
		    if (age == 0) return;

		} while (age < 16);

		if (age != 0) {
		    person.setAge(age);
		}

		// Update specific fields for Student or Lecturer
		if (person instanceof Student) {
		    Double gpa = null;
		    do {
		        System.out.print("Input GPA [0 - 4]: ");
		        if (!scan.hasNextDouble()) {
		            System.out.println("Please input a double value!");
		            scan.next(); // Consume the invalid input
		            continue;
		        }

		        gpa = scan.nextDouble(); 
		        scan.nextLine();
		    } while (gpa < 0 || gpa > 4);

		    ((Student) person).setGpa(gpa);
		} else if (person instanceof Lecturer) {
		    Integer salary;
		    do {
		        System.out.print("Input salary [min 4000000]: ");
		        while (!scan.hasNextInt()) {
		            System.out.print("Invalid input. Please use a numeric value for salary [min 4000000]: ");
		            scan.next();
		        }
		        salary = scan.nextInt();
		        scan.nextLine();
		    } while (salary < 4000000);

		    ((Lecturer) person).setSalary(salary);
		}

	}
	
	public Main() {
		peoples.add(new Student("aisjd", 20, 3.0));
		
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
				viewAll();
			} else if (choice == 3) {
				removePeople();
			} else if (choice == 4) {
				updatePeople();
			} else if (choice == 5) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
