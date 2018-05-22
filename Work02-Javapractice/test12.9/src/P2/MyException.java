package P2;

public class MyException {
	String message;							
	public MyException(String ErrorMessagr) {		
		message = ErrorMessagr;
	}
	public String getMessage(){					
		return message;
	}
}
