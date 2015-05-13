/**
 */
package ucsb.converesationprotocol;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ucsb.converesationprotocol.ConveresationprotocolFactory
 * @model kind="package"
 * @generated
 */
public interface ConveresationprotocolPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "converesationprotocol";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://converesationprotocol/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "converesationprotocol";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConveresationprotocolPackage eINSTANCE = ucsb.converesationprotocol.impl.ConveresationprotocolPackageImpl.init();

	/**
	 * The meta object id for the '{@link ucsb.converesationprotocol.impl.ConversationProtocolImpl <em>Conversation Protocol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ucsb.converesationprotocol.impl.ConversationProtocolImpl
	 * @see ucsb.converesationprotocol.impl.ConveresationprotocolPackageImpl#getConversationProtocol()
	 * @generated
	 */
	int CONVERSATION_PROTOCOL = 0;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_PROTOCOL__STATES = 0;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_PROTOCOL__MESSAGES = 1;

	/**
	 * The feature id for the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_PROTOCOL__INITIAL_STATE = 2;

	/**
	 * The number of structural features of the '<em>Conversation Protocol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_PROTOCOL_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Conversation Protocol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_PROTOCOL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ucsb.converesationprotocol.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ucsb.converesationprotocol.impl.StateImpl
	 * @see ucsb.converesationprotocol.impl.ConveresationprotocolPackageImpl#getState()
	 * @generated
	 */
	int STATE = 1;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OUTGOING = 0;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__INCOMING = 1;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ucsb.converesationprotocol.impl.MessageImpl <em>Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ucsb.converesationprotocol.impl.MessageImpl
	 * @see ucsb.converesationprotocol.impl.ConveresationprotocolPackageImpl#getMessage()
	 * @generated
	 */
	int MESSAGE = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__TARGET = 1;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__SENDER = 2;

	/**
	 * The feature id for the '<em><b>Receiver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__RECEIVER = 3;

	/**
	 * The number of structural features of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link ucsb.converesationprotocol.ConversationProtocol <em>Conversation Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conversation Protocol</em>'.
	 * @see ucsb.converesationprotocol.ConversationProtocol
	 * @generated
	 */
	EClass getConversationProtocol();

	/**
	 * Returns the meta object for the containment reference list '{@link ucsb.converesationprotocol.ConversationProtocol#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see ucsb.converesationprotocol.ConversationProtocol#getStates()
	 * @see #getConversationProtocol()
	 * @generated
	 */
	EReference getConversationProtocol_States();

	/**
	 * Returns the meta object for the containment reference list '{@link ucsb.converesationprotocol.ConversationProtocol#getMessages <em>Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Messages</em>'.
	 * @see ucsb.converesationprotocol.ConversationProtocol#getMessages()
	 * @see #getConversationProtocol()
	 * @generated
	 */
	EReference getConversationProtocol_Messages();

	/**
	 * Returns the meta object for the reference '{@link ucsb.converesationprotocol.ConversationProtocol#getInitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial State</em>'.
	 * @see ucsb.converesationprotocol.ConversationProtocol#getInitialState()
	 * @see #getConversationProtocol()
	 * @generated
	 */
	EReference getConversationProtocol_InitialState();

	/**
	 * Returns the meta object for class '{@link ucsb.converesationprotocol.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see ucsb.converesationprotocol.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the reference '{@link ucsb.converesationprotocol.State#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outgoing</em>'.
	 * @see ucsb.converesationprotocol.State#getOutgoing()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Outgoing();

	/**
	 * Returns the meta object for the reference '{@link ucsb.converesationprotocol.State#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Incoming</em>'.
	 * @see ucsb.converesationprotocol.State#getIncoming()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Incoming();

	/**
	 * Returns the meta object for class '{@link ucsb.converesationprotocol.Message <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message</em>'.
	 * @see ucsb.converesationprotocol.Message
	 * @generated
	 */
	EClass getMessage();

	/**
	 * Returns the meta object for the reference '{@link ucsb.converesationprotocol.Message#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see ucsb.converesationprotocol.Message#getSource()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_Source();

	/**
	 * Returns the meta object for the reference '{@link ucsb.converesationprotocol.Message#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see ucsb.converesationprotocol.Message#getTarget()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_Target();

	/**
	 * Returns the meta object for the reference '{@link ucsb.converesationprotocol.Message#getSender <em>Sender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sender</em>'.
	 * @see ucsb.converesationprotocol.Message#getSender()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_Sender();

	/**
	 * Returns the meta object for the reference '{@link ucsb.converesationprotocol.Message#getReceiver <em>Receiver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Receiver</em>'.
	 * @see ucsb.converesationprotocol.Message#getReceiver()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_Receiver();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConveresationprotocolFactory getConveresationprotocolFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link ucsb.converesationprotocol.impl.ConversationProtocolImpl <em>Conversation Protocol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ucsb.converesationprotocol.impl.ConversationProtocolImpl
		 * @see ucsb.converesationprotocol.impl.ConveresationprotocolPackageImpl#getConversationProtocol()
		 * @generated
		 */
		EClass CONVERSATION_PROTOCOL = eINSTANCE.getConversationProtocol();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONVERSATION_PROTOCOL__STATES = eINSTANCE.getConversationProtocol_States();

		/**
		 * The meta object literal for the '<em><b>Messages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONVERSATION_PROTOCOL__MESSAGES = eINSTANCE.getConversationProtocol_Messages();

		/**
		 * The meta object literal for the '<em><b>Initial State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONVERSATION_PROTOCOL__INITIAL_STATE = eINSTANCE.getConversationProtocol_InitialState();

		/**
		 * The meta object literal for the '{@link ucsb.converesationprotocol.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ucsb.converesationprotocol.impl.StateImpl
		 * @see ucsb.converesationprotocol.impl.ConveresationprotocolPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OUTGOING = eINSTANCE.getState_Outgoing();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__INCOMING = eINSTANCE.getState_Incoming();

		/**
		 * The meta object literal for the '{@link ucsb.converesationprotocol.impl.MessageImpl <em>Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ucsb.converesationprotocol.impl.MessageImpl
		 * @see ucsb.converesationprotocol.impl.ConveresationprotocolPackageImpl#getMessage()
		 * @generated
		 */
		EClass MESSAGE = eINSTANCE.getMessage();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__SOURCE = eINSTANCE.getMessage_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__TARGET = eINSTANCE.getMessage_Target();

		/**
		 * The meta object literal for the '<em><b>Sender</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__SENDER = eINSTANCE.getMessage_Sender();

		/**
		 * The meta object literal for the '<em><b>Receiver</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__RECEIVER = eINSTANCE.getMessage_Receiver();

	}

} //ConveresationprotocolPackage
