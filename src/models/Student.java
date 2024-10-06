package models;

public class Student extends People{
	private Double gpa;

	public Student(String name, Integer age, Double gpa) {
		super(name, age);
		this.gpa = gpa;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	@Override
	public void sayInfo() {
		System.out.println("Hello, my name is " + getName());
		System.out.println("I am " + getAge() + " Years old");
		System.out.println("I am a Student");
		System.out.println("My GPA " + getGpa());
	}
	
}
