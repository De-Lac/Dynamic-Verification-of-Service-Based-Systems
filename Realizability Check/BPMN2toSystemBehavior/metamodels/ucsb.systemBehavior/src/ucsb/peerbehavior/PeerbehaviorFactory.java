/**
 */
package ucsb.peerbehavior;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ucsb.peerbehavior.PeerbehaviorPackage
 * @generated
 */
public interface PeerbehaviorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PeerbehaviorFactory eINSTANCE = ucsb.peerbehavior.impl.PeerbehaviorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Peer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Peer</em>'.
	 * @generated
	 */
	Peer createPeer();

	/**
	 * Returns a new object of class '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State</em>'.
	 * @generated
	 */
	State createState();

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
	 * Returns a new object of class '<em>input</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>input</em>'.
	 * @generated
	 */
	input createinput();

	/**
	 * Returns a new object of class '<em>output</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>output</em>'.
	 * @generated
	 */
	output createoutput();

	/**
	 * Returns a new object of class '<em>Internal Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Internal Transition</em>'.
	 * @generated
	 */
	InternalTransition createInternalTransition();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PeerbehaviorPackage getPeerbehaviorPackage();

} //PeerbehaviorFactory
