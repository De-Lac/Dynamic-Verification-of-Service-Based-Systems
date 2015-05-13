/**
 */
package ucsb.systembehavior;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import ucsb.peerbehavior.Message;
import ucsb.peerbehavior.Peer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ucsb.systembehavior.SystemBehavior#getPeers <em>Peers</em>}</li>
 *   <li>{@link ucsb.systembehavior.SystemBehavior#getMessages <em>Messages</em>}</li>
 *   <li>{@link ucsb.systembehavior.SystemBehavior#getStates <em>States</em>}</li>
 *   <li>{@link ucsb.systembehavior.SystemBehavior#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link ucsb.systembehavior.SystemBehavior#getInitialState <em>Initial State</em>}</li>
 * </ul>
 * </p>
 *
 * @see ucsb.systembehavior.SystembehaviorPackage#getSystemBehavior()
 * @model
 * @generated
 */
public interface SystemBehavior extends EObject {
	/**
	 * Returns the value of the '<em><b>Peers</b></em>' reference list.
	 * The list contents are of type {@link ucsb.peerbehavior.Peer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Peers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Peers</em>' reference list.
	 * @see ucsb.systembehavior.SystembehaviorPackage#getSystemBehavior_Peers()
	 * @model required="true"
	 * @generated
	 */
	EList<Peer> getPeers();

	/**
	 * Returns the value of the '<em><b>Messages</b></em>' reference list.
	 * The list contents are of type {@link ucsb.peerbehavior.Message}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Messages</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Messages</em>' reference list.
	 * @see ucsb.systembehavior.SystembehaviorPackage#getSystemBehavior_Messages()
	 * @model
	 * @generated
	 */
	EList<Message> getMessages();

	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link ucsb.systembehavior.PeerSituation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see ucsb.systembehavior.SystembehaviorPackage#getSystemBehavior_States()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<PeerSituation> getStates();

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link ucsb.systembehavior.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see ucsb.systembehavior.SystembehaviorPackage#getSystemBehavior_Transitions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Transition> getTransitions();

	/**
	 * Returns the value of the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial State</em>' reference.
	 * @see #setInitialState(PeerSituation)
	 * @see ucsb.systembehavior.SystembehaviorPackage#getSystemBehavior_InitialState()
	 * @model required="true"
	 * @generated
	 */
	PeerSituation getInitialState();

	/**
	 * Sets the value of the '{@link ucsb.systembehavior.SystemBehavior#getInitialState <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial State</em>' reference.
	 * @see #getInitialState()
	 * @generated
	 */
	void setInitialState(PeerSituation value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	String toDOTforGraphViz();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void saveModel(String fileName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void deleteInternalTransition();

} // SystemBehavior
