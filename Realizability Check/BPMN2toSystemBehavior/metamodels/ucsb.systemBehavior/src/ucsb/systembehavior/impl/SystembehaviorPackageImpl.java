/**
 */
package ucsb.systembehavior.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import ucsb.converesationprotocol.ConveresationprotocolPackage;

import ucsb.converesationprotocol.impl.ConveresationprotocolPackageImpl;

import ucsb.peerbehavior.PeerbehaviorPackage;

import ucsb.peerbehavior.impl.PeerbehaviorPackageImpl;

import ucsb.systembehavior.InternalTransition;
import ucsb.systembehavior.LoopTransition;
import ucsb.systembehavior.PeerSituation;
import ucsb.systembehavior.Receive;
import ucsb.systembehavior.Send;
import ucsb.systembehavior.SystemBehavior;
import ucsb.systembehavior.SystembehaviorFactory;
import ucsb.systembehavior.SystembehaviorPackage;
import ucsb.systembehavior.Transition;
import unicam.workflowgraph.WorkflowgraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SystembehaviorPackageImpl extends EPackageImpl implements SystembehaviorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemBehaviorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass peerSituationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sendEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass receiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalTransitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopTransitionEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see ucsb.systembehavior.SystembehaviorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SystembehaviorPackageImpl() {
		super(eNS_URI, SystembehaviorFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SystembehaviorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SystembehaviorPackage init() {
		if (isInited) return (SystembehaviorPackage)EPackage.Registry.INSTANCE.getEPackage(SystembehaviorPackage.eNS_URI);

		// Obtain or create and register package
		SystembehaviorPackageImpl theSystembehaviorPackage = (SystembehaviorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SystembehaviorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SystembehaviorPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		WorkflowgraphPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ConveresationprotocolPackageImpl theConveresationprotocolPackage = (ConveresationprotocolPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConveresationprotocolPackage.eNS_URI) instanceof ConveresationprotocolPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConveresationprotocolPackage.eNS_URI) : ConveresationprotocolPackage.eINSTANCE);
		PeerbehaviorPackageImpl thePeerbehaviorPackage = (PeerbehaviorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PeerbehaviorPackage.eNS_URI) instanceof PeerbehaviorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PeerbehaviorPackage.eNS_URI) : PeerbehaviorPackage.eINSTANCE);

		// Create package meta-data objects
		theSystembehaviorPackage.createPackageContents();
		theConveresationprotocolPackage.createPackageContents();
		thePeerbehaviorPackage.createPackageContents();

		// Initialize created meta-data
		theSystembehaviorPackage.initializePackageContents();
		theConveresationprotocolPackage.initializePackageContents();
		thePeerbehaviorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSystembehaviorPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SystembehaviorPackage.eNS_URI, theSystembehaviorPackage);
		return theSystembehaviorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemBehavior() {
		return systemBehaviorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemBehavior_Peers() {
		return (EReference)systemBehaviorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemBehavior_Messages() {
		return (EReference)systemBehaviorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemBehavior_States() {
		return (EReference)systemBehaviorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemBehavior_Transitions() {
		return (EReference)systemBehaviorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemBehavior_InitialState() {
		return (EReference)systemBehaviorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSystemBehavior__ToDOTforGraphViz() {
		return systemBehaviorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSystemBehavior__SaveModel__String() {
		return systemBehaviorEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSystemBehavior__DeleteInternalTransition() {
		return systemBehaviorEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPeerSituation() {
		return peerSituationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPeerSituation_Messages() {
		return (EReference)peerSituationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPeerSituation_States() {
		return (EReference)peerSituationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPeerSituation_Name() {
		return (EAttribute)peerSituationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPeerSituation_Id() {
		return (EAttribute)peerSituationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPeerSituation_Outcoming() {
		return (EReference)peerSituationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPeerSituation_Incoming() {
		return (EReference)peerSituationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPeerSituation_GatewayRef() {
		return (EReference)peerSituationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransition() {
		return transitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransition_From() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransition_To() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSend() {
		return sendEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSend_Source() {
		return (EReference)sendEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSend_Target() {
		return (EReference)sendEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSend_Message() {
		return (EReference)sendEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSend_Name() {
		return (EAttribute)sendEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSend_MessageExchangeRef() {
		return (EReference)sendEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReceive() {
		return receiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalTransition() {
		return internalTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopTransition() {
		return loopTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystembehaviorFactory getSystembehaviorFactory() {
		return (SystembehaviorFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		systemBehaviorEClass = createEClass(SYSTEM_BEHAVIOR);
		createEReference(systemBehaviorEClass, SYSTEM_BEHAVIOR__PEERS);
		createEReference(systemBehaviorEClass, SYSTEM_BEHAVIOR__MESSAGES);
		createEReference(systemBehaviorEClass, SYSTEM_BEHAVIOR__STATES);
		createEReference(systemBehaviorEClass, SYSTEM_BEHAVIOR__TRANSITIONS);
		createEReference(systemBehaviorEClass, SYSTEM_BEHAVIOR__INITIAL_STATE);
		createEOperation(systemBehaviorEClass, SYSTEM_BEHAVIOR___TO_DO_TFOR_GRAPH_VIZ);
		createEOperation(systemBehaviorEClass, SYSTEM_BEHAVIOR___SAVE_MODEL__STRING);
		createEOperation(systemBehaviorEClass, SYSTEM_BEHAVIOR___DELETE_INTERNAL_TRANSITION);

		peerSituationEClass = createEClass(PEER_SITUATION);
		createEReference(peerSituationEClass, PEER_SITUATION__MESSAGES);
		createEReference(peerSituationEClass, PEER_SITUATION__STATES);
		createEAttribute(peerSituationEClass, PEER_SITUATION__NAME);
		createEAttribute(peerSituationEClass, PEER_SITUATION__ID);
		createEReference(peerSituationEClass, PEER_SITUATION__OUTCOMING);
		createEReference(peerSituationEClass, PEER_SITUATION__INCOMING);
		createEReference(peerSituationEClass, PEER_SITUATION__GATEWAY_REF);

		transitionEClass = createEClass(TRANSITION);
		createEReference(transitionEClass, TRANSITION__FROM);
		createEReference(transitionEClass, TRANSITION__TO);

		sendEClass = createEClass(SEND);
		createEReference(sendEClass, SEND__SOURCE);
		createEReference(sendEClass, SEND__TARGET);
		createEReference(sendEClass, SEND__MESSAGE);
		createEAttribute(sendEClass, SEND__NAME);
		createEReference(sendEClass, SEND__MESSAGE_EXCHANGE_REF);

		receiveEClass = createEClass(RECEIVE);

		internalTransitionEClass = createEClass(INTERNAL_TRANSITION);

		loopTransitionEClass = createEClass(LOOP_TRANSITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		PeerbehaviorPackage thePeerbehaviorPackage = (PeerbehaviorPackage)EPackage.Registry.INSTANCE.getEPackage(PeerbehaviorPackage.eNS_URI);
		WorkflowgraphPackage theWorkflowgraphPackage = (WorkflowgraphPackage)EPackage.Registry.INSTANCE.getEPackage(WorkflowgraphPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sendEClass.getESuperTypes().add(this.getTransition());
		receiveEClass.getESuperTypes().add(this.getTransition());
		internalTransitionEClass.getESuperTypes().add(this.getTransition());
		loopTransitionEClass.getESuperTypes().add(this.getInternalTransition());

		// Initialize classes, features, and operations; add parameters
		initEClass(systemBehaviorEClass, SystemBehavior.class, "SystemBehavior", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystemBehavior_Peers(), thePeerbehaviorPackage.getPeer(), null, "peers", null, 1, -1, SystemBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemBehavior_Messages(), thePeerbehaviorPackage.getMessage(), null, "messages", null, 0, -1, SystemBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemBehavior_States(), this.getPeerSituation(), null, "states", null, 1, -1, SystemBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemBehavior_Transitions(), this.getTransition(), null, "transitions", null, 1, -1, SystemBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemBehavior_InitialState(), this.getPeerSituation(), null, "initialState", null, 1, 1, SystemBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getSystemBehavior__ToDOTforGraphViz(), ecorePackage.getEString(), "toDOTforGraphViz", 1, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getSystemBehavior__SaveModel__String(), null, "saveModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "fileName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getSystemBehavior__DeleteInternalTransition(), null, "deleteInternalTransition", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(peerSituationEClass, PeerSituation.class, "PeerSituation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPeerSituation_Messages(), thePeerbehaviorPackage.getinput(), null, "messages", null, 0, -1, PeerSituation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPeerSituation_States(), thePeerbehaviorPackage.getState(), null, "states", null, 0, -1, PeerSituation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPeerSituation_Name(), ecorePackage.getEString(), "name", null, 0, 1, PeerSituation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPeerSituation_Id(), ecorePackage.getEString(), "id", null, 1, 1, PeerSituation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPeerSituation_Outcoming(), this.getTransition(), this.getTransition_From(), "outcoming", null, 1, -1, PeerSituation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPeerSituation_Incoming(), this.getTransition(), this.getTransition_To(), "incoming", null, 1, -1, PeerSituation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPeerSituation_GatewayRef(), theWorkflowgraphPackage.getGateway(), null, "gatewayRef", null, 0, 1, PeerSituation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transitionEClass, Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransition_From(), this.getPeerSituation(), this.getPeerSituation_Outcoming(), "from", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_To(), this.getPeerSituation(), this.getPeerSituation_Incoming(), "to", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sendEClass, Send.class, "Send", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSend_Source(), thePeerbehaviorPackage.getPeer(), null, "source", null, 1, 1, Send.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSend_Target(), thePeerbehaviorPackage.getPeer(), null, "target", null, 1, 1, Send.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSend_Message(), thePeerbehaviorPackage.getMessage(), null, "message", null, 1, 1, Send.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSend_Name(), ecorePackage.getEString(), "name", null, 0, 1, Send.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSend_MessageExchangeRef(), theWorkflowgraphPackage.getMessageExchange(), null, "messageExchangeRef", null, 0, 1, Send.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(receiveEClass, Receive.class, "Receive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(internalTransitionEClass, InternalTransition.class, "InternalTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loopTransitionEClass, LoopTransition.class, "LoopTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (getSend_MessageExchangeRef(), 
		   source, 
		   new String[] {
			 "name", "messageExchangeRef"
		   });
	}

} //SystembehaviorPackageImpl
