package ucsb.BPMNtoXSB.exception;

public class TestGenerationException extends Exception 
{
	public TestGenerationException() { super(); }

	public TestGenerationException(String message) 
	{ super(message); }

	public TestGenerationException(String message, Throwable cause) 
	{ super(message, cause); }

	public TestGenerationException(Throwable cause)
	{ super(cause); }

}
