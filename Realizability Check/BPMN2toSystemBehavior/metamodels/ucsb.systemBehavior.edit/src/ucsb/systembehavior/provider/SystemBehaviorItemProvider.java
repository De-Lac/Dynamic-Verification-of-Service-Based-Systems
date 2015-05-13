/**
 */
package ucsb.systembehavior.provider;


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

import ucsb.converesationprotocol.provider.SystemBehaviorEditPlugin;

import ucsb.systembehavior.SystemBehavior;
import ucsb.systembehavior.SystembehaviorFactory;
import ucsb.systembehavior.SystembehaviorPackage;

/**
 * This is the item provider adapter for a {@link ucsb.systembehavior.SystemBehavior} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemBehaviorItemProvider
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
	public SystemBehaviorItemProvider(AdapterFactory adapterFactory) {
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

			addPeersPropertyDescriptor(object);
			addMessagesPropertyDescriptor(object);
			addInitialStatePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Peers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPeersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SystemBehavior_peers_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SystemBehavior_peers_feature", "_UI_SystemBehavior_type"),
				 SystembehaviorPackage.Literals.SYSTEM_BEHAVIOR__PEERS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Messages feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMessagesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SystemBehavior_messages_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SystemBehavior_messages_feature", "_UI_SystemBehavior_type"),
				 SystembehaviorPackage.Literals.SYSTEM_BEHAVIOR__MESSAGES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Initial State feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInitialStatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SystemBehavior_initialState_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SystemBehavior_initialState_feature", "_UI_SystemBehavior_type"),
				 SystembehaviorPackage.Literals.SYSTEM_BEHAVIOR__INITIAL_STATE,
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
			childrenFeatures.add(SystembehaviorPackage.Literals.SYSTEM_BEHAVIOR__STATES);
			childrenFeatures.add(SystembehaviorPackage.Literals.SYSTEM_BEHAVIOR__TRANSITIONS);
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
	 * This returns SystemBehavior.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SystemBehavior"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_SystemBehavior_type");
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

		switch (notification.getFeatureID(SystemBehavior.class)) {
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__STATES:
			case SystembehaviorPackage.SYSTEM_BEHAVIOR__TRANSITIONS:
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
				(SystembehaviorPackage.Literals.SYSTEM_BEHAVIOR__STATES,
				 SystembehaviorFactory.eINSTANCE.createPeerSituation()));

		newChildDescriptors.add
			(createChildParameter
				(SystembehaviorPackage.Literals.SYSTEM_BEHAVIOR__TRANSITIONS,
				 SystembehaviorFactory.eINSTANCE.createTransition()));

		newChildDescriptors.add
			(createChildParameter
				(SystembehaviorPackage.Literals.SYSTEM_BEHAVIOR__TRANSITIONS,
				 SystembehaviorFactory.eINSTANCE.createSend()));

		newChildDescriptors.add
			(createChildParameter
				(SystembehaviorPackage.Literals.SYSTEM_BEHAVIOR__TRANSITIONS,
				 SystembehaviorFactory.eINSTANCE.createReceive()));

		newChildDescriptors.add
			(createChildParameter
				(SystembehaviorPackage.Literals.SYSTEM_BEHAVIOR__TRANSITIONS,
				 SystembehaviorFactory.eINSTANCE.createInternalTransition()));

		newChildDescriptors.add
			(createChildParameter
				(SystembehaviorPackage.Literals.SYSTEM_BEHAVIOR__TRANSITIONS,
				 SystembehaviorFactory.eINSTANCE.createLoopTransition()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return SystemBehaviorEditPlugin.INSTANCE;
	}

}
