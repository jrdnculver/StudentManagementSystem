package application;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller_classSignUp {
	@FXML
	private ComboBox<String> classSubject;
	@FXML
	private ComboBox<String> className;
	@FXML
	private ComboBox<Integer> classNumber;
	@FXML
	private ComboBox<String> classTeacher;
	@FXML
	private Label displayStatus;
	
	private ArrayList<Courses> CourseInformation;
	
	private Student studentLogin;
	
	private Parent root;
	
	@FXML
	public void returnHome() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("studentAccount.fxml"));
			root = loader.load();
			
			Controller_StudentAccount studentAcct = loader.getController();
			
			studentAcct.returnLogin(studentLogin);
			Stage window = (Stage)classSubject.getScene().getWindow();
			
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void handleSubjectSelection() {
			ArrayList<String> courseName = new ArrayList<String>();
			for (Courses cou : CourseInformation) {
				if (classSubject.getValue().equals(cou.getCourseSubject())) {
					courseName.add(cou.getCourseName());
				}
				else {
					continue;
				}
			}
			
			ObservableList<String> nameList = FXCollections.observableArrayList(courseName);
			className.setItems(nameList);
		
	}
	
	
	@FXML
	public void handleNameSelection() {
		
			ArrayList<Integer> courseNumber = new ArrayList<Integer>();
			for (Courses cou : CourseInformation) {
				if (className.getValue().equals(cou.getCourseName())) {
					courseNumber.add(cou.getCourseNumber());
				}
				else {
					continue;
				}
			}
			
			ObservableList<Integer> numberList = FXCollections.observableArrayList(courseNumber);
			classNumber.setItems(numberList);
	}
	
	@FXML
	public void handleNumberSelection() {
			ArrayList<String> courseTeacher = new ArrayList<String>();
			for (Courses cou : CourseInformation) {
				if (classNumber.getValue().equals(cou.getCourseNumber())) {
					String[] teach = cou.getCourseTeacher().split(" ");
					ArrayList<String> finalNames = new ArrayList<String>();
					int num = teach.length;
					
					for (int i = 0; i < num - 1; i++) {
						String value = teach[i];
						finalNames.add(value);
					}
					String finalName = String.join(" ", finalNames);
					System.out.println(finalName);
					courseTeacher.add(finalName);
				}
				else {
					continue;
				}
			}
			
			ObservableList<String> teacherList = FXCollections.observableArrayList(courseTeacher);
			classTeacher.setItems(teacherList);
	}
	
	@FXML
	public void addClassSelection() {
		GivenGrade classInsert = new GivenGrade();
		Sequel_Classes dataClass = new Sequel_Classes();
		Connection data = dataClass.connectToDatabase();
		dataClass.createTable(data, studentLogin.getNumber());
		
		System.out.println(classTeacher.getValue());
		
		try {
			classInsert.setCourseSubject(classSubject.getValue());
			classInsert.setCourseName(className.getValue());
			classInsert.setCourseNumber(classNumber.getValue());
			classInsert.setCourseTeacher(classTeacher.getValue());
			classInsert.setCourseGrade("");
			dataClass.insertValue(data, classInsert, studentLogin.getNumber());
			
			displayStatus.setText("Class Added Successfully");
		}
		catch(Exception e){
			displayStatus.setText("Something went wrong");
		}
	}
	
	
	
	public void returnLogin(Student student) {
		studentLogin = student;
		
		Sequel_Courses dataCourse = new Sequel_Courses();
		Connection data = dataCourse.connectToDatabase();
		@SuppressWarnings("unchecked")
		ArrayList<Courses> courseInfo = dataCourse.readValue(data, "Course");
		CourseInformation = courseInfo;
		
		ArrayList<String> Subjects = new ArrayList<String>();
		for (Courses cou : CourseInformation) {
			Subjects.add(cou.getCourseSubject());
		}
		
		ObservableList<String> subjectList = FXCollections.observableArrayList(Subjects);
		classSubject.setItems(subjectList);
		
	}

}
