package application;

public class Person {
	protected String firstName;
	protected String lastName;
	protected String address;
	protected Boolean isTeacher;
	protected Boolean isStudent;
	protected Boolean isAdmin;
	protected String userName;
	protected String password;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Boolean getIsTeacher() {
		return isTeacher;
	}
	
	public void setIsTeacher(Boolean isTeacher) {
		this.isTeacher = isTeacher;
	}
	
	public Boolean getIsStudent() {
		return isStudent;
	}
	
	public void setIsStudent(Boolean isStudent) {
		this.isStudent = isStudent;
	}
	
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getBit(Boolean bool) {
		if (bool) {
			return 1;
		}
		return 0;
	}
	
	public Boolean decipherBit(Integer inte) {
		if (inte.equals(1)) {
			return true;
		}
		return false;
	}
	
}
