/**
 */
package ucsb.peerbehavior;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ucsb.peerbehavior.State#getName <em>Name</em>}</li>
 *   <li>{@link ucsb.peerbehavior.State#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link ucsb.peerbehavior.State#getOutcoming <em>Outcoming</em>}</li>
 * </ul>
 * </p>
 *
 * @see ucsb.peerbehavior.PeerbehaviorPackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see ucsb.peerbehavior.PeerbehaviorPackage#getState_Name()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ucsb.peerbehavior.State#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference list.
	 * The list contents are of type {@link ucsb.peerbehavior.Transition}.
	 * It is bidirectional and its opposite is '{@link ucsb.peerbehavior.Transition#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference list.
	 * @see ucsb.peerbehavior.PeerbehaviorPackage#getState_Incoming()
	 * @see ucsb.peerbehavior.Transition#getTo
	 * @model opposite="to"
	 * @generated
	 */
	EList<Transition> getIncoming();

	/**
	 * Returns the value of the '<em><b>Outcoming</b></em>' reference list.
	 * The list contents are of type {@link ucsb.peerbehavior.Transition}.
	 * It is bidirectional and its opposite is '{@link ucsb.peerbehavior.Transition#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outcoming</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outcoming</em>' reference list.
	 * @see ucsb.peerbehavior.PeerbehaviorPackage#getState_Outcoming()
	 * @see ucsb.peerbehavior.Transition#getFrom
	 * @model opposite="from"
	 * @generated
	 */
	EList<Transition> getOutcoming();

} // State
