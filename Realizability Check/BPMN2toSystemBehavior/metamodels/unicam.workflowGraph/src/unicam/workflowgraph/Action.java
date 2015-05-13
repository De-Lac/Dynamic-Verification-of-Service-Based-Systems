/**
 */
package unicam.workflowgraph;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The action rapresented by the node. This is an simplified class of the real action, pointed by refObject.
 * For instance...  let's take the ChoreographyTask. This model rapresents it with the class MessageExchange where there are the sender, receiver and req&resp. Anyway the real object ChoreographyTask is pointed by refObject
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link unicam.workflowgraph.Action#getSuccessor <em>Successor</em>}</li>
 *   <li>{@link unicam.workflowgraph.Action#getPredecessor <em>Predecessor</em>}</li>
 * </ul>
 * </p>
 *
 * @see unicam.workflowgraph.WorkflowgraphPackage#getAction()
 * @model abstract="true"
 * @generated
 */
public interface Action<GenericType> extends WfgNode {
	/**
	 * Returns the value of the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successor</em>' reference.
	 * @see #setSuccessor(WfgNode)
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getAction_Successor()
	 * @model ordered="false"
	 * @generated
	 */
	WfgNode getSuccessor();

	/**
	 * Sets the value of the '{@link unicam.workflowgraph.Action#getSuccessor <em>Successor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Successor</em>' reference.
	 * @see #getSuccessor()
	 * @generated
	 */
	void setSuccessor(WfgNode value);

	/**
	 * Returns the value of the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predecessor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predecessor</em>' reference.
	 * @see #setPredecessor(WfgNode)
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getAction_Predecessor()
	 * @model ordered="false"
	 * @generated
	 */
	WfgNode getPredecessor();

	/**
	 * Sets the value of the '{@link unicam.workflowgraph.Action#getPredecessor <em>Predecessor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predecessor</em>' reference.
	 * @see #getPredecessor()
	 * @generated
	 */
	void setPredecessor(WfgNode value);

} // Action
