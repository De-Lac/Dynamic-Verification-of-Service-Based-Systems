/**
 */
package unicam.workflowgraph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Branch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * a list of nodes, that constitutes a branch of a gateway. the predecessor of the first node is the starting gateway. The successor of the last node of the branch is the closing gateway.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link unicam.workflowgraph.Branch#getNodes <em>Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see unicam.workflowgraph.WorkflowgraphPackage#getBranch()
 * @model
 * @generated
 */
public interface Branch extends EObject {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' reference list.
	 * The list contents are of type {@link unicam.workflowgraph.WfgNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' reference list.
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getBranch_Nodes()
	 * @model
	 * @generated
	 */
	EList<WfgNode> getNodes();

} // Branch
