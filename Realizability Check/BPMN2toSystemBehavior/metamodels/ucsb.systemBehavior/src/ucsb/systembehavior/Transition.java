/**
 */
package ucsb.systembehavior;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ucsb.systembehavior.Transition#getFrom <em>From</em>}</li>
 *   <li>{@link ucsb.systembehavior.Transition#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @see ucsb.systembehavior.SystembehaviorPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends EObject {
	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link ucsb.systembehavior.PeerSituation#getOutcoming <em>Outcoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(PeerSituation)
	 * @see ucsb.systembehavior.SystembehaviorPackage#getTransition_From()
	 * @see ucsb.systembehavior.PeerSituation#getOutcoming
	 * @model opposite="outcoming" required="true"
	 * @generated
	 */
	PeerSituation getFrom();

	/**
	 * Sets the value of the '{@link ucsb.systembehavior.Transition#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(PeerSituation value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link ucsb.systembehavior.PeerSituation#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(PeerSituation)
	 * @see ucsb.systembehavior.SystembehaviorPackage#getTransition_To()
	 * @see ucsb.systembehavior.PeerSituation#getIncoming
	 * @model opposite="incoming" required="true"
	 * @generated
	 */
	PeerSituation getTo();

	/**
	 * Sets the value of the '{@link ucsb.systembehavior.Transition#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(PeerSituation value);

} // Transition
