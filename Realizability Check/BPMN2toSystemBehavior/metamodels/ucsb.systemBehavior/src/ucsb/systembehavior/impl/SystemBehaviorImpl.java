/**
 */
package ucsb.systembehavior.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import ucsb.peerbehavior.Message;
import ucsb.peerbehavior.Peer;
import ucsb.peerbehavior.State;
import ucsb.systembehavior.InternalTransition;
import ucsb.systembehavior.PeerSituation;
import ucsb.systembehavior.Send;
import ucsb.systembehavior.SystemBehavior;
import ucsb.systembehavior.SystembehaviorPackage;
import ucsb.systembehavior.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ucsb.systembehavior.impl.SystemBehaviorImpl#getPeers <em>Peers</em>}</li>
 *   <li>{@link ucsb.systembehavior.impl.SystemBehaviorImpl#getMessages <em>Messages</em>}</li>
 *   <li>{@link ucsb.systembehavior.impl.SystemBehaviorImpl#getStates <em>States</em>}</li>
 *   <li>{@link ucsb.systembehavior.impl.SystemBehaviorImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link ucsb.systembehavior.impl.SystemBehaviorImpl#getInitialState <em>Initial State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemBehaviorImpl extends MinimalEObjectImpl.Container implements SystemBehavior {
	/**
	 * The cached value of the '{@link #getPeers() <em>Peers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeers()
	 * @generated
	 * @ordered
	 */
	protected EList<Peer> peers;

	/**
	 * The cached value of the '{@link #getMessages() <em>Messages</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessages()
	 * @generated
	 * @ordered
	 */
	protected EList<Message> messages;

	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<PeerSituation> states;

	/**
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> transitions;

	/**
	 * The cached value of the '{@link #getInitialState() <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialState()
	 * @generated
	 * @ordered
	 */
	protected PeerSituation initialState;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemBehaviorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SystembehaviorPackage.Literals.SYSTEM_BEHAVIOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Peer> getPeers() {
		if (peers == null) {
			peers = new EObjectResolvingEList<Peer>(Peer.class, this, SystembehaviorPackage.SYSTEM_BEHAVIOR__PEERS);
		}
		return peers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Message> getMessages() {
		if (messages == null) {
			messages = new EObjectResolvingEList<Message>(Message.class, this, SystembehaviorPackage.SYSTEM_BEHAVIOR__MESSAGES);
		}
		return messages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PeerSituation> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<PeerSituation>(PeerSituation.class, this, SystembehaviorPackage.SYSTEM_BEHAVIOR__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Transition> getTransitions() {
		if (transitions == null) {
			transitions = new EObjectContainmentEList<Transition>(Transition.class, this, SystembehaviorPackage.SYSTEM_BEHAVIOR__TRANSITIONS);
		}
		return transitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PeerSituation getInitialState() {
		if (initialState != null && initialState.eIsProxy()) {
			InternalEObject oldInitialState = (InternalEObject)initialState;
			initialState = (PeerSituation)eResolveProxy(oldInitialState);
			if (initialState != oldInitialState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystembehaviorPackage.SYSTEM_BEHAVIOR__INITIAL_STATE, oldInitialState, initialState));
			}
		}
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PeerSituation basicGetInitialState() {
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialState(PeerSituation newInitialState) {
		PeerSituation oldInitialState = initialState;
		initialState = newInitialState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystembehaviorPackage.SYSTEM_BEHAVIOR__INITIAL_STATE, oldInitialState, initialState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toDOTforGraphViz() {

		String result = "";
		result += "digraph G {\n";
		result += "rankdir=LR \n"; //rankdir=LR for left to right graph; rankdir=TD for top to down graph
		PeerSituation initSt = getInitialState();
		for (PeerSituation s : this.getStates()) 
			{ String bubble = "[shape=ellipse";
			  if (s == initSt)
			  	{bubble += ", fillcolor=green, style=filled";}
			  else if (s.getOutcoming().size()==0)
			    {bubble += ", fillcolor=red";} 
			  else
			    {bubble += ", fillcolor=white";} 
			  if (s.getGatewayRef() != null)
			 	{  bubble += ", color=blue";}
			  else
			  	{  bubble += ", color=black";}
			  
			  if (s.getGatewayRef() != null)
			    {
			     if (s.getGatewayRef().isFork())
					 { result += String.format("  %s"+bubble+", label=\"%s\"];\n", escapeString(s.getId()), "("+escapeString(s.getId())+") start_"+escapeString(s.getGatewayRef().getName())); }
				 else
				 	 { result += String.format("  %s"+bubble+", label=\"%s\"];\n", escapeString(s.getId()), "("+escapeString(s.getId())+") end_"+escapeString(s.getGatewayRef().getName())); }
			 	}
			 else
			 	{ result += String.format(" %s"+bubble+", label=\"%s\"];\n", escapeString(s.getId()), escapeString(s.getId())); }
			}
		result+="\n";
		
		for (Transition t : this.getTransitions()) 
			{
			  try
				{
				 if (t instanceof Send)
					 {
					  Send s = (Send)t;
					  result += String.format("  %s -> %s [ label="+escapeString(s.getName())+" ];\n", escapeString(s.getFrom().getId()), escapeString(s.getTo().getId()));
					 }
				 else if (t instanceof InternalTransitionImpl)
				 	{
					 InternalTransitionImpl i = (InternalTransitionImpl)t;
					 	String attributes = "[ label="+new Character((char)949).toString();
					    if (t instanceof LoopTransitionImpl)
					    	{ attributes += ", color=purple"; }
					 	attributes += " ]";
					 result += String.format("  %s -> %s "+attributes+";\n", escapeString(i.getFrom().getId()), escapeString(i.getTo().getId()));
				 	}
				 } 
			   catch(java.lang.NullPointerException ex){}
			}	
		result += "}";
		
		return result;
	}

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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void deleteInternalTransition() 
	{
	 String err = "the method 'ucsb.systembehavior.impl.SystemBehavior.deleteInternalTransition()' not implemented.\n"+ 
	              "Anyway you can avoid the internal transitions\n"+
	 		      "adding a parallel gateway at the begin, and a closing one at the end.\n"+
			      "The only branch of the parallel gateway will be the whole choreography.\n"+
	 		      "This trick is just a work-around.";
	 throw new NullPointerException (err);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__TRANSITIONS:
				return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
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
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__PEERS:
				return getPeers();
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__MESSAGES:
				return getMessages();
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__STATES:
				return getStates();
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__TRANSITIONS:
				return getTransitions();
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__INITIAL_STATE:
				if (resolve) return getInitialState();
				return basicGetInitialState();
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
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__PEERS:
				getPeers().clear();
				getPeers().addAll((Collection<? extends Peer>)newValue);
				return;
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__MESSAGES:
				getMessages().clear();
				getMessages().addAll((Collection<? extends Message>)newValue);
				return;
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends PeerSituation>)newValue);
				return;
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__TRANSITIONS:
				getTransitions().clear();
				getTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__INITIAL_STATE:
				setInitialState((PeerSituation)newValue);
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
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__PEERS:
				getPeers().clear();
				return;
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__MESSAGES:
				getMessages().clear();
				return;
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__STATES:
				getStates().clear();
				return;
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__TRANSITIONS:
				getTransitions().clear();
				return;
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__INITIAL_STATE:
				setInitialState((PeerSituation)null);
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
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__PEERS:
				return peers != null && !peers.isEmpty();
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__MESSAGES:
				return messages != null && !messages.isEmpty();
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__STATES:
				return states != null && !states.isEmpty();
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__TRANSITIONS:
				return transitions != null && !transitions.isEmpty();
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__INITIAL_STATE:
				return initialState != null;
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
			case SystembehaviorPackage.SYSTEM_BEHAVIOR___TO_DO_TFOR_GRAPH_VIZ:
				return toDOTforGraphViz();
			case SystembehaviorPackage.SYSTEM_BEHAVIOR___SAVE_MODEL__STRING:
				saveModel((String)arguments.get(0));
				return null;
			case SystembehaviorPackage.SYSTEM_BEHAVIOR___DELETE_INTERNAL_TRANSITION:
				deleteInternalTransition();
				return null;
		}
		return super.eInvoke(operationID, arguments);
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

} //SystemBehaviorImpl
