/**
 */
package unicam.workflowgraph.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import unicam.workflowgraph.Action;
import unicam.workflowgraph.Branch;
import unicam.workflowgraph.Gateway;
import unicam.workflowgraph.WfgNode;
import unicam.workflowgraph.WorkflowgraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gateway</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link unicam.workflowgraph.impl.GatewayImpl#isFork <em>Fork</em>}</li>
 *   <li>{@link unicam.workflowgraph.impl.GatewayImpl#isMerge <em>Merge</em>}</li>
 *   <li>{@link unicam.workflowgraph.impl.GatewayImpl#getRefMerge <em>Ref Merge</em>}</li>
 *   <li>{@link unicam.workflowgraph.impl.GatewayImpl#getRefFork <em>Ref Fork</em>}</li>
 *   <li>{@link unicam.workflowgraph.impl.GatewayImpl#getPredecessors <em>Predecessors</em>}</li>
 *   <li>{@link unicam.workflowgraph.impl.GatewayImpl#getSuccessors <em>Successors</em>}</li>
 *   <li>{@link unicam.workflowgraph.impl.GatewayImpl#getGatewayRef <em>Gateway Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class GatewayImpl extends WfgNodeImpl implements Gateway {
	/**
	 * The default value of the '{@link #isFork() <em>Fork</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFork()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FORK_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFork() <em>Fork</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFork()
	 * @generated
	 * @ordered
	 */
	protected boolean fork = FORK_EDEFAULT;

	/**
	 * The default value of the '{@link #isMerge() <em>Merge</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMerge()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MERGE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMerge() <em>Merge</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMerge()
	 * @generated
	 * @ordered
	 */
	protected boolean merge = MERGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRefMerge() <em>Ref Merge</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefMerge()
	 * @generated
	 * @ordered
	 */
	protected Gateway refMerge;

	/**
	 * The cached value of the '{@link #getRefFork() <em>Ref Fork</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefFork()
	 * @generated
	 * @ordered
	 */
	protected Gateway refFork;

	/**
	 * The cached value of the '{@link #getPredecessors() <em>Predecessors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredecessors()
	 * @generated
	 * @ordered
	 */
	protected EList<WfgNode> predecessors;

	/**
	 * The cached value of the '{@link #getSuccessors() <em>Successors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccessors()
	 * @generated
	 * @ordered
	 */
	protected EList<WfgNode> successors;

	/**
	 * The cached value of the '{@link #getGatewayRef() <em>Gateway Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGatewayRef()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.bpmn2.Gateway gatewayRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GatewayImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowgraphPackage.Literals.GATEWAY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFork() {
		return fork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFork(boolean newFork) {
		boolean oldFork = fork;
		fork = newFork;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowgraphPackage.GATEWAY__FORK, oldFork, fork));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMerge() {
		return merge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMerge(boolean newMerge) {
		boolean oldMerge = merge;
		merge = newMerge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowgraphPackage.GATEWAY__MERGE, oldMerge, merge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gateway getRefMerge() {
		if (refMerge != null && refMerge.eIsProxy()) {
			InternalEObject oldRefMerge = (InternalEObject)refMerge;
			refMerge = (Gateway)eResolveProxy(oldRefMerge);
			if (refMerge != oldRefMerge) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowgraphPackage.GATEWAY__REF_MERGE, oldRefMerge, refMerge));
			}
		}
		return refMerge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gateway basicGetRefMerge() {
		return refMerge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRefMerge(Gateway newRefMerge, NotificationChain msgs) {
		Gateway oldRefMerge = refMerge;
		refMerge = newRefMerge;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowgraphPackage.GATEWAY__REF_MERGE, oldRefMerge, newRefMerge);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws NullPointerException 
	 * @generated not
	 */
	public void setRefMerge(Gateway newRefMerge) throws NullPointerException {
		if (newRefMerge != null && newRefMerge.isFork())
			{throw new NullPointerException(newRefMerge.getName()+" can not be used as RefMerge of "+this.name);}
		if (newRefMerge != null && newRefMerge != refMerge) {
			NotificationChain msgs = null;
			if (refMerge != null)
				msgs = ((InternalEObject)refMerge).eInverseRemove(this, WorkflowgraphPackage.GATEWAY__REF_FORK, Gateway.class, msgs);
			if (newRefMerge != null)
				msgs = ((InternalEObject)newRefMerge).eInverseAdd(this, WorkflowgraphPackage.GATEWAY__REF_FORK, Gateway.class, msgs);
			msgs = basicSetRefMerge(newRefMerge, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowgraphPackage.GATEWAY__REF_MERGE, newRefMerge, newRefMerge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gateway getRefFork() {
		if (refFork != null && refFork.eIsProxy()) {
			InternalEObject oldRefFork = (InternalEObject)refFork;
			refFork = (Gateway)eResolveProxy(oldRefFork);
			if (refFork != oldRefFork) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowgraphPackage.GATEWAY__REF_FORK, oldRefFork, refFork));
			}
		}
		return refFork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gateway basicGetRefFork() {
		return refFork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRefFork(Gateway newRefFork, NotificationChain msgs) {
		Gateway oldRefFork = refFork;
		refFork = newRefFork;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowgraphPackage.GATEWAY__REF_FORK, oldRefFork, newRefFork);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws NullPointerException 
	 * @generated NOT
	 */
	public void setRefFork(Gateway newRefFork) throws NullPointerException {
		if (newRefFork != null && newRefFork.isMerge())
			{throw new NullPointerException(newRefFork.getName()+" can not be used as RefFork of "+this.name);}
		if (newRefFork != null && newRefFork != refFork) {
			NotificationChain msgs = null;
			if (refFork != null)
				msgs = ((InternalEObject)refFork).eInverseRemove(this, WorkflowgraphPackage.GATEWAY__REF_MERGE, Gateway.class, msgs);
			if (newRefFork != null)
				msgs = ((InternalEObject)newRefFork).eInverseAdd(this, WorkflowgraphPackage.GATEWAY__REF_MERGE, Gateway.class, msgs);
			msgs = basicSetRefFork(newRefFork, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowgraphPackage.GATEWAY__REF_FORK, newRefFork, newRefFork));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WfgNode> getSuccessors() {
		if (successors == null) {
			successors = new EObjectResolvingEList<WfgNode>(WfgNode.class, this, WorkflowgraphPackage.GATEWAY__SUCCESSORS);
		}
		return successors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.bpmn2.Gateway getGatewayRef() {
		if (gatewayRef != null && gatewayRef.eIsProxy()) {
			InternalEObject oldGatewayRef = (InternalEObject)gatewayRef;
			gatewayRef = (org.eclipse.bpmn2.Gateway)eResolveProxy(oldGatewayRef);
			if (gatewayRef != oldGatewayRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowgraphPackage.GATEWAY__GATEWAY_REF, oldGatewayRef, gatewayRef));
			}
		}
		return gatewayRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.bpmn2.Gateway basicGetGatewayRef() {
		return gatewayRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGatewayRef(org.eclipse.bpmn2.Gateway newGatewayRef) {
		org.eclipse.bpmn2.Gateway oldGatewayRef = gatewayRef;
		gatewayRef = newGatewayRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowgraphPackage.GATEWAY__GATEWAY_REF, oldGatewayRef, gatewayRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WfgNode> getPredecessors() {
		if (predecessors == null) {
			predecessors = new EObjectResolvingEList<WfgNode>(WfgNode.class, this, WorkflowgraphPackage.GATEWAY__PREDECESSORS);
		}
		return predecessors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Branch> getBranches() 
	{
		if (isMerge()) 
			{return null;}
		EList<Branch> branches = new BasicEList<Branch>();
		for (WfgNode node: successors)
			{
			 Branch branch = WorkflowgraphFactoryImpl.eINSTANCE.createBranch();
			 while (node != null && node != getRefMerge())
			  {
			   branch.getNodes().add(node);
			   if (node instanceof Action)
			 	{ node = ((Action)node).getSuccessor(); }
			   else if(node instanceof Gateway && ((Gateway)node).isFork())
					  	{ node = ((Gateway)node).getRefMerge(); }
			   		 else if (node instanceof Gateway && ((Gateway)node).isMerge())
			   		 	{ // be aware of cycles. successors should not be the refFork
			   			  if ( ((Gateway)node).getSuccessors().size() < 2)
			   				  { node = ((Gateway)node).getSuccessors().get(0);} 
			   			  else if ( ((Gateway)node).getSuccessors().get(0) == ((Gateway)node).getRefFork() )
			   			  	{ node = ((Gateway)node).getSuccessors().get(1); }
			   			  else 
			   			  	{ node = ((Gateway)node).getSuccessors().get(0); }
			   			  }
			  }
			 branches.add(branch);
			}
		return branches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowgraphPackage.GATEWAY__REF_MERGE:
				if (refMerge != null)
					msgs = ((InternalEObject)refMerge).eInverseRemove(this, WorkflowgraphPackage.GATEWAY__REF_FORK, Gateway.class, msgs);
				return basicSetRefMerge((Gateway)otherEnd, msgs);
			case WorkflowgraphPackage.GATEWAY__REF_FORK:
				if (refFork != null)
					msgs = ((InternalEObject)refFork).eInverseRemove(this, WorkflowgraphPackage.GATEWAY__REF_MERGE, Gateway.class, msgs);
				return basicSetRefFork((Gateway)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowgraphPackage.GATEWAY__REF_MERGE:
				return basicSetRefMerge(null, msgs);
			case WorkflowgraphPackage.GATEWAY__REF_FORK:
				return basicSetRefFork(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowgraphPackage.GATEWAY__FORK:
				return isFork();
			case WorkflowgraphPackage.GATEWAY__MERGE:
				return isMerge();
			case WorkflowgraphPackage.GATEWAY__REF_MERGE:
				if (resolve) return getRefMerge();
				return basicGetRefMerge();
			case WorkflowgraphPackage.GATEWAY__REF_FORK:
				if (resolve) return getRefFork();
				return basicGetRefFork();
			case WorkflowgraphPackage.GATEWAY__PREDECESSORS:
				return getPredecessors();
			case WorkflowgraphPackage.GATEWAY__SUCCESSORS:
				return getSuccessors();
			case WorkflowgraphPackage.GATEWAY__GATEWAY_REF:
				if (resolve) return getGatewayRef();
				return basicGetGatewayRef();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WorkflowgraphPackage.GATEWAY__FORK:
				setFork((Boolean)newValue);
				return;
			case WorkflowgraphPackage.GATEWAY__MERGE:
				setMerge((Boolean)newValue);
				return;
			case WorkflowgraphPackage.GATEWAY__REF_MERGE:
				setRefMerge((Gateway)newValue);
				return;
			case WorkflowgraphPackage.GATEWAY__REF_FORK:
				setRefFork((Gateway)newValue);
				return;
			case WorkflowgraphPackage.GATEWAY__PREDECESSORS:
				getPredecessors().clear();
				getPredecessors().addAll((Collection<? extends WfgNode>)newValue);
				return;
			case WorkflowgraphPackage.GATEWAY__SUCCESSORS:
				getSuccessors().clear();
				getSuccessors().addAll((Collection<? extends WfgNode>)newValue);
				return;
			case WorkflowgraphPackage.GATEWAY__GATEWAY_REF:
				setGatewayRef((org.eclipse.bpmn2.Gateway)newValue);
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
			case WorkflowgraphPackage.GATEWAY__FORK:
				setFork(FORK_EDEFAULT);
				return;
			case WorkflowgraphPackage.GATEWAY__MERGE:
				setMerge(MERGE_EDEFAULT);
				return;
			case WorkflowgraphPackage.GATEWAY__REF_MERGE:
				setRefMerge((Gateway)null);
				return;
			case WorkflowgraphPackage.GATEWAY__REF_FORK:
				setRefFork((Gateway)null);
				return;
			case WorkflowgraphPackage.GATEWAY__PREDECESSORS:
				getPredecessors().clear();
				return;
			case WorkflowgraphPackage.GATEWAY__SUCCESSORS:
				getSuccessors().clear();
				return;
			case WorkflowgraphPackage.GATEWAY__GATEWAY_REF:
				setGatewayRef((org.eclipse.bpmn2.Gateway)null);
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
			case WorkflowgraphPackage.GATEWAY__FORK:
				return fork != FORK_EDEFAULT;
			case WorkflowgraphPackage.GATEWAY__MERGE:
				return merge != MERGE_EDEFAULT;
			case WorkflowgraphPackage.GATEWAY__REF_MERGE:
				return refMerge != null;
			case WorkflowgraphPackage.GATEWAY__REF_FORK:
				return refFork != null;
			case WorkflowgraphPackage.GATEWAY__PREDECESSORS:
				return predecessors != null && !predecessors.isEmpty();
			case WorkflowgraphPackage.GATEWAY__SUCCESSORS:
				return successors != null && !successors.isEmpty();
			case WorkflowgraphPackage.GATEWAY__GATEWAY_REF:
				return gatewayRef != null;
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
			case WorkflowgraphPackage.GATEWAY___GET_BRANCHES:
				return getBranches();
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
		result.append(" (fork: ");
		result.append(fork);
		result.append(", merge: ");
		result.append(merge);
		result.append(')');
		return result.toString();
	}
	
		

} //GatewayImpl
