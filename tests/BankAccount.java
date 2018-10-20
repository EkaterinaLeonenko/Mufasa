import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankAccount {
// Testing some validations in the class	

	private BankAccountData bad; // Define an object
	
	@Before
	public void init() {
		bad = new BankAccountData(); // and create it
	}
	
	
	// Set of test cases below	
	@Test
	// Testing User Password 
	public void testValidUserPassword() {
		assertTrue(bad.setUserPassword("PaSsWoRd123","PaSsWoRd123"));
	}

	@Test
	public void testInvalidUserPassword() {
		assertFalse(bad.setUserPassword("PaSsWoRd123","Password123"));
		assertFalse(bad.setUserPassword("PaSsWoRd123","PaSsWoRd125"));
	}

	@Test
	// Testing Street Address
	public void testValidStreetAddress() {
		assertTrue(bad.setStreetAddress("2301 Woodward street Apartment F24"));
	}

	@Test
	// Note: the address is pretty valid as it is real address - not quite correct specifications
	public void testInvalidStreetAddress() {
		assertFalse(bad.setStreetAddress("2301 Woodward street Apartment F-24"));
	}
	
	@Test
	// Testing Cardholder Name 
	public void testValidCardHolder() {
		assertTrue(bad.setCardHolder("John Smith"));
	}

	@Test
	public void testInvalidCardHolder() {
		assertFalse(bad.setCardHolder("John Sm1th"));
	}
	
	@Test
	// Testing Card Number
	public void testValidCardNumber() {
		assertTrue(bad.setCardNumber("1234567890123456"));
	}

	@Test
	public void testInvalidCardNumber() {
		assertFalse(bad.setCardNumber("12345678901234567"));
		assertFalse(bad.setCardNumber("123456789012345"));
		assertFalse(bad.setCardNumber("123456789A123456"));
	}


}
