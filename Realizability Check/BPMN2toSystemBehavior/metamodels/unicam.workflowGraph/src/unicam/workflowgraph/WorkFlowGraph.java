/**
 */
package unicam.workflowgraph;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Work Flow Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link unicam.workflowgraph.WorkFlowGraph#getGateways <em>Gateways</em>}</li>
 *   <li>{@link unicam.workflowgraph.WorkFlowGraph#getStartingNode <em>Starting Node</em>}</li>
 *   <li>{@link unicam.workflowgraph.WorkFlowGraph#getEndingNode <em>Ending Node</em>}</li>
 *   <li>{@link unicam.workflowgraph.WorkFlowGraph#getActions <em>Actions</em>}</li>
 *   <li>{@link unicam.workflowgraph.WorkFlowGraph#getParticipants <em>Participants</em>}</li>
 *   <li>{@link unicam.workflowgraph.WorkFlowGraph#getInnerGateway <em>Inner Gateway</em>}</li>
 * </ul>
 * </p>
 *
 * @see unicam.workflowgraph.WorkflowgraphPackage#getWorkFlowGraph()
 * @model
 * @generated
 */
public interface WorkFlowGraph extends EObject {
	/**
	 * Returns the value of the '<em><b>Gateways</b></em>' containment reference list.
	 * The list contents are of type {@link unicam.workflowgraph.Gateway}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gateways</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gateways</em>' containment reference list.
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getWorkFlowGraph_Gateways()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Gateway> getGateways();

	/**
	 * Returns the value of the '<em><b>Starting Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Starting Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Starting Node</em>' reference.
	 * @see #isSetStartingNode()
	 * @see #unsetStartingNode()
	 * @see #setStartingNode(WfgNode)
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getWorkFlowGraph_StartingNode()
	 * @model unsettable="true" required="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	WfgNode getStartingNode();

	/**
	 * Sets the value of the '{@link unicam.workflowgraph.WorkFlowGraph#getStartingNode <em>Starting Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Starting Node</em>' reference.
	 * @see #isSetStartingNode()
	 * @see #unsetStartingNode()
	 * @see #getStartingNode()
	 * @generated
	 */
	void setStartingNode(WfgNode value);

	/**
	 * Unsets the value of the '{@link unicam.workflowgraph.WorkFlowGraph#getStartingNode <em>Starting Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStartingNode()
	 * @see #getStartingNode()
	 * @see #setStartingNode(WfgNode)
	 * @generated
	 */
	void unsetStartingNode();

	/**
	 * Returns whether the value of the '{@link unicam.workflowgraph.WorkFlowGraph#getStartingNode <em>Starting Node</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Starting Node</em>' reference is set.
	 * @see #unsetStartingNode()
	 * @see #getStartingNode()
	 * @see #setStartingNode(WfgNode)
	 * @generated
	 */
	boolean isSetStartingNode();

	/**
	 * Returns the value of the '<em><b>Ending Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ending Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ending Node</em>' reference.
	 * @see #isSetEndingNode()
	 * @see #unsetEndingNode()
	 * @see #setEndingNode(WfgNode)
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getWorkFlowGraph_EndingNode()
	 * @model unsettable="true" required="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	WfgNode getEndingNode();

	/**
	 * Sets the value of the '{@link unicam.workflowgraph.WorkFlowGraph#getEndingNode <em>Ending Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ending Node</em>' reference.
	 * @see #isSetEndingNode()
	 * @see #unsetEndingNode()
	 * @see #getEndingNode()
	 * @generated
	 */
	void setEndingNode(WfgNode value);

	/**
	 * Unsets the value of the '{@link unicam.workflowgraph.WorkFlowGraph#getEndingNode <em>Ending Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEndingNode()
	 * @see #getEndingNode()
	 * @see #setEndingNode(WfgNode)
	 * @generated
	 */
	void unsetEndingNode();

	/**
	 * Returns whether the value of the '{@link unicam.workflowgraph.WorkFlowGraph#getEndingNode <em>Ending Node</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ending Node</em>' reference is set.
	 * @see #unsetEndingNode()
	 * @see #getEndingNode()
	 * @see #setEndingNode(WfgNode)
	 * @generated
	 */
	boolean isSetEndingNode();

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link unicam.workflowgraph.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getWorkFlowGraph_Actions()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<Action> getActions();

	/**
	 * Returns the value of the '<em><b>Participants</b></em>' containment reference list.
	 * The list contents are of type {@link unicam.workflowgraph.Participant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participants</em>' containment reference list.
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getWorkFlowGraph_Participants()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<Participant> getParticipants();

	/**
	 * Returns the value of the '<em><b>Inner Gateway</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Gateway</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Gateway</em>' reference.
	 * @see #isSetInnerGateway()
	 * @see #unsetInnerGateway()
	 * @see #setInnerGateway(Gateway)
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getWorkFlowGraph_InnerGateway()
	 * @model unsettable="true" volatile="true" derived="true"
	 * @generated
	 */
	Gateway getInnerGateway();

	/**
	 * Sets the value of the '{@link unicam.workflowgraph.WorkFlowGraph#getInnerGateway <em>Inner Gateway</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Gateway</em>' reference.
	 * @see #isSetInnerGateway()
	 * @see #unsetInnerGateway()
	 * @see #getInnerGateway()
	 * @generated
	 */
	void setInnerGateway(Gateway value);

	/**
	 * Unsets the value of the '{@link unicam.workflowgraph.WorkFlowGraph#getInnerGateway <em>Inner Gateway</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInnerGateway()
	 * @see #getInnerGateway()
	 * @see #setInnerGateway(Gateway)
	 * @generated
	 */
	void unsetInnerGateway();

	/**
	 * Returns whether the value of the '{@link unicam.workflowgraph.WorkFlowGraph#getInnerGateway <em>Inner Gateway</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Inner Gateway</em>' reference is set.
	 * @see #unsetInnerGateway()
	 * @see #getInnerGateway()
	 * @see #setInnerGateway(Gateway)
	 * @generated
	 */
	boolean isSetInnerGateway();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * It should be called just after the transformation of model to a WFG, when all the nodes have been already loaded. (it should be automatically called in an ATL rule). 
	 * It links starting gateways to endings and viceversa, and load branches in gateways as sequence of nodes
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void initialize();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean removeNode(WfgNode node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean addNode(WfgNode node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	ExclusiveChoice createNewExclusiveChoice(String name, boolean merge, boolean fork);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	ParallelExecution createNewParallelExecution(String name, boolean merge, boolean fork);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" nodesMany="false"
	 * @generated NOT
	 */
	boolean removeNodes(EList<WfgNode> nodes);

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
	 * @model required="true"
	 * @generated
	 */
	MessageExchange createNewMessageExchange(String name, String request, String response, Participant sender, Participant receiver);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void saveModel(String filename);

} // WorkFlowGraph
