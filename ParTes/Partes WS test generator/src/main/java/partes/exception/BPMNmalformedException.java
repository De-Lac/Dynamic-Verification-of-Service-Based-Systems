package partes.exception;

public class BPMNmalformedException extends Exception {

	public BPMNmalformedException() { super(); }
	
	  public BPMNmalformedException(String message) 
	  	{ super(message); }
	  
	  public BPMNmalformedException(String message, Throwable cause) 
	  	{ super(message, cause); }
	  
	  public BPMNmalformedException(Throwable cause)
	  	{ super(cause); }
}
