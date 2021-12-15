package application;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller_creatingStudent implements Initializable {
	@FXML
	public TextField firstNameTxt;
	@FXML
	public TextField lastNameTxt;
	@FXML
	public TextField roadTxt;
	@FXML
	public TextField cityTxt;
	@FXML
	public ComboBox<String> stateCmb;
	@FXML
	public TextField zipTxt;
	@FXML
	public CheckBox isTeacherChk;
	@FXML
	public CheckBox isStudentChk;
	@FXML
	public CheckBox isAdminChk;
	@FXML
	public TextField userNameTxt;
	@FXML
	public TextField passwordTxt;
	@FXML
	public Label displayStatusLbl;
	
	private ObservableList<String> stateList = FXCollections.observableArrayList(
			"AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH",
			"NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY");
	
	private Sequel_Students dataStudent = new Sequel_Students();
	
	@FXML
	public void createStudent() {
		Student student = new Student();
		Address addre = new Address();
		
		String firstName = firstNameTxt.getText();
		String lastName = lastNameTxt.getText();
		addre.setRoad(roadTxt.getText());
		addre.setCity(cityTxt.getText());
		addre.setState(stateCmb.getValue());
		addre.setZip(Integer.valueOf(zipTxt.getText()));
		Boolean isAdmin = isAdminChk.isSelected();
		Boolean isTeacher = isTeacherChk.isSelected();
		Boolean isStudent = isStudentChk.isSelected();
		String username = userNameTxt.getText();
		String password = passwordTxt.getText();
		
		
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setAddress(addre.writeAddress());
		student.setIsAdmin(isAdmin);
		student.setIsTeacher(isTeacher);
		student.setIsStudent(isStudent);
		student.setUserName(username);
		student.setPassword(password);
		student.setNumber();
		
		try {
			Connection data = dataStudent.connectToDatabase();
			dataStudent.insertValue(data, student);
			displayStatusLbl.setText("Student Created Successfully");
			System.out.println("Success");
		}
		catch(Exception e){
			displayStatusLbl.setText("Something went wrong");
		}	
	}

	@FXML
	public void returnBack() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
			Stage window = (Stage)firstNameTxt.getScene().getWindow();
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		stateCmb.setItems(stateList);
		
	}
}
