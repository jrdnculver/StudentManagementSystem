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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller_creatingSchool implements Initializable {
	@FXML
	private TextField schoolNameTxt;
	@FXML
	private TextField schoolLocationTxt;
	@FXML
	private ComboBox<Integer> schoolYearCmb;
	@FXML
	private ComboBox<String> schoolLevelCmb;
	@FXML
	private Label displayStatusLbl;
	
	private Sequel_Schools dataSchool = new Sequel_Schools();
	
	private ObservableList<Integer> observeYear = FXCollections.observableArrayList(
			2020,2021,2022,2023
			);
	private ObservableList<String> observeLevel = FXCollections.observableArrayList(
			"Pre-KinderGarten", "KinderGarten", "Elementary School", "Middle School", "Jr. High School", "High School", "College", "University");
	
	@FXML
	public void createSchool() {
		try {
			School school = new School();
			String name = schoolNameTxt.getText();
			String location = schoolLocationTxt.getText();
			Integer year = schoolYearCmb.getValue();
			String level = schoolLevelCmb.getValue();
			
			school.setSchoolName(name);
			school.setSchoolLocation(location);
			school.setSchoolYear(year);
			school.setSchoolLevel(level);
			
			Connection data = dataSchool.connectToDatabase();
			dataSchool.insertValue(data, school);
			displayStatusLbl.setText("School Created Successfully");
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
			Stage window = (Stage)schoolNameTxt.getScene().getWindow();
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			schoolYearCmb.setItems(observeYear);
			schoolLevelCmb.setItems(observeLevel);
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
