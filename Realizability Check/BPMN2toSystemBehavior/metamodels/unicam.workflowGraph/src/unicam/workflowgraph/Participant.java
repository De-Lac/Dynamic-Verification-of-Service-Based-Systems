/**
 */
package unicam.workflowgraph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Participant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link unicam.workflowgraph.Participant#getName <em>Name</em>}</li>
 *   <li>{@link unicam.workflowgraph.Participant#getId <em>Id</em>}</li>
 *   <li>{@link unicam.workflowgraph.Participant#getParticipantRef <em>Participant Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see unicam.workflowgraph.WorkflowgraphPackage#getParticipant()
 * @model
 * @generated
 */
public interface Participant<P> extends EObject {
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
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getParticipant_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link unicam.workflowgraph.Participant#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Participant Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participant Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participant Ref</em>' reference.
	 * @see #setParticipantRef(org.eclipse.bpmn2.Participant)
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getParticipant_ParticipantRef()
	 * @model
	 * @generated
	 */
	org.eclipse.bpmn2.Participant getParticipantRef();

	/**
	 * Sets the value of the '{@link unicam.workflowgraph.Participant#getParticipantRef <em>Participant Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Participant Ref</em>' reference.
	 * @see #getParticipantRef()
	 * @generated
	 */
	void setParticipantRef(org.eclipse.bpmn2.Participant value);

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
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getParticipant_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link unicam.workflowgraph.Participant#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // Participant
