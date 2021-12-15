package application;

public class Address {
	private String road;
	private String city;
	private String state;
	private int zip;
	
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	
	public String writeAddress() {
		return String.format("%s %s, %s %d", this.road,this.city, this.state, this.zip);
	}
}
