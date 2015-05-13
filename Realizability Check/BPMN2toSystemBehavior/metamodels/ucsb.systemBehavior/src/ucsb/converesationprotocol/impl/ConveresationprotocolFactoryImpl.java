/**
 */
package ucsb.converesationprotocol.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import ucsb.converesationprotocol.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConveresationprotocolFactoryImpl extends EFactoryImpl implements ConveresationprotocolFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConveresationprotocolFactory init() {
		try {
			ConveresationprotocolFactory theConveresationprotocolFactory = (ConveresationprotocolFactory)EPackage.Registry.INSTANCE.getEFactory(ConveresationprotocolPackage.eNS_URI);
			if (theConveresationprotocolFactory != null) {
				return theConveresationprotocolFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConveresationprotocolFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConveresationprotocolFactoryImpl() {
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
			case ConveresationprotocolPackage.CONVERSATION_PROTOCOL: return createConversationProtocol();
			case ConveresationprotocolPackage.STATE: return createState();
			case ConveresationprotocolPackage.MESSAGE: return createMessage();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConversationProtocol createConversationProtocol() {
		ConversationProtocolImpl conversationProtocol = new ConversationProtocolImpl();
		return conversationProtocol;
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
	public Message createMessage() {
		MessageImpl message = new MessageImpl();
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConveresationprotocolPackage getConveresationprotocolPackage() {
		return (ConveresationprotocolPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ConveresationprotocolPackage getPackage() {
		return ConveresationprotocolPackage.eINSTANCE;
	}

} //ConveresationprotocolFactoryImpl
