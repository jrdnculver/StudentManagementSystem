package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Sequel_Classes extends Sequel {
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
		String sql = String.format("CREATE TABLE IF NOT EXISTS %s (subject text NOT NULL, name text NOT NULL, number integer NOT NULL, teacher text NOT NULL, grade text);", tableName);
		
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
	
	public void insertValue(Connection data, GivenGrade givenGrade, String tableName) {
		String sql = String.format("INSERT into %s (subject,name,number,teacher,grade) Values ('%s','%s',%d,'%s','%s')",tableName, givenGrade.getCourseSubject(), givenGrade.getCourseName(),
				givenGrade.getCourseNumber(),givenGrade.getCourseTeacher(),givenGrade.getCourseGrade());
		
		try (Statement sqlExecute = data.createStatement()) {
			
			sqlExecute.execute(sql);
			
       } catch (SQLException e) {
       	
           System.out.println(e.getMessage());
           
       }
	};
	
	@SuppressWarnings("rawtypes")
	@Override
	public ArrayList readValue(Connection data, String tableName) {
		ArrayList<GivenGrade> givengrades = new ArrayList<GivenGrade>();
       String sql = String.format("SELECT name,number,teacher,grade FROM %;",tableName);

		try (PreparedStatement pstmt  = data.prepareStatement(sql)){
		  
		  //
		  ResultSet rs  = pstmt.executeQuery();
		  
		  // loop through the result set
		  while (rs.next()) {
			  GivenGrade givengrade = new GivenGrade();
			  //givengrade.setCourseSubject(rs.getString("subject"));
			  givengrade.setCourseName(rs.getString("name"));
			  givengrade.setCourseNumber(rs.getInt("number"));
			  givengrade.setCourseTeacher(rs.getString("teacher"));
			  givengrade.setCourseGrade(rs.getString("grade"));
		      
		  }
		  return givengrades;
		  
		} catch (SQLException e) {
		  System.out.println(e.getMessage());
		  return null;
		}
		}
}
