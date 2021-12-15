package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GivenGradeTest {
	private GivenGrade givenGrade = new GivenGrade();

	// Will test values for GivenGrade Class
	@Test
	void test() {
		givenGrade.setCourseGrade("A");
		Assertions.assertEquals("A", givenGrade.getCourseGrade());
	}
	
	@Test
	void testOne() {
		givenGrade.setCourseSubject("Physics");
		Assertions.assertEquals("Physics", givenGrade.getCourseSubject());
	}
	
	@Test
	void testTwo() {
		givenGrade.setCourseName("Intro to Physics");
		Assertions.assertEquals("Intro to Physics", givenGrade.getCourseName());
	}
	
	@Test
	void testThree() {
		givenGrade.setCourseNumber(123);
		Assertions.assertEquals(123, givenGrade.getCourseNumber());
	}
	
	@Test
	void testFour() {
		givenGrade.setCourseTeacher("Jackson");
		Assertions.assertEquals("Jackson", givenGrade.getCourseTeacher());
	}

}
