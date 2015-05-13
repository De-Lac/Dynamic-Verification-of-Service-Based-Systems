/**
 */
package ucsb.systembehavior.tests;

import junit.textui.TestRunner;

import ucsb.systembehavior.InternalTransition;
import ucsb.systembehavior.SystembehaviorFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Internal Transition</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class InternalTransitionTest extends TransitionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(InternalTransitionTest.class);
	}

	/**
	 * Constructs a new Internal Transition test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalTransitionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Internal Transition test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected InternalTransition getFixture() {
		return (InternalTransition)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SystembehaviorFactory.eINSTANCE.createInternalTransition());
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

} //InternalTransitionTest
