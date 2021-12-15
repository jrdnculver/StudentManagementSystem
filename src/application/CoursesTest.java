package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoursesTest {
	private Courses course = new Courses();
	
	// Will test values for Courses Class
	@Test
	void test() {
		course.setCourseCapacity(35);
		Assertions.assertEquals(35, course.getCourseCapacity());
	}
	
	@Test
	void testOne() {
		course.setCourseCredits(5);
		Assertions.assertEquals(5, course.getCourseCredits());
	}
	
	@Test
	void testTwo() {
		course.setCourseDescription("This is a class");
		Assertions.assertEquals("This is a class", course.getCourseDescription());
	}
	
	@Test
	void testThree() {
		course.setCourseEndDate("01/02/1987");
		Assertions.assertEquals("01/02/1987", course.getCourseEndDate());
	}
	
	@Test
	void testFour() {
		course.setCourseName("MathFun");
		Assertions.assertEquals("MathFun", course.getCourseName());
	}
	
	@Test
	void testFive() {
		course.setCourseNumber(1);
		Assertions.assertEquals(1, course.getCourseNumber());
	}
	
	@Test
	void testSix() {
		course.setCourseStartDate("08/31/1976");
		Assertions.assertEquals("08/31/1976", course.getCourseStartDate());
	}
	
	@Test
	void testSeven() {
		course.setCourseSubject("Math");
		Assertions.assertEquals("Math", course.getCourseSubject());
	}
	
	@Test
	void testEight() {
		course.setCourseTeacher("Jerrigan");
		Assertions.assertEquals("Jerrigan", course.getCourseTeacher());
	}
}
