
public class BankAccountData {
// Account holder banking details
// More or less complete functionality
// Stub and Fake methods are appropriately commented in the code below	

	// User's attributes
	private String 		userName;        // Link from PersonData class
	private String 		userPassword;
	private String		streetAddress;
	private String		City;
	private String		PostalCode;
	private String		Country;
	private String		cardHolder;
	private String		cardType;
	private String		cardNumber;
	private String  	cardExpiry;		  // Need refactoring -> LocalDate type
	
	// Class for commonly used methods
	Tools t = new Tools();

	// Get/Set for attributes + Validation
	public String getUserName() {
		return(this.userName);
	}

	// No validations here - it comes from PersonData
	public boolean setUserName(String name) {
		this.userName=name;
		return(true);
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

	public String getStreetAddress() {
		return(this.streetAddress);
	}

	public boolean setStreetAddress(String sss) {
		// I would add , . and - as valid symbols - and have space added already, though it is not specified
		if(t.ValidateString("abcdefghijklmnopqrstuvwxyz 0123456789",sss, false)) {
			this.streetAddress=sss;
			return(true);
		}
		else
			return(false);
	}

	public String getCity() {
		return(this.City);
	}

	public boolean setCity(String sss) {
		// Space added as a valid symbol, though it is not specified. "Saint Petersburg" is a valid city name
		if(t.ValidateString("abcdefghijklmnopqrstuvwxyz ",sss, false)) {
			this.City=sss;
			return(true);
		}
		else
			return(false);
	}

	public String getPostalCode() {
		return(this.PostalCode);
	}

	public boolean setPostalCode(String sss) {
		if(!t.ValidateString("0123456789-",sss, true))
			return false;
		this.PostalCode=sss;
		return(true);
	}
	
	public String getCountry() {
		return(this.Country);
	}

	public boolean setCountry(String sss) {
		// Space added as a valid symbol, though it is not specified. "Kosta Rica" is a valid country name
		// This is Fake method - it does validation of input, but saves USA, if input ok
		if(t.ValidateString("abcdefghijklmnopqrstuvwxyz ",sss, false)) {
			this.Country="USA";
			return(true);
		}
		else
			return(false);
	}
	
	public String getCardHolder() {
		return(this.cardHolder);
	}

	public boolean setCardHolder(String sss) {
		// Validating alphabetical plus space
		if(t.ValidateString("abcdefghijklmnopqrstuvwxyz ",sss, false)) {
			this.cardHolder=sss;
			return(true);
		}
		else
			return(false);
	}
	
	public String getCardType() {
		return(this.cardType);
	}

	public boolean setCardType(String sss) {
		// This is Stub method - no validation, saves VISA
		this.cardType="VISA";
		return(true);
	}

	public String getCardNumber() {
		return(this.cardNumber);
	}

	public boolean setCardNumber(String sss) {
		// This is Fake method - only simplest validations (digits and length)
		if(t.ValidateString("0123456789",sss, false)  &&
		   (sss.length() == 16)) {
			this.cardNumber=sss;
			return(true);
		}
		else
			return(false);
	}

	public String getCardExpiry() {
		return(this.cardExpiry);
	}

	public boolean setCardExpiry(String sss) {
		// This is Stub method - no validation, saves 03/20, which is valid
		this.cardExpiry="03/20";
		return(true);
	}

}
