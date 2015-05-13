/**
 */
package ucsb.peerbehavior;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Send</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ucsb.peerbehavior.Send#getMessage <em>Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see ucsb.peerbehavior.PeerbehaviorPackage#getSend()
 * @model
 * @generated
 */
public interface Send extends Transition {
	/**
	 * Returns the value of the '<em><b>Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' reference.
	 * @see #setMessage(output)
	 * @see ucsb.peerbehavior.PeerbehaviorPackage#getSend_Message()
	 * @model required="true"
	 * @generated
	 */
	output getMessage();

	/**
	 * Sets the value of the '{@link ucsb.peerbehavior.Send#getMessage <em>Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' reference.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(output value);

} // Send
