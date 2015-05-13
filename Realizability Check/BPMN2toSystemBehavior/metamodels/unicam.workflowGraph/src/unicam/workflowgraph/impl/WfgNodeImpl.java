/**
 */
package unicam.workflowgraph.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import unicam.workflowgraph.WfgNode;
import unicam.workflowgraph.WorkflowgraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Wfg Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link unicam.workflowgraph.impl.WfgNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link unicam.workflowgraph.impl.WfgNodeImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class WfgNodeImpl extends MinimalEObjectImpl.Container implements WfgNode {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WfgNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowgraphPackage.Literals.WFG_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowgraphPackage.WFG_NODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowgraphPackage.WFG_NODE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean add_set_successor(WfgNode node) {
		if (this instanceof ActionImpl)
			{
			 ((ActionImpl)this).setSuccessor(node); 
			}
		else if (this instanceof GatewayImpl)
			{
			 ((GatewayImpl)this).getSuccessors().add(node); 
			}
		
		if (node instanceof ActionImpl)
			{ 
			 ((ActionImpl)node).setPredecessor(this);
			}
		else if (node instanceof GatewayImpl)
			{
			 ((GatewayImpl)node).getPredecessors().add(this);
			}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean add_set_predecessor(WfgNode node) 
	{
		if (this instanceof ActionImpl)
			{ 
			 ((ActionImpl)this).setPredecessor(node);
			}
		else if (this instanceof GatewayImpl)
			{
			 ((GatewayImpl)this).getPredecessors().add(node);
			}
		
		if (node instanceof ActionImpl)
			{ 
			 ((ActionImpl)node).setSuccessor(this);
			}
		else if (node instanceof GatewayImpl)
			{
			 ((GatewayImpl)node).getSuccessors().add(this);
			}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean remove_unset_successor(WfgNode node) 
	{
		if (this instanceof ActionImpl)
			{
			 ((ActionImpl)this).setSuccessor(null); 
			}
		else if (this instanceof GatewayImpl)
			{
			 ((GatewayImpl)this).getSuccessors().remove(node);
			}
		
		if (node instanceof ActionImpl)
			{ 
			 ((ActionImpl)node).setPredecessor(null);
			}
		else if (node instanceof GatewayImpl)
			{
			 ((GatewayImpl)node).getPredecessors().remove(this);
			}
		return true;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean remove_unset_predecessor(WfgNode node) 
	{
		if (this instanceof ActionImpl)
			{
			 ((ActionImpl)this).setPredecessor(null); 
			}
		else if (this instanceof GatewayImpl)
			{
			 ((GatewayImpl)this).getPredecessors().remove(node);
			}
		
		if (node instanceof ActionImpl)
			{ 
			 ((ActionImpl)node).setSuccessor(null);
			}
		else if (node instanceof GatewayImpl)
			{
			 ((GatewayImpl)node).getSuccessors().remove(this);
			}
		return true;
	}
	/**
	 * <!-- begin-user-doc -->
	 * the new ID is generated using java.util.UUID.randomUUID(). 
	 * the cloned node MUST BE ADDED TO THE RELATIVE WFG!!
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public WfgNode clone() {
		WfgNode newNode = null;
		if (this instanceof MessageExchangeImpl)
			{
			 newNode = WorkflowgraphFactoryImpl.eINSTANCE.createMessageExchange();
			 newNode.setId(UUID.randomUUID().toString());
			 newNode.setName(this.name);
			 ((MessageExchangeImpl)newNode).setReceiver(((MessageExchangeImpl)this).receiver);
			 ((MessageExchangeImpl)newNode).setSender(((MessageExchangeImpl)this).sender);
			 ((MessageExchangeImpl)newNode).setRequest(((MessageExchangeImpl)this).request);
			 ((MessageExchangeImpl)newNode).setSynchResponse(((MessageExchangeImpl)this).synchResponse);
			 }
		else if (this instanceof ExclusiveChoiceImpl)
			{
			 newNode = WorkflowgraphFactoryImpl.eINSTANCE.createExclusiveChoice();
			 newNode.setId(UUID.randomUUID().toString());
			 newNode.setName(this.name);
			 ((ExclusiveChoiceImpl)newNode).setFork(((ExclusiveChoiceImpl)this).isFork());
			 ((ExclusiveChoiceImpl)newNode).setMerge(((ExclusiveChoiceImpl)this).isMerge());
			 }
		else if (this instanceof ParallelExecutionImpl)
			{
			 newNode = WorkflowgraphFactoryImpl.eINSTANCE.createParallelExecution();
			 newNode.setId(UUID.randomUUID().toString());
			 newNode.setName(this.name);
			 ((ParallelExecutionImpl)newNode).setFork(((ParallelExecutionImpl)this).isFork());
			 ((ParallelExecutionImpl)newNode).setMerge(((ParallelExecutionImpl)this).isMerge());
			 }
		return newNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowgraphPackage.WFG_NODE__NAME:
				return getName();
			case WorkflowgraphPackage.WFG_NODE__ID:
				return getId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WorkflowgraphPackage.WFG_NODE__NAME:
				setName((String)newValue);
				return;
			case WorkflowgraphPackage.WFG_NODE__ID:
				setId((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case WorkflowgraphPackage.WFG_NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case WorkflowgraphPackage.WFG_NODE__ID:
				setId(ID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WorkflowgraphPackage.WFG_NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case WorkflowgraphPackage.WFG_NODE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case WorkflowgraphPackage.WFG_NODE___ADD_SET_SUCCESSOR__WFGNODE:
				return add_set_successor((WfgNode)arguments.get(0));
			case WorkflowgraphPackage.WFG_NODE___ADD_SET_PREDECESSOR__WFGNODE:
				return add_set_predecessor((WfgNode)arguments.get(0));
			case WorkflowgraphPackage.WFG_NODE___REMOVE_UNSET_SUCCESSOR__WFGNODE:
				return remove_unset_successor((WfgNode)arguments.get(0));
			case WorkflowgraphPackage.WFG_NODE___REMOVE_UNSET_PREDECESSOR__WFGNODE:
				return remove_unset_predecessor((WfgNode)arguments.get(0));
			case WorkflowgraphPackage.WFG_NODE___CLONE:
				return clone();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //WfgNodeImpl
