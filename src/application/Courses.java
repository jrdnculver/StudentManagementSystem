package application;

public class Courses {
	private Integer courseNumber;
	private String courseName;
	private int courseCapacity;
	private String courseStartDate;
	private String courseEndDate;
	private String courseTeacher;
	private String courseDescription;
	private int courseCredits;
	private String courseSubject;
	
	public Courses() {}
	
	public Courses(Integer courseNumber, String courseName, int courseCapacity, String courseStartDate, String courseEndDate, String courseTeacher, String courseDescription,
			int courseCredits, String courseSubject) {
		this.courseNumber = courseNumber;
		this.courseName = courseName;
		this.courseCapacity = courseCapacity;
		this.courseStartDate = courseStartDate;
		this.courseEndDate = courseEndDate;
		this.courseTeacher = courseTeacher;
		this.courseDescription = courseDescription;
		this.courseCredits = courseCredits;
		this.courseSubject = courseSubject;
	}

	public Integer getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(Integer courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseCapacity() {
		return courseCapacity;
	}

	public void setCourseCapacity(int courseCapacity) {
		this.courseCapacity = courseCapacity;
	}
	
	public String getCourseStartDate() {
		return courseStartDate;
	}

	public void setCourseStartDate(String courseStartDate) {
		this.courseStartDate = courseStartDate;
	}
	
	public String getCourseEndDate() {
		return courseEndDate;
	}

	public void setCourseEndDate(String courseEndDate) {
		this.courseEndDate = courseEndDate;
	}

	public String getCourseTeacher() {
		return courseTeacher;
	}

	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public int getCourseCredits() {
		return courseCredits;
	}

	public void setCourseCredits(int courseCredits) {
		this.courseCredits = courseCredits;
	}

	public String getCourseSubject() {
		return courseSubject;
	}

	public void setCourseSubject(String courseSubject) {
		this.courseSubject = courseSubject;
	}
	
	
}
