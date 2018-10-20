// Interface to external bank
public interface ExtBank {
	
	public boolean checkCVC (String userName, String cvc);
	
	public boolean doTransaction (String userName, String cvc);

	public boolean getRefund (String userName, String cvc);

}
