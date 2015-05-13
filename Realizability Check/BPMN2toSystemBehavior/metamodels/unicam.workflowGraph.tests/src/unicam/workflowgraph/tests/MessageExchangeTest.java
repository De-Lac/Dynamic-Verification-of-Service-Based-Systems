/**
 */
package unicam.workflowgraph.tests;

import junit.textui.TestRunner;

import unicam.workflowgraph.MessageExchange;
import unicam.workflowgraph.WorkflowgraphFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Message Exchange</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MessageExchangeTest extends ActionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MessageExchangeTest.class);
	}

	/**
	 * Constructs a new Message Exchange test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageExchangeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Message Exchange test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected MessageExchange getFixture() {
		return (MessageExchange)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(WorkflowgraphFactory.eINSTANCE.createMessageExchange());
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

} //MessageExchangeTest
