package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Sequel_Schools extends Sequel {
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
		String sql = String.format("CREATE TABLE IF NOT EXISTS %s (schoolName text NOT NULL, schoolLocation text NOT NULL,"
				+ "schoolYear integer NOT NULL, schoolLevel integer NOT NULL);", tableName);
		
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
	
	public void insertValue(Connection data, School school) {
		String sql = String.format("INSERT into School (schoolName,schoolLocation,schoolYear,schoolLevel) Values ('%s','%s',%d,'%s')",
				school.getSchoolName(), school.getSchoolLocation(), school.getSchoolYear(), school.getSchoolLevel());
		
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
//       } catch (SQLException e) {
//           System.out.println(e.getMessage());
//       }
	};
	
	@SuppressWarnings("rawtypes")
	@Override
	public ArrayList readValue(Connection data, String tableName) {
		ArrayList<School> schools = new ArrayList<School>();
       String sql = "SELECT schoolName,schoolSize,schoolLocation,schoolYear,schoolLevel FROM School;";

		try (PreparedStatement pstmt  = data.prepareStatement(sql)){
		  
		  //
		  ResultSet rs  = pstmt.executeQuery();
		  
		  // loop through the result set
		  while (rs.next()) {
			  School school = new School();
			  school.setSchoolName(rs.getString("schoolName"));
			  school.setSchoolLocation(rs.getString("schoolLocation"));
			  school.setSchoolYear(rs.getInt("schoolyear"));
			  school.setSchoolLevel(rs.getString("schoolLevel"));
		  }
		  return schools;
		  
		} catch (SQLException e) {
		  System.out.println(e.getMessage());
		  return null;
		}
		}

}
