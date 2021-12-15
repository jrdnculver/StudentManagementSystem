package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Sequel_Courses extends Sequel{
	public Connection connectToDatabase() {
		 try {
	         Class.forName("org.sqlite.JDBC");
	         Connection data = DriverManager.getConnection("jdbc:sqlite:schoolManagementSystem.db");
	         return data;
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	         return null;
	      }
	}
	
	@Override
	public void createTable(Connection data, String tableName) {
		String sql = String.format("CREATE TABLE IF NOT EXISTS %s (courseNumber integer NOT NULL, courseName text NOT NULL,"
				+ "courseCapacity integer NOT NULL, courseStartDate text NOT NULL, courseEndDate text NOT NULL, courseTeacher text NOT NULL, courseDescription text NOT NULL,"
				+ "courseCredits integer NOT NULL, courseSubject text NOT NULL);", tableName);
		
		try (Statement sqlExecute = data.createStatement()) {
			
			sqlExecute.execute(sql);
			
      } catch (SQLException e) {
      	
          System.out.println(e.getMessage());
          
      }
	};
	
	@Override
	public void deleteTable(Connection data, String tableName) {
		String sql = String.format("DROP Table %s", tableName);
		
		try (Statement sqlExecute = data.createStatement()) {
			
			sqlExecute.execute(sql);
			
      } catch (SQLException e) {
      	
          System.out.println(e.getMessage());
          
      }
	};
	
	public void insertValue(Connection data, Courses course) {
		String sql = String.format("INSERT into Course (courseNumber,courseName,courseCapacity,courseStartDate,courseEndDate,courseTeacher,courseDescription,courseCredits,"
				+ "courseSubject) Values (%d,'%s',%d,'%s','%s','%s','%s','%d','%s')",
				course.getCourseNumber(), course.getCourseName(), course.getCourseCapacity(), course.getCourseStartDate(), course.getCourseEndDate(), course.getCourseTeacher(),
				course.getCourseDescription(),course.getCourseCredits(), course.getCourseSubject());
		
		try (Statement sqlExecute = data.createStatement()) {
			
			sqlExecute.execute(sql);
			
      } catch (SQLException e) {
      	
          System.out.println(e.getMessage());
          
      }
		
//		String sql = String.format("INSERT into Admin (UserName,Password) Values (?,?)");
//		
//		try (PreparedStatement inserting = data.prepareStatement(sql)) {
//			inserting.setString(1,admin.getUserName());
//			inserting.setString(2, admin.getPassword());
//			inserting.executeUpdate(sql);
//      } catch (SQLException e) {
//          System.out.println(e.getMessage());
//      }
	};
	
	@SuppressWarnings("rawtypes")
	@Override
	public ArrayList readValue(Connection data, String tableName) {
		ArrayList<Courses> courses = new ArrayList<Courses>();
      String sql = "SELECT courseNumber,courseName,courseCapacity,courseStartDate,courseEndDate,courseTeacher,courseDescription,courseCredits,courseSubject FROM Course;";

		try (PreparedStatement pstmt  = data.prepareStatement(sql)){
		  
		  //
		  ResultSet rs  = pstmt.executeQuery();
		  
		  // loop through the result set
		  while (rs.next()) {
			  Courses course = new Courses();
			  course.setCourseNumber(rs.getInt("courseNumber"));;
			  course.setCourseName(rs.getString("courseName"));
			  course.setCourseCapacity(rs.getInt("courseCapacity"));
			  course.setCourseStartDate(rs.getString("courseStartDate"));
			  course.setCourseEndDate(rs.getString("courseEndDate"));
			  course.setCourseTeacher(rs.getString("courseTeacher"));
			  course.setCourseDescription(rs.getString("courseDescription"));
			  course.setCourseCredits(rs.getInt("courseCredits"));
			  course.setCourseSubject(rs.getString("courseSubject"));
			  
			  courses.add(course); 
		  }
		  return courses;
		  
		} catch (SQLException e) {
		  System.out.println(e.getMessage());
		  return null;
		}
		}
}
