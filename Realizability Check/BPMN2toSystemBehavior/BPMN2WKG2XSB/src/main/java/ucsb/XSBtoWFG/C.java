package ucsb.XSBtoWFG;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.bpmn2.ChoreographyTask;
import org.eclipse.bpmn2.FlowNode;
import org.eclipse.bpmn2.Gateway;
import org.eclipse.bpmn2.impl.ChoreographyImpl;

import ucsb.systembehavior.PeerSituation;
import ucsb.systembehavior.Send;
import ucsb.systembehavior.SystemBehavior;
import ucsb.systembehavior.Transition;
import unicam.workflowgraph.MessageExchange;
import unicam.workflowgraph.WfgNode;
import unicam.workflowgraph.WorkFlowGraph;
import unicam.workflowgraph.WorkflowgraphFactory;

public class C 
{
	private SystemBehavior systemBehavior;
	private WorkFlowGraph wfg;
	private ChoreographyImpl bpmn2;	
	private String newSystem;
	
	public C (SystemBehavior systemBehavior, WorkFlowGraph wfg, ChoreographyImpl bpmn2, String newSystem)
	{
	 this.systemBehavior=systemBehavior;  
	 this.wfg=wfg;
	 this.bpmn2=bpmn2;
	 this.newSystem=newSystem.trim();
	}
	
	
	public void main (String[] args)
	{
	 SystemBehavior systemBehavior = null;
	 WorkFlowGraph wfg = null;
	 ChoreographyImpl bpmn2 = null;	
	 String newSystem="";
	 C instance = new C(systemBehavior, wfg, bpmn2, newSystem);
	 try 
	 	{instance.run();} 
	 catch (FileNotFoundException e) 
	 	{ e.printStackTrace(); }
	}
	
	
	
//	public void readFile(String systemPath) throws FileNotFoundException
//	{
//		Scanner scan = new Scanner(new FileReader(systemPath));
//		while(scan.hasNext())
//		 {
//			String transition = scan.next().trim();
//		 }
//		scan.close();
//	}
	
	
	
	 /**
	  * new system should contains just added transitions and removed transitions;
	  * not all the transitions of the system
	  * Now I am supposing they are just ADD.
	  * TODO divide added and removed and handle them in the right way
	  * */
	public void run () throws FileNotFoundException
	{
		
		String[] transitions = newSystem.split(").");
		
		for (String transition : transitions)
		 {
			handleNewTransition(transition);
		 }
	}

	
	
	/**
	 * I should handle a transition according to it it's added or removed.
	 * now I am supposing they are all 'add'.
	 * TODO handle the remove transitions
	 * */
   private void handleNewTransition (String transition)
   {   
		 String fromSysState;
		 String sysMessage;
		 String toSysState;
	   //                  gtrans  (  s11 ,  ('A','B',msg1  ),  s5    ).
	    String pattern = "(gtrans\\()(.*)(,\\(.*,.*,)(.*)(\\),)(.*)(\\).)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(transition);
		if (m.find( )) 
		{ // it's a gtrans transition, I should replicate it in the others models
		 fromSysState = m.group(2); // s11
		 sysMessage = m.group(4);   // msg1
		 toSysState = m.group(6);   // s5
		 
		 
		 
		 // create the new WFT MessageExchange
		 WfgNode fromWfgNode = null;
		 WfgNode toWfgNode = null;
		 MessageExchange newWfgCt = WorkflowgraphFactory.eINSTANCE.createMessageExchange();
		 newWfgCt.setName("new MessageExchange");
		 newWfgCt.setPredecessor(fromWfgNode);
		 fromWfgNode.add_set_successor(newWfgCt);
		 newWfgCt.setRequest(sysMessage);
		 // TODO retrieve sender and receiver from gtrans. I have to change the pattern
		 newWfgCt.setSender(arg0);
		 newWfgCt.setReceiver(arg0);		 
		 
		 // find where insert the new MessageExchange in the WFG

		 
		 // find the corresponding WFG fromNode
		 try {  fromWfgNode = findRightPlaceInWFG(fromSysState);}
		 // TODO if it's empty, it's a new CT added by the repair
		 // I should fill it with the new messages
		 catch (NotCorrespondingObjectException e) 
		   { 
			 // at this point, a WFG node (even if empty) should be existing
			 System.err.println("at this point, a WFG node (even if empty) should be existing \n"+e.getMessage());
			 e.printStackTrace();
			 System.exit(1);
		   }
		 
		 // find the corresponding WFG toNode, if present		 
		 try {  toWfgNode = findRightPlaceInWFG(toSysState); } 
		 catch (NotCorrespondingObjectException e) 
		   {
			// if it's not present, I should create it!
			// I will fill it later, when it compares a sender in a gtrans
			 MessageExchange newWfgCt = WorkflowgraphFactory.eINSTANCE.createMessageExchange();
			 newWfgCt.setName(toSysState);
			 newWfgCt.setPredecessor(fromWfgNode);
			 fromWfgNode.add_set_successor(newWfgCt);
		   }
		}
   }
   
   
   /**
    * 
    * from the string "gtrans(fromSysState ,('sender', 'receiver', sysMessage), toSysState )"
    * I retrieve the corresponding point in the WorkFlowGraph
    * <br><br>
    * <i>[note] Probably 'message' and 'toState' are not needed as input. Now I am using them
    * just to make some (maybe useless) control.</i>
 * @throws NotCorrespondingObjectException 
    * 
    * */
   private WfgNode findRightPlaceInWFG(String fromSysState) throws NotCorrespondingObjectException
   {
		 for (PeerSituation sysState : systemBehavior.getStates())
		 	{
			 if (sysState.getId().equals(fromSysState))
			 	{
				 if (sysState.getGatewayRef() != null)
				 	{ // I AM A GATEWAY
					 unicam.workflowgraph.Gateway wfgGateway = sysState.getGatewayRef();
					 if (wfgGateway == null)
					 	{throw new NotCorrespondingObjectException(sysState.getName()+" has not a corresponding object in the WFG");}
					 return wfgGateway;
				 	}
				 else if (sysState.getOutcoming().size() == 1)
				 	{// I AM A PARTICULAR CT
					 Transition trans = sysState.getOutcoming().get(0);
					 if  (trans instanceof Send)
					   {
						 MessageExchange wfgChorTask = ((Send)trans).getMessageExchangeRef();
						 if (wfgChorTask == null)
						 	{throw new NotCorrespondingObjectException(((Send)trans).getName()+" has not a corresponding object in the WFG");}
						 return wfgChorTask;						 
					   }
					 else
					   {
						 System.err.println("[findRightPlace] "+trans+" is not a Send. There is something wrong");
						 System.exit(1);
					   }
					 
				 	}
				 else
				    {// I MUST FIND THE RELATIVE POSITION IN THE CHOREOGRAPHY..
					 try{throw new Exception("not yet implemented");}catch(Exception ex){ex.printStackTrace();}
					 System.exit(1);
				    }
			 	}
		 	}
		 return null;

          		 
		}
	   
}
	
	










