import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Person {
// Testing not everything, but it does most validations 
    private PersonData pd; // Define an object
	
	@Before
	public void init() {
		pd = new PersonData(); // and create it
	}
	
	
	// Set of test cases below	
	
	@Test
	// Testing First Name (No tests for Last Name)
	public void testValidFirstName() {
		assertTrue(pd.setFirstName("John"));
	}

	@Test
	public void testInvalidFirstName() {
		assertFalse(pd.setFirstName("John1"));
		assertFalse(pd.setFirstName("Joh n"));
		assertFalse(pd.setFirstName("Joh@n"));
	}

	@Test
	// Testing User Name 
	public void testValidUserName() {
		assertTrue(pd.setUserName("Abc_123"));
	}

	@Test
	public void testInvalidUserName() {
		assertFalse(pd.setUserName("Abc__123"));
		assertFalse(pd.setUserName("1234567890123456"));
		assertFalse(pd.setUserName("Abc_@123"));
	}


	@Test
	// Testing User Password 
	public void testValidUserPassword() {
		assertTrue(pd.setUserPassword("PaSsWoRd123","PaSsWoRd123"));
	}

	@Test
	public void testInvalidUserPassword() {
		assertFalse(pd.setUserPassword("PaSsWoRd123","Password123"));
		assertFalse(pd.setUserPassword("PaSsWoRd123","PaSsWoRd125"));
	}

	// No tests for Country
	
	@Test
	// Testing Birth Date
		public void testValidBirthDate() {
		assertTrue(pd.setBirthDate("30/03/1990"));
	}

	@Test
	public void testInvalidBirthDate() {
		assertFalse(pd.setBirthDate("30-03-1990"));
		assertFalse(pd.setBirthDate("30/03/2005"));
	}

	// No tests for Phone Number

	@Test
	// Testing email 
	public void testValidEmail() {
		assertTrue(pd.setEmailAddress("js@mail.com","js@mail.com"));
	}

	@Test
	public void testInvalidEmail() {
		assertFalse(pd.setEmailAddress("js@mail.com","jd@mail.com"));
	}


}
