package ucsb.XSBtoWFG;

public class NotCorrespondingObjectException extends Exception {

	public NotCorrespondingObjectException() { super(); }
	
	  public NotCorrespondingObjectException(String message) 
	  	{ super(message); }
	  
	  public NotCorrespondingObjectException(String message, Throwable cause) 
	  	{ super(message, cause); }
	  
	  public NotCorrespondingObjectException(Throwable cause)
	  	{ super(cause); }
}
