/**
 */
package ucsb.converesationprotocol.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

import ucsb.peerbehavior.tests.PeerbehaviorTests;
import ucsb.systembehavior.tests.SystembehaviorTests;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>SystemBehavior</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemBehaviorAllTests extends TestSuite {

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
		TestSuite suite = new SystemBehaviorAllTests("SystemBehavior Tests");
		suite.addTest(SystembehaviorTests.suite());
		suite.addTest(PeerbehaviorTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemBehaviorAllTests(String name) {
		super(name);
	}

} //SystemBehaviorAllTests
