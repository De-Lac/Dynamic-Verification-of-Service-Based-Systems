/**
 */
package ucsb.peerbehavior;

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
 * @see ucsb.peerbehavior.PeerbehaviorFactory
 * @model kind="package"
 * @generated
 */
public interface PeerbehaviorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "peerbehavior";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://peerbehavior/1.0.2";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "peerbehavior";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PeerbehaviorPackage eINSTANCE = ucsb.peerbehavior.impl.PeerbehaviorPackageImpl.init();

	/**
	 * The meta object id for the '{@link ucsb.peerbehavior.impl.PeerImpl <em>Peer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ucsb.peerbehavior.impl.PeerImpl
	 * @see ucsb.peerbehavior.impl.PeerbehaviorPackageImpl#getPeer()
	 * @generated
	 */
	int PEER = 0;

	/**
	 * The feature id for the '<em><b>In</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER__IN = 0;

	/**
	 * The feature id for the '<em><b>Out</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER__OUT = 1;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER__STATES = 2;

	/**
	 * The feature id for the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER__INITIAL_STATE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER__NAME = 4;

	/**
	 * The feature id for the '<em><b>Transictions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER__TRANSICTIONS = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER__ID = 6;

	/**
	 * The feature id for the '<em><b>Test</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER__TEST = 7;

	/**
	 * The feature id for the '<em><b>Participant Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER__PARTICIPANT_REF = 8;

	/**
	 * The number of structural features of the '<em>Peer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER_FEATURE_COUNT = 9;

	/**
	 * The operation id for the '<em>To DO Tfor Graph Viz</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER___TO_DO_TFOR_GRAPH_VIZ = 0;

	/**
	 * The operation id for the '<em>Save Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER___SAVE_MODEL__STRING = 1;

	/**
	 * The number of operations of the '<em>Peer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEER_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link ucsb.peerbehavior.impl.MessageImpl <em>Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ucsb.peerbehavior.impl.MessageImpl
	 * @see ucsb.peerbehavior.impl.PeerbehaviorPackageImpl#getMessage()
	 * @generated
	 */
	int MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__ID = 1;

	/**
	 * The number of structural features of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE___EQUALS__EOBJECT = 0;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE___HASH_CODE = 1;

	/**
	 * The number of operations of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link ucsb.peerbehavior.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ucsb.peerbehavior.impl.StateImpl
	 * @see ucsb.peerbehavior.impl.PeerbehaviorPackageImpl#getState()
	 * @generated
	 */
	int STATE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__INCOMING = 1;

	/**
	 * The feature id for the '<em><b>Outcoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OUTCOMING = 2;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ucsb.peerbehavior.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ucsb.peerbehavior.impl.TransitionImpl
	 * @see ucsb.peerbehavior.impl.PeerbehaviorPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 3;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__NAME = 2;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION___TO_STRING = 0;

	/**
	 * The number of operations of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link ucsb.peerbehavior.impl.SendImpl <em>Send</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ucsb.peerbehavior.impl.SendImpl
	 * @see ucsb.peerbehavior.impl.PeerbehaviorPackageImpl#getSend()
	 * @generated
	 */
	int SEND = 4;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND__NAME = TRANSITION__NAME;

	/**
	 * The feature id for the '<em><b>Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND__MESSAGE = TRANSITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Send</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_FEATURE_COUNT = TRANSITION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND___TO_STRING = TRANSITION___TO_STRING;

	/**
	 * The number of operations of the '<em>Send</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_OPERATION_COUNT = TRANSITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ucsb.peerbehavior.impl.ReceiveImpl <em>Receive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ucsb.peerbehavior.impl.ReceiveImpl
	 * @see ucsb.peerbehavior.impl.PeerbehaviorPackageImpl#getReceive()
	 * @generated
	 */
	int RECEIVE = 5;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE__NAME = TRANSITION__NAME;

	/**
	 * The feature id for the '<em><b>Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE__MESSAGE = TRANSITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Receive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_FEATURE_COUNT = TRANSITION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE___TO_STRING = TRANSITION___TO_STRING;

	/**
	 * The number of operations of the '<em>Receive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_OPERATION_COUNT = TRANSITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ucsb.peerbehavior.impl.inputImpl <em>input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ucsb.peerbehavior.impl.inputImpl
	 * @see ucsb.peerbehavior.impl.PeerbehaviorPackageImpl#getinput()
	 * @generated
	 */
	int INPUT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__NAME = MESSAGE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__ID = MESSAGE__ID;

	/**
	 * The number of structural features of the '<em>input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT___EQUALS__EOBJECT = MESSAGE___EQUALS__EOBJECT;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT___HASH_CODE = MESSAGE___HASH_CODE;

	/**
	 * The number of operations of the '<em>input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ucsb.peerbehavior.impl.outputImpl <em>output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ucsb.peerbehavior.impl.outputImpl
	 * @see ucsb.peerbehavior.impl.PeerbehaviorPackageImpl#getoutput()
	 * @generated
	 */
	int OUTPUT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__NAME = MESSAGE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__ID = MESSAGE__ID;

	/**
	 * The number of structural features of the '<em>output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT___EQUALS__EOBJECT = MESSAGE___EQUALS__EOBJECT;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT___HASH_CODE = MESSAGE___HASH_CODE;

	/**
	 * The number of operations of the '<em>output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ucsb.peerbehavior.impl.InternalTransitionImpl <em>Internal Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ucsb.peerbehavior.impl.InternalTransitionImpl
	 * @see ucsb.peerbehavior.impl.PeerbehaviorPackageImpl#getInternalTransition()
	 * @generated
	 */
	int INTERNAL_TRANSITION = 8;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_TRANSITION__NAME = TRANSITION__NAME;

	/**
	 * The number of structural features of the '<em>Internal Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_TRANSITION_FEATURE_COUNT = TRANSITION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_TRANSITION___TO_STRING = TRANSITION___TO_STRING;

	/**
	 * The number of operations of the '<em>Internal Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_TRANSITION_OPERATION_COUNT = TRANSITION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link ucsb.peerbehavior.Peer <em>Peer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Peer</em>'.
	 * @see ucsb.peerbehavior.Peer
	 * @generated
	 */
	EClass getPeer();

	/**
	 * Returns the meta object for the containment reference list '{@link ucsb.peerbehavior.Peer#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>In</em>'.
	 * @see ucsb.peerbehavior.Peer#getIn()
	 * @see #getPeer()
	 * @generated
	 */
	EReference getPeer_In();

	/**
	 * Returns the meta object for the containment reference list '{@link ucsb.peerbehavior.Peer#getOut <em>Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Out</em>'.
	 * @see ucsb.peerbehavior.Peer#getOut()
	 * @see #getPeer()
	 * @generated
	 */
	EReference getPeer_Out();

	/**
	 * Returns the meta object for the containment reference list '{@link ucsb.peerbehavior.Peer#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see ucsb.peerbehavior.Peer#getStates()
	 * @see #getPeer()
	 * @generated
	 */
	EReference getPeer_States();

	/**
	 * Returns the meta object for the reference '{@link ucsb.peerbehavior.Peer#getInitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial State</em>'.
	 * @see ucsb.peerbehavior.Peer#getInitialState()
	 * @see #getPeer()
	 * @generated
	 */
	EReference getPeer_InitialState();

	/**
	 * Returns the meta object for the attribute '{@link ucsb.peerbehavior.Peer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ucsb.peerbehavior.Peer#getName()
	 * @see #getPeer()
	 * @generated
	 */
	EAttribute getPeer_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link ucsb.peerbehavior.Peer#getTransictions <em>Transictions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transictions</em>'.
	 * @see ucsb.peerbehavior.Peer#getTransictions()
	 * @see #getPeer()
	 * @generated
	 */
	EReference getPeer_Transictions();

	/**
	 * Returns the meta object for the attribute '{@link ucsb.peerbehavior.Peer#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see ucsb.peerbehavior.Peer#getId()
	 * @see #getPeer()
	 * @generated
	 */
	EAttribute getPeer_Id();

	/**
	 * Returns the meta object for the attribute '{@link ucsb.peerbehavior.Peer#getTest <em>Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test</em>'.
	 * @see ucsb.peerbehavior.Peer#getTest()
	 * @see #getPeer()
	 * @generated
	 */
	EAttribute getPeer_Test();

	/**
	 * Returns the meta object for the reference '{@link ucsb.peerbehavior.Peer#getParticipantRef <em>Participant Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Participant Ref</em>'.
	 * @see ucsb.peerbehavior.Peer#getParticipantRef()
	 * @see #getPeer()
	 * @generated
	 */
	EReference getPeer_ParticipantRef();

	/**
	 * Returns the meta object for the '{@link ucsb.peerbehavior.Peer#toDOTforGraphViz() <em>To DO Tfor Graph Viz</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To DO Tfor Graph Viz</em>' operation.
	 * @see ucsb.peerbehavior.Peer#toDOTforGraphViz()
	 * @generated
	 */
	EOperation getPeer__ToDOTforGraphViz();

	/**
	 * Returns the meta object for the '{@link ucsb.peerbehavior.Peer#saveModel(java.lang.String) <em>Save Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Save Model</em>' operation.
	 * @see ucsb.peerbehavior.Peer#saveModel(java.lang.String)
	 * @generated
	 */
	EOperation getPeer__SaveModel__String();

	/**
	 * Returns the meta object for class '{@link ucsb.peerbehavior.Message <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message</em>'.
	 * @see ucsb.peerbehavior.Message
	 * @generated
	 */
	EClass getMessage();

	/**
	 * Returns the meta object for the attribute '{@link ucsb.peerbehavior.Message#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ucsb.peerbehavior.Message#getName()
	 * @see #getMessage()
	 * @generated
	 */
	EAttribute getMessage_Name();

	/**
	 * Returns the meta object for the attribute '{@link ucsb.peerbehavior.Message#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see ucsb.peerbehavior.Message#getId()
	 * @see #getMessage()
	 * @generated
	 */
	EAttribute getMessage_Id();

	/**
	 * Returns the meta object for the '{@link ucsb.peerbehavior.Message#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see ucsb.peerbehavior.Message#hashCode()
	 * @generated
	 */
	EOperation getMessage__HashCode();

	/**
	 * Returns the meta object for the '{@link ucsb.peerbehavior.Message#equals(org.eclipse.emf.ecore.EObject) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see ucsb.peerbehavior.Message#equals(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getMessage__Equals__EObject();

	/**
	 * Returns the meta object for class '{@link ucsb.peerbehavior.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see ucsb.peerbehavior.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the attribute '{@link ucsb.peerbehavior.State#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ucsb.peerbehavior.State#getName()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Name();

	/**
	 * Returns the meta object for the reference list '{@link ucsb.peerbehavior.State#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming</em>'.
	 * @see ucsb.peerbehavior.State#getIncoming()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Incoming();

	/**
	 * Returns the meta object for the reference list '{@link ucsb.peerbehavior.State#getOutcoming <em>Outcoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outcoming</em>'.
	 * @see ucsb.peerbehavior.State#getOutcoming()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Outcoming();

	/**
	 * Returns the meta object for class '{@link ucsb.peerbehavior.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see ucsb.peerbehavior.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference '{@link ucsb.peerbehavior.Transition#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see ucsb.peerbehavior.Transition#getFrom()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_From();

	/**
	 * Returns the meta object for the reference '{@link ucsb.peerbehavior.Transition#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see ucsb.peerbehavior.Transition#getTo()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_To();

	/**
	 * Returns the meta object for the attribute '{@link ucsb.peerbehavior.Transition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ucsb.peerbehavior.Transition#getName()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Name();

	/**
	 * Returns the meta object for the '{@link ucsb.peerbehavior.Transition#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see ucsb.peerbehavior.Transition#toString()
	 * @generated
	 */
	EOperation getTransition__ToString();

	/**
	 * Returns the meta object for class '{@link ucsb.peerbehavior.Send <em>Send</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Send</em>'.
	 * @see ucsb.peerbehavior.Send
	 * @generated
	 */
	EClass getSend();

	/**
	 * Returns the meta object for the reference '{@link ucsb.peerbehavior.Send#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Message</em>'.
	 * @see ucsb.peerbehavior.Send#getMessage()
	 * @see #getSend()
	 * @generated
	 */
	EReference getSend_Message();

	/**
	 * Returns the meta object for class '{@link ucsb.peerbehavior.Receive <em>Receive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Receive</em>'.
	 * @see ucsb.peerbehavior.Receive
	 * @generated
	 */
	EClass getReceive();

	/**
	 * Returns the meta object for the reference '{@link ucsb.peerbehavior.Receive#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Message</em>'.
	 * @see ucsb.peerbehavior.Receive#getMessage()
	 * @see #getReceive()
	 * @generated
	 */
	EReference getReceive_Message();

	/**
	 * Returns the meta object for class '{@link ucsb.peerbehavior.input <em>input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>input</em>'.
	 * @see ucsb.peerbehavior.input
	 * @generated
	 */
	EClass getinput();

	/**
	 * Returns the meta object for class '{@link ucsb.peerbehavior.output <em>output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>output</em>'.
	 * @see ucsb.peerbehavior.output
	 * @generated
	 */
	EClass getoutput();

	/**
	 * Returns the meta object for class '{@link ucsb.peerbehavior.InternalTransition <em>Internal Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Transition</em>'.
	 * @see ucsb.peerbehavior.InternalTransition
	 * @generated
	 */
	EClass getInternalTransition();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PeerbehaviorFactory getPeerbehaviorFactory();

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
		 * The meta object literal for the '{@link ucsb.peerbehavior.impl.PeerImpl <em>Peer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ucsb.peerbehavior.impl.PeerImpl
		 * @see ucsb.peerbehavior.impl.PeerbehaviorPackageImpl#getPeer()
		 * @generated
		 */
		EClass PEER = eINSTANCE.getPeer();

		/**
		 * The meta object literal for the '<em><b>In</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PEER__IN = eINSTANCE.getPeer_In();

		/**
		 * The meta object literal for the '<em><b>Out</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PEER__OUT = eINSTANCE.getPeer_Out();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PEER__STATES = eINSTANCE.getPeer_States();

		/**
		 * The meta object literal for the '<em><b>Initial State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PEER__INITIAL_STATE = eINSTANCE.getPeer_InitialState();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PEER__NAME = eINSTANCE.getPeer_Name();

		/**
		 * The meta object literal for the '<em><b>Transictions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PEER__TRANSICTIONS = eINSTANCE.getPeer_Transictions();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PEER__ID = eINSTANCE.getPeer_Id();

		/**
		 * The meta object literal for the '<em><b>Test</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PEER__TEST = eINSTANCE.getPeer_Test();

		/**
		 * The meta object literal for the '<em><b>Participant Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PEER__PARTICIPANT_REF = eINSTANCE.getPeer_ParticipantRef();

		/**
		 * The meta object literal for the '<em><b>To DO Tfor Graph Viz</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PEER___TO_DO_TFOR_GRAPH_VIZ = eINSTANCE.getPeer__ToDOTforGraphViz();

		/**
		 * The meta object literal for the '<em><b>Save Model</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PEER___SAVE_MODEL__STRING = eINSTANCE.getPeer__SaveModel__String();

		/**
		 * The meta object literal for the '{@link ucsb.peerbehavior.impl.MessageImpl <em>Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ucsb.peerbehavior.impl.MessageImpl
		 * @see ucsb.peerbehavior.impl.PeerbehaviorPackageImpl#getMessage()
		 * @generated
		 */
		EClass MESSAGE = eINSTANCE.getMessage();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE__NAME = eINSTANCE.getMessage_Name();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE__ID = eINSTANCE.getMessage_Id();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MESSAGE___HASH_CODE = eINSTANCE.getMessage__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MESSAGE___EQUALS__EOBJECT = eINSTANCE.getMessage__Equals__EObject();

		/**
		 * The meta object literal for the '{@link ucsb.peerbehavior.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ucsb.peerbehavior.impl.StateImpl
		 * @see ucsb.peerbehavior.impl.PeerbehaviorPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__NAME = eINSTANCE.getState_Name();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__INCOMING = eINSTANCE.getState_Incoming();

		/**
		 * The meta object literal for the '<em><b>Outcoming</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OUTCOMING = eINSTANCE.getState_Outcoming();

		/**
		 * The meta object literal for the '{@link ucsb.peerbehavior.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ucsb.peerbehavior.impl.TransitionImpl
		 * @see ucsb.peerbehavior.impl.PeerbehaviorPackageImpl#getTransition()
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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__NAME = eINSTANCE.getTransition_Name();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TRANSITION___TO_STRING = eINSTANCE.getTransition__ToString();

		/**
		 * The meta object literal for the '{@link ucsb.peerbehavior.impl.SendImpl <em>Send</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ucsb.peerbehavior.impl.SendImpl
		 * @see ucsb.peerbehavior.impl.PeerbehaviorPackageImpl#getSend()
		 * @generated
		 */
		EClass SEND = eINSTANCE.getSend();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND__MESSAGE = eINSTANCE.getSend_Message();

		/**
		 * The meta object literal for the '{@link ucsb.peerbehavior.impl.ReceiveImpl <em>Receive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ucsb.peerbehavior.impl.ReceiveImpl
		 * @see ucsb.peerbehavior.impl.PeerbehaviorPackageImpl#getReceive()
		 * @generated
		 */
		EClass RECEIVE = eINSTANCE.getReceive();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECEIVE__MESSAGE = eINSTANCE.getReceive_Message();

		/**
		 * The meta object literal for the '{@link ucsb.peerbehavior.impl.inputImpl <em>input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ucsb.peerbehavior.impl.inputImpl
		 * @see ucsb.peerbehavior.impl.PeerbehaviorPackageImpl#getinput()
		 * @generated
		 */
		EClass INPUT = eINSTANCE.getinput();

		/**
		 * The meta object literal for the '{@link ucsb.peerbehavior.impl.outputImpl <em>output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ucsb.peerbehavior.impl.outputImpl
		 * @see ucsb.peerbehavior.impl.PeerbehaviorPackageImpl#getoutput()
		 * @generated
		 */
		EClass OUTPUT = eINSTANCE.getoutput();

		/**
		 * The meta object literal for the '{@link ucsb.peerbehavior.impl.InternalTransitionImpl <em>Internal Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ucsb.peerbehavior.impl.InternalTransitionImpl
		 * @see ucsb.peerbehavior.impl.PeerbehaviorPackageImpl#getInternalTransition()
		 * @generated
		 */
		EClass INTERNAL_TRANSITION = eINSTANCE.getInternalTransition();

	}

} //PeerbehaviorPackage
