/**
 */
package ucsb.systembehavior.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import ucsb.systembehavior.PeerSituation;
import ucsb.systembehavior.SystembehaviorFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Peer Situation</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PeerSituationTest extends TestCase {

	/**
	 * The fixture for this Peer Situation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PeerSituation fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PeerSituationTest.class);
	}

	/**
	 * Constructs a new Peer Situation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PeerSituationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Peer Situation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(PeerSituation fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Peer Situation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PeerSituation getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SystembehaviorFactory.eINSTANCE.createPeerSituation());
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

} //PeerSituationTest
