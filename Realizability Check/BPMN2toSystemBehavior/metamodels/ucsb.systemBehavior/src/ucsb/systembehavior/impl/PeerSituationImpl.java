/**
 */
package ucsb.systembehavior.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import ucsb.peerbehavior.Peer;
import ucsb.peerbehavior.State;
import ucsb.peerbehavior.input;
import ucsb.systembehavior.InternalTransition;
import ucsb.systembehavior.PeerSituation;
import ucsb.systembehavior.Send;
import ucsb.systembehavior.SystembehaviorPackage;
import ucsb.systembehavior.Transition;
import unicam.workflowgraph.Gateway;
import unicam.workflowgraph.WfgNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Peer Situation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ucsb.systembehavior.impl.PeerSituationImpl#getMessages <em>Messages</em>}</li>
 *   <li>{@link ucsb.systembehavior.impl.PeerSituationImpl#getStates <em>States</em>}</li>
 *   <li>{@link ucsb.systembehavior.impl.PeerSituationImpl#getName <em>Name</em>}</li>
 *   <li>{@link ucsb.systembehavior.impl.PeerSituationImpl#getId <em>Id</em>}</li>
 *   <li>{@link ucsb.systembehavior.impl.PeerSituationImpl#getOutcoming <em>Outcoming</em>}</li>
 *   <li>{@link ucsb.systembehavior.impl.PeerSituationImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link ucsb.systembehavior.impl.PeerSituationImpl#getGatewayRef <em>Gateway Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PeerSituationImpl extends MinimalEObjectImpl.Container implements PeerSituation {
	
	static private int IDcounter = 0;
	
	
	/**
	 * The cached value of the '{@link #getMessages() <em>Messages</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessages()
	 * @generated
	 * @ordered
	 */
	protected EList<input> messages;

	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> states;

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
	 * This is true if the Name attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean nameESet;

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
	 * This is true if the Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean idESet;

	/**
	 * The cached value of the '{@link #getOutcoming() <em>Outcoming</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutcoming()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> outcoming;

	/**
	 * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncoming()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> incoming;

	/**
	 * The cached value of the '{@link #getGatewayRef() <em>Gateway Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGatewayRef()
	 * @generated
	 * @ordered
	 */
	protected Gateway gatewayRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	protected PeerSituationImpl() {
		super();
		setId("s"+IDcounter);
		IDcounter++;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SystembehaviorPackage.Literals.PEER_SITUATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<input> getMessages() {
		if (messages == null) {
			messages = new EObjectResolvingEList<input>(input.class, this, SystembehaviorPackage.PEER_SITUATION__MESSAGES);
		}
		return messages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getStates() {
		if (states == null) {
			states = new EObjectResolvingEList<State>(State.class, this, SystembehaviorPackage.PEER_SITUATION__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		 try{
			 String name="";
			 for (State s :getStates())
			 	{
				 name += ((Peer)s.eContainer()).getName()+"("+s.getName()+"); ";
			 	}
			  return name;
		 	}
		 catch (NullPointerException ex){return "Nullpointer";}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		boolean oldNameESet = nameESet;
		nameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystembehaviorPackage.PEER_SITUATION__NAME, oldName, name, !oldNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetName() {
		String oldName = name;
		boolean oldNameESet = nameESet;
		name = NAME_EDEFAULT;
		nameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, SystembehaviorPackage.PEER_SITUATION__NAME, oldName, NAME_EDEFAULT, oldNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetName() {
		return nameESet;
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
		boolean oldIdESet = idESet;
		idESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystembehaviorPackage.PEER_SITUATION__ID, oldId, id, !oldIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetId() {
		String oldId = id;
		boolean oldIdESet = idESet;
		id = ID_EDEFAULT;
		idESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, SystembehaviorPackage.PEER_SITUATION__ID, oldId, ID_EDEFAULT, oldIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetId() {
		return idESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getOutcoming() {
		if (outcoming == null) {
			outcoming = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, SystembehaviorPackage.PEER_SITUATION__OUTCOMING, SystembehaviorPackage.TRANSITION__FROM);
		}
		return outcoming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getIncoming() {
		if (incoming == null) {
			incoming = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, SystembehaviorPackage.PEER_SITUATION__INCOMING, SystembehaviorPackage.TRANSITION__TO);
		}
		return incoming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gateway getGatewayRef() {
		if (gatewayRef != null && gatewayRef.eIsProxy()) {
			InternalEObject oldGatewayRef = (InternalEObject)gatewayRef;
			gatewayRef = (Gateway)eResolveProxy(oldGatewayRef);
			if (gatewayRef != oldGatewayRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystembehaviorPackage.PEER_SITUATION__GATEWAY_REF, oldGatewayRef, gatewayRef));
			}
		}
		return gatewayRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gateway basicGetGatewayRef() {
		return gatewayRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGatewayRef(Gateway newGatewayRef) {
		Gateway oldGatewayRef = gatewayRef;
		gatewayRef = newGatewayRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystembehaviorPackage.PEER_SITUATION__GATEWAY_REF, oldGatewayRef, gatewayRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SystembehaviorPackage.PEER_SITUATION__OUTCOMING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutcoming()).basicAdd(otherEnd, msgs);
			case SystembehaviorPackage.PEER_SITUATION__INCOMING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncoming()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SystembehaviorPackage.PEER_SITUATION__OUTCOMING:
				return ((InternalEList<?>)getOutcoming()).basicRemove(otherEnd, msgs);
			case SystembehaviorPackage.PEER_SITUATION__INCOMING:
				return ((InternalEList<?>)getIncoming()).basicRemove(otherEnd, msgs);
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
			case SystembehaviorPackage.PEER_SITUATION__MESSAGES:
				return getMessages();
			case SystembehaviorPackage.PEER_SITUATION__STATES:
				return getStates();
			case SystembehaviorPackage.PEER_SITUATION__NAME:
				return getName();
			case SystembehaviorPackage.PEER_SITUATION__ID:
				return getId();
			case SystembehaviorPackage.PEER_SITUATION__OUTCOMING:
				return getOutcoming();
			case SystembehaviorPackage.PEER_SITUATION__INCOMING:
				return getIncoming();
			case SystembehaviorPackage.PEER_SITUATION__GATEWAY_REF:
				if (resolve) return getGatewayRef();
				return basicGetGatewayRef();
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
			case SystembehaviorPackage.PEER_SITUATION__MESSAGES:
				getMessages().clear();
				getMessages().addAll((Collection<? extends input>)newValue);
				return;
			case SystembehaviorPackage.PEER_SITUATION__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends State>)newValue);
				return;
			case SystembehaviorPackage.PEER_SITUATION__NAME:
				setName((String)newValue);
				return;
			case SystembehaviorPackage.PEER_SITUATION__ID:
				setId((String)newValue);
				return;
			case SystembehaviorPackage.PEER_SITUATION__OUTCOMING:
				getOutcoming().clear();
				getOutcoming().addAll((Collection<? extends Transition>)newValue);
				return;
			case SystembehaviorPackage.PEER_SITUATION__INCOMING:
				getIncoming().clear();
				getIncoming().addAll((Collection<? extends Transition>)newValue);
				return;
			case SystembehaviorPackage.PEER_SITUATION__GATEWAY_REF:
				setGatewayRef((Gateway)newValue);
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
			case SystembehaviorPackage.PEER_SITUATION__MESSAGES:
				getMessages().clear();
				return;
			case SystembehaviorPackage.PEER_SITUATION__STATES:
				getStates().clear();
				return;
			case SystembehaviorPackage.PEER_SITUATION__NAME:
				unsetName();
				return;
			case SystembehaviorPackage.PEER_SITUATION__ID:
				unsetId();
				return;
			case SystembehaviorPackage.PEER_SITUATION__OUTCOMING:
				getOutcoming().clear();
				return;
			case SystembehaviorPackage.PEER_SITUATION__INCOMING:
				getIncoming().clear();
				return;
			case SystembehaviorPackage.PEER_SITUATION__GATEWAY_REF:
				setGatewayRef((Gateway)null);
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
			case SystembehaviorPackage.PEER_SITUATION__MESSAGES:
				return messages != null && !messages.isEmpty();
			case SystembehaviorPackage.PEER_SITUATION__STATES:
				return states != null && !states.isEmpty();
			case SystembehaviorPackage.PEER_SITUATION__NAME:
				return isSetName();
			case SystembehaviorPackage.PEER_SITUATION__ID:
				return isSetId();
			case SystembehaviorPackage.PEER_SITUATION__OUTCOMING:
				return outcoming != null && !outcoming.isEmpty();
			case SystembehaviorPackage.PEER_SITUATION__INCOMING:
				return incoming != null && !incoming.isEmpty();
			case SystembehaviorPackage.PEER_SITUATION__GATEWAY_REF:
				return gatewayRef != null;
		}
		return super.eIsSet(featureID);
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
		if (nameESet) result.append(name); else result.append("<unset>");
		result.append(", id: ");
		if (idESet) result.append(id); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}
	
	
	
	public void blabla(String msg)
		{System.out.println(msg);}
	
	public void blabla(ArrayList<PeerSituation> old_states,ArrayList<WfgNode> visitedNodes)
	{
	 String r="";
	 for (State st : states)
	 	{try{r += " "+st.getName()+" ";}catch(Exception ex){}}
	 r += "  has:  ";
	 for (PeerSituation n : old_states)
	 	{try{r += " "+n.getName()+" ";}catch(Exception ex){}}
	 r += "    visited:  ";
	 for (WfgNode n : visitedNodes)
	 	{try{r += " "+n.getName()+" ";}catch(Exception ex){}}
	System.out.println(r);
	
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * delete the current Sys State, and delete all the linked sys and peer transitions/states
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void deleteCascade()
		{
		 ArrayList <PeerSituationImpl> previousSysStates = new ArrayList <PeerSituationImpl>(); 
		 while (getIncoming().size()>0)
      		{
			 previousSysStates.add((PeerSituationImpl) getIncoming().get(0).getFrom());
			 EcoreUtil.delete(getIncoming().get(0));
			 }
		 for (PeerSituationImpl prev : previousSysStates)
		 	{
			 if (prev.getOutcoming().size()==0)
			 	{ prev.deleteCascade(); }
		 	}
		 while (getOutcoming().size()>0)
   			{EcoreUtil.delete(getOutcoming().get(0));}
		 
		 ArrayList<State> previouses = new ArrayList<State>();
		 while (getStates().size()>0)
	      	{
	      	 while (getStates().get(0).getIncoming().size() > 0)
	      		{
	      		 previouses.add(getStates().get(0).getIncoming().get(0).getFrom());
	      		 EcoreUtil.delete(getStates().get(0).getIncoming().get(0));
	      		}
	      	 for (State s : previouses)
	      	 	{
	      		 if (s.getOutcoming().size() == 0)
	      		 	{ EcoreUtil.delete(s); }
	      	 	}
	      	 while (getStates().get(0).getOutcoming().size() > 0)
	      		{EcoreUtil.delete(getStates().get(0).getOutcoming().get(0));}
	      	 EcoreUtil.delete(getStates().get(0));
	      	}
		 EcoreUtil.delete(this);
		}
	
	
	
	private String result;
	private HashSet<PeerSituation> done = new HashSet<PeerSituation>();
	
	public void toDOTforGraphViz() 
	{

		result = "";
		done.clear();
		result += "digraph G {\n";
		result += "rankdir=LR \n"; //rankdir=LR for left to right graph; rankdir=TD for top to down graph
		addNextDot(this);
		result += "}";
		System.out.println();System.out.println();System.out.println();System.out.println("=============================================================");
		System.out.println(result);
	}
		
		
	
		
	private void addNextDot(PeerSituation ps)
	{
		if (done.contains(ps))
			{return ;}
		done.add(ps);
		result += String.format("  %s[shape=round,label=\"%s\"];\n", escapeString(ps.getName()), escapeString(ps.getName()));
		result+="\n";
		for (Transition t : ps.getOutcoming()) 
		{
		  try
			{
			  if (t instanceof Send)
				 {
				  Send s = (Send)t;
				  result += String.format("  %s -> %s [ label="+escapeString(s.getName())+" ];\n", escapeString(s.getFrom().getName()), escapeString(s.getTo().getName()));
				 }
			  else if (t instanceof InternalTransition)
			 	{
				  InternalTransition i = (InternalTransition)t;
				 result += String.format("  %s -> %s [ label="+new Character((char)949).toString()+" ];\n", escapeString(i.getFrom().getName()), escapeString(i.getTo().getName()));
			 	}
			  addNextDot(t.getTo());
			 } 
		   catch(java.lang.NullPointerException ex){}
		}	
	}
	
	
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

} //PeerSituationImpl
