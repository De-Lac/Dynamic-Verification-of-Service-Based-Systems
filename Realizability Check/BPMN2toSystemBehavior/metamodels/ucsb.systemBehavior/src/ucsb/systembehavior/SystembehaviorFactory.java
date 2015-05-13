/**
 */
package ucsb.systembehavior;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ucsb.systembehavior.SystembehaviorPackage
 * @generated
 */
public interface SystembehaviorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SystembehaviorFactory eINSTANCE = ucsb.systembehavior.impl.SystembehaviorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>System Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System Behavior</em>'.
	 * @generated
	 */
	SystemBehavior createSystemBehavior();

	/**
	 * Returns a new object of class '<em>Peer Situation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Peer Situation</em>'.
	 * @generated
	 */
	PeerSituation createPeerSituation();

	/**
	 * Returns a new object of class '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition</em>'.
	 * @generated
	 */
	Transition createTransition();

	/**
	 * Returns a new object of class '<em>Send</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Send</em>'.
	 * @generated
	 */
	Send createSend();

	/**
	 * Returns a new object of class '<em>Receive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Receive</em>'.
	 * @generated
	 */
	Receive createReceive();

	/**
	 * Returns a new object of class '<em>Internal Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Internal Transition</em>'.
	 * @generated
	 */
	InternalTransition createInternalTransition();

	/**
	 * Returns a new object of class '<em>Loop Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Transition</em>'.
	 * @generated
	 */
	LoopTransition createLoopTransition();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SystembehaviorPackage getSystembehaviorPackage();

} //SystembehaviorFactory
