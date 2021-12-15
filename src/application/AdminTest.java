package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AdminTest {
	private Admin admin = new Admin();
	
	// Will test values for Admin Class
	@Test
	void test() {
		admin.setNumber(1);
		Assertions.assertEquals(1, admin.getNumber());
	}
	
	@Test
	void testOne() {
		admin.setUserName("culverj");
		Assertions.assertEquals("culverj", admin.getUserName());
	}
	
	@Test
	void testTwo() {
		admin.setPassword("password");
		Assertions.assertEquals("password", admin.getPassword());
	}
	
	@Test
	void testThree() {
		admin.setCheckPassword("password");
		Assertions.assertEquals("password", admin.getCheckPassword());
	}

}
