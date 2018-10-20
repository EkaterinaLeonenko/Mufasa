import static org.junit.Assert.*;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.Before;


public class Mufasa {
// Mock Mufasa scenarios
	private PersonData pd;
	private BankAccountData bad;
	private String user;
	private String cvc;
	private ExtBank bank;
	
	@Before
	public void setup() {
		pd = new PersonData();
		pd.setUserName("Jonn123");
		bad = new BankAccountData();
		bad.setUserName("Jonn123");
		user = bad.getUserName();
		cvc  = "123";
		// Note: we have separate tests for PersonData and BankAccountData,
		//       so we test their functionality from there.
		//       Here we just set user name as it is a link between objects - as it is enough for a mock, and cvc
		//       Sure, for test with a real system, we need all information populated in objects 
		
		//Mock create
		bank = EasyMock.createMock(ExtBank.class);
		//Mock set expectations
		EasyMock.expect(bank.checkCVC(user, "123")).andReturn(true);
		EasyMock.expect(bank.checkCVC(user, "345")).andReturn(false);
		EasyMock.expect(bank.doTransaction(user, "123")).andReturn(true);
		EasyMock.expect(bank.doTransaction(user, "345")).andReturn(false);
		EasyMock.expect(bank.getRefund(user, "123")).andReturn(true);
		EasyMock.expect(bank.getRefund(user, "345")).andReturn(false);
		//Mock ready
		EasyMock.replay(bank); //activating the expected behaviour
	}
		
	//verifying external dependencies
	@Test 
	// Check positive scenario
	public void externalCommunicationsOK() {
		// Imitating the expected communications
		assertTrue(bank.checkCVC(user, cvc)); 
		assertTrue(bank.doTransaction(user, cvc)); 
		assertTrue(bank.getRefund(user, cvc)); 
	}

	@Test 
	// Check wrong cvc
	public void externalWrongCVC() {
		// Imitating the expected communications
		cvc = "345";
		assertFalse(bank.checkCVC(user, cvc)); 
		// No need to further tests 
	}
	
	@Test 
	// Check wrong transaction
	public void externalWrongTransaction() {
		// Imitating the expected communications
		cvc = "123"; // good one
		assertTrue(bank.checkCVC(user, cvc)); 
		cvc = "345"; // bad one, this makes unsuccessful transaction
		assertFalse(bank.doTransaction(user, cvc)); 
		// No need to test refund 
	}
	
	@Test 
	// Check wrong refund
	public void externalWrongRefund() {
		// Imitating the expected communications
		cvc = "123"; // good one
		assertTrue(bank.checkCVC(user, cvc)); 
		assertTrue(bank.doTransaction(user, cvc)); 
		cvc = "345"; // bad one, this makes unsuccessful refund
		assertFalse(bank.getRefund(user, cvc)); 
	}

}
