/**
 */
package unicam.workflowgraph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gateway</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * the name of the relatives fork and merge should be THE SAME
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link unicam.workflowgraph.Gateway#isFork <em>Fork</em>}</li>
 *   <li>{@link unicam.workflowgraph.Gateway#isMerge <em>Merge</em>}</li>
 *   <li>{@link unicam.workflowgraph.Gateway#getRefMerge <em>Ref Merge</em>}</li>
 *   <li>{@link unicam.workflowgraph.Gateway#getRefFork <em>Ref Fork</em>}</li>
 *   <li>{@link unicam.workflowgraph.Gateway#getPredecessors <em>Predecessors</em>}</li>
 *   <li>{@link unicam.workflowgraph.Gateway#getSuccessors <em>Successors</em>}</li>
 *   <li>{@link unicam.workflowgraph.Gateway#getGatewayRef <em>Gateway Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see unicam.workflowgraph.WorkflowgraphPackage#getGateway()
 * @model abstract="true"
 * @generated
 */
public interface Gateway extends WfgNode {
	/**
	 * Returns the value of the '<em><b>Fork</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * should be true if the gateway is a starting one.
	 * if it's true, merge should be false.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fork</em>' attribute.
	 * @see #setFork(boolean)
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getGateway_Fork()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isFork();

	/**
	 * Sets the value of the '{@link unicam.workflowgraph.Gateway#isFork <em>Fork</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fork</em>' attribute.
	 * @see #isFork()
	 * @generated
	 */
	void setFork(boolean value);

	/**
	 * Returns the value of the '<em><b>Merge</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * should be true if the gateway is an ending one.
	 * if it's true, fork should be false.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Merge</em>' attribute.
	 * @see #setMerge(boolean)
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getGateway_Merge()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isMerge();

	/**
	 * Sets the value of the '{@link unicam.workflowgraph.Gateway#isMerge <em>Merge</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Merge</em>' attribute.
	 * @see #isMerge()
	 * @generated
	 */
	void setMerge(boolean value);

	/**
	 * Returns the value of the '<em><b>Ref Merge</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link unicam.workflowgraph.Gateway#getRefFork <em>Ref Fork</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Merge</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Merge</em>' reference.
	 * @see #setRefMerge(Gateway)
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getGateway_RefMerge()
	 * @see unicam.workflowgraph.Gateway#getRefFork
	 * @model opposite="refFork" required="true"
	 * @generated
	 */
	Gateway getRefMerge();

	/**
	 * Sets the value of the '{@link unicam.workflowgraph.Gateway#getRefMerge <em>Ref Merge</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Merge</em>' reference.
	 * @throws NullPointerException 
	 * @see #getRefMerge()
	 * @generated NOT
	 */
	void setRefMerge(Gateway value) throws NullPointerException;

	/**
	 * Returns the value of the '<em><b>Ref Fork</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link unicam.workflowgraph.Gateway#getRefMerge <em>Ref Merge</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Fork</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Fork</em>' reference.
	 * @see #setRefFork(Gateway)
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getGateway_RefFork()
	 * @see unicam.workflowgraph.Gateway#getRefMerge
	 * @model opposite="refMerge" required="true"
	 * @generated
	 */
	Gateway getRefFork();

	/**
	 * Sets the value of the '{@link unicam.workflowgraph.Gateway#getRefFork <em>Ref Fork</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Fork</em>' reference.
	 * @throws NullPointerException 
	 * @see #getRefFork()
	 * @generated NOT
	 */
	void setRefFork(Gateway value) throws NullPointerException;

	/**
	 * Returns the value of the '<em><b>Successors</b></em>' reference list.
	 * The list contents are of type {@link unicam.workflowgraph.WfgNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successors</em>' reference list.
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getGateway_Successors()
	 * @model
	 * @generated
	 */
	EList<WfgNode> getSuccessors();

	/**
	 * Returns the value of the '<em><b>Gateway Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gateway Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gateway Ref</em>' reference.
	 * @see #setGatewayRef(org.eclipse.bpmn2.Gateway)
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getGateway_GatewayRef()
	 * @model
	 * @generated
	 */
	org.eclipse.bpmn2.Gateway getGatewayRef();

	/**
	 * Sets the value of the '{@link unicam.workflowgraph.Gateway#getGatewayRef <em>Gateway Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gateway Ref</em>' reference.
	 * @see #getGatewayRef()
	 * @generated
	 */
	void setGatewayRef(org.eclipse.bpmn2.Gateway value);

	/**
	 * Returns the value of the '<em><b>Predecessors</b></em>' reference list.
	 * The list contents are of type {@link unicam.workflowgraph.WfgNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predecessors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predecessors</em>' reference list.
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getGateway_Predecessors()
	 * @model ordered="false"
	 * @generated
	 */
	EList<WfgNode> getPredecessors();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branches</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	EList<Branch> getBranches();

} // Gateway
