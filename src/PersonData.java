import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class PersonData {
// Basic Data Collection for a user
// More or less complete functionality
// Stub and Fake methods are appropriately commented in the code below		
	
	// User's attributes
	private String 		firstName;
	private String 		lastName;
	private String 		userName;
	private String 		userPassword;
	private String		Country;
	private LocalDate	birthDate;      // Using new API
	private String 		phoneNumber;
	private String 		emailAddress;

	// Class for commonly used methods
	Tools t = new Tools();
	
	// Get/Set for attributes + Validation
	public String getFirstName() {
		return(this.firstName);
	}

	public boolean setFirstName(String name) {
		if(t.ValidateString("abcdefghijklmnopqrstuvwxyz",name, false)) {
			this.firstName=name;
			return(true);
		}
		else
			return(false);
	}
	
	public String getLastName() {
		return(this.lastName);
	}

	public boolean setLastName(String name) {
		if(t.ValidateString("abcdefghijklmnopqrstuvwxyz",name, false)) {
			this.lastName=name;
			return(true);
		}
		else
			return(false);
	}

	public String getUserName() {
		return(this.userName);
	}

	public boolean setUserName(String name) {
		if(t.ValidateString("abcdefghijklmnopqrstuvwxyz_0123456789",name, false)  &&
		   (name.length() >0 && name.length() <= 15)                              &&
		   t.OccuredOnce ("_",name)) {
			this.userName=name;
			return(true);
		}
		else
			return(false);
	}

	public String getUserPassword() {
		return(this.userPassword);
	}

	public boolean setUserPassword(String pass1, String pass2) {
		if(t.ValidateString("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789",pass1, true)  &&
		   (pass1.length() >8)                                                                             &&
		   (pass1 == pass2)) {
			this.userPassword=pass1;
			return(true);
		}
		else
			return(false);
	}
	
	public String getCountry() {
		return(this.Country);
	}

	// No validation here - it should be done by UI (you can't select invalid country from the list!)
	public boolean setCountry(String name) {
		this.Country=name;
		return(true);
	}
	
	public LocalDate getBirthDate() {
		return(this.birthDate);
	}

	public boolean setBirthDate(String sss) {
		if(!t.ValidateString("0123456789/",sss, true))
				return false;
		LocalDate today = LocalDate.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ddd = LocalDate.parse(sss, dateFormat);
	    if (Period.between(ddd, today).getYears() < 18)
	    	return false;
		this.birthDate=ddd;
		return(true);
	}
	
	public String getPhoneNumber() {
		return(this.phoneNumber);
	}

	public boolean setPhoneNumber(String sss) {
	// This is Fake method - does very simple validation	
		if(!t.ValidateString("0123456789",sss, true))
			return false;
		this.phoneNumber=sss;
		return(true);
	}

	public String getEmailAddress() {
		return(this.emailAddress);
	}

	public boolean setEmailAddress(String addr1, String addr2) {
	// This is Fake method - does very simple validation	
		if(addr1 == addr2) {
			this.emailAddress=addr1;
			return(true);
		}
		else
			return(false);
	}
	
}
 