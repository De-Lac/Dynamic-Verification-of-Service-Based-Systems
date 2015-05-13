/**
 */
package unicam.workflowgraph.impl;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.di.BpmnDiPackage;
import org.eclipse.dd.dc.DcPackage;
import org.eclipse.dd.di.DiPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import unicam.workflowgraph.Action;
import unicam.workflowgraph.Branch;
import unicam.workflowgraph.ExclusiveChoice;
import unicam.workflowgraph.Gateway;
import unicam.workflowgraph.MessageExchange;
import unicam.workflowgraph.ParallelExecution;
import unicam.workflowgraph.Participant;
import unicam.workflowgraph.WfgNode;
import unicam.workflowgraph.WorkFlowGraph;
import unicam.workflowgraph.WorkflowgraphFactory;
import unicam.workflowgraph.WorkflowgraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorkflowgraphPackageImpl extends EPackageImpl implements WorkflowgraphPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wfgNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gatewayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exclusiveChoiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parallelExecutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workFlowGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageExchangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass branchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass participantEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see unicam.workflowgraph.WorkflowgraphPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WorkflowgraphPackageImpl() {
		super(eNS_URI, WorkflowgraphFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link WorkflowgraphPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static WorkflowgraphPackage init() {
		if (isInited) return (WorkflowgraphPackage)EPackage.Registry.INSTANCE.getEPackage(WorkflowgraphPackage.eNS_URI);

		// Obtain or create and register package
		WorkflowgraphPackageImpl theWorkflowgraphPackage = (WorkflowgraphPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof WorkflowgraphPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new WorkflowgraphPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		Bpmn2Package.eINSTANCE.eClass();
		BpmnDiPackage.eINSTANCE.eClass();
		DiPackage.eINSTANCE.eClass();
		DcPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theWorkflowgraphPackage.createPackageContents();

		// Initialize created meta-data
		theWorkflowgraphPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWorkflowgraphPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(WorkflowgraphPackage.eNS_URI, theWorkflowgraphPackage);
		return theWorkflowgraphPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWfgNode() {
		return wfgNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWfgNode_Name() {
		return (EAttribute)wfgNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWfgNode_Id() {
		return (EAttribute)wfgNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWfgNode__Add_set_successor__WfgNode() {
		return wfgNodeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWfgNode__Add_set_predecessor__WfgNode() {
		return wfgNodeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWfgNode__Remove_unset_successor__WfgNode() {
		return wfgNodeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWfgNode__Remove_unset_predecessor__WfgNode() {
		return wfgNodeEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWfgNode__Clone() {
		return wfgNodeEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGateway() {
		return gatewayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGateway_Fork() {
		return (EAttribute)gatewayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGateway_Merge() {
		return (EAttribute)gatewayEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGateway_RefMerge() {
		return (EReference)gatewayEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGateway_RefFork() {
		return (EReference)gatewayEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGateway_Successors() {
		return (EReference)gatewayEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGateway_GatewayRef() {
		return (EReference)gatewayEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getGateway__GetBranches() {
		return gatewayEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGateway_Predecessors() {
		return (EReference)gatewayEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExclusiveChoice() {
		return exclusiveChoiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParallelExecution() {
		return parallelExecutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAction() {
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAction_Successor() {
		return (EReference)actionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAction_Predecessor() {
		return (EReference)actionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkFlowGraph() {
		return workFlowGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkFlowGraph_Gateways() {
		return (EReference)workFlowGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkFlowGraph_StartingNode() {
		return (EReference)workFlowGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkFlowGraph_EndingNode() {
		return (EReference)workFlowGraphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkFlowGraph_Actions() {
		return (EReference)workFlowGraphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkFlowGraph_Participants() {
		return (EReference)workFlowGraphEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkFlowGraph_InnerGateway() {
		return (EReference)workFlowGraphEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWorkFlowGraph__Initialize() {
		return workFlowGraphEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWorkFlowGraph__RemoveNode__WfgNode() {
		return workFlowGraphEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWorkFlowGraph__AddNode__WfgNode() {
		return workFlowGraphEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWorkFlowGraph__CreateNewExclusiveChoice__String_boolean_boolean() {
		return workFlowGraphEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWorkFlowGraph__CreateNewParallelExecution__String_boolean_boolean() {
		return workFlowGraphEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWorkFlowGraph__RemoveNodes__EList() {
		return workFlowGraphEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWorkFlowGraph__ToDOTforGraphViz() {
		return workFlowGraphEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWorkFlowGraph__CreateNewMessageExchange__String_String_String_Participant_Participant() {
		return workFlowGraphEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWorkFlowGraph__SaveModel__String() {
		return workFlowGraphEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageExchange() {
		return messageExchangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageExchange_Sender() {
		return (EReference)messageExchangeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageExchange_Receiver() {
		return (EReference)messageExchangeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageExchange_ChoreographyTaskRef() {
		return (EReference)messageExchangeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageExchange_Request() {
		return (EAttribute)messageExchangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageExchange_SynchResponse() {
		return (EAttribute)messageExchangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBranch() {
		return branchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranch_Nodes() {
		return (EReference)branchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParticipant() {
		return participantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParticipant_Name() {
		return (EAttribute)participantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParticipant_ParticipantRef() {
		return (EReference)participantEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParticipant_Id() {
		return (EAttribute)participantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowgraphFactory getWorkflowgraphFactory() {
		return (WorkflowgraphFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		wfgNodeEClass = createEClass(WFG_NODE);
		createEAttribute(wfgNodeEClass, WFG_NODE__NAME);
		createEAttribute(wfgNodeEClass, WFG_NODE__ID);
		createEOperation(wfgNodeEClass, WFG_NODE___ADD_SET_SUCCESSOR__WFGNODE);
		createEOperation(wfgNodeEClass, WFG_NODE___ADD_SET_PREDECESSOR__WFGNODE);
		createEOperation(wfgNodeEClass, WFG_NODE___REMOVE_UNSET_SUCCESSOR__WFGNODE);
		createEOperation(wfgNodeEClass, WFG_NODE___REMOVE_UNSET_PREDECESSOR__WFGNODE);
		createEOperation(wfgNodeEClass, WFG_NODE___CLONE);

		gatewayEClass = createEClass(GATEWAY);
		createEAttribute(gatewayEClass, GATEWAY__FORK);
		createEAttribute(gatewayEClass, GATEWAY__MERGE);
		createEReference(gatewayEClass, GATEWAY__REF_MERGE);
		createEReference(gatewayEClass, GATEWAY__REF_FORK);
		createEReference(gatewayEClass, GATEWAY__PREDECESSORS);
		createEReference(gatewayEClass, GATEWAY__SUCCESSORS);
		createEReference(gatewayEClass, GATEWAY__GATEWAY_REF);
		createEOperation(gatewayEClass, GATEWAY___GET_BRANCHES);

		exclusiveChoiceEClass = createEClass(EXCLUSIVE_CHOICE);

		parallelExecutionEClass = createEClass(PARALLEL_EXECUTION);

		actionEClass = createEClass(ACTION);
		createEReference(actionEClass, ACTION__SUCCESSOR);
		createEReference(actionEClass, ACTION__PREDECESSOR);

		workFlowGraphEClass = createEClass(WORK_FLOW_GRAPH);
		createEReference(workFlowGraphEClass, WORK_FLOW_GRAPH__GATEWAYS);
		createEReference(workFlowGraphEClass, WORK_FLOW_GRAPH__STARTING_NODE);
		createEReference(workFlowGraphEClass, WORK_FLOW_GRAPH__ENDING_NODE);
		createEReference(workFlowGraphEClass, WORK_FLOW_GRAPH__ACTIONS);
		createEReference(workFlowGraphEClass, WORK_FLOW_GRAPH__PARTICIPANTS);
		createEReference(workFlowGraphEClass, WORK_FLOW_GRAPH__INNER_GATEWAY);
		createEOperation(workFlowGraphEClass, WORK_FLOW_GRAPH___INITIALIZE);
		createEOperation(workFlowGraphEClass, WORK_FLOW_GRAPH___REMOVE_NODE__WFGNODE);
		createEOperation(workFlowGraphEClass, WORK_FLOW_GRAPH___ADD_NODE__WFGNODE);
		createEOperation(workFlowGraphEClass, WORK_FLOW_GRAPH___CREATE_NEW_EXCLUSIVE_CHOICE__STRING_BOOLEAN_BOOLEAN);
		createEOperation(workFlowGraphEClass, WORK_FLOW_GRAPH___CREATE_NEW_PARALLEL_EXECUTION__STRING_BOOLEAN_BOOLEAN);
		createEOperation(workFlowGraphEClass, WORK_FLOW_GRAPH___REMOVE_NODES__ELIST);
		createEOperation(workFlowGraphEClass, WORK_FLOW_GRAPH___TO_DO_TFOR_GRAPH_VIZ);
		createEOperation(workFlowGraphEClass, WORK_FLOW_GRAPH___CREATE_NEW_MESSAGE_EXCHANGE__STRING_STRING_STRING_PARTICIPANT_PARTICIPANT);
		createEOperation(workFlowGraphEClass, WORK_FLOW_GRAPH___SAVE_MODEL__STRING);

		messageExchangeEClass = createEClass(MESSAGE_EXCHANGE);
		createEAttribute(messageExchangeEClass, MESSAGE_EXCHANGE__REQUEST);
		createEAttribute(messageExchangeEClass, MESSAGE_EXCHANGE__SYNCH_RESPONSE);
		createEReference(messageExchangeEClass, MESSAGE_EXCHANGE__SENDER);
		createEReference(messageExchangeEClass, MESSAGE_EXCHANGE__RECEIVER);
		createEReference(messageExchangeEClass, MESSAGE_EXCHANGE__CHOREOGRAPHY_TASK_REF);

		branchEClass = createEClass(BRANCH);
		createEReference(branchEClass, BRANCH__NODES);

		participantEClass = createEClass(PARTICIPANT);
		createEAttribute(participantEClass, PARTICIPANT__NAME);
		createEAttribute(participantEClass, PARTICIPANT__ID);
		createEReference(participantEClass, PARTICIPANT__PARTICIPANT_REF);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		Bpmn2Package theBpmn2Package = (Bpmn2Package)EPackage.Registry.INSTANCE.getEPackage(Bpmn2Package.eNS_URI);

		// Create type parameters
		addETypeParameter(actionEClass, "GenericType");
		addETypeParameter(participantEClass, "P");

		// Set bounds for type parameters

		// Add supertypes to classes
		gatewayEClass.getESuperTypes().add(this.getWfgNode());
		exclusiveChoiceEClass.getESuperTypes().add(this.getGateway());
		parallelExecutionEClass.getESuperTypes().add(this.getGateway());
		actionEClass.getESuperTypes().add(this.getWfgNode());
		messageExchangeEClass.getESuperTypes().add(this.getAction());

		// Initialize classes, features, and operations; add parameters
		initEClass(wfgNodeEClass, WfgNode.class, "WfgNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWfgNode_Name(), ecorePackage.getEString(), "name", null, 1, 1, WfgNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWfgNode_Id(), ecorePackage.getEString(), "id", null, 1, 1, WfgNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getWfgNode__Add_set_successor__WfgNode(), ecorePackage.getEBoolean(), "add_set_successor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getWfgNode(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getWfgNode__Add_set_predecessor__WfgNode(), ecorePackage.getEBoolean(), "add_set_predecessor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getWfgNode(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getWfgNode__Remove_unset_successor__WfgNode(), ecorePackage.getEBoolean(), "remove_unset_successor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getWfgNode(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getWfgNode__Remove_unset_predecessor__WfgNode(), ecorePackage.getEBoolean(), "remove_unset_predecessor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getWfgNode(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getWfgNode__Clone(), this.getWfgNode(), "clone", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(gatewayEClass, Gateway.class, "Gateway", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGateway_Fork(), ecorePackage.getEBoolean(), "fork", "false", 1, 1, Gateway.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGateway_Merge(), ecorePackage.getEBoolean(), "merge", "false", 1, 1, Gateway.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGateway_RefMerge(), this.getGateway(), this.getGateway_RefFork(), "refMerge", null, 1, 1, Gateway.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGateway_RefFork(), this.getGateway(), this.getGateway_RefMerge(), "refFork", null, 1, 1, Gateway.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGateway_Predecessors(), this.getWfgNode(), null, "predecessors", null, 0, -1, Gateway.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGateway_Successors(), this.getWfgNode(), null, "successors", null, 0, -1, Gateway.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGateway_GatewayRef(), theBpmn2Package.getGateway(), null, "gatewayRef", null, 0, 1, Gateway.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getGateway__GetBranches(), this.getBranch(), "getBranches", 1, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(exclusiveChoiceEClass, ExclusiveChoice.class, "ExclusiveChoice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(parallelExecutionEClass, ParallelExecution.class, "ParallelExecution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(actionEClass, Action.class, "Action", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAction_Successor(), this.getWfgNode(), null, "successor", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAction_Predecessor(), this.getWfgNode(), null, "predecessor", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(workFlowGraphEClass, WorkFlowGraph.class, "WorkFlowGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorkFlowGraph_Gateways(), this.getGateway(), null, "gateways", null, 0, -1, WorkFlowGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getWorkFlowGraph_StartingNode(), this.getWfgNode(), null, "startingNode", null, 1, 1, WorkFlowGraph.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getWorkFlowGraph_EndingNode(), this.getWfgNode(), null, "endingNode", null, 1, 1, WorkFlowGraph.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getWorkFlowGraph_Actions(), this.getAction(), null, "actions", null, 1, -1, WorkFlowGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getWorkFlowGraph_Participants(), this.getParticipant(), null, "participants", null, 2, -1, WorkFlowGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkFlowGraph_InnerGateway(), this.getGateway(), null, "innerGateway", null, 0, 1, WorkFlowGraph.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getWorkFlowGraph__Initialize(), null, "initialize", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getWorkFlowGraph__RemoveNode__WfgNode(), ecorePackage.getEBoolean(), "removeNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getWfgNode(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getWorkFlowGraph__AddNode__WfgNode(), ecorePackage.getEBoolean(), "addNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getWfgNode(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getWorkFlowGraph__CreateNewExclusiveChoice__String_boolean_boolean(), this.getExclusiveChoice(), "createNewExclusiveChoice", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "merge", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "fork", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getWorkFlowGraph__CreateNewParallelExecution__String_boolean_boolean(), this.getParallelExecution(), "createNewParallelExecution", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "merge", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "fork", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getWorkFlowGraph__RemoveNodes__EList(), ecorePackage.getEBoolean(), "removeNodes", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEEList(), "nodes", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getWorkFlowGraph__ToDOTforGraphViz(), ecorePackage.getEString(), "toDOTforGraphViz", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getWorkFlowGraph__CreateNewMessageExchange__String_String_String_Participant_Participant(), this.getMessageExchange(), "createNewMessageExchange", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "request", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "response", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getParticipant(), "sender", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getParticipant(), "receiver", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getWorkFlowGraph__SaveModel__String(), null, "saveModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "filename", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(messageExchangeEClass, MessageExchange.class, "MessageExchange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMessageExchange_Request(), ecorePackage.getEString(), "request", null, 1, 1, MessageExchange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageExchange_SynchResponse(), ecorePackage.getEString(), "synchResponse", null, 0, 1, MessageExchange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessageExchange_Sender(), this.getParticipant(), null, "sender", null, 1, 1, MessageExchange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessageExchange_Receiver(), this.getParticipant(), null, "receiver", null, 1, 1, MessageExchange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessageExchange_ChoreographyTaskRef(), theBpmn2Package.getChoreographyTask(), null, "choreographyTaskRef", null, 0, 1, MessageExchange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(branchEClass, Branch.class, "Branch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBranch_Nodes(), this.getWfgNode(), null, "nodes", null, 0, -1, Branch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(participantEClass, Participant.class, "Participant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParticipant_Name(), ecorePackage.getEString(), "name", null, 0, 1, Participant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParticipant_Id(), ecorePackage.getEString(), "id", null, 0, 1, Participant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParticipant_ParticipantRef(), theBpmn2Package.getParticipant(), null, "participantRef", null, 0, 1, Participant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //WorkflowgraphPackageImpl
