/**
 */
package ucsb.converesationprotocol.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import ucsb.converesationprotocol.ConveresationprotocolFactory;
import ucsb.converesationprotocol.ConveresationprotocolPackage;
import ucsb.converesationprotocol.ConversationProtocol;
import ucsb.converesationprotocol.Message;
import ucsb.converesationprotocol.State;

import ucsb.peerbehavior.PeerbehaviorPackage;

import ucsb.peerbehavior.impl.PeerbehaviorPackageImpl;

import ucsb.systembehavior.SystembehaviorPackage;

import ucsb.systembehavior.impl.SystembehaviorPackageImpl;
import unicam.workflowgraph.WorkflowgraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConveresationprotocolPackageImpl extends EPackageImpl implements ConveresationprotocolPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conversationProtocolEClass = null;

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
	private EClass messageEClass = null;

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
	 * @see ucsb.converesationprotocol.ConveresationprotocolPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ConveresationprotocolPackageImpl() {
		super(eNS_URI, ConveresationprotocolFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ConveresationprotocolPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ConveresationprotocolPackage init() {
		if (isInited) return (ConveresationprotocolPackage)EPackage.Registry.INSTANCE.getEPackage(ConveresationprotocolPackage.eNS_URI);

		// Obtain or create and register package
		ConveresationprotocolPackageImpl theConveresationprotocolPackage = (ConveresationprotocolPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ConveresationprotocolPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ConveresationprotocolPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		WorkflowgraphPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SystembehaviorPackageImpl theSystembehaviorPackage = (SystembehaviorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SystembehaviorPackage.eNS_URI) instanceof SystembehaviorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SystembehaviorPackage.eNS_URI) : SystembehaviorPackage.eINSTANCE);
		PeerbehaviorPackageImpl thePeerbehaviorPackage = (PeerbehaviorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PeerbehaviorPackage.eNS_URI) instanceof PeerbehaviorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PeerbehaviorPackage.eNS_URI) : PeerbehaviorPackage.eINSTANCE);

		// Create package meta-data objects
		theConveresationprotocolPackage.createPackageContents();
		theSystembehaviorPackage.createPackageContents();
		thePeerbehaviorPackage.createPackageContents();

		// Initialize created meta-data
		theConveresationprotocolPackage.initializePackageContents();
		theSystembehaviorPackage.initializePackageContents();
		thePeerbehaviorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theConveresationprotocolPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ConveresationprotocolPackage.eNS_URI, theConveresationprotocolPackage);
		return theConveresationprotocolPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConversationProtocol() {
		return conversationProtocolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConversationProtocol_States() {
		return (EReference)conversationProtocolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConversationProtocol_Messages() {
		return (EReference)conversationProtocolEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConversationProtocol_InitialState() {
		return (EReference)conversationProtocolEClass.getEStructuralFeatures().get(2);
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
	public EReference getState_Outgoing() {
		return (EReference)stateEClass.getEStructuralFeatures().get(0);
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
	public EClass getMessage() {
		return messageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessage_Source() {
		return (EReference)messageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessage_Target() {
		return (EReference)messageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessage_Sender() {
		return (EReference)messageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessage_Receiver() {
		return (EReference)messageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConveresationprotocolFactory getConveresationprotocolFactory() {
		return (ConveresationprotocolFactory)getEFactoryInstance();
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
		conversationProtocolEClass = createEClass(CONVERSATION_PROTOCOL);
		createEReference(conversationProtocolEClass, CONVERSATION_PROTOCOL__STATES);
		createEReference(conversationProtocolEClass, CONVERSATION_PROTOCOL__MESSAGES);
		createEReference(conversationProtocolEClass, CONVERSATION_PROTOCOL__INITIAL_STATE);

		stateEClass = createEClass(STATE);
		createEReference(stateEClass, STATE__OUTGOING);
		createEReference(stateEClass, STATE__INCOMING);

		messageEClass = createEClass(MESSAGE);
		createEReference(messageEClass, MESSAGE__SOURCE);
		createEReference(messageEClass, MESSAGE__TARGET);
		createEReference(messageEClass, MESSAGE__SENDER);
		createEReference(messageEClass, MESSAGE__RECEIVER);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(conversationProtocolEClass, ConversationProtocol.class, "ConversationProtocol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConversationProtocol_States(), this.getState(), null, "states", null, 1, -1, ConversationProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConversationProtocol_Messages(), this.getMessage(), null, "messages", null, 1, -1, ConversationProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConversationProtocol_InitialState(), this.getState(), null, "initialState", null, 1, 1, ConversationProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getState_Outgoing(), this.getMessage(), null, "outgoing", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_Incoming(), this.getMessage(), null, "incoming", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(messageEClass, Message.class, "Message", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMessage_Source(), this.getState(), null, "source", null, 0, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessage_Target(), this.getState(), null, "target", null, 0, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessage_Sender(), thePeerbehaviorPackage.getPeer(), null, "sender", null, 1, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessage_Receiver(), thePeerbehaviorPackage.getPeer(), null, "receiver", null, 1, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ConveresationprotocolPackageImpl
