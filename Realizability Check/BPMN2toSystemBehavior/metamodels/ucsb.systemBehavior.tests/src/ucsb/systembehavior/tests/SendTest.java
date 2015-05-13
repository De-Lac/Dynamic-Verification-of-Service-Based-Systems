/**
 */
package ucsb.systembehavior.tests;

import junit.textui.TestRunner;

import ucsb.systembehavior.Send;
import ucsb.systembehavior.SystembehaviorFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Send</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SendTest extends TransitionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SendTest.class);
	}

	/**
	 * Constructs a new Send test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SendTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Send test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Send getFixture() {
		return (Send)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SystembehaviorFactory.eINSTANCE.createSend());
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

} //SendTest
