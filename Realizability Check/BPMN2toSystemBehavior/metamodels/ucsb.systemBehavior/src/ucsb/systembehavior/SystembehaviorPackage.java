/**
 */
package ucsb.systembehavior;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
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
 * @see ucsb.systembehavior.SystembehaviorFactory
 * @model kind="package"
 * @generated
 */
public interface SystembehaviorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "systembehavior";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://systembehavior/1.0.5";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "systembehavior";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SystembehaviorPackage eINSTANCE = ucsb.systembehavior.impl.SystembehaviorPackageImpl.init();

	/**
	 * The meta object id for the '{@link ucsb.systembehavior.impl.SystemBehaviorImpl <em>System Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ucsb.systembehavior.impl.SystemBehaviorImpl
	 * @see ucsb.systembehavior.impl.SystembehaviorPackageImpl#getSystemBehavior()
	 * @generated
	 */
	int SYSTEM_BEHAVIOR = 0;

	/**
	 * The feature id for the '<em><b>Peers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BEHAVIOR__PEERS = 0;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BEHAVIOR__MESSAGES = 1;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BEHAVIOR__STATES = 2;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BEHAVIOR__TRANSITIONS = 3;

	/**
	 * The feature id for the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BEHAVIOR__INITIAL_STATE = 4;

	/**
	 * The number of structural features of the '<em>System Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BEHAVIOR_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>To DO Tfor Graph Viz</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BEHAVIOR___TO_DO_TFOR_GRAPH_VIZ = 0;

	/**
	 * The operation id for the '<em>Save Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BEHAVIOR___SAVE_MODEL__STRING = 1;

	/**
	 * The operation id for the '<em>Delete Internal Transition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BEHAVIOR___DELETE_INTERNAL_TRANSITION = 2;

	/**
	 * The number of operations of the '<em>System Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_BEHAVIOR_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link ucsb.systembehavior.impl.PeerSituationImpl <em>Peer Situation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ucsb.systembehavior.impl.PeerSituationImpl
	 * @see ucsb.systembehavior.impl.SystembehaviorPackageImpl#getPeerSituation()
	 * @generated
	 */
	int PEER_SITUATION = 1;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER_SITUATION__MESSAGES = 0;

	/**
	 * The feature id for the '<em><b>States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER_SITUATION__STATES = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER_SITUATION__NAME = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER_SITUATION__ID = 3;

	/**
	 * The feature id for the '<em><b>Outcoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER_SITUATION__OUTCOMING = 4;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER_SITUATION__INCOMING = 5;

	/**
	 * The feature id for the '<em><b>Gateway Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER_SITUATION__GATEWAY_REF = 6;

	/**
	 * The number of structural features of the '<em>Peer Situation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER_SITUATION_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Peer Situation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER_SITUATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ucsb.systembehavior.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ucsb.systembehavior.impl.TransitionImpl
	 * @see ucsb.systembehavior.impl.SystembehaviorPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 2;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__FROM = 0;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TO = 1;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ucsb.systembehavior.impl.SendImpl <em>Send</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ucsb.systembehavior.impl.SendImpl
	 * @see ucsb.systembehavior.impl.SystembehaviorPackageImpl#getSend()
	 * @generated
	 */
	int SEND = 3;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND__FROM = TRANSITION__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND__TO = TRANSITION__TO;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND__SOURCE = TRANSITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND__TARGET = TRANSITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND__MESSAGE = TRANSITION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND__NAME = TRANSITION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Message Exchange Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND__MESSAGE_EXCHANGE_REF = TRANSITION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Send</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_FEATURE_COUNT = TRANSITION_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Send</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_OPERATION_COUNT = TRANSITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ucsb.systembehavior.impl.ReceiveImpl <em>Receive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ucsb.systembehavior.impl.ReceiveImpl
	 * @see ucsb.systembehavior.impl.SystembehaviorPackageImpl#getReceive()
	 * @generated
	 */
	int RECEIVE = 4;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE__FROM = TRANSITION__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE__TO = TRANSITION__TO;

	/**
	 * The number of structural features of the '<em>Receive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_FEATURE_COUNT = TRANSITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Receive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_OPERATION_COUNT = TRANSITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ucsb.systembehavior.impl.InternalTransitionImpl <em>Internal Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ucsb.systembehavior.impl.InternalTransitionImpl
	 * @see ucsb.systembehavior.impl.SystembehaviorPackageImpl#getInternalTransition()
	 * @generated
	 */
	int INTERNAL_TRANSITION = 5;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_TRANSITION__FROM = TRANSITION__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_TRANSITION__TO = TRANSITION__TO;

	/**
	 * The number of structural features of the '<em>Internal Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_TRANSITION_FEATURE_COUNT = TRANSITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Internal Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_TRANSITION_OPERATION_COUNT = TRANSITION_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link ucsb.systembehavior.impl.LoopTransitionImpl <em>Loop Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ucsb.systembehavior.impl.LoopTransitionImpl
	 * @see ucsb.systembehavior.impl.SystembehaviorPackageImpl#getLoopTransition()
	 * @generated
	 */
	int LOOP_TRANSITION = 6;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_TRANSITION__FROM = INTERNAL_TRANSITION__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_TRANSITION__TO = INTERNAL_TRANSITION__TO;

	/**
	 * The number of structural features of the '<em>Loop Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_TRANSITION_FEATURE_COUNT = INTERNAL_TRANSITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Loop Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_TRANSITION_OPERATION_COUNT = INTERNAL_TRANSITION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link ucsb.systembehavior.SystemBehavior <em>System Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Behavior</em>'.
	 * @see ucsb.systembehavior.SystemBehavior
	 * @generated
	 */
	EClass getSystemBehavior();

	/**
	 * Returns the meta object for the reference list '{@link ucsb.systembehavior.SystemBehavior#getPeers <em>Peers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Peers</em>'.
	 * @see ucsb.systembehavior.SystemBehavior#getPeers()
	 * @see #getSystemBehavior()
	 * @generated
	 */
	EReference getSystemBehavior_Peers();

	/**
	 * Returns the meta object for the reference list '{@link ucsb.systembehavior.SystemBehavior#getMessages <em>Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Messages</em>'.
	 * @see ucsb.systembehavior.SystemBehavior#getMessages()
	 * @see #getSystemBehavior()
	 * @generated
	 */
	EReference getSystemBehavior_Messages();

	/**
	 * Returns the meta object for the containment reference list '{@link ucsb.systembehavior.SystemBehavior#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see ucsb.systembehavior.SystemBehavior#getStates()
	 * @see #getSystemBehavior()
	 * @generated
	 */
	EReference getSystemBehavior_States();

	/**
	 * Returns the meta object for the containment reference list '{@link ucsb.systembehavior.SystemBehavior#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see ucsb.systembehavior.SystemBehavior#getTransitions()
	 * @see #getSystemBehavior()
	 * @generated
	 */
	EReference getSystemBehavior_Transitions();

	/**
	 * Returns the meta object for the reference '{@link ucsb.systembehavior.SystemBehavior#getInitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial State</em>'.
	 * @see ucsb.systembehavior.SystemBehavior#getInitialState()
	 * @see #getSystemBehavior()
	 * @generated
	 */
	EReference getSystemBehavior_InitialState();

	/**
	 * Returns the meta object for the '{@link ucsb.systembehavior.SystemBehavior#toDOTforGraphViz() <em>To DO Tfor Graph Viz</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To DO Tfor Graph Viz</em>' operation.
	 * @see ucsb.systembehavior.SystemBehavior#toDOTforGraphViz()
	 * @generated
	 */
	EOperation getSystemBehavior__ToDOTforGraphViz();

	/**
	 * Returns the meta object for the '{@link ucsb.systembehavior.SystemBehavior#saveModel(java.lang.String) <em>Save Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Save Model</em>' operation.
	 * @see ucsb.systembehavior.SystemBehavior#saveModel(java.lang.String)
	 * @generated
	 */
	EOperation getSystemBehavior__SaveModel__String();

	/**
	 * Returns the meta object for the '{@link ucsb.systembehavior.SystemBehavior#deleteInternalTransition() <em>Delete Internal Transition</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Internal Transition</em>' operation.
	 * @see ucsb.systembehavior.SystemBehavior#deleteInternalTransition()
	 * @generated
	 */
	EOperation getSystemBehavior__DeleteInternalTransition();

	/**
	 * Returns the meta object for class '{@link ucsb.systembehavior.PeerSituation <em>Peer Situation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Peer Situation</em>'.
	 * @see ucsb.systembehavior.PeerSituation
	 * @generated
	 */
	EClass getPeerSituation();

	/**
	 * Returns the meta object for the reference list '{@link ucsb.systembehavior.PeerSituation#getMessages <em>Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Messages</em>'.
	 * @see ucsb.systembehavior.PeerSituation#getMessages()
	 * @see #getPeerSituation()
	 * @generated
	 */
	EReference getPeerSituation_Messages();

	/**
	 * Returns the meta object for the reference list '{@link ucsb.systembehavior.PeerSituation#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>States</em>'.
	 * @see ucsb.systembehavior.PeerSituation#getStates()
	 * @see #getPeerSituation()
	 * @generated
	 */
	EReference getPeerSituation_States();

	/**
	 * Returns the meta object for the attribute '{@link ucsb.systembehavior.PeerSituation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ucsb.systembehavior.PeerSituation#getName()
	 * @see #getPeerSituation()
	 * @generated
	 */
	EAttribute getPeerSituation_Name();

	/**
	 * Returns the meta object for the attribute '{@link ucsb.systembehavior.PeerSituation#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see ucsb.systembehavior.PeerSituation#getId()
	 * @see #getPeerSituation()
	 * @generated
	 */
	EAttribute getPeerSituation_Id();

	/**
	 * Returns the meta object for the reference list '{@link ucsb.systembehavior.PeerSituation#getOutcoming <em>Outcoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outcoming</em>'.
	 * @see ucsb.systembehavior.PeerSituation#getOutcoming()
	 * @see #getPeerSituation()
	 * @generated
	 */
	EReference getPeerSituation_Outcoming();

	/**
	 * Returns the meta object for the reference list '{@link ucsb.systembehavior.PeerSituation#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming</em>'.
	 * @see ucsb.systembehavior.PeerSituation#getIncoming()
	 * @see #getPeerSituation()
	 * @generated
	 */
	EReference getPeerSituation_Incoming();

	/**
	 * Returns the meta object for the reference '{@link ucsb.systembehavior.PeerSituation#getGatewayRef <em>Gateway Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Gateway Ref</em>'.
	 * @see ucsb.systembehavior.PeerSituation#getGatewayRef()
	 * @see #getPeerSituation()
	 * @generated
	 */
	EReference getPeerSituation_GatewayRef();

	/**
	 * Returns the meta object for class '{@link ucsb.systembehavior.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see ucsb.systembehavior.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference '{@link ucsb.systembehavior.Transition#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see ucsb.systembehavior.Transition#getFrom()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_From();

	/**
	 * Returns the meta object for the reference '{@link ucsb.systembehavior.Transition#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see ucsb.systembehavior.Transition#getTo()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_To();

	/**
	 * Returns the meta object for class '{@link ucsb.systembehavior.Send <em>Send</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Send</em>'.
	 * @see ucsb.systembehavior.Send
	 * @generated
	 */
	EClass getSend();

	/**
	 * Returns the meta object for the reference '{@link ucsb.systembehavior.Send#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see ucsb.systembehavior.Send#getSource()
	 * @see #getSend()
	 * @generated
	 */
	EReference getSend_Source();

	/**
	 * Returns the meta object for the reference '{@link ucsb.systembehavior.Send#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see ucsb.systembehavior.Send#getTarget()
	 * @see #getSend()
	 * @generated
	 */
	EReference getSend_Target();

	/**
	 * Returns the meta object for the reference '{@link ucsb.systembehavior.Send#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Message</em>'.
	 * @see ucsb.systembehavior.Send#getMessage()
	 * @see #getSend()
	 * @generated
	 */
	EReference getSend_Message();

	/**
	 * Returns the meta object for the attribute '{@link ucsb.systembehavior.Send#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ucsb.systembehavior.Send#getName()
	 * @see #getSend()
	 * @generated
	 */
	EAttribute getSend_Name();

	/**
	 * Returns the meta object for the reference '{@link ucsb.systembehavior.Send#getMessageExchangeRef <em>Message Exchange Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Message Exchange Ref</em>'.
	 * @see ucsb.systembehavior.Send#getMessageExchangeRef()
	 * @see #getSend()
	 * @generated
	 */
	EReference getSend_MessageExchangeRef();

	/**
	 * Returns the meta object for class '{@link ucsb.systembehavior.Receive <em>Receive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Receive</em>'.
	 * @see ucsb.systembehavior.Receive
	 * @generated
	 */
	EClass getReceive();

	/**
	 * Returns the meta object for class '{@link ucsb.systembehavior.InternalTransition <em>Internal Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Transition</em>'.
	 * @see ucsb.systembehavior.InternalTransition
	 * @generated
	 */
	EClass getInternalTransition();

	/**
	 * Returns the meta object for class '{@link ucsb.systembehavior.LoopTransition <em>Loop Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Transition</em>'.
	 * @see ucsb.systembehavior.LoopTransition
	 * @generated
	 */
	EClass getLoopTransition();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SystembehaviorFactory getSystembehaviorFactory();

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
		 * The meta object literal for the '{@link ucsb.systembehavior.impl.SystemBehaviorImpl <em>System Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ucsb.systembehavior.impl.SystemBehaviorImpl
		 * @see ucsb.systembehavior.impl.SystembehaviorPackageImpl#getSystemBehavior()
		 * @generated
		 */
		EClass SYSTEM_BEHAVIOR = eINSTANCE.getSystemBehavior();

		/**
		 * The meta object literal for the '<em><b>Peers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_BEHAVIOR__PEERS = eINSTANCE.getSystemBehavior_Peers();

		/**
		 * The meta object literal for the '<em><b>Messages</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_BEHAVIOR__MESSAGES = eINSTANCE.getSystemBehavior_Messages();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_BEHAVIOR__STATES = eINSTANCE.getSystemBehavior_States();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_BEHAVIOR__TRANSITIONS = eINSTANCE.getSystemBehavior_Transitions();

		/**
		 * The meta object literal for the '<em><b>Initial State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_BEHAVIOR__INITIAL_STATE = eINSTANCE.getSystemBehavior_InitialState();

		/**
		 * The meta object literal for the '<em><b>To DO Tfor Graph Viz</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SYSTEM_BEHAVIOR___TO_DO_TFOR_GRAPH_VIZ = eINSTANCE.getSystemBehavior__ToDOTforGraphViz();

		/**
		 * The meta object literal for the '<em><b>Save Model</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SYSTEM_BEHAVIOR___SAVE_MODEL__STRING = eINSTANCE.getSystemBehavior__SaveModel__String();

		/**
		 * The meta object literal for the '<em><b>Delete Internal Transition</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SYSTEM_BEHAVIOR___DELETE_INTERNAL_TRANSITION = eINSTANCE.getSystemBehavior__DeleteInternalTransition();

		/**
		 * The meta object literal for the '{@link ucsb.systembehavior.impl.PeerSituationImpl <em>Peer Situation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ucsb.systembehavior.impl.PeerSituationImpl
		 * @see ucsb.systembehavior.impl.SystembehaviorPackageImpl#getPeerSituation()
		 * @generated
		 */
		EClass PEER_SITUATION = eINSTANCE.getPeerSituation();

		/**
		 * The meta object literal for the '<em><b>Messages</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PEER_SITUATION__MESSAGES = eINSTANCE.getPeerSituation_Messages();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PEER_SITUATION__STATES = eINSTANCE.getPeerSituation_States();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PEER_SITUATION__NAME = eINSTANCE.getPeerSituation_Name();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PEER_SITUATION__ID = eINSTANCE.getPeerSituation_Id();

		/**
		 * The meta object literal for the '<em><b>Outcoming</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PEER_SITUATION__OUTCOMING = eINSTANCE.getPeerSituation_Outcoming();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PEER_SITUATION__INCOMING = eINSTANCE.getPeerSituation_Incoming();

		/**
		 * The meta object literal for the '<em><b>Gateway Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PEER_SITUATION__GATEWAY_REF = eINSTANCE.getPeerSituation_GatewayRef();

		/**
		 * The meta object literal for the '{@link ucsb.systembehavior.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ucsb.systembehavior.impl.TransitionImpl
		 * @see ucsb.systembehavior.impl.SystembehaviorPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__FROM = eINSTANCE.getTransition_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TO = eINSTANCE.getTransition_To();

		/**
		 * The meta object literal for the '{@link ucsb.systembehavior.impl.SendImpl <em>Send</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ucsb.systembehavior.impl.SendImpl
		 * @see ucsb.systembehavior.impl.SystembehaviorPackageImpl#getSend()
		 * @generated
		 */
		EClass SEND = eINSTANCE.getSend();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND__SOURCE = eINSTANCE.getSend_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND__TARGET = eINSTANCE.getSend_Target();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND__MESSAGE = eINSTANCE.getSend_Message();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEND__NAME = eINSTANCE.getSend_Name();

		/**
		 * The meta object literal for the '<em><b>Message Exchange Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND__MESSAGE_EXCHANGE_REF = eINSTANCE.getSend_MessageExchangeRef();

		/**
		 * The meta object literal for the '{@link ucsb.systembehavior.impl.ReceiveImpl <em>Receive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ucsb.systembehavior.impl.ReceiveImpl
		 * @see ucsb.systembehavior.impl.SystembehaviorPackageImpl#getReceive()
		 * @generated
		 */
		EClass RECEIVE = eINSTANCE.getReceive();

		/**
		 * The meta object literal for the '{@link ucsb.systembehavior.impl.InternalTransitionImpl <em>Internal Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ucsb.systembehavior.impl.InternalTransitionImpl
		 * @see ucsb.systembehavior.impl.SystembehaviorPackageImpl#getInternalTransition()
		 * @generated
		 */
		EClass INTERNAL_TRANSITION = eINSTANCE.getInternalTransition();

		/**
		 * The meta object literal for the '{@link ucsb.systembehavior.impl.LoopTransitionImpl <em>Loop Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ucsb.systembehavior.impl.LoopTransitionImpl
		 * @see ucsb.systembehavior.impl.SystembehaviorPackageImpl#getLoopTransition()
		 * @generated
		 */
		EClass LOOP_TRANSITION = eINSTANCE.getLoopTransition();

	}

} //SystembehaviorPackage
