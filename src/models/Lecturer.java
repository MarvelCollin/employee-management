package models;

public class Lecturer extends People{
	private Integer salary;

	public Lecturer(String name, Integer age, Integer salary) {
		super(name, age);
		this.salary = salary;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public void sayInfo() {
		System.out.println("Hello, my name is " + getName());
		System.out.println("I am " + getAge() + " Years old");
		System.out.println("I am a Lecturer");
		System.out.println("My salary " + getSalary());
	}
		
}
