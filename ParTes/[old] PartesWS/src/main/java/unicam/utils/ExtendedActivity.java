package unicam.utils;


import java.util.HashMap;

import org.omg.spec.bpmn._20100524.model.TChoreographyTask;
import org.omg.spec.bpmn._20100524.model.TParticipant;
/**
 * extends  {@link org.jbpt.pm.Activity Activity}. It points to a 
 * {@link org.omg.spec.bpmn._20100524.model.TChoreographyTask ChoreographyTask}providing
 * also its sender and receiver.
 */
public class ExtendedActivity extends  org.jbpt.pm.Activity
{

	private TParticipant receiver;
	private TParticipant sender;
	private long branchNumber;
	private TChoreographyTask choreographyTask;
	private String method;
	private String methodClass;
	private HashMap<String, String> params;

	public ExtendedActivity(TChoreographyTask ct, TParticipant sender, TParticipant receiver) 
	{
	 if(ct!=null)this.setName(ct.getName()+"_"+ct.getId());
	 this.sender = sender;
	 this.receiver = receiver;
	 choreographyTask = ct;
	 params = new HashMap<String, String>();
	}
	
	public TParticipant getSender()
		{return sender;}
	
	public TParticipant getReceiver()
		{return receiver;}

	
	/** an id of the branch. it's used to know if two tasks are owned by the same branch */
	public void setBranchNumber(long branchNumber)
		{
		 this.branchNumber = branchNumber;
		}
	
	public long getBranchNumber() {
		return branchNumber;
	}
	
	public TChoreographyTask getChoreographyTask()
		{return choreographyTask;}

	
	
	/**
	 * returns the params needed by the method invoked by the choreography task
	 * (type, name)
	 * @return
	 */
	public HashMap<String, String> getParams() {
		return params;
	}
	
	
	
	/**
	 * adds a parameter to the method invoked in the choreography task, by the sender
	 * into the receiver
	 * @param type of the parameter
	 * @param name of the parameter
	 */
	public void addParams(String type, String name) {
		params.put(type, name);
	}

	/**
	 * returns the method invoked by the sender into the receiver of the message exchanged in the
	 * choreography task
	 * @return
	 */
	public String getMethod() {
		return method;
	}
	
	public void setMethod(String m) {
		method = m;
	}

	public String getMethodClass() {
		return methodClass;
	}
	
	public void setMethodClass(String mc) {
		methodClass = mc;
	}

	
	
	/**
     * get the message in the form:  methodToInvoke(type:name, type:name)
     * and fill method and params attributes
	 */
	public void fillMessage(String message) 
	{
	 message = message.trim();
	 String[] m = message.split("\\(");
	 setMethod(m[0]);
//	 m[1] = m[1].replace(")", "");
//	 String[] parameters = m[1].split(",");
//	 for(String p : parameters)
//	 	{
//		 try{addParams(p.split(":")[0],p.split(":")[1]);}
//		 catch(java.lang.ArrayIndexOutOfBoundsException ex){/*there are no params*/}
//	 	}	
	}
 

}
