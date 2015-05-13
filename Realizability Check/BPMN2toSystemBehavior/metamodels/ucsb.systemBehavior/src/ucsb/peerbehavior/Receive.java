/**
 */
package ucsb.peerbehavior;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Receive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ucsb.peerbehavior.Receive#getMessage <em>Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see ucsb.peerbehavior.PeerbehaviorPackage#getReceive()
 * @model
 * @generated
 */
public interface Receive extends Transition {
	/**
	 * Returns the value of the '<em><b>Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' reference.
	 * @see #setMessage(input)
	 * @see ucsb.peerbehavior.PeerbehaviorPackage#getReceive_Message()
	 * @model required="true"
	 * @generated
	 */
	input getMessage();

	/**
	 * Sets the value of the '{@link ucsb.peerbehavior.Receive#getMessage <em>Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' reference.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(input value);

} // Receive
