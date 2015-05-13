/**
 */
package unicam.workflowgraph.impl;

import org.eclipse.bpmn2.ChoreographyTask;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import unicam.workflowgraph.MessageExchange;
import unicam.workflowgraph.Participant;
import unicam.workflowgraph.WorkflowgraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Exchange</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link unicam.workflowgraph.impl.MessageExchangeImpl#getRequest <em>Request</em>}</li>
 *   <li>{@link unicam.workflowgraph.impl.MessageExchangeImpl#getSynchResponse <em>Synch Response</em>}</li>
 *   <li>{@link unicam.workflowgraph.impl.MessageExchangeImpl#getSender <em>Sender</em>}</li>
 *   <li>{@link unicam.workflowgraph.impl.MessageExchangeImpl#getReceiver <em>Receiver</em>}</li>
 *   <li>{@link unicam.workflowgraph.impl.MessageExchangeImpl#getChoreographyTaskRef <em>Choreography Task Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageExchangeImpl extends ActionImpl implements MessageExchange {
	/**
	 * The default value of the '{@link #getRequest() <em>Request</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequest()
	 * @generated
	 * @ordered
	 */
	protected static final String REQUEST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRequest() <em>Request</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequest()
	 * @generated
	 * @ordered
	 */
	protected String request = REQUEST_EDEFAULT;

	/**
	 * The default value of the '{@link #getSynchResponse() <em>Synch Response</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynchResponse()
	 * @generated
	 * @ordered
	 */
	protected static final String SYNCH_RESPONSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSynchResponse() <em>Synch Response</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynchResponse()
	 * @generated
	 * @ordered
	 */
	protected String synchResponse = SYNCH_RESPONSE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSender() <em>Sender</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSender()
	 * @generated
	 * @ordered
	 */
	protected Participant sender;

	/**
	 * The cached value of the '{@link #getReceiver() <em>Receiver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceiver()
	 * @generated
	 * @ordered
	 */
	protected Participant receiver;

	/**
	 * The cached value of the '{@link #getChoreographyTaskRef() <em>Choreography Task Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChoreographyTaskRef()
	 * @generated
	 * @ordered
	 */
	protected ChoreographyTask choreographyTaskRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageExchangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowgraphPackage.Literals.MESSAGE_EXCHANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant getSender() {
		if (sender != null && sender.eIsProxy()) {
			InternalEObject oldSender = (InternalEObject)sender;
			sender = (Participant)eResolveProxy(oldSender);
			if (sender != oldSender) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowgraphPackage.MESSAGE_EXCHANGE__SENDER, oldSender, sender));
			}
		}
		return sender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant basicGetSender() {
		return sender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSender(Participant newSender) {
		Participant oldSender = sender;
		sender = newSender;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowgraphPackage.MESSAGE_EXCHANGE__SENDER, oldSender, sender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant getReceiver() {
		if (receiver != null && receiver.eIsProxy()) {
			InternalEObject oldReceiver = (InternalEObject)receiver;
			receiver = (Participant)eResolveProxy(oldReceiver);
			if (receiver != oldReceiver) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowgraphPackage.MESSAGE_EXCHANGE__RECEIVER, oldReceiver, receiver));
			}
		}
		return receiver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant basicGetReceiver() {
		return receiver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReceiver(Participant newReceiver) {
		Participant oldReceiver = receiver;
		receiver = newReceiver;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowgraphPackage.MESSAGE_EXCHANGE__RECEIVER, oldReceiver, receiver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChoreographyTask getChoreographyTaskRef() {
		if (choreographyTaskRef != null && choreographyTaskRef.eIsProxy()) {
			InternalEObject oldChoreographyTaskRef = (InternalEObject)choreographyTaskRef;
			choreographyTaskRef = (ChoreographyTask)eResolveProxy(oldChoreographyTaskRef);
			if (choreographyTaskRef != oldChoreographyTaskRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowgraphPackage.MESSAGE_EXCHANGE__CHOREOGRAPHY_TASK_REF, oldChoreographyTaskRef, choreographyTaskRef));
			}
		}
		return choreographyTaskRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChoreographyTask basicGetChoreographyTaskRef() {
		return choreographyTaskRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChoreographyTaskRef(ChoreographyTask newChoreographyTaskRef) {
		ChoreographyTask oldChoreographyTaskRef = choreographyTaskRef;
		choreographyTaskRef = newChoreographyTaskRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowgraphPackage.MESSAGE_EXCHANGE__CHOREOGRAPHY_TASK_REF, oldChoreographyTaskRef, choreographyTaskRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRequest() {
		return request;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequest(String newRequest) {
		String oldRequest = request;
		request = newRequest;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowgraphPackage.MESSAGE_EXCHANGE__REQUEST, oldRequest, request));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSynchResponse() {
		return synchResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSynchResponse(String newSynchResponse) {
		String oldSynchResponse = synchResponse;
		synchResponse = newSynchResponse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowgraphPackage.MESSAGE_EXCHANGE__SYNCH_RESPONSE, oldSynchResponse, synchResponse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowgraphPackage.MESSAGE_EXCHANGE__REQUEST:
				return getRequest();
			case WorkflowgraphPackage.MESSAGE_EXCHANGE__SYNCH_RESPONSE:
				return getSynchResponse();
			case WorkflowgraphPackage.MESSAGE_EXCHANGE__SENDER:
				if (resolve) return getSender();
				return basicGetSender();
			case WorkflowgraphPackage.MESSAGE_EXCHANGE__RECEIVER:
				if (resolve) return getReceiver();
				return basicGetReceiver();
			case WorkflowgraphPackage.MESSAGE_EXCHANGE__CHOREOGRAPHY_TASK_REF:
				if (resolve) return getChoreographyTaskRef();
				return basicGetChoreographyTaskRef();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WorkflowgraphPackage.MESSAGE_EXCHANGE__REQUEST:
				setRequest((String)newValue);
				return;
			case WorkflowgraphPackage.MESSAGE_EXCHANGE__SYNCH_RESPONSE:
				setSynchResponse((String)newValue);
				return;
			case WorkflowgraphPackage.MESSAGE_EXCHANGE__SENDER:
				setSender((Participant)newValue);
				return;
			case WorkflowgraphPackage.MESSAGE_EXCHANGE__RECEIVER:
				setReceiver((Participant)newValue);
				return;
			case WorkflowgraphPackage.MESSAGE_EXCHANGE__CHOREOGRAPHY_TASK_REF:
				setChoreographyTaskRef((ChoreographyTask)newValue);
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
			case WorkflowgraphPackage.MESSAGE_EXCHANGE__REQUEST:
				setRequest(REQUEST_EDEFAULT);
				return;
			case WorkflowgraphPackage.MESSAGE_EXCHANGE__SYNCH_RESPONSE:
				setSynchResponse(SYNCH_RESPONSE_EDEFAULT);
				return;
			case WorkflowgraphPackage.MESSAGE_EXCHANGE__SENDER:
				setSender((Participant)null);
				return;
			case WorkflowgraphPackage.MESSAGE_EXCHANGE__RECEIVER:
				setReceiver((Participant)null);
				return;
			case WorkflowgraphPackage.MESSAGE_EXCHANGE__CHOREOGRAPHY_TASK_REF:
				setChoreographyTaskRef((ChoreographyTask)null);
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
			case WorkflowgraphPackage.MESSAGE_EXCHANGE__REQUEST:
				return REQUEST_EDEFAULT == null ? request != null : !REQUEST_EDEFAULT.equals(request);
			case WorkflowgraphPackage.MESSAGE_EXCHANGE__SYNCH_RESPONSE:
				return SYNCH_RESPONSE_EDEFAULT == null ? synchResponse != null : !SYNCH_RESPONSE_EDEFAULT.equals(synchResponse);
			case WorkflowgraphPackage.MESSAGE_EXCHANGE__SENDER:
				return sender != null;
			case WorkflowgraphPackage.MESSAGE_EXCHANGE__RECEIVER:
				return receiver != null;
			case WorkflowgraphPackage.MESSAGE_EXCHANGE__CHOREOGRAPHY_TASK_REF:
				return choreographyTaskRef != null;
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
		result.append(" (request: ");
		result.append(request);
		result.append(", synchResponse: ");
		result.append(synchResponse);
		result.append(')');
		return result.toString();
	}

} //MessageExchangeImpl
