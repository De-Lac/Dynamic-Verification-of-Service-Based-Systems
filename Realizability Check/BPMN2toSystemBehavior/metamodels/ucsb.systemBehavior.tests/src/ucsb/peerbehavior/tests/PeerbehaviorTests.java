/**
 */
package ucsb.peerbehavior.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>peerbehavior</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class PeerbehaviorTests extends TestSuite {

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
		TestSuite suite = new PeerbehaviorTests("peerbehavior Tests");
		suite.addTestSuite(PeerTest.class);
		suite.addTestSuite(TransitionTest.class);
		suite.addTestSuite(SendTest.class);
		suite.addTestSuite(ReceiveTest.class);
		suite.addTestSuite(inputTest.class);
		suite.addTestSuite(outputTest.class);
		suite.addTestSuite(InternalTransitionTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PeerbehaviorTests(String name) {
		super(name);
	}

} //PeerbehaviorTests
