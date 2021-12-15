package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonTest {
	private Person person = new Person();

	// Will test values for Person Class
	@Test
	void test() {
		person.setAddress("435 W Chester St Central IN 46992");
		Assertions.assertEquals("435 W Chester St Central IN 46992", person.getAddress());
	}
	
	@Test
	void testOne() {
		person.setFirstName("Jordan");
		Assertions.assertEquals("Jordan", person.getFirstName());
	}
	
	@Test
	void testTwo() {
		person.setIsAdmin(false);
		Assertions.assertEquals(false, person.getIsAdmin());
	}
	
	@Test
	void testThree() {
		person.setIsStudent(false);
		Assertions.assertEquals(false, person.getIsStudent());
	}
	
	@Test
	void testFour() {
		person.setIsTeacher(true);
		Assertions.assertEquals(true, person.getIsTeacher());
	}
	
	@Test
	void testFive() {
		person.setLastName("Culver");
		Assertions.assertEquals("Culver", person.getLastName());
	}
	
	@Test
	void testSix() {
		person.setPassword("password");
		Assertions.assertEquals("password", person.getPassword());
	}
	
	@Test
	void testSeven() {
		person.setUserName("culverj");
		Assertions.assertEquals("culverj", person.getUserName());
	}
}
