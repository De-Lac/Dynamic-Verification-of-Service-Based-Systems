/**
 */
package unicam.workflowgraph.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>workflowgraph</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorkflowgraphTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new WorkflowgraphTests("workflowgraph Tests");
		suite.addTestSuite(ExclusiveChoiceTest.class);
		suite.addTestSuite(ParallelExecutionTest.class);
		suite.addTestSuite(WorkFlowGraphTest.class);
		suite.addTestSuite(MessageExchangeTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowgraphTests(String name) {
		super(name);
	}

} //WorkflowgraphTests
