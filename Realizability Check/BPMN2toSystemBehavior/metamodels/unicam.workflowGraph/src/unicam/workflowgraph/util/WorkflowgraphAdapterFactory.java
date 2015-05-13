/**
 */
package unicam.workflowgraph.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import unicam.workflowgraph.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see unicam.workflowgraph.WorkflowgraphPackage
 * @generated
 */
public class WorkflowgraphAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static WorkflowgraphPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowgraphAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = WorkflowgraphPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkflowgraphSwitch<Adapter> modelSwitch =
		new WorkflowgraphSwitch<Adapter>() {
			@Override
			public Adapter caseWfgNode(WfgNode object) {
				return createWfgNodeAdapter();
			}
			@Override
			public Adapter caseGateway(Gateway object) {
				return createGatewayAdapter();
			}
			@Override
			public Adapter caseExclusiveChoice(ExclusiveChoice object) {
				return createExclusiveChoiceAdapter();
			}
			@Override
			public Adapter caseParallelExecution(ParallelExecution object) {
				return createParallelExecutionAdapter();
			}
			@Override
			public <GenericType> Adapter caseAction(Action<GenericType> object) {
				return createActionAdapter();
			}
			@Override
			public Adapter caseWorkFlowGraph(WorkFlowGraph object) {
				return createWorkFlowGraphAdapter();
			}
			@Override
			public Adapter caseMessageExchange(MessageExchange object) {
				return createMessageExchangeAdapter();
			}
			@Override
			public Adapter caseBranch(Branch object) {
				return createBranchAdapter();
			}
			@Override
			public <P> Adapter caseParticipant(Participant<P> object) {
				return createParticipantAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link unicam.workflowgraph.WfgNode <em>Wfg Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unicam.workflowgraph.WfgNode
	 * @generated
	 */
	public Adapter createWfgNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unicam.workflowgraph.Gateway <em>Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unicam.workflowgraph.Gateway
	 * @generated
	 */
	public Adapter createGatewayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unicam.workflowgraph.ExclusiveChoice <em>Exclusive Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unicam.workflowgraph.ExclusiveChoice
	 * @generated
	 */
	public Adapter createExclusiveChoiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unicam.workflowgraph.ParallelExecution <em>Parallel Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unicam.workflowgraph.ParallelExecution
	 * @generated
	 */
	public Adapter createParallelExecutionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unicam.workflowgraph.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unicam.workflowgraph.Action
	 * @generated
	 */
	public Adapter createActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unicam.workflowgraph.WorkFlowGraph <em>Work Flow Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unicam.workflowgraph.WorkFlowGraph
	 * @generated
	 */
	public Adapter createWorkFlowGraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unicam.workflowgraph.MessageExchange <em>Message Exchange</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unicam.workflowgraph.MessageExchange
	 * @generated
	 */
	public Adapter createMessageExchangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unicam.workflowgraph.Branch <em>Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unicam.workflowgraph.Branch
	 * @generated
	 */
	public Adapter createBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link unicam.workflowgraph.Participant <em>Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see unicam.workflowgraph.Participant
	 * @generated
	 */
	public Adapter createParticipantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //WorkflowgraphAdapterFactory
