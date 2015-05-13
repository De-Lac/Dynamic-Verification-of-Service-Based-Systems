/**
 */
package ucsb.peerbehavior.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import ucsb.peerbehavior.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PeerbehaviorFactoryImpl extends EFactoryImpl implements PeerbehaviorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PeerbehaviorFactory init() {
		try {
			PeerbehaviorFactory thePeerbehaviorFactory = (PeerbehaviorFactory)EPackage.Registry.INSTANCE.getEFactory(PeerbehaviorPackage.eNS_URI);
			if (thePeerbehaviorFactory != null) {
				return thePeerbehaviorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PeerbehaviorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PeerbehaviorFactoryImpl() {
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
			case PeerbehaviorPackage.PEER: return createPeer();
			case PeerbehaviorPackage.STATE: return createState();
			case PeerbehaviorPackage.TRANSITION: return createTransition();
			case PeerbehaviorPackage.SEND: return createSend();
			case PeerbehaviorPackage.RECEIVE: return createReceive();
			case PeerbehaviorPackage.INPUT: return createinput();
			case PeerbehaviorPackage.OUTPUT: return createoutput();
			case PeerbehaviorPackage.INTERNAL_TRANSITION: return createInternalTransition();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Peer createPeer() {
		PeerImpl peer = new PeerImpl();
		return peer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
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
	public input createinput() {
		inputImpl input = new inputImpl();
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public output createoutput() {
		outputImpl output = new outputImpl();
		return output;
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
	public PeerbehaviorPackage getPeerbehaviorPackage() {
		return (PeerbehaviorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PeerbehaviorPackage getPackage() {
		return PeerbehaviorPackage.eINSTANCE;
	}

} //PeerbehaviorFactoryImpl
