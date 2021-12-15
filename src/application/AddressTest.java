package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddressTest {
	private Address address = new Address();
// Will test values for Address Class
	@Test
	void test() {
		
		address.setRoad("300 Forever Rd");
		Assertions.assertEquals("300 Forever Rd", address.getRoad());
	}
	
	@Test
	void testTwo() {
		
		address.setCity("Giant City");
		Assertions.assertEquals("Giant City", address.getCity());
	}
	
	@Test
	void testThree() {
		
		address.setState("IN");
		Assertions.assertEquals("IN", address.getState());
	}
	
	@Test
	void testFour() {
		
		address.setZip(46879);
		Assertions.assertEquals(46879, address.getZip());
	}

}
