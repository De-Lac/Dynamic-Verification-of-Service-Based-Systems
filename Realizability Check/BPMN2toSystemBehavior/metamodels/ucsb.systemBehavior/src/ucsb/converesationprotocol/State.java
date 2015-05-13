/**
 */
package ucsb.converesationprotocol;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ucsb.converesationprotocol.State#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link ucsb.converesationprotocol.State#getIncoming <em>Incoming</em>}</li>
 * </ul>
 * </p>
 *
 * @see ucsb.converesationprotocol.ConveresationprotocolPackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject {
	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference.
	 * @see #setOutgoing(Message)
	 * @see ucsb.converesationprotocol.ConveresationprotocolPackage#getState_Outgoing()
	 * @model
	 * @generated
	 */
	Message getOutgoing();

	/**
	 * Sets the value of the '{@link ucsb.converesationprotocol.State#getOutgoing <em>Outgoing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outgoing</em>' reference.
	 * @see #getOutgoing()
	 * @generated
	 */
	void setOutgoing(Message value);

	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference.
	 * @see #setIncoming(Message)
	 * @see ucsb.converesationprotocol.ConveresationprotocolPackage#getState_Incoming()
	 * @model
	 * @generated
	 */
	Message getIncoming();

	/**
	 * Sets the value of the '{@link ucsb.converesationprotocol.State#getIncoming <em>Incoming</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incoming</em>' reference.
	 * @see #getIncoming()
	 * @generated
	 */
	void setIncoming(Message value);

} // State
