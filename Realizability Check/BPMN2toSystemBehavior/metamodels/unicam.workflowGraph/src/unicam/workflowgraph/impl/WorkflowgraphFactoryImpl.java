/**
 */
package unicam.workflowgraph.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import unicam.workflowgraph.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorkflowgraphFactoryImpl extends EFactoryImpl implements WorkflowgraphFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WorkflowgraphFactory init() {
		try {
			WorkflowgraphFactory theWorkflowgraphFactory = (WorkflowgraphFactory)EPackage.Registry.INSTANCE.getEFactory(WorkflowgraphPackage.eNS_URI);
			if (theWorkflowgraphFactory != null) {
				return theWorkflowgraphFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new WorkflowgraphFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowgraphFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case WorkflowgraphPackage.EXCLUSIVE_CHOICE: return createExclusiveChoice();
			case WorkflowgraphPackage.PARALLEL_EXECUTION: return createParallelExecution();
			case WorkflowgraphPackage.WORK_FLOW_GRAPH: return createWorkFlowGraph();
			case WorkflowgraphPackage.MESSAGE_EXCHANGE: return createMessageExchange();
			case WorkflowgraphPackage.BRANCH: return createBranch();
			case WorkflowgraphPackage.PARTICIPANT: return createParticipant();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExclusiveChoice createExclusiveChoice() {
		ExclusiveChoiceImpl exclusiveChoice = new ExclusiveChoiceImpl();
		return exclusiveChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParallelExecution createParallelExecution() {
		ParallelExecutionImpl parallelExecution = new ParallelExecutionImpl();
		return parallelExecution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkFlowGraph createWorkFlowGraph() {
		WorkFlowGraphImpl workFlowGraph = new WorkFlowGraphImpl();
		return workFlowGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageExchange createMessageExchange() {
		MessageExchangeImpl messageExchange = new MessageExchangeImpl();
		return messageExchange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Branch createBranch() {
		BranchImpl branch = new BranchImpl();
		return branch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <P> Participant<P> createParticipant() {
		ParticipantImpl<P> participant = new ParticipantImpl<P>();
		return participant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowgraphPackage getWorkflowgraphPackage() {
		return (WorkflowgraphPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static WorkflowgraphPackage getPackage() {
		return WorkflowgraphPackage.eINSTANCE;
	}

} //WorkflowgraphFactoryImpl
