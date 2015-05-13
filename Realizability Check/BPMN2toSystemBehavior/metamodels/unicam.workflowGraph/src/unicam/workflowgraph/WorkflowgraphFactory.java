/**
 */
package unicam.workflowgraph;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see unicam.workflowgraph.WorkflowgraphPackage
 * @generated
 */
public interface WorkflowgraphFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WorkflowgraphFactory eINSTANCE = unicam.workflowgraph.impl.WorkflowgraphFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Exclusive Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exclusive Choice</em>'.
	 * @generated
	 */
	ExclusiveChoice createExclusiveChoice();

	/**
	 * Returns a new object of class '<em>Parallel Execution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parallel Execution</em>'.
	 * @generated
	 */
	ParallelExecution createParallelExecution();

	/**
	 * Returns a new object of class '<em>Work Flow Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Work Flow Graph</em>'.
	 * @generated
	 */
	WorkFlowGraph createWorkFlowGraph();

	/**
	 * Returns a new object of class '<em>Message Exchange</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Exchange</em>'.
	 * @generated
	 */
	MessageExchange createMessageExchange();

	/**
	 * Returns a new object of class '<em>Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Branch</em>'.
	 * @generated
	 */
	Branch createBranch();

	/**
	 * Returns a new object of class '<em>Participant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Participant</em>'.
	 * @generated
	 */
	<P> Participant<P> createParticipant();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	WorkflowgraphPackage getWorkflowgraphPackage();

} //WorkflowgraphFactory
