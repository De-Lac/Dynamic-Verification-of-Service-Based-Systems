/**
 */
package ucsb.peerbehavior.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import ucsb.converesationprotocol.ConveresationprotocolPackage;
import ucsb.converesationprotocol.impl.ConveresationprotocolPackageImpl;
import ucsb.peerbehavior.InternalTransition;
import ucsb.peerbehavior.Message;
import ucsb.peerbehavior.Peer;
import ucsb.peerbehavior.PeerbehaviorFactory;
import ucsb.peerbehavior.PeerbehaviorPackage;
import ucsb.peerbehavior.Receive;
import ucsb.peerbehavior.Send;
import ucsb.peerbehavior.State;
import ucsb.peerbehavior.Transition;
import ucsb.peerbehavior.input;
import ucsb.peerbehavior.output;
import ucsb.systembehavior.SystembehaviorPackage;
import ucsb.systembehavior.impl.SystembehaviorPackageImpl;
import unicam.workflowgraph.WorkflowgraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PeerbehaviorPackageImpl extends EPackageImpl implements PeerbehaviorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass peerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateEClass = null;

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
	private EClass inputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalTransitionEClass = null;

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
	 * @see ucsb.peerbehavior.PeerbehaviorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PeerbehaviorPackageImpl() {
		super(eNS_URI, PeerbehaviorFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PeerbehaviorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PeerbehaviorPackage init() {
		if (isInited) return (PeerbehaviorPackage)EPackage.Registry.INSTANCE.getEPackage(PeerbehaviorPackage.eNS_URI);

		// Obtain or create and register package
		PeerbehaviorPackageImpl thePeerbehaviorPackage = (PeerbehaviorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PeerbehaviorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PeerbehaviorPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		WorkflowgraphPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ConveresationprotocolPackageImpl theConveresationprotocolPackage = (ConveresationprotocolPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConveresationprotocolPackage.eNS_URI) instanceof ConveresationprotocolPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConveresationprotocolPackage.eNS_URI) : ConveresationprotocolPackage.eINSTANCE);
		SystembehaviorPackageImpl theSystembehaviorPackage = (SystembehaviorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SystembehaviorPackage.eNS_URI) instanceof SystembehaviorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SystembehaviorPackage.eNS_URI) : SystembehaviorPackage.eINSTANCE);

		// Create package meta-data objects
		thePeerbehaviorPackage.createPackageContents();
		theConveresationprotocolPackage.createPackageContents();
		theSystembehaviorPackage.createPackageContents();

		// Initialize created meta-data
		thePeerbehaviorPackage.initializePackageContents();
		theConveresationprotocolPackage.initializePackageContents();
		theSystembehaviorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePeerbehaviorPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PeerbehaviorPackage.eNS_URI, thePeerbehaviorPackage);
		return thePeerbehaviorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPeer() {
		return peerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPeer_In() {
		return (EReference)peerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPeer_Out() {
		return (EReference)peerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPeer_States() {
		return (EReference)peerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPeer_InitialState() {
		return (EReference)peerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPeer_Name() {
		return (EAttribute)peerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPeer_Transictions() {
		return (EReference)peerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPeer_Id() {
		return (EAttribute)peerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPeer_Test() {
		return (EAttribute)peerEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPeer_ParticipantRef() {
		return (EReference)peerEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPeer__ToDOTforGraphViz() {
		return peerEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPeer__SaveModel__String() {
		return peerEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessage() {
		return messageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessage_Name() {
		return (EAttribute)messageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessage_Id() {
		return (EAttribute)messageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMessage__HashCode() {
		return messageEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMessage__Equals__EObject() {
		return messageEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getState() {
		return stateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getState_Name() {
		return (EAttribute)stateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getState_Incoming() {
		return (EReference)stateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getState_Outcoming() {
		return (EReference)stateEClass.getEStructuralFeatures().get(2);
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
	public EAttribute getTransition_Name() {
		return (EAttribute)transitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTransition__ToString() {
		return transitionEClass.getEOperations().get(0);
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
	public EReference getSend_Message() {
		return (EReference)sendEClass.getEStructuralFeatures().get(0);
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
	public EReference getReceive_Message() {
		return (EReference)receiveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getinput() {
		return inputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getoutput() {
		return outputEClass;
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
	public PeerbehaviorFactory getPeerbehaviorFactory() {
		return (PeerbehaviorFactory)getEFactoryInstance();
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
		peerEClass = createEClass(PEER);
		createEReference(peerEClass, PEER__IN);
		createEReference(peerEClass, PEER__OUT);
		createEReference(peerEClass, PEER__STATES);
		createEReference(peerEClass, PEER__INITIAL_STATE);
		createEAttribute(peerEClass, PEER__NAME);
		createEReference(peerEClass, PEER__TRANSICTIONS);
		createEAttribute(peerEClass, PEER__ID);
		createEAttribute(peerEClass, PEER__TEST);
		createEReference(peerEClass, PEER__PARTICIPANT_REF);
		createEOperation(peerEClass, PEER___TO_DO_TFOR_GRAPH_VIZ);
		createEOperation(peerEClass, PEER___SAVE_MODEL__STRING);

		messageEClass = createEClass(MESSAGE);
		createEAttribute(messageEClass, MESSAGE__NAME);
		createEAttribute(messageEClass, MESSAGE__ID);
		createEOperation(messageEClass, MESSAGE___EQUALS__EOBJECT);
		createEOperation(messageEClass, MESSAGE___HASH_CODE);

		stateEClass = createEClass(STATE);
		createEAttribute(stateEClass, STATE__NAME);
		createEReference(stateEClass, STATE__INCOMING);
		createEReference(stateEClass, STATE__OUTCOMING);

		transitionEClass = createEClass(TRANSITION);
		createEReference(transitionEClass, TRANSITION__FROM);
		createEReference(transitionEClass, TRANSITION__TO);
		createEAttribute(transitionEClass, TRANSITION__NAME);
		createEOperation(transitionEClass, TRANSITION___TO_STRING);

		sendEClass = createEClass(SEND);
		createEReference(sendEClass, SEND__MESSAGE);

		receiveEClass = createEClass(RECEIVE);
		createEReference(receiveEClass, RECEIVE__MESSAGE);

		inputEClass = createEClass(INPUT);

		outputEClass = createEClass(OUTPUT);

		internalTransitionEClass = createEClass(INTERNAL_TRANSITION);
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
		WorkflowgraphPackage theWorkflowgraphPackage = (WorkflowgraphPackage)EPackage.Registry.INSTANCE.getEPackage(WorkflowgraphPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sendEClass.getESuperTypes().add(this.getTransition());
		receiveEClass.getESuperTypes().add(this.getTransition());
		inputEClass.getESuperTypes().add(this.getMessage());
		outputEClass.getESuperTypes().add(this.getMessage());
		internalTransitionEClass.getESuperTypes().add(this.getTransition());

		// Initialize classes, features, and operations; add parameters
		initEClass(peerEClass, Peer.class, "Peer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPeer_In(), this.getinput(), null, "in", null, 0, -1, Peer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getPeer_In().getEKeys().add(this.getMessage_Name());
		initEReference(getPeer_Out(), this.getoutput(), null, "out", null, 0, -1, Peer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getPeer_Out().getEKeys().add(this.getMessage_Name());
		initEReference(getPeer_States(), this.getState(), null, "states", null, 0, -1, Peer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPeer_InitialState(), this.getState(), null, "initialState", null, 1, 1, Peer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPeer_Name(), ecorePackage.getEString(), "name", null, 1, 1, Peer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPeer_Transictions(), this.getTransition(), null, "transictions", null, 1, -1, Peer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPeer_Id(), ecorePackage.getEString(), "id", null, 1, 1, Peer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPeer_Test(), ecorePackage.getEInt(), "test", "0", 0, 1, Peer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPeer_ParticipantRef(), theWorkflowgraphPackage.getParticipant(), null, "participantRef", null, 0, 1, Peer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getPeer__ToDOTforGraphViz(), ecorePackage.getEString(), "toDOTforGraphViz", 1, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getPeer__SaveModel__String(), null, "saveModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "fileName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(messageEClass, Message.class, "Message", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMessage_Name(), ecorePackage.getEString(), "name", null, 1, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessage_Id(), ecorePackage.getEString(), "id", "", 1, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getMessage__Equals__EObject(), ecorePackage.getEBoolean(), "equals", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMessage__HashCode(), ecorePackage.getEInt(), "hashCode", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getState_Name(), ecorePackage.getEString(), "name", null, 1, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_Incoming(), this.getTransition(), this.getTransition_To(), "incoming", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_Outcoming(), this.getTransition(), this.getTransition_From(), "outcoming", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transitionEClass, Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransition_From(), this.getState(), this.getState_Outcoming(), "from", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_To(), this.getState(), this.getState_Incoming(), "to", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransition_Name(), ecorePackage.getEString(), "name", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getTransition__ToString(), ecorePackage.getEString(), "toString", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sendEClass, Send.class, "Send", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSend_Message(), this.getoutput(), null, "message", null, 1, 1, Send.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(receiveEClass, Receive.class, "Receive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReceive_Message(), this.getinput(), null, "message", null, 1, 1, Receive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputEClass, input.class, "input", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(outputEClass, output.class, "output", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(internalTransitionEClass, InternalTransition.class, "InternalTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //PeerbehaviorPackageImpl
