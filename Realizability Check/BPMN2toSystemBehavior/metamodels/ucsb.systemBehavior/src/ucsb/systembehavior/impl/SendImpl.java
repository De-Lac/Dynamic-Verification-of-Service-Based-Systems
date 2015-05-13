/**
 */
package ucsb.systembehavior.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ucsb.peerbehavior.Message;
import ucsb.peerbehavior.Peer;
import ucsb.peerbehavior.Receive;
import ucsb.systembehavior.Send;
import ucsb.systembehavior.SystembehaviorPackage;
import unicam.workflowgraph.MessageExchange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Send</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ucsb.systembehavior.impl.SendImpl#getSource <em>Source</em>}</li>
 *   <li>{@link ucsb.systembehavior.impl.SendImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link ucsb.systembehavior.impl.SendImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link ucsb.systembehavior.impl.SendImpl#getName <em>Name</em>}</li>
 *   <li>{@link ucsb.systembehavior.impl.SendImpl#getMessageExchangeRef <em>Message Exchange Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SendImpl extends TransitionImpl implements Send {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Peer source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Peer target;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected Message message;

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
	 * The cached value of the '{@link #getMessageExchangeRef() <em>Message Exchange Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageExchangeRef()
	 * @generated
	 * @ordered
	 */
	protected MessageExchange messageExchangeRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SendImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SystembehaviorPackage.Literals.SEND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Peer getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Peer)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystembehaviorPackage.SEND__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Peer basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Peer newSource) {
		Peer oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystembehaviorPackage.SEND__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Peer getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Peer)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystembehaviorPackage.SEND__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Peer basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Peer newTarget) {
		Peer oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystembehaviorPackage.SEND__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message getMessage() {
		if (message != null && message.eIsProxy()) {
			InternalEObject oldMessage = (InternalEObject)message;
			message = (Message)eResolveProxy(oldMessage);
			if (message != oldMessage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystembehaviorPackage.SEND__MESSAGE, oldMessage, message));
			}
		}
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message basicGetMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(Message newMessage) {
		Message oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystembehaviorPackage.SEND__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {

		 try{
			  return getSource().getName()+" ---"+getMessage().getName()+"--->"+getTarget().getName();
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystembehaviorPackage.SEND__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageExchange getMessageExchangeRef() {
		if (messageExchangeRef != null && messageExchangeRef.eIsProxy()) {
			InternalEObject oldMessageExchangeRef = (InternalEObject)messageExchangeRef;
			messageExchangeRef = (MessageExchange)eResolveProxy(oldMessageExchangeRef);
			if (messageExchangeRef != oldMessageExchangeRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystembehaviorPackage.SEND__MESSAGE_EXCHANGE_REF, oldMessageExchangeRef, messageExchangeRef));
			}
		}
		return messageExchangeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageExchange basicGetMessageExchangeRef() {
		return messageExchangeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessageExchangeRef(MessageExchange newMessageExchangeRef) {
		MessageExchange oldMessageExchangeRef = messageExchangeRef;
		messageExchangeRef = newMessageExchangeRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystembehaviorPackage.SEND__MESSAGE_EXCHANGE_REF, oldMessageExchangeRef, messageExchangeRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SystembehaviorPackage.SEND__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case SystembehaviorPackage.SEND__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case SystembehaviorPackage.SEND__MESSAGE:
				if (resolve) return getMessage();
				return basicGetMessage();
			case SystembehaviorPackage.SEND__NAME:
				return getName();
			case SystembehaviorPackage.SEND__MESSAGE_EXCHANGE_REF:
				if (resolve) return getMessageExchangeRef();
				return basicGetMessageExchangeRef();
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
			case SystembehaviorPackage.SEND__SOURCE:
				setSource((Peer)newValue);
				return;
			case SystembehaviorPackage.SEND__TARGET:
				setTarget((Peer)newValue);
				return;
			case SystembehaviorPackage.SEND__MESSAGE:
				setMessage((Message)newValue);
				return;
			case SystembehaviorPackage.SEND__NAME:
				setName((String)newValue);
				return;
			case SystembehaviorPackage.SEND__MESSAGE_EXCHANGE_REF:
				setMessageExchangeRef((MessageExchange)newValue);
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
			case SystembehaviorPackage.SEND__SOURCE:
				setSource((Peer)null);
				return;
			case SystembehaviorPackage.SEND__TARGET:
				setTarget((Peer)null);
				return;
			case SystembehaviorPackage.SEND__MESSAGE:
				setMessage((Message)null);
				return;
			case SystembehaviorPackage.SEND__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SystembehaviorPackage.SEND__MESSAGE_EXCHANGE_REF:
				setMessageExchangeRef((MessageExchange)null);
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
			case SystembehaviorPackage.SEND__SOURCE:
				return source != null;
			case SystembehaviorPackage.SEND__TARGET:
				return target != null;
			case SystembehaviorPackage.SEND__MESSAGE:
				return message != null;
			case SystembehaviorPackage.SEND__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SystembehaviorPackage.SEND__MESSAGE_EXCHANGE_REF:
				return messageExchangeRef != null;
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
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //SendImpl
