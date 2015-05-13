/**
 */
package unicam.workflowgraph;

import org.eclipse.bpmn2.ChoreographyTask;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Exchange</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * It's the simplified vision of a ChoreographyTask, with the participants and message exchanged. There should always be the requeste message (sender->receiver). The response (receiver->sender) is facultative. If there is, it means it's a synchronous message exchange, otherwise the response should be mapped in another MessageExchange instance.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link unicam.workflowgraph.MessageExchange#getRequest <em>Request</em>}</li>
 *   <li>{@link unicam.workflowgraph.MessageExchange#getSynchResponse <em>Synch Response</em>}</li>
 *   <li>{@link unicam.workflowgraph.MessageExchange#getSender <em>Sender</em>}</li>
 *   <li>{@link unicam.workflowgraph.MessageExchange#getReceiver <em>Receiver</em>}</li>
 *   <li>{@link unicam.workflowgraph.MessageExchange#getChoreographyTaskRef <em>Choreography Task Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see unicam.workflowgraph.WorkflowgraphPackage#getMessageExchange()
 * @model
 * @generated
 */
public interface MessageExchange extends Action {
	/**
	 * Returns the value of the '<em><b>Sender</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sender</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sender</em>' reference.
	 * @see #setSender(Participant)
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getMessageExchange_Sender()
	 * @model required="true"
	 * @generated
	 */
	Participant getSender();

	/**
	 * Sets the value of the '{@link unicam.workflowgraph.MessageExchange#getSender <em>Sender</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sender</em>' reference.
	 * @see #getSender()
	 * @generated
	 */
	void setSender(Participant value);

	/**
	 * Returns the value of the '<em><b>Receiver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receiver</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receiver</em>' reference.
	 * @see #setReceiver(Participant)
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getMessageExchange_Receiver()
	 * @model required="true"
	 * @generated
	 */
	Participant getReceiver();

	/**
	 * Sets the value of the '{@link unicam.workflowgraph.MessageExchange#getReceiver <em>Receiver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Receiver</em>' reference.
	 * @see #getReceiver()
	 * @generated
	 */
	void setReceiver(Participant value);

	/**
	 * Returns the value of the '<em><b>Choreography Task Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Choreography Task Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Choreography Task Ref</em>' reference.
	 * @see #setChoreographyTaskRef(ChoreographyTask)
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getMessageExchange_ChoreographyTaskRef()
	 * @model
	 * @generated
	 */
	ChoreographyTask getChoreographyTaskRef();

	/**
	 * Sets the value of the '{@link unicam.workflowgraph.MessageExchange#getChoreographyTaskRef <em>Choreography Task Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Choreography Task Ref</em>' reference.
	 * @see #getChoreographyTaskRef()
	 * @generated
	 */
	void setChoreographyTaskRef(ChoreographyTask value);

	/**
	 * Returns the value of the '<em><b>Request</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Request</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Request</em>' attribute.
	 * @see #setRequest(String)
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getMessageExchange_Request()
	 * @model required="true"
	 * @generated
	 */
	String getRequest();

	/**
	 * Sets the value of the '{@link unicam.workflowgraph.MessageExchange#getRequest <em>Request</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Request</em>' attribute.
	 * @see #getRequest()
	 * @generated
	 */
	void setRequest(String value);

	/**
	 * Returns the value of the '<em><b>Synch Response</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Synch Response</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Synch Response</em>' attribute.
	 * @see #setSynchResponse(String)
	 * @see unicam.workflowgraph.WorkflowgraphPackage#getMessageExchange_SynchResponse()
	 * @model
	 * @generated
	 */
	String getSynchResponse();

	/**
	 * Sets the value of the '{@link unicam.workflowgraph.MessageExchange#getSynchResponse <em>Synch Response</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Synch Response</em>' attribute.
	 * @see #getSynchResponse()
	 * @generated
	 */
	void setSynchResponse(String value);

} // MessageExchange
