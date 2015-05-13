/**
 */
package unicam.workflowgraph.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import unicam.workflowgraph.Participant;
import unicam.workflowgraph.WorkflowgraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Participant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link unicam.workflowgraph.impl.ParticipantImpl#getName <em>Name</em>}</li>
 *   <li>{@link unicam.workflowgraph.impl.ParticipantImpl#getId <em>Id</em>}</li>
 *   <li>{@link unicam.workflowgraph.impl.ParticipantImpl#getParticipantRef <em>Participant Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParticipantImpl<P> extends MinimalEObjectImpl.Container implements Participant<P> {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParticipantRef() <em>Participant Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipantRef()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.bpmn2.Participant participantRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParticipantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowgraphPackage.Literals.PARTICIPANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowgraphPackage.PARTICIPANT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.bpmn2.Participant getParticipantRef() {
		if (participantRef != null && participantRef.eIsProxy()) {
			InternalEObject oldParticipantRef = (InternalEObject)participantRef;
			participantRef = (org.eclipse.bpmn2.Participant)eResolveProxy(oldParticipantRef);
			if (participantRef != oldParticipantRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowgraphPackage.PARTICIPANT__PARTICIPANT_REF, oldParticipantRef, participantRef));
			}
		}
		return participantRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.bpmn2.Participant basicGetParticipantRef() {
		return participantRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParticipantRef(org.eclipse.bpmn2.Participant newParticipantRef) {
		org.eclipse.bpmn2.Participant oldParticipantRef = participantRef;
		participantRef = newParticipantRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowgraphPackage.PARTICIPANT__PARTICIPANT_REF, oldParticipantRef, participantRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowgraphPackage.PARTICIPANT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowgraphPackage.PARTICIPANT__NAME:
				return getName();
			case WorkflowgraphPackage.PARTICIPANT__ID:
				return getId();
			case WorkflowgraphPackage.PARTICIPANT__PARTICIPANT_REF:
				if (resolve) return getParticipantRef();
				return basicGetParticipantRef();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WorkflowgraphPackage.PARTICIPANT__NAME:
				setName((String)newValue);
				return;
			case WorkflowgraphPackage.PARTICIPANT__ID:
				setId((String)newValue);
				return;
			case WorkflowgraphPackage.PARTICIPANT__PARTICIPANT_REF:
				setParticipantRef((org.eclipse.bpmn2.Participant)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case WorkflowgraphPackage.PARTICIPANT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case WorkflowgraphPackage.PARTICIPANT__ID:
				setId(ID_EDEFAULT);
				return;
			case WorkflowgraphPackage.PARTICIPANT__PARTICIPANT_REF:
				setParticipantRef((org.eclipse.bpmn2.Participant)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WorkflowgraphPackage.PARTICIPANT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case WorkflowgraphPackage.PARTICIPANT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case WorkflowgraphPackage.PARTICIPANT__PARTICIPANT_REF:
				return participantRef != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //ParticipantImpl
