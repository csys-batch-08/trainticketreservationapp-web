package in.berbin.exception;

public class SignUpException extends Exception {
	public String getEmailRegisterMessage() {
		return "Already SignedUp please Login";
	}
	

	public String getPhoneRegisterMessage() {
		return "Already SignedUp please Login";
	}
}
