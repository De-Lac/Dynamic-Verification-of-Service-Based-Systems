/**
 */
package ucsb.converesationprotocol;

import org.eclipse.emf.ecore.EObject;

import ucsb.peerbehavior.Peer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ucsb.converesationprotocol.Message#getSource <em>Source</em>}</li>
 *   <li>{@link ucsb.converesationprotocol.Message#getTarget <em>Target</em>}</li>
 *   <li>{@link ucsb.converesationprotocol.Message#getSender <em>Sender</em>}</li>
 *   <li>{@link ucsb.converesationprotocol.Message#getReceiver <em>Receiver</em>}</li>
 * </ul>
 * </p>
 *
 * @see ucsb.converesationprotocol.ConveresationprotocolPackage#getMessage()
 * @model
 * @generated
 */
public interface Message extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(State)
	 * @see ucsb.converesationprotocol.ConveresationprotocolPackage#getMessage_Source()
	 * @model
	 * @generated
	 */
	State getSource();

	/**
	 * Sets the value of the '{@link ucsb.converesationprotocol.Message#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(State value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(State)
	 * @see ucsb.converesationprotocol.ConveresationprotocolPackage#getMessage_Target()
	 * @model
	 * @generated
	 */
	State getTarget();

	/**
	 * Sets the value of the '{@link ucsb.converesationprotocol.Message#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(State value);

	/**
	 * Returns the value of the '<em><b>Sender</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sender</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sender</em>' reference.
	 * @see #setSender(Peer)
	 * @see ucsb.converesationprotocol.ConveresationprotocolPackage#getMessage_Sender()
	 * @model required="true"
	 * @generated
	 */
	Peer getSender();

	/**
	 * Sets the value of the '{@link ucsb.converesationprotocol.Message#getSender <em>Sender</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sender</em>' reference.
	 * @see #getSender()
	 * @generated
	 */
	void setSender(Peer value);

	/**
	 * Returns the value of the '<em><b>Receiver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receiver</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receiver</em>' reference.
	 * @see #setReceiver(Peer)
	 * @see ucsb.converesationprotocol.ConveresationprotocolPackage#getMessage_Receiver()
	 * @model required="true"
	 * @generated
	 */
	Peer getReceiver();

	/**
	 * Sets the value of the '{@link ucsb.converesationprotocol.Message#getReceiver <em>Receiver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Receiver</em>' reference.
	 * @see #getReceiver()
	 * @generated
	 */
	void setReceiver(Peer value);

} // Message
