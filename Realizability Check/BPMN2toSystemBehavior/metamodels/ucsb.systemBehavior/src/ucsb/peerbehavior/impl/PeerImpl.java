/**
 */
package ucsb.peerbehavior.impl;

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
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import ucsb.peerbehavior.InternalTransition;
import ucsb.peerbehavior.Peer;
import ucsb.peerbehavior.PeerbehaviorPackage;
import ucsb.peerbehavior.Receive;
import ucsb.peerbehavior.Send;
import ucsb.peerbehavior.State;
import ucsb.peerbehavior.Transition;
import ucsb.peerbehavior.input;
import ucsb.peerbehavior.output;
import unicam.workflowgraph.Participant;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Peer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ucsb.peerbehavior.impl.PeerImpl#getIn <em>In</em>}</li>
 *   <li>{@link ucsb.peerbehavior.impl.PeerImpl#getOut <em>Out</em>}</li>
 *   <li>{@link ucsb.peerbehavior.impl.PeerImpl#getStates <em>States</em>}</li>
 *   <li>{@link ucsb.peerbehavior.impl.PeerImpl#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link ucsb.peerbehavior.impl.PeerImpl#getName <em>Name</em>}</li>
 *   <li>{@link ucsb.peerbehavior.impl.PeerImpl#getTransictions <em>Transictions</em>}</li>
 *   <li>{@link ucsb.peerbehavior.impl.PeerImpl#getId <em>Id</em>}</li>
 *   <li>{@link ucsb.peerbehavior.impl.PeerImpl#getTest <em>Test</em>}</li>
 *   <li>{@link ucsb.peerbehavior.impl.PeerImpl#getParticipantRef <em>Participant Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PeerImpl extends MinimalEObjectImpl.Container implements Peer {
	/**
	 * The cached value of the '{@link #getIn() <em>In</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIn()
	 * @generated
	 * @ordered
	 */
	protected EList<input> in;

	/**
	 * The cached value of the '{@link #getOut() <em>Out</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOut()
	 * @generated
	 * @ordered
	 */
	protected EList<output> out;

	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> states;

	/**
	 * The cached value of the '{@link #getInitialState() <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialState()
	 * @generated
	 * @ordered
	 */
	protected State initialState;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTransictions() <em>Transictions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransictions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> transictions;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getTest() <em>Test</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTest()
	 * @generated
	 * @ordered
	 */
	protected static final int TEST_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTest() <em>Test</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTest()
	 * @generated
	 * @ordered
	 */
	protected int test = TEST_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParticipantRef() <em>Participant Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipantRef()
	 * @generated
	 * @ordered
	 */
	protected Participant participantRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PeerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PeerbehaviorPackage.Literals.PEER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<input> getIn() {
		if (in == null) {
			in = new EObjectContainmentEList<input>(input.class, this, PeerbehaviorPackage.PEER__IN);
		}
		return in;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<output> getOut() {
		if (out == null) {
			out = new EObjectContainmentEList<output>(output.class, this, PeerbehaviorPackage.PEER__OUT);
		}
		return out;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<State>(State.class, this, PeerbehaviorPackage.PEER__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getInitialState() {
		if (initialState != null && initialState.eIsProxy()) {
			InternalEObject oldInitialState = (InternalEObject)initialState;
			initialState = (State)eResolveProxy(oldInitialState);
			if (initialState != oldInitialState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PeerbehaviorPackage.PEER__INITIAL_STATE, oldInitialState, initialState));
			}
		}
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetInitialState() {
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialState(State newInitialState) {
		State oldInitialState = initialState;
		initialState = newInitialState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PeerbehaviorPackage.PEER__INITIAL_STATE, oldInitialState, initialState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PeerbehaviorPackage.PEER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getTransictions() {
		if (transictions == null) {
			transictions = new EObjectContainmentEList<Transition>(Transition.class, this, PeerbehaviorPackage.PEER__TRANSICTIONS);
		}
		return transictions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PeerbehaviorPackage.PEER__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTest() {
		return test;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTest(int newTest) {
		int oldTest = test;
		test = newTest;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PeerbehaviorPackage.PEER__TEST, oldTest, test));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant getParticipantRef() {
		if (participantRef != null && participantRef.eIsProxy()) {
			InternalEObject oldParticipantRef = (InternalEObject)participantRef;
			participantRef = (Participant)eResolveProxy(oldParticipantRef);
			if (participantRef != oldParticipantRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PeerbehaviorPackage.PEER__PARTICIPANT_REF, oldParticipantRef, participantRef));
			}
		}
		return participantRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant basicGetParticipantRef() {
		return participantRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParticipantRef(Participant newParticipantRef) {
		Participant oldParticipantRef = participantRef;
		participantRef = newParticipantRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PeerbehaviorPackage.PEER__PARTICIPANT_REF, oldParticipantRef, participantRef));
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
		
		for (State s : this.getStates()) 
			{
			 result += String.format("  %s[shape=round,label=\"%s\"];\n", escapeString(s.getName()), escapeString(s.getName()));
			}
		result+="\n";
		
		for (Transition t : this.getTransictions()) 
			{
			 try
			 	{
				 if (t instanceof Send)
					 {
					  Send s = (Send)t;
					  result += String.format("  %s -> %s [ label="+escapeString(s.getMessage().getName())+" ];\n", escapeString(s.getFrom().getName()), escapeString(s.getTo().getName()));
					 }
				 else if (t instanceof Receive)
				 	{
					 Receive r = (Receive)t;
					 result += String.format("  %s -> %s [ label="+escapeString(r.getMessage().getName())+" ];\n", escapeString(r.getFrom().getName()), escapeString(r.getTo().getName()));
				 	}
				 else if (t instanceof InternalTransition)
				 	{
					 InternalTransition i = (InternalTransition)t;
					 result += String.format("  %s -> %s [ label="+new Character((char)949).toString()+" ];\n", escapeString(i.getFrom().getName()), escapeString(i.getTo().getName()));
				 	} 
				 }
			catch(java.lang.NullPointerException ex){}
			}
		result+="\n";
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
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PeerbehaviorPackage.PEER__IN:
				return ((InternalEList<?>)getIn()).basicRemove(otherEnd, msgs);
			case PeerbehaviorPackage.PEER__OUT:
				return ((InternalEList<?>)getOut()).basicRemove(otherEnd, msgs);
			case PeerbehaviorPackage.PEER__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
			case PeerbehaviorPackage.PEER__TRANSICTIONS:
				return ((InternalEList<?>)getTransictions()).basicRemove(otherEnd, msgs);
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
			case PeerbehaviorPackage.PEER__IN:
				return getIn();
			case PeerbehaviorPackage.PEER__OUT:
				return getOut();
			case PeerbehaviorPackage.PEER__STATES:
				return getStates();
			case PeerbehaviorPackage.PEER__INITIAL_STATE:
				if (resolve) return getInitialState();
				return basicGetInitialState();
			case PeerbehaviorPackage.PEER__NAME:
				return getName();
			case PeerbehaviorPackage.PEER__TRANSICTIONS:
				return getTransictions();
			case PeerbehaviorPackage.PEER__ID:
				return getId();
			case PeerbehaviorPackage.PEER__TEST:
				return getTest();
			case PeerbehaviorPackage.PEER__PARTICIPANT_REF:
				if (resolve) return getParticipantRef();
				return basicGetParticipantRef();
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
			case PeerbehaviorPackage.PEER__IN:
				getIn().clear();
				getIn().addAll((Collection<? extends input>)newValue);
				return;
			case PeerbehaviorPackage.PEER__OUT:
				getOut().clear();
				getOut().addAll((Collection<? extends output>)newValue);
				return;
			case PeerbehaviorPackage.PEER__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends State>)newValue);
				return;
			case PeerbehaviorPackage.PEER__INITIAL_STATE:
				setInitialState((State)newValue);
				return;
			case PeerbehaviorPackage.PEER__NAME:
				setName((String)newValue);
				return;
			case PeerbehaviorPackage.PEER__TRANSICTIONS:
				getTransictions().clear();
				getTransictions().addAll((Collection<? extends Transition>)newValue);
				return;
			case PeerbehaviorPackage.PEER__ID:
				setId((String)newValue);
				return;
			case PeerbehaviorPackage.PEER__TEST:
				setTest((Integer)newValue);
				return;
			case PeerbehaviorPackage.PEER__PARTICIPANT_REF:
				setParticipantRef((Participant)newValue);
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
			case PeerbehaviorPackage.PEER__IN:
				getIn().clear();
				return;
			case PeerbehaviorPackage.PEER__OUT:
				getOut().clear();
				return;
			case PeerbehaviorPackage.PEER__STATES:
				getStates().clear();
				return;
			case PeerbehaviorPackage.PEER__INITIAL_STATE:
				setInitialState((State)null);
				return;
			case PeerbehaviorPackage.PEER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PeerbehaviorPackage.PEER__TRANSICTIONS:
				getTransictions().clear();
				return;
			case PeerbehaviorPackage.PEER__ID:
				setId(ID_EDEFAULT);
				return;
			case PeerbehaviorPackage.PEER__TEST:
				setTest(TEST_EDEFAULT);
				return;
			case PeerbehaviorPackage.PEER__PARTICIPANT_REF:
				setParticipantRef((Participant)null);
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
			case PeerbehaviorPackage.PEER__IN:
				return in != null && !in.isEmpty();
			case PeerbehaviorPackage.PEER__OUT:
				return out != null && !out.isEmpty();
			case PeerbehaviorPackage.PEER__STATES:
				return states != null && !states.isEmpty();
			case PeerbehaviorPackage.PEER__INITIAL_STATE:
				return initialState != null;
			case PeerbehaviorPackage.PEER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PeerbehaviorPackage.PEER__TRANSICTIONS:
				return transictions != null && !transictions.isEmpty();
			case PeerbehaviorPackage.PEER__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case PeerbehaviorPackage.PEER__TEST:
				return test != TEST_EDEFAULT;
			case PeerbehaviorPackage.PEER__PARTICIPANT_REF:
				return participantRef != null;
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
			case PeerbehaviorPackage.PEER___TO_DO_TFOR_GRAPH_VIZ:
				return toDOTforGraphViz();
			case PeerbehaviorPackage.PEER___SAVE_MODEL__STRING:
				saveModel((String)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", id: ");
		result.append(id);
		result.append(", test: ");
		result.append(test);
		result.append(')');
		return result.toString();
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
	

} //PeerImpl
