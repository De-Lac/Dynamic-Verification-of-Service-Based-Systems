/**
 */
package ucsb.peerbehavior.tests;

import junit.textui.TestRunner;

import ucsb.peerbehavior.PeerbehaviorFactory;
import ucsb.peerbehavior.input;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>input</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class inputTest extends MessageTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(inputTest.class);
	}

	/**
	 * Constructs a new input test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public inputTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this input test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected input getFixture() {
		return (input)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(PeerbehaviorFactory.eINSTANCE.createinput());
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

} //inputTest
