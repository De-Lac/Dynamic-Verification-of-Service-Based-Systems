/**
 */
package unicam.workflowgraph.provider;


import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import unicam.workflowgraph.WorkFlowGraph;
import unicam.workflowgraph.WorkflowgraphFactory;
import unicam.workflowgraph.WorkflowgraphPackage;

/**
 * This is the item provider adapter for a {@link unicam.workflowgraph.WorkFlowGraph} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class WorkFlowGraphItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkFlowGraphItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addStartingNodePropertyDescriptor(object);
			addEndingNodePropertyDescriptor(object);
			addInnerGatewayPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Starting Node feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStartingNodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WorkFlowGraph_startingNode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_WorkFlowGraph_startingNode_feature", "_UI_WorkFlowGraph_type"),
				 WorkflowgraphPackage.Literals.WORK_FLOW_GRAPH__STARTING_NODE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ending Node feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndingNodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WorkFlowGraph_endingNode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_WorkFlowGraph_endingNode_feature", "_UI_WorkFlowGraph_type"),
				 WorkflowgraphPackage.Literals.WORK_FLOW_GRAPH__ENDING_NODE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Inner Gateway feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInnerGatewayPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WorkFlowGraph_innerGateway_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_WorkFlowGraph_innerGateway_feature", "_UI_WorkFlowGraph_type"),
				 WorkflowgraphPackage.Literals.WORK_FLOW_GRAPH__INNER_GATEWAY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(WorkflowgraphPackage.Literals.WORK_FLOW_GRAPH__GATEWAYS);
			childrenFeatures.add(WorkflowgraphPackage.Literals.WORK_FLOW_GRAPH__ACTIONS);
			childrenFeatures.add(WorkflowgraphPackage.Literals.WORK_FLOW_GRAPH__PARTICIPANTS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns WorkFlowGraph.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/WorkFlowGraph"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_WorkFlowGraph_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(WorkFlowGraph.class)) {
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__GATEWAYS:
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__ACTIONS:
			case WorkflowgraphPackage.WORK_FLOW_GRAPH__PARTICIPANTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(WorkflowgraphPackage.Literals.WORK_FLOW_GRAPH__GATEWAYS,
				 WorkflowgraphFactory.eINSTANCE.createExclusiveChoice()));

		newChildDescriptors.add
			(createChildParameter
				(WorkflowgraphPackage.Literals.WORK_FLOW_GRAPH__GATEWAYS,
				 WorkflowgraphFactory.eINSTANCE.createParallelExecution()));

		newChildDescriptors.add
			(createChildParameter
				(WorkflowgraphPackage.Literals.WORK_FLOW_GRAPH__ACTIONS,
				 WorkflowgraphFactory.eINSTANCE.createMessageExchange()));

		newChildDescriptors.add
			(createChildParameter
				(WorkflowgraphPackage.Literals.WORK_FLOW_GRAPH__PARTICIPANTS,
				 WorkflowgraphFactory.eINSTANCE.createParticipant()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return WorkflowGraphEditPlugin.INSTANCE;
	}

}
