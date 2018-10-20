
public class Tools {
//
	// Method to validate strings 
	public boolean ValidateString(String allowed, String to_check, boolean is_case_sensitive) {
		// Convert to lower case
		if (!is_case_sensitive)
			to_check = to_check.toLowerCase();
		for (int i = 0; i < to_check.length(); i++) {
			String one_char = to_check.substring(i,i+1);
			if(!allowed.contains(one_char)) {
				return false;
			}
		}
		return(true);	
	}

	public boolean OccuredOnce(String what, String to_check) {
		int count = to_check.length() - to_check.replace(what, "").length();
		if(count>1) 
			return false;	
		else
			return true;
	}
		
	

}
