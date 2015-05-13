/**
 */
package ucsb.systembehavior;

import ucsb.peerbehavior.Message;
import ucsb.peerbehavior.Peer;
import unicam.workflowgraph.MessageExchange;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Send</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ucsb.systembehavior.Send#getSource <em>Source</em>}</li>
 *   <li>{@link ucsb.systembehavior.Send#getTarget <em>Target</em>}</li>
 *   <li>{@link ucsb.systembehavior.Send#getMessage <em>Message</em>}</li>
 *   <li>{@link ucsb.systembehavior.Send#getName <em>Name</em>}</li>
 *   <li>{@link ucsb.systembehavior.Send#getMessageExchangeRef <em>Message Exchange Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see ucsb.systembehavior.SystembehaviorPackage#getSend()
 * @model
 * @generated
 */
public interface Send extends Transition {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Peer)
	 * @see ucsb.systembehavior.SystembehaviorPackage#getSend_Source()
	 * @model required="true"
	 * @generated
	 */
	Peer getSource();

	/**
	 * Sets the value of the '{@link ucsb.systembehavior.Send#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Peer value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Peer)
	 * @see ucsb.systembehavior.SystembehaviorPackage#getSend_Target()
	 * @model required="true"
	 * @generated
	 */
	Peer getTarget();

	/**
	 * Sets the value of the '{@link ucsb.systembehavior.Send#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Peer value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' reference.
	 * @see #setMessage(Message)
	 * @see ucsb.systembehavior.SystembehaviorPackage#getSend_Message()
	 * @model required="true"
	 * @generated
	 */
	Message getMessage();

	/**
	 * Sets the value of the '{@link ucsb.systembehavior.Send#getMessage <em>Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' reference.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(Message value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see ucsb.systembehavior.SystembehaviorPackage#getSend_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ucsb.systembehavior.Send#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Message Exchange Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Exchange Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Exchange Ref</em>' reference.
	 * @see #setMessageExchangeRef(MessageExchange)
	 * @see ucsb.systembehavior.SystembehaviorPackage#getSend_MessageExchangeRef()
	 * @model extendedMetaData="name='messageExchangeRef'"
	 * @generated
	 */
	MessageExchange getMessageExchangeRef();

	/**
	 * Sets the value of the '{@link ucsb.systembehavior.Send#getMessageExchangeRef <em>Message Exchange Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Exchange Ref</em>' reference.
	 * @see #getMessageExchangeRef()
	 * @generated
	 */
	void setMessageExchangeRef(MessageExchange value);

} // Send
