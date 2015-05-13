/**
 */
package unicam.workflowgraph.tests;

import junit.textui.TestRunner;

import unicam.workflowgraph.ParallelExecution;
import unicam.workflowgraph.WorkflowgraphFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Parallel Execution</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParallelExecutionTest extends GatewayTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ParallelExecutionTest.class);
	}

	/**
	 * Constructs a new Parallel Execution test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParallelExecutionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Parallel Execution test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ParallelExecution getFixture() {
		return (ParallelExecution)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(WorkflowgraphFactory.eINSTANCE.createParallelExecution());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ParallelExecutionTest
