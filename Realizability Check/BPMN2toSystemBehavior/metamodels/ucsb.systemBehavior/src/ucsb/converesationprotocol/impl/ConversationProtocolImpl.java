/**
 */
package ucsb.converesationprotocol.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import ucsb.converesationprotocol.ConveresationprotocolPackage;
import ucsb.converesationprotocol.ConversationProtocol;
import ucsb.converesationprotocol.Message;
import ucsb.converesationprotocol.State;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conversation Protocol</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ucsb.converesationprotocol.impl.ConversationProtocolImpl#getStates <em>States</em>}</li>
 *   <li>{@link ucsb.converesationprotocol.impl.ConversationProtocolImpl#getMessages <em>Messages</em>}</li>
 *   <li>{@link ucsb.converesationprotocol.impl.ConversationProtocolImpl#getInitialState <em>Initial State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConversationProtocolImpl extends MinimalEObjectImpl.Container implements ConversationProtocol {
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
	 * The cached value of the '{@link #getMessages() <em>Messages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessages()
	 * @generated
	 * @ordered
	 */
	protected EList<Message> messages;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConversationProtocolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConveresationprotocolPackage.Literals.CONVERSATION_PROTOCOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<State>(State.class, this, ConveresationprotocolPackage.CONVERSATION_PROTOCOL__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Message> getMessages() {
		if (messages == null) {
			messages = new EObjectContainmentEList<Message>(Message.class, this, ConveresationprotocolPackage.CONVERSATION_PROTOCOL__MESSAGES);
		}
		return messages;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConveresationprotocolPackage.CONVERSATION_PROTOCOL__INITIAL_STATE, oldInitialState, initialState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConveresationprotocolPackage.CONVERSATION_PROTOCOL__INITIAL_STATE, oldInitialState, initialState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConveresationprotocolPackage.CONVERSATION_PROTOCOL__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
			case ConveresationprotocolPackage.CONVERSATION_PROTOCOL__MESSAGES:
				return ((InternalEList<?>)getMessages()).basicRemove(otherEnd, msgs);
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
			case ConveresationprotocolPackage.CONVERSATION_PROTOCOL__STATES:
				return getStates();
			case ConveresationprotocolPackage.CONVERSATION_PROTOCOL__MESSAGES:
				return getMessages();
			case ConveresationprotocolPackage.CONVERSATION_PROTOCOL__INITIAL_STATE:
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
			case ConveresationprotocolPackage.CONVERSATION_PROTOCOL__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends State>)newValue);
				return;
			case ConveresationprotocolPackage.CONVERSATION_PROTOCOL__MESSAGES:
				getMessages().clear();
				getMessages().addAll((Collection<? extends Message>)newValue);
				return;
			case ConveresationprotocolPackage.CONVERSATION_PROTOCOL__INITIAL_STATE:
				setInitialState((State)newValue);
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
			case ConveresationprotocolPackage.CONVERSATION_PROTOCOL__STATES:
				getStates().clear();
				return;
			case ConveresationprotocolPackage.CONVERSATION_PROTOCOL__MESSAGES:
				getMessages().clear();
				return;
			case ConveresationprotocolPackage.CONVERSATION_PROTOCOL__INITIAL_STATE:
				setInitialState((State)null);
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
			case ConveresationprotocolPackage.CONVERSATION_PROTOCOL__STATES:
				return states != null && !states.isEmpty();
			case ConveresationprotocolPackage.CONVERSATION_PROTOCOL__MESSAGES:
				return messages != null && !messages.isEmpty();
			case ConveresationprotocolPackage.CONVERSATION_PROTOCOL__INITIAL_STATE:
				return initialState != null;
		}
		return super.eIsSet(featureID);
	}

} //ConversationProtocolImpl
