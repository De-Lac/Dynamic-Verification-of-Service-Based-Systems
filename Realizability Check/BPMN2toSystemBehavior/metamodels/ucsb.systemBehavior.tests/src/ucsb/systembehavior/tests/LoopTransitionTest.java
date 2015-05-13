/**
 */
package ucsb.systembehavior.tests;

import junit.textui.TestRunner;

import ucsb.systembehavior.LoopTransition;
import ucsb.systembehavior.SystembehaviorFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Loop Transition</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LoopTransitionTest extends InternalTransitionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LoopTransitionTest.class);
	}

	/**
	 * Constructs a new Loop Transition test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopTransitionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Loop Transition test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected LoopTransition getFixture() {
		return (LoopTransition)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SystembehaviorFactory.eINSTANCE.createLoopTransition());
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

} //LoopTransitionTest
