package application;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Teacher extends Person {
	private List<Courses> classesTaught;
	private Map<Courses, List<Student>> currentStudents;
	private String teacherNumber;
	
	public Teacher () {};
	
	public Teacher(String firstName, String lastName, String address, Boolean isAdmin, Boolean isTeacher, Boolean isStudent, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.isAdmin = isAdmin;
		this.isTeacher = isTeacher;
		this.isStudent = isStudent;
		this.userName = userName;
		this.password = password;
	};
	
	public List<Courses> getClassesTaught() {
		return classesTaught;
	}
	
	public void setClassesTaught(List<Courses> classesTaught) {
		this.classesTaught = classesTaught;
	}
	
	public Map<Courses, List<Student>> getCurrentStudents() {
		return currentStudents;
	}
	
	public void setCurrentStudents(Map<Courses, List<Student>> currentStudents) {
		this.currentStudents = currentStudents;
	}

	public String getTeacherNumber() {
		return teacherNumber;
	}
	
	public void settingTeacherNumber(String teacherNumber) {
		this.teacherNumber = teacherNumber;
	}

	public void setTeacherNumber() {
Integer nums = null;
		
		Random rand = new Random();
		nums = rand.nextInt(900000) + 100000;
		
		
		this.teacherNumber = String.format("TN04%d", nums);
	}
}
