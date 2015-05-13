/**
 */
package ucsb.systembehavior.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import ucsb.systembehavior.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see ucsb.systembehavior.SystembehaviorPackage
 * @generated
 */
public class SystembehaviorAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SystembehaviorPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystembehaviorAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SystembehaviorPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystembehaviorSwitch<Adapter> modelSwitch =
		new SystembehaviorSwitch<Adapter>() {
			@Override
			public Adapter caseSystemBehavior(SystemBehavior object) {
				return createSystemBehaviorAdapter();
			}
			@Override
			public Adapter casePeerSituation(PeerSituation object) {
				return createPeerSituationAdapter();
			}
			@Override
			public Adapter caseTransition(Transition object) {
				return createTransitionAdapter();
			}
			@Override
			public Adapter caseSend(Send object) {
				return createSendAdapter();
			}
			@Override
			public Adapter caseReceive(Receive object) {
				return createReceiveAdapter();
			}
			@Override
			public Adapter caseInternalTransition(InternalTransition object) {
				return createInternalTransitionAdapter();
			}
			@Override
			public Adapter caseLoopTransition(LoopTransition object) {
				return createLoopTransitionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link ucsb.systembehavior.SystemBehavior <em>System Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ucsb.systembehavior.SystemBehavior
	 * @generated
	 */
	public Adapter createSystemBehaviorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ucsb.systembehavior.PeerSituation <em>Peer Situation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ucsb.systembehavior.PeerSituation
	 * @generated
	 */
	public Adapter createPeerSituationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ucsb.systembehavior.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ucsb.systembehavior.Transition
	 * @generated
	 */
	public Adapter createTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ucsb.systembehavior.Send <em>Send</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ucsb.systembehavior.Send
	 * @generated
	 */
	public Adapter createSendAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ucsb.systembehavior.Receive <em>Receive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ucsb.systembehavior.Receive
	 * @generated
	 */
	public Adapter createReceiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ucsb.systembehavior.InternalTransition <em>Internal Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ucsb.systembehavior.InternalTransition
	 * @generated
	 */
	public Adapter createInternalTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ucsb.systembehavior.LoopTransition <em>Loop Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ucsb.systembehavior.LoopTransition
	 * @generated
	 */
	public Adapter createLoopTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SystembehaviorAdapterFactory
