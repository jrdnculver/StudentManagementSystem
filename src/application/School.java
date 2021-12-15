package application;

public class School {
	private String schoolName;
	private Integer schoolSize;
	private String schoolLocation;
	private Integer schoolYear;
	private String schoolLevel;
	
	public School () {}
	
	public School (String schoolName, String schoolLocation, Integer schoolYear, String schoolLevel) {
		this.schoolName = schoolName;
		this.schoolLocation = schoolLocation;
		this.schoolYear = schoolYear;
		this.schoolLevel = schoolLevel;
	}
	
	public String getSchoolName() {
		return schoolName;
	}
	
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public int getSchoolSize() {
		return schoolSize;
	}
	
	public void setSchoolSize(int schoolSize) {
		this.schoolSize = schoolSize;
	}
	
	public String getSchoolLocation() {
		return schoolLocation;
	}
	
	public void setSchoolLocation(String schoolLocation) {
		this.schoolLocation = schoolLocation;
	}
	
	public int getSchoolYear() {
		return schoolYear;
	}
	
	public void setSchoolYear(int schoolYear) {
		this.schoolYear = schoolYear;
	}
	
	public String getSchoolLevel() {
		return schoolLevel;
	}
	
	public void setSchoolLevel(String schoolLevel) {
		this.schoolLevel = schoolLevel;
	}
}
