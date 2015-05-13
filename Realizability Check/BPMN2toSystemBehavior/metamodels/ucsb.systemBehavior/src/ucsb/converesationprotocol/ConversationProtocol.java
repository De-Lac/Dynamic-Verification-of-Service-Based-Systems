/**
 */
package ucsb.converesationprotocol;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conversation Protocol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ucsb.converesationprotocol.ConversationProtocol#getStates <em>States</em>}</li>
 *   <li>{@link ucsb.converesationprotocol.ConversationProtocol#getMessages <em>Messages</em>}</li>
 *   <li>{@link ucsb.converesationprotocol.ConversationProtocol#getInitialState <em>Initial State</em>}</li>
 * </ul>
 * </p>
 *
 * @see ucsb.converesationprotocol.ConveresationprotocolPackage#getConversationProtocol()
 * @model
 * @generated
 */
public interface ConversationProtocol extends EObject {
	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link ucsb.converesationprotocol.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see ucsb.converesationprotocol.ConveresationprotocolPackage#getConversationProtocol_States()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<State> getStates();

	/**
	 * Returns the value of the '<em><b>Messages</b></em>' containment reference list.
	 * The list contents are of type {@link ucsb.converesationprotocol.Message}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Messages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Messages</em>' containment reference list.
	 * @see ucsb.converesationprotocol.ConveresationprotocolPackage#getConversationProtocol_Messages()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Message> getMessages();

	/**
	 * Returns the value of the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial State</em>' reference.
	 * @see #setInitialState(State)
	 * @see ucsb.converesationprotocol.ConveresationprotocolPackage#getConversationProtocol_InitialState()
	 * @model required="true"
	 * @generated
	 */
	State getInitialState();

	/**
	 * Sets the value of the '{@link ucsb.converesationprotocol.ConversationProtocol#getInitialState <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial State</em>' reference.
	 * @see #getInitialState()
	 * @generated
	 */
	void setInitialState(State value);

} // ConversationProtocol
