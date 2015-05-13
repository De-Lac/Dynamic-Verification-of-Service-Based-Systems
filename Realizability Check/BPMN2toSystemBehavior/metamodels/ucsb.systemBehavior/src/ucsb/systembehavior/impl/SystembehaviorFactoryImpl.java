/**
 */
package ucsb.systembehavior.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import ucsb.systembehavior.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SystembehaviorFactoryImpl extends EFactoryImpl implements SystembehaviorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SystembehaviorFactory init() {
		try {
			SystembehaviorFactory theSystembehaviorFactory = (SystembehaviorFactory)EPackage.Registry.INSTANCE.getEFactory(SystembehaviorPackage.eNS_URI);
			if (theSystembehaviorFactory != null) {
				return theSystembehaviorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SystembehaviorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystembehaviorFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SystembehaviorPackage.SYSTEM_BEHAVIOR: return createSystemBehavior();
			case SystembehaviorPackage.PEER_SITUATION: return createPeerSituation();
			case SystembehaviorPackage.TRANSITION: return createTransition();
			case SystembehaviorPackage.SEND: return createSend();
			case SystembehaviorPackage.RECEIVE: return createReceive();
			case SystembehaviorPackage.INTERNAL_TRANSITION: return createInternalTransition();
			case SystembehaviorPackage.LOOP_TRANSITION: return createLoopTransition();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemBehavior createSystemBehavior() {
		SystemBehaviorImpl systemBehavior = new SystemBehaviorImpl();
		return systemBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PeerSituation createPeerSituation() {
		PeerSituationImpl peerSituation = new PeerSituationImpl();
		return peerSituation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition createTransition() {
		TransitionImpl transition = new TransitionImpl();
		return transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Send createSend() {
		SendImpl send = new SendImpl();
		return send;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Receive createReceive() {
		ReceiveImpl receive = new ReceiveImpl();
		return receive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalTransition createInternalTransition() {
		InternalTransitionImpl internalTransition = new InternalTransitionImpl();
		return internalTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopTransition createLoopTransition() {
		LoopTransitionImpl loopTransition = new LoopTransitionImpl();
		return loopTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystembehaviorPackage getSystembehaviorPackage() {
		return (SystembehaviorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SystembehaviorPackage getPackage() {
		return SystembehaviorPackage.eINSTANCE;
	}

} //SystembehaviorFactoryImpl
