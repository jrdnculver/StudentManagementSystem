package application;

import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller_creatingCourses implements Initializable {
	
	@FXML
	public TextField courseNumberTxt;
	@FXML
	public TextField courseNameTxt;
	@FXML
	public TextField courseCapacityTxt;
	@FXML
	public ComboBox<Integer> courseStartDateMonthCmb;
	@FXML
	public ComboBox<Integer> courseStartDateDayCmb;
	@FXML
	public ComboBox<Integer> courseStartDateYearCmb;
	@FXML
	public ComboBox<Integer> courseEndDateMonthCmb;
	@FXML
	public ComboBox<Integer> courseEndDateDayCmb;
	@FXML
	public ComboBox<Integer> courseEndDateYearCmb;
	@FXML
	public ComboBox<String> courseTeacherCmb;
	@FXML
	public TextArea courseDescriptionTxt;
	@FXML
	public ComboBox<Integer> courseCreditsCmb;
	@FXML
	public ComboBox<String> courseSubjectCmb;
	@FXML
	public Label displayStatusLbl;
	
	private Sequel_Courses dataCourses = new Sequel_Courses();
	private Sequel_Teachers dataTeachers = new Sequel_Teachers();
	
	private ObservableList<Integer> numberMonths = FXCollections.observableArrayList(
			1,2,3,4,5,6,7,8,9,10,11,12
			);
	
	private ObservableList<Integer> numberDays = FXCollections.observableArrayList(
			1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31
			);
	
	private ObservableList<Integer> numberYears = FXCollections.observableArrayList(
			2020,2021,2022,2023
			);
	
	private ObservableList<Integer> creditValues = FXCollections.observableArrayList(
			1,2,3,4,5,6,7,8,9,10,11,12,13,14,15
			);
	
	private ObservableList<String> courseValues = FXCollections.observableArrayList("Math", "Sociology", "Philosophy", "Biology", "Anatomy", "Physiology", "Psychology",
			"Business", "Criminal Justice", "Chemistry", "Physics", "Education", "Communication", "Writing", "Geography", "History", "Art", "French", "Spanish", "English");
	@FXML
	public void createCourse() {
		Courses course = new Courses();
		
		Integer number = Integer.valueOf(courseNumberTxt.getText());
		String name = courseNameTxt.getText();
		Integer capacity = Integer.valueOf(courseCapacityTxt.getText());
		Integer startMonth = Integer.valueOf(courseStartDateMonthCmb.getValue());
		Integer startDay = Integer.valueOf(courseStartDateDayCmb.getValue());
		Integer startYear = Integer.valueOf(courseStartDateYearCmb.getValue());
		String startDate = String.format("%d/%d/%d",startMonth,startDay,startYear);
		Integer endMonth = Integer.valueOf(courseEndDateMonthCmb.getValue());
		Integer endDay = Integer.valueOf(courseEndDateDayCmb.getValue());
		Integer endYear = Integer.valueOf(courseEndDateYearCmb.getValue());
		String endDate = String.format("%d/%d/%d",endMonth,endDay,endYear);
		String teacher = courseTeacherCmb.getValue();
		String description = courseDescriptionTxt.getText();
		Integer credits = courseCreditsCmb.getValue();
		String subject = courseSubjectCmb.getValue();
		
		try {
			course.setCourseNumber(number);
			course.setCourseName(name);
			course.setCourseCapacity(capacity);
			course.setCourseStartDate(startDate);
			course.setCourseEndDate(endDate);
			course.setCourseTeacher(teacher);
			course.setCourseDescription(description);
			course.setCourseCredits(credits);
			course.setCourseSubject(subject);
			
			Connection data = dataCourses.connectToDatabase();
			dataCourses.insertValue(data, course);
			displayStatusLbl.setText("Course Created Successfully");
		}
		catch(Exception e){
			displayStatusLbl.setText("Something went wrong");
		}
	}
	
	@FXML
	public void returnBack() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
			Stage window = (Stage)courseNumberTxt.getScene().getWindow();
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		courseCreditsCmb.setItems(creditValues);
		courseSubjectCmb.setItems(courseValues);
		courseStartDateMonthCmb.setItems(numberMonths);
		courseStartDateDayCmb.setItems(numberDays);
		courseStartDateYearCmb.setItems(numberYears);
		courseEndDateMonthCmb.setItems(numberMonths);
		courseEndDateDayCmb.setItems(numberDays);
		courseEndDateYearCmb.setItems(numberYears);
		
		Connection data = dataTeachers.connectToDatabase();
		@SuppressWarnings("unchecked")
		ArrayList<Teacher> teacherList = dataTeachers.readValue(data, "Teacher");
		ArrayList<String> teacherName = new ArrayList<String>();
		for (Teacher teach : teacherList) {
			String name = String.format("%s %s %s", teach.getFirstName(), teach.getLastName(), teach.getTeacherNumber());
			teacherName.add(name);
			System.out.println(teach.firstName);
		}
		ObservableList<String> teacherNames = FXCollections.observableArrayList(teacherName);
		courseTeacherCmb.setItems(teacherNames);
		
	}
	
}
