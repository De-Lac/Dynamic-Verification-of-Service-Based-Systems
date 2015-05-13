/**
 */
package ucsb.peerbehavior.tests;

import junit.textui.TestRunner;

import ucsb.peerbehavior.PeerbehaviorFactory;
import ucsb.peerbehavior.output;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>output</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class outputTest extends MessageTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(outputTest.class);
	}

	/**
	 * Constructs a new output test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public outputTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this output test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected output getFixture() {
		return (output)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(PeerbehaviorFactory.eINSTANCE.createoutput());
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

} //outputTest
