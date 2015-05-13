/**
 */
package ucsb.peerbehavior;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import unicam.workflowgraph.Participant;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Peer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ucsb.peerbehavior.Peer#getIn <em>In</em>}</li>
 *   <li>{@link ucsb.peerbehavior.Peer#getOut <em>Out</em>}</li>
 *   <li>{@link ucsb.peerbehavior.Peer#getStates <em>States</em>}</li>
 *   <li>{@link ucsb.peerbehavior.Peer#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link ucsb.peerbehavior.Peer#getName <em>Name</em>}</li>
 *   <li>{@link ucsb.peerbehavior.Peer#getTransictions <em>Transictions</em>}</li>
 *   <li>{@link ucsb.peerbehavior.Peer#getId <em>Id</em>}</li>
 *   <li>{@link ucsb.peerbehavior.Peer#getTest <em>Test</em>}</li>
 *   <li>{@link ucsb.peerbehavior.Peer#getParticipantRef <em>Participant Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see ucsb.peerbehavior.PeerbehaviorPackage#getPeer()
 * @model
 * @generated
 */
public interface Peer extends EObject {
	/**
	 * Returns the value of the '<em><b>In</b></em>' containment reference list.
	 * The list contents are of type {@link ucsb.peerbehavior.input}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In</em>' containment reference list.
	 * @see ucsb.peerbehavior.PeerbehaviorPackage#getPeer_In()
	 * @model containment="true" keys="name"
	 * @generated
	 */
	EList<input> getIn();

	/**
	 * Returns the value of the '<em><b>Out</b></em>' containment reference list.
	 * The list contents are of type {@link ucsb.peerbehavior.output}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out</em>' containment reference list.
	 * @see ucsb.peerbehavior.PeerbehaviorPackage#getPeer_Out()
	 * @model containment="true" keys="name"
	 * @generated
	 */
	EList<output> getOut();

	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link ucsb.peerbehavior.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see ucsb.peerbehavior.PeerbehaviorPackage#getPeer_States()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getStates();

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
	 * @see ucsb.peerbehavior.PeerbehaviorPackage#getPeer_InitialState()
	 * @model required="true"
	 * @generated
	 */
	State getInitialState();

	/**
	 * Sets the value of the '{@link ucsb.peerbehavior.Peer#getInitialState <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial State</em>' reference.
	 * @see #getInitialState()
	 * @generated
	 */
	void setInitialState(State value);

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
	 * @see ucsb.peerbehavior.PeerbehaviorPackage#getPeer_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ucsb.peerbehavior.Peer#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Transictions</b></em>' containment reference list.
	 * The list contents are of type {@link ucsb.peerbehavior.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transictions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transictions</em>' containment reference list.
	 * @see ucsb.peerbehavior.PeerbehaviorPackage#getPeer_Transictions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Transition> getTransictions();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see ucsb.peerbehavior.PeerbehaviorPackage#getPeer_Id()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link ucsb.peerbehavior.Peer#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Test</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test</em>' attribute.
	 * @see #setTest(int)
	 * @see ucsb.peerbehavior.PeerbehaviorPackage#getPeer_Test()
	 * @model default="0"
	 * @generated
	 */
	int getTest();

	/**
	 * Sets the value of the '{@link ucsb.peerbehavior.Peer#getTest <em>Test</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test</em>' attribute.
	 * @see #getTest()
	 * @generated
	 */
	void setTest(int value);

	/**
	 * Returns the value of the '<em><b>Participant Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participant Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participant Ref</em>' reference.
	 * @see #setParticipantRef(Participant)
	 * @see ucsb.peerbehavior.PeerbehaviorPackage#getPeer_ParticipantRef()
	 * @model
	 * @generated
	 */
	Participant getParticipantRef();

	/**
	 * Sets the value of the '{@link ucsb.peerbehavior.Peer#getParticipantRef <em>Participant Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Participant Ref</em>' reference.
	 * @see #getParticipantRef()
	 * @generated
	 */
	void setParticipantRef(Participant value);

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

} // Peer
