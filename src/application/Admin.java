package application;

public class Admin {
	private Integer number;
	private String userName;
	private String password;
	private String checkPassword;
	
	public Admin() {};
	
	public Admin(Integer number, String userName, String password) {
		this.number = number;
		this.userName = userName;
		this.password = password;
	};
	
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
	
	public String getCheckPassword() {
		return checkPassword;
	}

	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}


	public Integer getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
