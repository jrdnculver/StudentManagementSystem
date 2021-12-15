package application;

public class GivenGrade {
	private String courseSubject;
	private String courseName;
	private int courseNumber;
	private String courseTeacher;
	private String courseGrade;
	
	public GivenGrade() {}
	
	public GivenGrade(Integer number, String name, String teacher, String grade) {
		this.courseNumber = number;
		this.courseName = name;
		this.courseTeacher = teacher;
		this.courseGrade = grade;
	}
	
	public String getCourseSubject() {
		return courseSubject;
	}
	public void setCourseSubject(String courseSubject) {
		this.courseSubject = courseSubject;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}
	public String getCourseTeacher() {
		return courseTeacher;
	}
	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}
	public String getCourseGrade() {
		return courseGrade;
	}
	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}

}
