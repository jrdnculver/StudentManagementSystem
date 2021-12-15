package application;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student extends Person {
	private String studentNumber;
	private double gpa = 0.0;
	private boolean enrolled;
	private List<Courses> currentClasses;
	
	public Student () {};
	
	public Student(String firstName, String lastName, String address, Boolean isAdmin, Boolean isTeacher, Boolean isStudent, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.isAdmin = isAdmin;
		this.isTeacher = isTeacher;
		this.isStudent = isStudent;
		this.userName = userName;
		this.password = password;
	};
	
	public String getNumber() {
		return studentNumber;
	}
	
	public String settingNumber(String number) {
		return this.studentNumber = number;
	}

	public void setNumber() {
		Integer nums = null;
		
		Random rand = new Random();
		nums = rand.nextInt(900000) + 100000;
		
		
		this.studentNumber = String.format("SN04%d", nums);
		
		Sequel_Students dataStudent = new Sequel_Students();
		Connection data = dataStudent.connectToDatabase();
		dataStudent.readValue(data, "Student");
	}
	
	public double getGpa() {
		return gpa;
	}
	
	public boolean isEnrolled() {
		return enrolled;
	}
	
	public List<Courses> getCurrentClasses() {
		return currentClasses;
	}
	
	public void setCurrentClasses(List<Courses> currentClasses) {
		this.currentClasses = currentClasses;
	}
}
