package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SchoolTest {
	private School school = new School();
	
	// Will test values for School Class
	@Test
	void test() {
		school.setSchoolLevel("Kindergarten");
		Assertions.assertEquals("Kindergarten", school.getSchoolLevel());
	}
	
	@Test
	void testOne() {
		school.setSchoolLocation("Wabash");
		Assertions.assertEquals("Wabash", school.getSchoolLocation());
	}
	
	@Test
	void testTwo() {
		school.setSchoolName("Metro North");
		Assertions.assertEquals("Metro North", school.getSchoolName());
	}
	
	@Test
	void testThree() {
		school.setSchoolSize(456);
		Assertions.assertEquals(456, school.getSchoolSize());
	}
	
	@Test
	void testFour() {
		school.setSchoolYear(2021);
		Assertions.assertEquals(2021, school.getSchoolYear());
	}
}