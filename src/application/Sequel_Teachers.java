package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Sequel_Teachers extends Sequel {
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
		String sql = String.format("CREATE TABLE IF NOT EXISTS %s (firstName text NOT NULL, lastName text NOT NULL, address text NOT NULL,"
				+ "isAdmin bit NOT NULL, isTeacher bit NOT NULL, isStudent bit NOT NULL, userName text NOT NULL, password text NOT NULL, number text NOT NULL);", tableName);
		
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
	
	public void insertValue(Connection data, Teacher person) {
		String sql = String.format("INSERT into Teacher (firstName,lastName,address,isAdmin,isTeacher,isStudent,userName,password, number) Values ('%s','%s','%s',%d,%d,%d,'%s'"
				+ ",'%s','%s')", person.getFirstName(),person.getLastName(),person.getAddress(),person.getBit(person.getIsAdmin()),person.getBit(person.getIsTeacher()),person.getBit(person.getIsStudent()),person.getUserName(),person.getPassword(),person.getTeacherNumber());
		
		try (Statement sqlExecute = data.createStatement()) {
			
			sqlExecute.execute(sql);
			
      } catch (SQLException e) {
      	
          System.out.println(e.getMessage());
          
      }
		
	};
	
	@SuppressWarnings("rawtypes")
	@Override
	public ArrayList readValue(Connection data, String tableName) {
		ArrayList<Teacher> persons = new ArrayList<Teacher >();
      String sql = "SELECT firstName,lastName,address,isAdmin,isTeacher,isStudent,userName,password,number FROM Teacher";

		try (PreparedStatement pstmt  = data.prepareStatement(sql)){
		  
		  //
		  ResultSet rs  = pstmt.executeQuery();
		  
		  // loop through the result set
		  while (rs.next()) {
			  Teacher person = new Teacher();
			  person.setFirstName(rs.getString("firstName"));
			  person.setLastName(rs.getString("lastName"));
			  person.setAddress(rs.getString("address"));
			  person.setIsAdmin(person.decipherBit(rs.getInt("isAdmin")));
			  person.setIsTeacher(person.decipherBit(rs.getInt("isTeacher")));
			  person.setIsStudent(person.decipherBit(rs.getInt("isStudent")));
			  person.setUserName(rs.getString("userName"));
			  person.setPassword(rs.getString("password"));
			  person.settingTeacherNumber(rs.getString("number"));
			  persons.add(person);
		      
		  }
		  return persons;
		  
		} catch (SQLException e) {
		  System.out.println(e.getMessage());
		  return null;
		}
	}

}
