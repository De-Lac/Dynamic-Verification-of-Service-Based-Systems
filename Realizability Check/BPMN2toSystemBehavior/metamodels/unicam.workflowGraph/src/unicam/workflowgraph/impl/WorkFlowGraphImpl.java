/**
 */
package unicam.workflowgraph.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import unicam.workflowgraph.Action;
import unicam.workflowgraph.Branch;
import unicam.workflowgraph.ExclusiveChoice;
import unicam.workflowgraph.Gateway;
import unicam.workflowgraph.MessageExchange;
import unicam.workflowgraph.ParallelExecution;
import unicam.workflowgraph.Participant;
import unicam.workflowgraph.WfgNode;
import unicam.workflowgraph.WorkFlowGraph;
import unicam.workflowgraph.WorkflowgraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Work Flow Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link unicam.workflowgraph.impl.WorkFlowGraphImpl#getGateways <em>Gateways</em>}</li>
 *   <li>{@link unicam.workflowgraph.impl.WorkFlowGraphImpl#getStartingNode <em>Starting Node</em>}</li>
 *   <li>{@link unicam.workflowgraph.impl.WorkFlowGraphImpl#getEndingNode <em>Ending Node</em>}</li>
 *   <li>{@link unicam.workflowgraph.impl.WorkFlowGraphImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link unicam.workflowgraph.impl.WorkFlowGraphImpl#getParticipants <em>Participants</em>}</li>
 *   <li>{@link unicam.workflowgraph.impl.WorkFlowGraphImpl#getInnerGateway <em>Inner Gateway</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkFlowGraphImpl extends MinimalEObjectImpl.Container implements WorkFlowGraph {
	/**
	 * The cached value of the '{@link #getGateways() <em>Gateways</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGateways()
	 * @generated
	 * @ordered
	 */
	protected EList<Gateway> gateways;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> actions;

	/**
	 * The cached value of the '{@link #getParticipants() <em>Participants</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipants()
	 * @generated
	 * @ordered
	 */
	protected EList<Participant> participants;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkFlowGraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowgraphPackage.Literals.WORK_FLOW_GRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Gateway> getGateways() {
		if (gateways == null) {
			gateways = new EObjectContainmentEList<Gateway>(Gateway.class, this, WorkflowgraphPackage.WORK_FLOW_GRAPH__GATEWAYS);
		}
		return gateways;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public WfgNode getStartingNode() 
	{

		for (Gateway g : getGateways())
		{
			if (g.isFork())
				{
				 if (g.getPredecessors().size()<1)
					{return g;}
				 else if (g.getPredecessors().size()==1 && 
						  g.getPredecessors().get(0)== g.getRefMerge()
						 )
				 		  {return g;}
					 
				}
		}
		for (Action a : getActions())
		{
		 if (a.getPredecessor()==null)
				{return a;}
		}
        return null;
	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public WfgNode basicGetStartingNode() {
		return getStartingNode();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public void setStartingNode(WfgNode newStartingNode) {}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public void unsetStartingNode() {}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public boolean isSetStartingNode() {
		if (getStartingNode()!=null)
				return true;
				else return false;
	}

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public WfgNode basicGetEndingNode() {
      return getEndingNode();
	}

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public void setEndingNode(WfgNode newEndingNode) {}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public void unsetEndingNode() {}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public boolean isSetEndingNode() {
		if (getEndingNode()!=null)
			{return true;}
		else return false;
	}

	

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public WfgNode getEndingNode() {

		for (Gateway g : getGateways())
		{
			if (g.isMerge())
				{ if (g.getSuccessors().size()<1)
					{return g;}
				  else if (g.getSuccessors().size()== 1 &&
						  g.getSuccessors().get(0) == g.getRefFork()
						  )
				  			{return g;}
				}
		}
		for (Action a : getActions())
		{
			if (a.getSuccessor()==null)
				{return a;}
		}

	
		return null;
	}




	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getActions() {
		if (actions == null) {
			actions = new EObjectContainmentEList<Action>(Action.class, this, WorkflowgraphPackage.WORK_FLOW_GRAPH__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Participant> getParticipants() {
		if (participants == null) {
			participants = new EObjectContainmentEList<Participant>(Participant.class, this, WorkflowgraphPackage.WORK_FLOW_GRAPH__PARTICIPANTS);
		}
		return participants;
	}

	

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Gateway getInnerGateway() 
	{
		  Gateway stg = null ;
		  // gateways filled. now i'm looking for the inner gateway to reduce
		  Iterator<Gateway> gatIterator = getGateways().iterator();
	      while (gatIterator.hasNext())
	      	{
	    	  Gateway  startGat = gatIterator.next();
	    	  while (startGat.isMerge() && gatIterator.hasNext())
	    	  	{startGat = gatIterator.next();} // start must be a fork
	    	  if (startGat.isMerge())
	    	  	{stg=null;break;}
	    	  boolean containsOtherGateways = false;
	    	  for( Branch branch : startGat.getBranches())
	    	  	{
	    		  for (WfgNode n : branch.getNodes())
	    		  	{
	    			  if (n instanceof Gateway)
	    			  	{ containsOtherGateways=true; break; }
	    		  	}
	    		  if (containsOtherGateways) {break;}
	    	  	}
	    	  if (!containsOtherGateways)
	    	  	{
	    		  stg = startGat;
	    		  break;
	    	  	}
	    	  
	      	}
	      return stg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public Gateway basicGetInnerGateway() {
		return getInnerGateway();
	}

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public void setInnerGateway(Gateway newInnerGateway) {}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public void unsetInnerGateway() {}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSetInnerGateway() 
	{
	 if (getInnerGateway() == null)
	 	{return false;}
	 else
	 	{return true;}
	}

	
	
	/**
	 *Assign to each DiergingGateway a value indicating its deep and distance from the start. 
     * An high value means deeper and righter. I need this value beacuse, when I need an inner gateway,
     * I should always start from the most right one. Otherwise I can have problem to connect inner with outer fragments
     * during future transformations.
     * distance is i++ at each gateway I cover with a BreadthFirst search
     * deep is i++ at each gateway I cover with a DeepFirst search, and i-- each ConvergingGateway
	 *<pre>
	 *                      ------
	 * /   \     /   \     |      |        /   \     /   \       /   \
	 *   A   -->   B   --> |  C   |    ->    A   -->   B   -->     D   
	 * \   /     \   /     |      |        \   /     \   /       \   / 
	 *                      ------
	 *  deep(A) = 0;   distance(A) = 0;
	 *  deep(B) = 1;   distance(B) = 1;
	 *  deep(D) = 0;   distance(D) = 2;
	 *</pre>
	 *
	 * @generated NOT
	 */
	public void assignDeepAndBreadthToGtws() 
	{ throw new UnsupportedOperationException();}
	
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * link starting gateways with ending gateways.  start should named as start_name1   and ending as end_name1.
	 * It fills also "branches" attribute of gateways
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void initialize() 
	{
		HashSet <String> gatewayNames = new HashSet <String>(); 
		// link starting and ending gateways
		System.out.println("i am initializating the gateways");
		for ( Gateway gat : getGateways() )
		{
			System.out.println("   "+gat.getName());
			if(gat.isFork())
			{
				if (gatewayNames.contains(gat.getName()))
					{ 
					String error="ERROR Divergin gateway"+gat.getName()+" already exist.\n";
					error += "It is not allowed have multiple diverging gateways with the same name";
					System.out.println(error);
					throw new UnsupportedOperationException(error);
					}
				System.out.print(gat.getName()+" --> ");
				gatewayNames.add(gat.getName());
				boolean closed = false;
				for ( Gateway gat2 : getGateways() )
				{
					if(gat2.getName().equals(gat.getName()) && gat2.isMerge() )
					{
						System.out.println(gat2.getName());
						gat.setRefMerge(gat2);
						closed = true;
						break;
					}
				}
				if (!closed)
				{
					String error="ERROR "+gat.getName()+" has not an ending gateway named "+gat.getName();
					System.out.println(error);
					throw new UnsupportedOperationException(error);
				}
			}
		}
	}

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean removeNode(WfgNode node) {
		EcoreUtil.delete(node);
		return true;
//		
//	    boolean result = false;
//		if (node instanceof Action && actions!=null)
//			{actions.remove((Action)node);
//			 result = true;
//			}
//	else if (node instanceof Gateway && gateways != null)
//			{gateways.remove((Gateway)node);
//			 result = true;
//			}
//	if (result) /*don't know if the code below is needed or not*/
//			{endingNodes.remove(node);
//			 startingNodes.remove(node);
//			}
//	node=null;
//	return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean addNode(WfgNode node) {
		if (node instanceof Action)
			{
			if (actions == null) 
				{ actions = new EObjectContainmentEList<Action>(Action.class, this, WorkflowgraphPackage.WORK_FLOW_GRAPH__ACTIONS);}
			 actions.add((Action)node);
			 return true;
			}
		else if (node instanceof Gateway)
			{
			 if (gateways == null) 
				{ gateways = new EObjectContainmentEList<Gateway>(Gateway.class, this, WorkflowgraphPackage.WORK_FLOW_GRAPH__GATEWAYS);}
			 gateways.add((Gateway)node);
			return true;
			}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ExclusiveChoice createNewExclusiveChoice(String name, boolean merge, boolean fork) {
		if (merge && fork)
			{System.out.println("a gateway can not be fork AND merge");return null;}
		ExclusiveChoice x = WorkflowgraphFactoryImpl.eINSTANCE.createExclusiveChoice();
		x.setFork(fork);
		x.setMerge(merge);
		x.setName(name);
		x.setId(UUID.randomUUID().toString());
		addNode(x);
		return x;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ParallelExecution createNewParallelExecution(String name,  boolean merge, boolean fork) {
		if (merge && fork)
			{System.out.println("a gateway can not be fork AND merge");return null;}
		ParallelExecution p = WorkflowgraphFactoryImpl.eINSTANCE.createParallelExecution();
		p.setFork(fork);
		p.setMerge(merge);
		p.setName(name);
		p.setId(UUID.randomUUID().toString());
		addNode(p);
		return p;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean removeNodes(EList<WfgNode> nodes) 
	{
		boolean allRemoved=true;
		for (WfgNode node : nodes)
			{
			 if (!removeNode(node))
			 	{allRemoved=false;}
			}
		return allRemoved;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toDOTforGraphViz() 
	{

		String result = "";
		result += "digraph G {\n";
		result += "rankdir=LR \n"; //rankdir=LR for left to right graph; rankdir=TD for top to down graph
		
		for (Action a : this.getActions()) {
			result += String.format("  n%s[shape=box,label=\"%s\"];\n", escapeString(a.getId()), escapeString(a.getName()));
		}
		result+="\n";
		
		for (Gateway g : this.getGateways()) 
		{
			if (g instanceof ParallelExecutionImpl)
				{ result += String.format("  %s[shape=diamond,label=\"%s\"];\n", escapeString(g.getId()), "AND_"+escapeString(g.getName()));}
			else if (g instanceof ExclusiveChoiceImpl)
				{ result += String.format("  %s[shape=diamond,label=\"%s\"];\n", escapeString(g.getId()), "XOR_"+escapeString(g.getName()));}
		}
		
		result+="\n";
		
		for (Gateway from : this.getGateways()) 
		{
		 for (WfgNode to : from.getSuccessors())
		 	{
			 result += String.format("  %s -> %s;\n", escapeString(from.getId()), escapeString(to.getId()));
		 	}
		}
		result+="\n";
		
		for (Action from : this.getActions()) 
			{
			 WfgNode to = from.getSuccessor();
			 if (to != null)
				{ result += String.format("  %s -> %s;\n", escapeString(from.getId()), escapeString(to.getId()));}
			}	
		result += "}";
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public MessageExchange createNewMessageExchange(String name, String request, String response, Participant sender, Participant receiver) 
	{
		MessageExchange m = WorkflowgraphFactoryImpl.eINSTANCE.createMessageExchange();
		m.setId(UUID.randomUUID().toString());
		m.setName(name);
		m.setRequest(request);
		m.setSender(sender);
		m.setReceiver(receiver);
		m.setSynchResponse(response);
		addNode(m);
		return m;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__GATEWAYS:
				return ((InternalEList<?>)getGateways()).basicRemove(otherEnd, msgs);
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__PARTICIPANTS:
				return ((InternalEList<?>)getParticipants()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__GATEWAYS:
				return getGateways();
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__STARTING_NODE:
				if (resolve) return getStartingNode();
				return basicGetStartingNode();
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__ENDING_NODE:
				if (resolve) return getEndingNode();
				return basicGetEndingNode();
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__ACTIONS:
				return getActions();
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__PARTICIPANTS:
				return getParticipants();
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__INNER_GATEWAY:
				if (resolve) return getInnerGateway();
				return basicGetInnerGateway();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__GATEWAYS:
				getGateways().clear();
				getGateways().addAll((Collection<? extends Gateway>)newValue);
				return;
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__STARTING_NODE:
				setStartingNode((WfgNode)newValue);
				return;
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__ENDING_NODE:
				setEndingNode((WfgNode)newValue);
				return;
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends Action>)newValue);
				return;
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__PARTICIPANTS:
				getParticipants().clear();
				getParticipants().addAll((Collection<? extends Participant>)newValue);
				return;
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__INNER_GATEWAY:
				setInnerGateway((Gateway)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__GATEWAYS:
				getGateways().clear();
				return;
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__STARTING_NODE:
				unsetStartingNode();
				return;
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__ENDING_NODE:
				unsetEndingNode();
				return;
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__ACTIONS:
				getActions().clear();
				return;
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__PARTICIPANTS:
				getParticipants().clear();
				return;
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__INNER_GATEWAY:
				unsetInnerGateway();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__GATEWAYS:
				return gateways != null && !gateways.isEmpty();
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__STARTING_NODE:
				return isSetStartingNode();
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__ENDING_NODE:
				return isSetEndingNode();
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__ACTIONS:
				return actions != null && !actions.isEmpty();
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__PARTICIPANTS:
				return participants != null && !participants.isEmpty();
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__INNER_GATEWAY:
				return isSetInnerGateway();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case WorkflowgraphPackage.WORK_FLOW_GRAPH___INITIALIZE:
				initialize();
				return null;
			case WorkflowgraphPackage.WORK_FLOW_GRAPH___REMOVE_NODE__WFGNODE:
				return removeNode((WfgNode)arguments.get(0));
			case WorkflowgraphPackage.WORK_FLOW_GRAPH___ADD_NODE__WFGNODE:
				return addNode((WfgNode)arguments.get(0));
			case WorkflowgraphPackage.WORK_FLOW_GRAPH___CREATE_NEW_EXCLUSIVE_CHOICE__STRING_BOOLEAN_BOOLEAN:
				return createNewExclusiveChoice((String)arguments.get(0), (Boolean)arguments.get(1), (Boolean)arguments.get(2));
			case WorkflowgraphPackage.WORK_FLOW_GRAPH___CREATE_NEW_PARALLEL_EXECUTION__STRING_BOOLEAN_BOOLEAN:
				return createNewParallelExecution((String)arguments.get(0), (Boolean)arguments.get(1), (Boolean)arguments.get(2));
			case WorkflowgraphPackage.WORK_FLOW_GRAPH___REMOVE_NODES__ELIST:
				return removeNodes((EList)arguments.get(0));
			case WorkflowgraphPackage.WORK_FLOW_GRAPH___TO_DO_TFOR_GRAPH_VIZ:
				return toDOTforGraphViz();
			case WorkflowgraphPackage.WORK_FLOW_GRAPH___CREATE_NEW_MESSAGE_EXCHANGE__STRING_STRING_STRING_PARTICIPANT_PARTICIPANT:
				return createNewMessageExchange((String)arguments.get(0), (String)arguments.get(1), (String)arguments.get(2), (Participant)arguments.get(3), (Participant)arguments.get(4));
			case WorkflowgraphPackage.WORK_FLOW_GRAPH___SAVE_MODEL__STRING:
				saveModel((String)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * this method should be invoked after made modification to the graph,
	 * like adding or removing nodes
	 * <!-- end-user-doc -->
	 * @generated not
	 */
//	public void refillStartingAndEndingNodes()
//	{
//		//clear the list
//		if (startingNodes == null)
//			{startingNodes = new EObjectResolvingEList<WfgNode>(WfgNode.class, this, WorkflowgraphPackage.WORK_FLOW_GRAPH__STARTING_NODES);}
//		else
//			{startingNodes.clear();}
//		if (endingNodes == null) 
//			{endingNodes = new EObjectResolvingEList<WfgNode>(WfgNode.class, this, WorkflowgraphPackage.WORK_FLOW_GRAPH__ENDING_NODES);}
//		else
//			{endingNodes.clear();}
//		
//		for (Gateway g : getGateways())
//		{
//			if (g.isFork() && g.getPredecessors().size()<1)
//				{startingNodes.add(g);}
//			else if (g.isMerge() && g.getSuccessors().size()<1)
//				{endingNodes.add(g);}
//		}
//		for (Action a : getActions())
//		{
//			if (a.getSuccessor()==null)
//				{endingNodes.add(a);}
//			else if (a.getPredecessor()==null)
//				{startingNodes.add(a);}
//		}
//
//	}


	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void saveModel(String fileName)  
		{  
		  Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		  Map<String, Object> m = reg.getExtensionToFactoryMap();
		  m.put("daform", new XMIResourceFactoryImpl());

		  ResourceSet resSet = new ResourceSetImpl();
		  Resource resource = resSet.createResource(URI.createFileURI(fileName));
		  resource.getContents().add(this);
		  try 
		  	{ resource.save(Collections.EMPTY_MAP);} 
		  catch (IOException e) 
		  	{
			 System.err.println("ERROR! IOException impossible save the model "+fileName);
		  	}
		}



	public static void main (String[] args)
	{
	 WorkFlowGraph wfg = WorkflowgraphFactoryImpl.eINSTANCE.createWorkFlowGraph();	
	 ParallelExecution gat = wfg.createNewParallelExecution("p1", true, false);
	 MessageExchange mess = wfg.createNewMessageExchange("name", "", "", null, null);
	 mess.add_set_successor(gat);
	 wfg.removeNode(mess);
	 
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	private String escapeString(String str) 
	{
		 str=str.replaceAll("\\;", "&#59;");
		 str=str.replaceAll("\\?", "&#63;");
		 str=str.replaceAll("\\!", "&#33;");
		 str=str.replaceAll("\\-", "&#45;");
		 str=str.replaceAll("\\(", "&#40;");
		 str=str.replaceAll("\\)", "&#41;");
		 str=str.replaceAll("\\>", "&#62;");
		 str=str.replaceAll("\\<", "&#60;");
		 str=str.replaceAll("\\_", "&#95;");
		 str=str.replaceAll("\\ ", "&#95;");
		 str = "<"+str+">";
		 return str;
		}
	
	
	
} //WorkFlowGraphImpl
