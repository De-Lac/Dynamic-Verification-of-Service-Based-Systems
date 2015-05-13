/**
 */
package unicam.workflowgraph;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see unicam.workflowgraph.WorkflowgraphFactory
 * @model kind="package"
 * @generated
 */
public interface WorkflowgraphPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "workflowgraph";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://workflowgraph/1.0.4";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WorkflowgraphPackage eINSTANCE = unicam.workflowgraph.impl.WorkflowgraphPackageImpl.init();

	/**
	 * The meta object id for the '{@link unicam.workflowgraph.impl.WfgNodeImpl <em>Wfg Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unicam.workflowgraph.impl.WfgNodeImpl
	 * @see unicam.workflowgraph.impl.WorkflowgraphPackageImpl#getWfgNode()
	 * @generated
	 */
	int WFG_NODE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WFG_NODE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WFG_NODE__ID = 1;

	/**
	 * The number of structural features of the '<em>Wfg Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WFG_NODE_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Add set successor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WFG_NODE___ADD_SET_SUCCESSOR__WFGNODE = 0;

	/**
	 * The operation id for the '<em>Add set predecessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WFG_NODE___ADD_SET_PREDECESSOR__WFGNODE = 1;

	/**
	 * The operation id for the '<em>Remove unset successor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WFG_NODE___REMOVE_UNSET_SUCCESSOR__WFGNODE = 2;

	/**
	 * The operation id for the '<em>Remove unset predecessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WFG_NODE___REMOVE_UNSET_PREDECESSOR__WFGNODE = 3;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WFG_NODE___CLONE = 4;

	/**
	 * The number of operations of the '<em>Wfg Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WFG_NODE_OPERATION_COUNT = 5;

	/**
	 * The meta object id for the '{@link unicam.workflowgraph.impl.GatewayImpl <em>Gateway</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unicam.workflowgraph.impl.GatewayImpl
	 * @see unicam.workflowgraph.impl.WorkflowgraphPackageImpl#getGateway()
	 * @generated
	 */
	int GATEWAY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__NAME = WFG_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__ID = WFG_NODE__ID;

	/**
	 * The feature id for the '<em><b>Fork</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__FORK = WFG_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Merge</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__MERGE = WFG_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ref Merge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__REF_MERGE = WFG_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ref Fork</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__REF_FORK = WFG_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Predecessors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__PREDECESSORS = WFG_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Successors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__SUCCESSORS = WFG_NODE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Gateway Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__GATEWAY_REF = WFG_NODE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Gateway</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY_FEATURE_COUNT = WFG_NODE_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>Add set successor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY___ADD_SET_SUCCESSOR__WFGNODE = WFG_NODE___ADD_SET_SUCCESSOR__WFGNODE;

	/**
	 * The operation id for the '<em>Add set predecessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY___ADD_SET_PREDECESSOR__WFGNODE = WFG_NODE___ADD_SET_PREDECESSOR__WFGNODE;

	/**
	 * The operation id for the '<em>Remove unset successor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY___REMOVE_UNSET_SUCCESSOR__WFGNODE = WFG_NODE___REMOVE_UNSET_SUCCESSOR__WFGNODE;

	/**
	 * The operation id for the '<em>Remove unset predecessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY___REMOVE_UNSET_PREDECESSOR__WFGNODE = WFG_NODE___REMOVE_UNSET_PREDECESSOR__WFGNODE;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY___CLONE = WFG_NODE___CLONE;

	/**
	 * The operation id for the '<em>Get Branches</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY___GET_BRANCHES = WFG_NODE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Gateway</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY_OPERATION_COUNT = WFG_NODE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link unicam.workflowgraph.impl.ExclusiveChoiceImpl <em>Exclusive Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unicam.workflowgraph.impl.ExclusiveChoiceImpl
	 * @see unicam.workflowgraph.impl.WorkflowgraphPackageImpl#getExclusiveChoice()
	 * @generated
	 */
	int EXCLUSIVE_CHOICE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_CHOICE__NAME = GATEWAY__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_CHOICE__ID = GATEWAY__ID;

	/**
	 * The feature id for the '<em><b>Fork</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_CHOICE__FORK = GATEWAY__FORK;

	/**
	 * The feature id for the '<em><b>Merge</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_CHOICE__MERGE = GATEWAY__MERGE;

	/**
	 * The feature id for the '<em><b>Ref Merge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_CHOICE__REF_MERGE = GATEWAY__REF_MERGE;

	/**
	 * The feature id for the '<em><b>Ref Fork</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_CHOICE__REF_FORK = GATEWAY__REF_FORK;

	/**
	 * The feature id for the '<em><b>Predecessors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_CHOICE__PREDECESSORS = GATEWAY__PREDECESSORS;

	/**
	 * The feature id for the '<em><b>Successors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_CHOICE__SUCCESSORS = GATEWAY__SUCCESSORS;

	/**
	 * The feature id for the '<em><b>Gateway Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_CHOICE__GATEWAY_REF = GATEWAY__GATEWAY_REF;

	/**
	 * The number of structural features of the '<em>Exclusive Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_CHOICE_FEATURE_COUNT = GATEWAY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Add set successor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_CHOICE___ADD_SET_SUCCESSOR__WFGNODE = GATEWAY___ADD_SET_SUCCESSOR__WFGNODE;

	/**
	 * The operation id for the '<em>Add set predecessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_CHOICE___ADD_SET_PREDECESSOR__WFGNODE = GATEWAY___ADD_SET_PREDECESSOR__WFGNODE;

	/**
	 * The operation id for the '<em>Remove unset successor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_CHOICE___REMOVE_UNSET_SUCCESSOR__WFGNODE = GATEWAY___REMOVE_UNSET_SUCCESSOR__WFGNODE;

	/**
	 * The operation id for the '<em>Remove unset predecessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_CHOICE___REMOVE_UNSET_PREDECESSOR__WFGNODE = GATEWAY___REMOVE_UNSET_PREDECESSOR__WFGNODE;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_CHOICE___CLONE = GATEWAY___CLONE;

	/**
	 * The operation id for the '<em>Get Branches</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_CHOICE___GET_BRANCHES = GATEWAY___GET_BRANCHES;

	/**
	 * The number of operations of the '<em>Exclusive Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_CHOICE_OPERATION_COUNT = GATEWAY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link unicam.workflowgraph.impl.ParallelExecutionImpl <em>Parallel Execution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unicam.workflowgraph.impl.ParallelExecutionImpl
	 * @see unicam.workflowgraph.impl.WorkflowgraphPackageImpl#getParallelExecution()
	 * @generated
	 */
	int PARALLEL_EXECUTION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_EXECUTION__NAME = GATEWAY__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_EXECUTION__ID = GATEWAY__ID;

	/**
	 * The feature id for the '<em><b>Fork</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_EXECUTION__FORK = GATEWAY__FORK;

	/**
	 * The feature id for the '<em><b>Merge</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_EXECUTION__MERGE = GATEWAY__MERGE;

	/**
	 * The feature id for the '<em><b>Ref Merge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_EXECUTION__REF_MERGE = GATEWAY__REF_MERGE;

	/**
	 * The feature id for the '<em><b>Ref Fork</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_EXECUTION__REF_FORK = GATEWAY__REF_FORK;

	/**
	 * The feature id for the '<em><b>Predecessors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_EXECUTION__PREDECESSORS = GATEWAY__PREDECESSORS;

	/**
	 * The feature id for the '<em><b>Successors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_EXECUTION__SUCCESSORS = GATEWAY__SUCCESSORS;

	/**
	 * The feature id for the '<em><b>Gateway Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_EXECUTION__GATEWAY_REF = GATEWAY__GATEWAY_REF;

	/**
	 * The number of structural features of the '<em>Parallel Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_EXECUTION_FEATURE_COUNT = GATEWAY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Add set successor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_EXECUTION___ADD_SET_SUCCESSOR__WFGNODE = GATEWAY___ADD_SET_SUCCESSOR__WFGNODE;

	/**
	 * The operation id for the '<em>Add set predecessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_EXECUTION___ADD_SET_PREDECESSOR__WFGNODE = GATEWAY___ADD_SET_PREDECESSOR__WFGNODE;

	/**
	 * The operation id for the '<em>Remove unset successor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_EXECUTION___REMOVE_UNSET_SUCCESSOR__WFGNODE = GATEWAY___REMOVE_UNSET_SUCCESSOR__WFGNODE;

	/**
	 * The operation id for the '<em>Remove unset predecessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_EXECUTION___REMOVE_UNSET_PREDECESSOR__WFGNODE = GATEWAY___REMOVE_UNSET_PREDECESSOR__WFGNODE;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_EXECUTION___CLONE = GATEWAY___CLONE;

	/**
	 * The operation id for the '<em>Get Branches</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_EXECUTION___GET_BRANCHES = GATEWAY___GET_BRANCHES;

	/**
	 * The number of operations of the '<em>Parallel Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_EXECUTION_OPERATION_COUNT = GATEWAY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link unicam.workflowgraph.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unicam.workflowgraph.impl.ActionImpl
	 * @see unicam.workflowgraph.impl.WorkflowgraphPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NAME = WFG_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__ID = WFG_NODE__ID;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__SUCCESSOR = WFG_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__PREDECESSOR = WFG_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = WFG_NODE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Add set successor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION___ADD_SET_SUCCESSOR__WFGNODE = WFG_NODE___ADD_SET_SUCCESSOR__WFGNODE;

	/**
	 * The operation id for the '<em>Add set predecessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION___ADD_SET_PREDECESSOR__WFGNODE = WFG_NODE___ADD_SET_PREDECESSOR__WFGNODE;

	/**
	 * The operation id for the '<em>Remove unset successor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION___REMOVE_UNSET_SUCCESSOR__WFGNODE = WFG_NODE___REMOVE_UNSET_SUCCESSOR__WFGNODE;

	/**
	 * The operation id for the '<em>Remove unset predecessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION___REMOVE_UNSET_PREDECESSOR__WFGNODE = WFG_NODE___REMOVE_UNSET_PREDECESSOR__WFGNODE;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION___CLONE = WFG_NODE___CLONE;

	/**
	 * The number of operations of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OPERATION_COUNT = WFG_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link unicam.workflowgraph.impl.WorkFlowGraphImpl <em>Work Flow Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unicam.workflowgraph.impl.WorkFlowGraphImpl
	 * @see unicam.workflowgraph.impl.WorkflowgraphPackageImpl#getWorkFlowGraph()
	 * @generated
	 */
	int WORK_FLOW_GRAPH = 5;

	/**
	 * The feature id for the '<em><b>Gateways</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_GRAPH__GATEWAYS = 0;

	/**
	 * The feature id for the '<em><b>Starting Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_GRAPH__STARTING_NODE = 1;

	/**
	 * The feature id for the '<em><b>Ending Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_GRAPH__ENDING_NODE = 2;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_GRAPH__ACTIONS = 3;

	/**
	 * The feature id for the '<em><b>Participants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_GRAPH__PARTICIPANTS = 4;

	/**
	 * The feature id for the '<em><b>Inner Gateway</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_GRAPH__INNER_GATEWAY = 5;

	/**
	 * The number of structural features of the '<em>Work Flow Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_GRAPH_FEATURE_COUNT = 6;

	/**
	 * The operation id for the '<em>Initialize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_GRAPH___INITIALIZE = 0;

	/**
	 * The operation id for the '<em>Remove Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_GRAPH___REMOVE_NODE__WFGNODE = 1;

	/**
	 * The operation id for the '<em>Add Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_GRAPH___ADD_NODE__WFGNODE = 2;

	/**
	 * The operation id for the '<em>Create New Exclusive Choice</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_GRAPH___CREATE_NEW_EXCLUSIVE_CHOICE__STRING_BOOLEAN_BOOLEAN = 3;

	/**
	 * The operation id for the '<em>Create New Parallel Execution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_GRAPH___CREATE_NEW_PARALLEL_EXECUTION__STRING_BOOLEAN_BOOLEAN = 4;

	/**
	 * The operation id for the '<em>Remove Nodes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_GRAPH___REMOVE_NODES__ELIST = 5;

	/**
	 * The operation id for the '<em>To DO Tfor Graph Viz</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_GRAPH___TO_DO_TFOR_GRAPH_VIZ = 6;

	/**
	 * The operation id for the '<em>Create New Message Exchange</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_GRAPH___CREATE_NEW_MESSAGE_EXCHANGE__STRING_STRING_STRING_PARTICIPANT_PARTICIPANT = 7;

	/**
	 * The operation id for the '<em>Save Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_GRAPH___SAVE_MODEL__STRING = 8;

	/**
	 * The number of operations of the '<em>Work Flow Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_GRAPH_OPERATION_COUNT = 9;

	/**
	 * The meta object id for the '{@link unicam.workflowgraph.impl.MessageExchangeImpl <em>Message Exchange</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unicam.workflowgraph.impl.MessageExchangeImpl
	 * @see unicam.workflowgraph.impl.WorkflowgraphPackageImpl#getMessageExchange()
	 * @generated
	 */
	int MESSAGE_EXCHANGE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXCHANGE__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXCHANGE__ID = ACTION__ID;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXCHANGE__SUCCESSOR = ACTION__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXCHANGE__PREDECESSOR = ACTION__PREDECESSOR;

	/**
	 * The feature id for the '<em><b>Request</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXCHANGE__REQUEST = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Synch Response</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXCHANGE__SYNCH_RESPONSE = ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXCHANGE__SENDER = ACTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Receiver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXCHANGE__RECEIVER = ACTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Choreography Task Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXCHANGE__CHOREOGRAPHY_TASK_REF = ACTION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Message Exchange</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXCHANGE_FEATURE_COUNT = ACTION_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Add set successor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXCHANGE___ADD_SET_SUCCESSOR__WFGNODE = ACTION___ADD_SET_SUCCESSOR__WFGNODE;

	/**
	 * The operation id for the '<em>Add set predecessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXCHANGE___ADD_SET_PREDECESSOR__WFGNODE = ACTION___ADD_SET_PREDECESSOR__WFGNODE;

	/**
	 * The operation id for the '<em>Remove unset successor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXCHANGE___REMOVE_UNSET_SUCCESSOR__WFGNODE = ACTION___REMOVE_UNSET_SUCCESSOR__WFGNODE;

	/**
	 * The operation id for the '<em>Remove unset predecessor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXCHANGE___REMOVE_UNSET_PREDECESSOR__WFGNODE = ACTION___REMOVE_UNSET_PREDECESSOR__WFGNODE;

	/**
	 * The operation id for the '<em>Clone</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXCHANGE___CLONE = ACTION___CLONE;

	/**
	 * The number of operations of the '<em>Message Exchange</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXCHANGE_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link unicam.workflowgraph.impl.BranchImpl <em>Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unicam.workflowgraph.impl.BranchImpl
	 * @see unicam.workflowgraph.impl.WorkflowgraphPackageImpl#getBranch()
	 * @generated
	 */
	int BRANCH = 7;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__NODES = 0;

	/**
	 * The number of structural features of the '<em>Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link unicam.workflowgraph.impl.ParticipantImpl <em>Participant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see unicam.workflowgraph.impl.ParticipantImpl
	 * @see unicam.workflowgraph.impl.WorkflowgraphPackageImpl#getParticipant()
	 * @generated
	 */
	int PARTICIPANT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__ID = 1;

	/**
	 * The feature id for the '<em><b>Participant Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__PARTICIPANT_REF = 2;

	/**
	 * The number of structural features of the '<em>Participant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Participant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link unicam.workflowgraph.WfgNode <em>Wfg Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wfg Node</em>'.
	 * @see unicam.workflowgraph.WfgNode
	 * @generated
	 */
	EClass getWfgNode();

	/**
	 * Returns the meta object for the attribute '{@link unicam.workflowgraph.WfgNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see unicam.workflowgraph.WfgNode#getName()
	 * @see #getWfgNode()
	 * @generated
	 */
	EAttribute getWfgNode_Name();

	/**
	 * Returns the meta object for the attribute '{@link unicam.workflowgraph.WfgNode#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see unicam.workflowgraph.WfgNode#getId()
	 * @see #getWfgNode()
	 * @generated
	 */
	EAttribute getWfgNode_Id();

	/**
	 * Returns the meta object for the '{@link unicam.workflowgraph.WfgNode#add_set_successor(unicam.workflowgraph.WfgNode) <em>Add set successor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add set successor</em>' operation.
	 * @see unicam.workflowgraph.WfgNode#add_set_successor(unicam.workflowgraph.WfgNode)
	 * @generated
	 */
	EOperation getWfgNode__Add_set_successor__WfgNode();

	/**
	 * Returns the meta object for the '{@link unicam.workflowgraph.WfgNode#add_set_predecessor(unicam.workflowgraph.WfgNode) <em>Add set predecessor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add set predecessor</em>' operation.
	 * @see unicam.workflowgraph.WfgNode#add_set_predecessor(unicam.workflowgraph.WfgNode)
	 * @generated
	 */
	EOperation getWfgNode__Add_set_predecessor__WfgNode();

	/**
	 * Returns the meta object for the '{@link unicam.workflowgraph.WfgNode#remove_unset_successor(unicam.workflowgraph.WfgNode) <em>Remove unset successor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Remove unset successor</em>' operation.
	 * @see unicam.workflowgraph.WfgNode#remove_unset_successor(unicam.workflowgraph.WfgNode)
	 * @generated
	 */
	EOperation getWfgNode__Remove_unset_successor__WfgNode();

	/**
	 * Returns the meta object for the '{@link unicam.workflowgraph.WfgNode#remove_unset_predecessor(unicam.workflowgraph.WfgNode) <em>Remove unset predecessor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Remove unset predecessor</em>' operation.
	 * @see unicam.workflowgraph.WfgNode#remove_unset_predecessor(unicam.workflowgraph.WfgNode)
	 * @generated
	 */
	EOperation getWfgNode__Remove_unset_predecessor__WfgNode();

	/**
	 * Returns the meta object for the '{@link unicam.workflowgraph.WfgNode#clone() <em>Clone</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Clone</em>' operation.
	 * @see unicam.workflowgraph.WfgNode#clone()
	 * @generated
	 */
	EOperation getWfgNode__Clone();

	/**
	 * Returns the meta object for class '{@link unicam.workflowgraph.Gateway <em>Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gateway</em>'.
	 * @see unicam.workflowgraph.Gateway
	 * @generated
	 */
	EClass getGateway();

	/**
	 * Returns the meta object for the attribute '{@link unicam.workflowgraph.Gateway#isFork <em>Fork</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fork</em>'.
	 * @see unicam.workflowgraph.Gateway#isFork()
	 * @see #getGateway()
	 * @generated
	 */
	EAttribute getGateway_Fork();

	/**
	 * Returns the meta object for the attribute '{@link unicam.workflowgraph.Gateway#isMerge <em>Merge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Merge</em>'.
	 * @see unicam.workflowgraph.Gateway#isMerge()
	 * @see #getGateway()
	 * @generated
	 */
	EAttribute getGateway_Merge();

	/**
	 * Returns the meta object for the reference '{@link unicam.workflowgraph.Gateway#getRefMerge <em>Ref Merge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Merge</em>'.
	 * @see unicam.workflowgraph.Gateway#getRefMerge()
	 * @see #getGateway()
	 * @generated
	 */
	EReference getGateway_RefMerge();

	/**
	 * Returns the meta object for the reference '{@link unicam.workflowgraph.Gateway#getRefFork <em>Ref Fork</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Fork</em>'.
	 * @see unicam.workflowgraph.Gateway#getRefFork()
	 * @see #getGateway()
	 * @generated
	 */
	EReference getGateway_RefFork();

	/**
	 * Returns the meta object for the reference list '{@link unicam.workflowgraph.Gateway#getSuccessors <em>Successors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Successors</em>'.
	 * @see unicam.workflowgraph.Gateway#getSuccessors()
	 * @see #getGateway()
	 * @generated
	 */
	EReference getGateway_Successors();

	/**
	 * Returns the meta object for the reference '{@link unicam.workflowgraph.Gateway#getGatewayRef <em>Gateway Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Gateway Ref</em>'.
	 * @see unicam.workflowgraph.Gateway#getGatewayRef()
	 * @see #getGateway()
	 * @generated
	 */
	EReference getGateway_GatewayRef();

	/**
	 * Returns the meta object for the '{@link unicam.workflowgraph.Gateway#getBranches() <em>Get Branches</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Branches</em>' operation.
	 * @see unicam.workflowgraph.Gateway#getBranches()
	 * @generated
	 */
	EOperation getGateway__GetBranches();

	/**
	 * Returns the meta object for the reference list '{@link unicam.workflowgraph.Gateway#getPredecessors <em>Predecessors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Predecessors</em>'.
	 * @see unicam.workflowgraph.Gateway#getPredecessors()
	 * @see #getGateway()
	 * @generated
	 */
	EReference getGateway_Predecessors();

	/**
	 * Returns the meta object for class '{@link unicam.workflowgraph.ExclusiveChoice <em>Exclusive Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exclusive Choice</em>'.
	 * @see unicam.workflowgraph.ExclusiveChoice
	 * @generated
	 */
	EClass getExclusiveChoice();

	/**
	 * Returns the meta object for class '{@link unicam.workflowgraph.ParallelExecution <em>Parallel Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parallel Execution</em>'.
	 * @see unicam.workflowgraph.ParallelExecution
	 * @generated
	 */
	EClass getParallelExecution();

	/**
	 * Returns the meta object for class '{@link unicam.workflowgraph.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see unicam.workflowgraph.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the reference '{@link unicam.workflowgraph.Action#getSuccessor <em>Successor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Successor</em>'.
	 * @see unicam.workflowgraph.Action#getSuccessor()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Successor();

	/**
	 * Returns the meta object for the reference '{@link unicam.workflowgraph.Action#getPredecessor <em>Predecessor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Predecessor</em>'.
	 * @see unicam.workflowgraph.Action#getPredecessor()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Predecessor();

	/**
	 * Returns the meta object for class '{@link unicam.workflowgraph.WorkFlowGraph <em>Work Flow Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Work Flow Graph</em>'.
	 * @see unicam.workflowgraph.WorkFlowGraph
	 * @generated
	 */
	EClass getWorkFlowGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link unicam.workflowgraph.WorkFlowGraph#getGateways <em>Gateways</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Gateways</em>'.
	 * @see unicam.workflowgraph.WorkFlowGraph#getGateways()
	 * @see #getWorkFlowGraph()
	 * @generated
	 */
	EReference getWorkFlowGraph_Gateways();

	/**
	 * Returns the meta object for the reference '{@link unicam.workflowgraph.WorkFlowGraph#getStartingNode <em>Starting Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Starting Node</em>'.
	 * @see unicam.workflowgraph.WorkFlowGraph#getStartingNode()
	 * @see #getWorkFlowGraph()
	 * @generated
	 */
	EReference getWorkFlowGraph_StartingNode();

	/**
	 * Returns the meta object for the reference '{@link unicam.workflowgraph.WorkFlowGraph#getEndingNode <em>Ending Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ending Node</em>'.
	 * @see unicam.workflowgraph.WorkFlowGraph#getEndingNode()
	 * @see #getWorkFlowGraph()
	 * @generated
	 */
	EReference getWorkFlowGraph_EndingNode();

	/**
	 * Returns the meta object for the containment reference list '{@link unicam.workflowgraph.WorkFlowGraph#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see unicam.workflowgraph.WorkFlowGraph#getActions()
	 * @see #getWorkFlowGraph()
	 * @generated
	 */
	EReference getWorkFlowGraph_Actions();

	/**
	 * Returns the meta object for the containment reference list '{@link unicam.workflowgraph.WorkFlowGraph#getParticipants <em>Participants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Participants</em>'.
	 * @see unicam.workflowgraph.WorkFlowGraph#getParticipants()
	 * @see #getWorkFlowGraph()
	 * @generated
	 */
	EReference getWorkFlowGraph_Participants();

	/**
	 * Returns the meta object for the reference '{@link unicam.workflowgraph.WorkFlowGraph#getInnerGateway <em>Inner Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inner Gateway</em>'.
	 * @see unicam.workflowgraph.WorkFlowGraph#getInnerGateway()
	 * @see #getWorkFlowGraph()
	 * @generated
	 */
	EReference getWorkFlowGraph_InnerGateway();

	/**
	 * Returns the meta object for the '{@link unicam.workflowgraph.WorkFlowGraph#initialize() <em>Initialize</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Initialize</em>' operation.
	 * @see unicam.workflowgraph.WorkFlowGraph#initialize()
	 * @generated
	 */
	EOperation getWorkFlowGraph__Initialize();

	/**
	 * Returns the meta object for the '{@link unicam.workflowgraph.WorkFlowGraph#removeNode(unicam.workflowgraph.WfgNode) <em>Remove Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Remove Node</em>' operation.
	 * @see unicam.workflowgraph.WorkFlowGraph#removeNode(unicam.workflowgraph.WfgNode)
	 * @generated
	 */
	EOperation getWorkFlowGraph__RemoveNode__WfgNode();

	/**
	 * Returns the meta object for the '{@link unicam.workflowgraph.WorkFlowGraph#addNode(unicam.workflowgraph.WfgNode) <em>Add Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Node</em>' operation.
	 * @see unicam.workflowgraph.WorkFlowGraph#addNode(unicam.workflowgraph.WfgNode)
	 * @generated
	 */
	EOperation getWorkFlowGraph__AddNode__WfgNode();

	/**
	 * Returns the meta object for the '{@link unicam.workflowgraph.WorkFlowGraph#createNewExclusiveChoice(java.lang.String, boolean, boolean) <em>Create New Exclusive Choice</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create New Exclusive Choice</em>' operation.
	 * @see unicam.workflowgraph.WorkFlowGraph#createNewExclusiveChoice(java.lang.String, boolean, boolean)
	 * @generated
	 */
	EOperation getWorkFlowGraph__CreateNewExclusiveChoice__String_boolean_boolean();

	/**
	 * Returns the meta object for the '{@link unicam.workflowgraph.WorkFlowGraph#createNewParallelExecution(java.lang.String, boolean, boolean) <em>Create New Parallel Execution</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create New Parallel Execution</em>' operation.
	 * @see unicam.workflowgraph.WorkFlowGraph#createNewParallelExecution(java.lang.String, boolean, boolean)
	 * @generated
	 */
	EOperation getWorkFlowGraph__CreateNewParallelExecution__String_boolean_boolean();

	/**
	 * Returns the meta object for the '{@link unicam.workflowgraph.WorkFlowGraph#removeNodes(org.eclipse.emf.common.util.EList) <em>Remove Nodes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Remove Nodes</em>' operation.
	 * @see unicam.workflowgraph.WorkFlowGraph#removeNodes(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getWorkFlowGraph__RemoveNodes__EList();

	/**
	 * Returns the meta object for the '{@link unicam.workflowgraph.WorkFlowGraph#toDOTforGraphViz() <em>To DO Tfor Graph Viz</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To DO Tfor Graph Viz</em>' operation.
	 * @see unicam.workflowgraph.WorkFlowGraph#toDOTforGraphViz()
	 * @generated
	 */
	EOperation getWorkFlowGraph__ToDOTforGraphViz();

	/**
	 * Returns the meta object for the '{@link unicam.workflowgraph.WorkFlowGraph#createNewMessageExchange(java.lang.String, java.lang.String, java.lang.String, unicam.workflowgraph.Participant, unicam.workflowgraph.Participant) <em>Create New Message Exchange</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create New Message Exchange</em>' operation.
	 * @see unicam.workflowgraph.WorkFlowGraph#createNewMessageExchange(java.lang.String, java.lang.String, java.lang.String, unicam.workflowgraph.Participant, unicam.workflowgraph.Participant)
	 * @generated
	 */
	EOperation getWorkFlowGraph__CreateNewMessageExchange__String_String_String_Participant_Participant();

	/**
	 * Returns the meta object for the '{@link unicam.workflowgraph.WorkFlowGraph#saveModel(java.lang.String) <em>Save Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Save Model</em>' operation.
	 * @see unicam.workflowgraph.WorkFlowGraph#saveModel(java.lang.String)
	 * @generated
	 */
	EOperation getWorkFlowGraph__SaveModel__String();

	/**
	 * Returns the meta object for class '{@link unicam.workflowgraph.MessageExchange <em>Message Exchange</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Exchange</em>'.
	 * @see unicam.workflowgraph.MessageExchange
	 * @generated
	 */
	EClass getMessageExchange();

	/**
	 * Returns the meta object for the reference '{@link unicam.workflowgraph.MessageExchange#getSender <em>Sender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sender</em>'.
	 * @see unicam.workflowgraph.MessageExchange#getSender()
	 * @see #getMessageExchange()
	 * @generated
	 */
	EReference getMessageExchange_Sender();

	/**
	 * Returns the meta object for the reference '{@link unicam.workflowgraph.MessageExchange#getReceiver <em>Receiver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Receiver</em>'.
	 * @see unicam.workflowgraph.MessageExchange#getReceiver()
	 * @see #getMessageExchange()
	 * @generated
	 */
	EReference getMessageExchange_Receiver();

	/**
	 * Returns the meta object for the reference '{@link unicam.workflowgraph.MessageExchange#getChoreographyTaskRef <em>Choreography Task Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Choreography Task Ref</em>'.
	 * @see unicam.workflowgraph.MessageExchange#getChoreographyTaskRef()
	 * @see #getMessageExchange()
	 * @generated
	 */
	EReference getMessageExchange_ChoreographyTaskRef();

	/**
	 * Returns the meta object for the attribute '{@link unicam.workflowgraph.MessageExchange#getRequest <em>Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Request</em>'.
	 * @see unicam.workflowgraph.MessageExchange#getRequest()
	 * @see #getMessageExchange()
	 * @generated
	 */
	EAttribute getMessageExchange_Request();

	/**
	 * Returns the meta object for the attribute '{@link unicam.workflowgraph.MessageExchange#getSynchResponse <em>Synch Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Synch Response</em>'.
	 * @see unicam.workflowgraph.MessageExchange#getSynchResponse()
	 * @see #getMessageExchange()
	 * @generated
	 */
	EAttribute getMessageExchange_SynchResponse();

	/**
	 * Returns the meta object for class '{@link unicam.workflowgraph.Branch <em>Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Branch</em>'.
	 * @see unicam.workflowgraph.Branch
	 * @generated
	 */
	EClass getBranch();

	/**
	 * Returns the meta object for the reference list '{@link unicam.workflowgraph.Branch#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Nodes</em>'.
	 * @see unicam.workflowgraph.Branch#getNodes()
	 * @see #getBranch()
	 * @generated
	 */
	EReference getBranch_Nodes();

	/**
	 * Returns the meta object for class '{@link unicam.workflowgraph.Participant <em>Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Participant</em>'.
	 * @see unicam.workflowgraph.Participant
	 * @generated
	 */
	EClass getParticipant();

	/**
	 * Returns the meta object for the attribute '{@link unicam.workflowgraph.Participant#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see unicam.workflowgraph.Participant#getName()
	 * @see #getParticipant()
	 * @generated
	 */
	EAttribute getParticipant_Name();

	/**
	 * Returns the meta object for the reference '{@link unicam.workflowgraph.Participant#getParticipantRef <em>Participant Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Participant Ref</em>'.
	 * @see unicam.workflowgraph.Participant#getParticipantRef()
	 * @see #getParticipant()
	 * @generated
	 */
	EReference getParticipant_ParticipantRef();

	/**
	 * Returns the meta object for the attribute '{@link unicam.workflowgraph.Participant#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see unicam.workflowgraph.Participant#getId()
	 * @see #getParticipant()
	 * @generated
	 */
	EAttribute getParticipant_Id();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WorkflowgraphFactory getWorkflowgraphFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link unicam.workflowgraph.impl.WfgNodeImpl <em>Wfg Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unicam.workflowgraph.impl.WfgNodeImpl
		 * @see unicam.workflowgraph.impl.WorkflowgraphPackageImpl#getWfgNode()
		 * @generated
		 */
		EClass WFG_NODE = eINSTANCE.getWfgNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WFG_NODE__NAME = eINSTANCE.getWfgNode_Name();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WFG_NODE__ID = eINSTANCE.getWfgNode_Id();

		/**
		 * The meta object literal for the '<em><b>Add set successor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation WFG_NODE___ADD_SET_SUCCESSOR__WFGNODE = eINSTANCE.getWfgNode__Add_set_successor__WfgNode();

		/**
		 * The meta object literal for the '<em><b>Add set predecessor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation WFG_NODE___ADD_SET_PREDECESSOR__WFGNODE = eINSTANCE.getWfgNode__Add_set_predecessor__WfgNode();

		/**
		 * The meta object literal for the '<em><b>Remove unset successor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation WFG_NODE___REMOVE_UNSET_SUCCESSOR__WFGNODE = eINSTANCE.getWfgNode__Remove_unset_successor__WfgNode();

		/**
		 * The meta object literal for the '<em><b>Remove unset predecessor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation WFG_NODE___REMOVE_UNSET_PREDECESSOR__WFGNODE = eINSTANCE.getWfgNode__Remove_unset_predecessor__WfgNode();

		/**
		 * The meta object literal for the '<em><b>Clone</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation WFG_NODE___CLONE = eINSTANCE.getWfgNode__Clone();

		/**
		 * The meta object literal for the '{@link unicam.workflowgraph.impl.GatewayImpl <em>Gateway</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unicam.workflowgraph.impl.GatewayImpl
		 * @see unicam.workflowgraph.impl.WorkflowgraphPackageImpl#getGateway()
		 * @generated
		 */
		EClass GATEWAY = eINSTANCE.getGateway();

		/**
		 * The meta object literal for the '<em><b>Fork</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GATEWAY__FORK = eINSTANCE.getGateway_Fork();

		/**
		 * The meta object literal for the '<em><b>Merge</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GATEWAY__MERGE = eINSTANCE.getGateway_Merge();

		/**
		 * The meta object literal for the '<em><b>Ref Merge</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GATEWAY__REF_MERGE = eINSTANCE.getGateway_RefMerge();

		/**
		 * The meta object literal for the '<em><b>Ref Fork</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GATEWAY__REF_FORK = eINSTANCE.getGateway_RefFork();

		/**
		 * The meta object literal for the '<em><b>Successors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GATEWAY__SUCCESSORS = eINSTANCE.getGateway_Successors();

		/**
		 * The meta object literal for the '<em><b>Gateway Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GATEWAY__GATEWAY_REF = eINSTANCE.getGateway_GatewayRef();

		/**
		 * The meta object literal for the '<em><b>Get Branches</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GATEWAY___GET_BRANCHES = eINSTANCE.getGateway__GetBranches();

		/**
		 * The meta object literal for the '<em><b>Predecessors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GATEWAY__PREDECESSORS = eINSTANCE.getGateway_Predecessors();

		/**
		 * The meta object literal for the '{@link unicam.workflowgraph.impl.ExclusiveChoiceImpl <em>Exclusive Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unicam.workflowgraph.impl.ExclusiveChoiceImpl
		 * @see unicam.workflowgraph.impl.WorkflowgraphPackageImpl#getExclusiveChoice()
		 * @generated
		 */
		EClass EXCLUSIVE_CHOICE = eINSTANCE.getExclusiveChoice();

		/**
		 * The meta object literal for the '{@link unicam.workflowgraph.impl.ParallelExecutionImpl <em>Parallel Execution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unicam.workflowgraph.impl.ParallelExecutionImpl
		 * @see unicam.workflowgraph.impl.WorkflowgraphPackageImpl#getParallelExecution()
		 * @generated
		 */
		EClass PARALLEL_EXECUTION = eINSTANCE.getParallelExecution();

		/**
		 * The meta object literal for the '{@link unicam.workflowgraph.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unicam.workflowgraph.impl.ActionImpl
		 * @see unicam.workflowgraph.impl.WorkflowgraphPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Successor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__SUCCESSOR = eINSTANCE.getAction_Successor();

		/**
		 * The meta object literal for the '<em><b>Predecessor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__PREDECESSOR = eINSTANCE.getAction_Predecessor();

		/**
		 * The meta object literal for the '{@link unicam.workflowgraph.impl.WorkFlowGraphImpl <em>Work Flow Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unicam.workflowgraph.impl.WorkFlowGraphImpl
		 * @see unicam.workflowgraph.impl.WorkflowgraphPackageImpl#getWorkFlowGraph()
		 * @generated
		 */
		EClass WORK_FLOW_GRAPH = eINSTANCE.getWorkFlowGraph();

		/**
		 * The meta object literal for the '<em><b>Gateways</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_FLOW_GRAPH__GATEWAYS = eINSTANCE.getWorkFlowGraph_Gateways();

		/**
		 * The meta object literal for the '<em><b>Starting Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_FLOW_GRAPH__STARTING_NODE = eINSTANCE.getWorkFlowGraph_StartingNode();

		/**
		 * The meta object literal for the '<em><b>Ending Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_FLOW_GRAPH__ENDING_NODE = eINSTANCE.getWorkFlowGraph_EndingNode();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_FLOW_GRAPH__ACTIONS = eINSTANCE.getWorkFlowGraph_Actions();

		/**
		 * The meta object literal for the '<em><b>Participants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_FLOW_GRAPH__PARTICIPANTS = eINSTANCE.getWorkFlowGraph_Participants();

		/**
		 * The meta object literal for the '<em><b>Inner Gateway</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_FLOW_GRAPH__INNER_GATEWAY = eINSTANCE.getWorkFlowGraph_InnerGateway();

		/**
		 * The meta object literal for the '<em><b>Initialize</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation WORK_FLOW_GRAPH___INITIALIZE = eINSTANCE.getWorkFlowGraph__Initialize();

		/**
		 * The meta object literal for the '<em><b>Remove Node</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation WORK_FLOW_GRAPH___REMOVE_NODE__WFGNODE = eINSTANCE.getWorkFlowGraph__RemoveNode__WfgNode();

		/**
		 * The meta object literal for the '<em><b>Add Node</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation WORK_FLOW_GRAPH___ADD_NODE__WFGNODE = eINSTANCE.getWorkFlowGraph__AddNode__WfgNode();

		/**
		 * The meta object literal for the '<em><b>Create New Exclusive Choice</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation WORK_FLOW_GRAPH___CREATE_NEW_EXCLUSIVE_CHOICE__STRING_BOOLEAN_BOOLEAN = eINSTANCE.getWorkFlowGraph__CreateNewExclusiveChoice__String_boolean_boolean();

		/**
		 * The meta object literal for the '<em><b>Create New Parallel Execution</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation WORK_FLOW_GRAPH___CREATE_NEW_PARALLEL_EXECUTION__STRING_BOOLEAN_BOOLEAN = eINSTANCE.getWorkFlowGraph__CreateNewParallelExecution__String_boolean_boolean();

		/**
		 * The meta object literal for the '<em><b>Remove Nodes</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation WORK_FLOW_GRAPH___REMOVE_NODES__ELIST = eINSTANCE.getWorkFlowGraph__RemoveNodes__EList();

		/**
		 * The meta object literal for the '<em><b>To DO Tfor Graph Viz</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation WORK_FLOW_GRAPH___TO_DO_TFOR_GRAPH_VIZ = eINSTANCE.getWorkFlowGraph__ToDOTforGraphViz();

		/**
		 * The meta object literal for the '<em><b>Create New Message Exchange</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation WORK_FLOW_GRAPH___CREATE_NEW_MESSAGE_EXCHANGE__STRING_STRING_STRING_PARTICIPANT_PARTICIPANT = eINSTANCE.getWorkFlowGraph__CreateNewMessageExchange__String_String_String_Participant_Participant();

		/**
		 * The meta object literal for the '<em><b>Save Model</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation WORK_FLOW_GRAPH___SAVE_MODEL__STRING = eINSTANCE.getWorkFlowGraph__SaveModel__String();

		/**
		 * The meta object literal for the '{@link unicam.workflowgraph.impl.MessageExchangeImpl <em>Message Exchange</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unicam.workflowgraph.impl.MessageExchangeImpl
		 * @see unicam.workflowgraph.impl.WorkflowgraphPackageImpl#getMessageExchange()
		 * @generated
		 */
		EClass MESSAGE_EXCHANGE = eINSTANCE.getMessageExchange();

		/**
		 * The meta object literal for the '<em><b>Sender</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_EXCHANGE__SENDER = eINSTANCE.getMessageExchange_Sender();

		/**
		 * The meta object literal for the '<em><b>Receiver</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_EXCHANGE__RECEIVER = eINSTANCE.getMessageExchange_Receiver();

		/**
		 * The meta object literal for the '<em><b>Choreography Task Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_EXCHANGE__CHOREOGRAPHY_TASK_REF = eINSTANCE.getMessageExchange_ChoreographyTaskRef();

		/**
		 * The meta object literal for the '<em><b>Request</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_EXCHANGE__REQUEST = eINSTANCE.getMessageExchange_Request();

		/**
		 * The meta object literal for the '<em><b>Synch Response</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_EXCHANGE__SYNCH_RESPONSE = eINSTANCE.getMessageExchange_SynchResponse();

		/**
		 * The meta object literal for the '{@link unicam.workflowgraph.impl.BranchImpl <em>Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unicam.workflowgraph.impl.BranchImpl
		 * @see unicam.workflowgraph.impl.WorkflowgraphPackageImpl#getBranch()
		 * @generated
		 */
		EClass BRANCH = eINSTANCE.getBranch();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRANCH__NODES = eINSTANCE.getBranch_Nodes();

		/**
		 * The meta object literal for the '{@link unicam.workflowgraph.impl.ParticipantImpl <em>Participant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see unicam.workflowgraph.impl.ParticipantImpl
		 * @see unicam.workflowgraph.impl.WorkflowgraphPackageImpl#getParticipant()
		 * @generated
		 */
		EClass PARTICIPANT = eINSTANCE.getParticipant();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTICIPANT__NAME = eINSTANCE.getParticipant_Name();

		/**
		 * The meta object literal for the '<em><b>Participant Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTICIPANT__PARTICIPANT_REF = eINSTANCE.getParticipant_ParticipantRef();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTICIPANT__ID = eINSTANCE.getParticipant_Id();

	}

} //WorkflowgraphPackage
