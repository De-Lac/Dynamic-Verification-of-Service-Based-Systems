/**
 */
package unicam.workflowgraph.tests;

import junit.textui.TestRunner;

import unicam.workflowgraph.ExclusiveChoice;
import unicam.workflowgraph.WorkflowgraphFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Exclusive Choice</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExclusiveChoiceTest extends GatewayTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ExclusiveChoiceTest.class);
	}

	/**
	 * Constructs a new Exclusive Choice test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExclusiveChoiceTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Exclusive Choice test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ExclusiveChoice getFixture() {
		return (ExclusiveChoice)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(WorkflowgraphFactory.eINSTANCE.createExclusiveChoice());
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

} //ExclusiveChoiceTest
