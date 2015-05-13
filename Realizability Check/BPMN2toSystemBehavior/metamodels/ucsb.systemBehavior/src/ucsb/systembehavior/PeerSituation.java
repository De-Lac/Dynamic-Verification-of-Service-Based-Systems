/**
 */
package ucsb.systembehavior;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import ucsb.peerbehavior.State;
import ucsb.peerbehavior.input;
import unicam.workflowgraph.Gateway;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Peer Situation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ucsb.systembehavior.PeerSituation#getMessages <em>Messages</em>}</li>
 *   <li>{@link ucsb.systembehavior.PeerSituation#getStates <em>States</em>}</li>
 *   <li>{@link ucsb.systembehavior.PeerSituation#getName <em>Name</em>}</li>
 *   <li>{@link ucsb.systembehavior.PeerSituation#getId <em>Id</em>}</li>
 *   <li>{@link ucsb.systembehavior.PeerSituation#getOutcoming <em>Outcoming</em>}</li>
 *   <li>{@link ucsb.systembehavior.PeerSituation#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link ucsb.systembehavior.PeerSituation#getGatewayRef <em>Gateway Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see ucsb.systembehavior.SystembehaviorPackage#getPeerSituation()
 * @model
 * @generated
 */
public interface PeerSituation extends EObject {
	/**
	 * Returns the value of the '<em><b>Messages</b></em>' reference list.
	 * The list contents are of type {@link ucsb.peerbehavior.input}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Messages</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Messages</em>' reference list.
	 * @see ucsb.systembehavior.SystembehaviorPackage#getPeerSituation_Messages()
	 * @model
	 * @generated
	 */
	EList<input> getMessages();

	/**
	 * Returns the value of the '<em><b>States</b></em>' reference list.
	 * The list contents are of type {@link ucsb.peerbehavior.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' reference list.
	 * @see ucsb.systembehavior.SystembehaviorPackage#getPeerSituation_States()
	 * @model ordered="false"
	 * @generated
	 */
	EList<State> getStates();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #setName(String)
	 * @see ucsb.systembehavior.SystembehaviorPackage#getPeerSituation_Name()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ucsb.systembehavior.PeerSituation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Unsets the value of the '{@link ucsb.systembehavior.PeerSituation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link ucsb.systembehavior.PeerSituation#getName <em>Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' attribute is set.
	 * @see #unsetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	boolean isSetName();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #isSetId()
	 * @see #unsetId()
	 * @see #setId(String)
	 * @see ucsb.systembehavior.SystembehaviorPackage#getPeerSituation_Id()
	 * @model unsettable="true" id="true" required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link ucsb.systembehavior.PeerSituation#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #isSetId()
	 * @see #unsetId()
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Unsets the value of the '{@link ucsb.systembehavior.PeerSituation#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetId()
	 * @see #getId()
	 * @see #setId(String)
	 * @generated
	 */
	void unsetId();

	/**
	 * Returns whether the value of the '{@link ucsb.systembehavior.PeerSituation#getId <em>Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Id</em>' attribute is set.
	 * @see #unsetId()
	 * @see #getId()
	 * @see #setId(String)
	 * @generated
	 */
	boolean isSetId();

	/**
	 * Returns the value of the '<em><b>Outcoming</b></em>' reference list.
	 * The list contents are of type {@link ucsb.systembehavior.Transition}.
	 * It is bidirectional and its opposite is '{@link ucsb.systembehavior.Transition#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outcoming</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outcoming</em>' reference list.
	 * @see ucsb.systembehavior.SystembehaviorPackage#getPeerSituation_Outcoming()
	 * @see ucsb.systembehavior.Transition#getFrom
	 * @model opposite="from" required="true"
	 * @generated
	 */
	EList<Transition> getOutcoming();

	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference list.
	 * The list contents are of type {@link ucsb.systembehavior.Transition}.
	 * It is bidirectional and its opposite is '{@link ucsb.systembehavior.Transition#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference list.
	 * @see ucsb.systembehavior.SystembehaviorPackage#getPeerSituation_Incoming()
	 * @see ucsb.systembehavior.Transition#getTo
	 * @model opposite="to" required="true"
	 * @generated
	 */
	EList<Transition> getIncoming();

	/**
	 * Returns the value of the '<em><b>Gateway Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gateway Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gateway Ref</em>' reference.
	 * @see #setGatewayRef(Gateway)
	 * @see ucsb.systembehavior.SystembehaviorPackage#getPeerSituation_GatewayRef()
	 * @model
	 * @generated
	 */
	Gateway getGatewayRef();

	/**
	 * Sets the value of the '{@link ucsb.systembehavior.PeerSituation#getGatewayRef <em>Gateway Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gateway Ref</em>' reference.
	 * @see #getGatewayRef()
	 * @generated
	 */
	void setGatewayRef(Gateway value);

} // PeerSituation
