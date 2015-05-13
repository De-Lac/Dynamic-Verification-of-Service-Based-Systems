/**
 */
package ucsb.peerbehavior.provider;


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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import ucsb.converesationprotocol.provider.SystemBehaviorEditPlugin;

import ucsb.peerbehavior.Peer;
import ucsb.peerbehavior.PeerbehaviorFactory;
import ucsb.peerbehavior.PeerbehaviorPackage;

/**
 * This is the item provider adapter for a {@link ucsb.peerbehavior.Peer} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PeerItemProvider
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
	public PeerItemProvider(AdapterFactory adapterFactory) {
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

			addInitialStatePropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addIdPropertyDescriptor(object);
			addTestPropertyDescriptor(object);
			addParticipantRefPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_Peer_initialState_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Peer_initialState_feature", "_UI_Peer_type"),
				 PeerbehaviorPackage.Literals.PEER__INITIAL_STATE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Peer_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Peer_name_feature", "_UI_Peer_type"),
				 PeerbehaviorPackage.Literals.PEER__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Peer_id_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Peer_id_feature", "_UI_Peer_type"),
				 PeerbehaviorPackage.Literals.PEER__ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Test feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTestPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Peer_test_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Peer_test_feature", "_UI_Peer_type"),
				 PeerbehaviorPackage.Literals.PEER__TEST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Participant Ref feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParticipantRefPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Peer_participantRef_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Peer_participantRef_feature", "_UI_Peer_type"),
				 PeerbehaviorPackage.Literals.PEER__PARTICIPANT_REF,
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
			childrenFeatures.add(PeerbehaviorPackage.Literals.PEER__IN);
			childrenFeatures.add(PeerbehaviorPackage.Literals.PEER__OUT);
			childrenFeatures.add(PeerbehaviorPackage.Literals.PEER__STATES);
			childrenFeatures.add(PeerbehaviorPackage.Literals.PEER__TRANSICTIONS);
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
	 * This returns Peer.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Peer"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Peer)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Peer_type") :
			getString("_UI_Peer_type") + " " + label;
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

		switch (notification.getFeatureID(Peer.class)) {
			case PeerbehaviorPackage.PEER__NAME:
			case PeerbehaviorPackage.PEER__ID:
			case PeerbehaviorPackage.PEER__TEST:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case PeerbehaviorPackage.PEER__IN:
			case PeerbehaviorPackage.PEER__OUT:
			case PeerbehaviorPackage.PEER__STATES:
			case PeerbehaviorPackage.PEER__TRANSICTIONS:
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
				(PeerbehaviorPackage.Literals.PEER__IN,
				 PeerbehaviorFactory.eINSTANCE.createinput()));

		newChildDescriptors.add
			(createChildParameter
				(PeerbehaviorPackage.Literals.PEER__OUT,
				 PeerbehaviorFactory.eINSTANCE.createoutput()));

		newChildDescriptors.add
			(createChildParameter
				(PeerbehaviorPackage.Literals.PEER__STATES,
				 PeerbehaviorFactory.eINSTANCE.createState()));

		newChildDescriptors.add
			(createChildParameter
				(PeerbehaviorPackage.Literals.PEER__TRANSICTIONS,
				 PeerbehaviorFactory.eINSTANCE.createTransition()));

		newChildDescriptors.add
			(createChildParameter
				(PeerbehaviorPackage.Literals.PEER__TRANSICTIONS,
				 PeerbehaviorFactory.eINSTANCE.createSend()));

		newChildDescriptors.add
			(createChildParameter
				(PeerbehaviorPackage.Literals.PEER__TRANSICTIONS,
				 PeerbehaviorFactory.eINSTANCE.createReceive()));

		newChildDescriptors.add
			(createChildParameter
				(PeerbehaviorPackage.Literals.PEER__TRANSICTIONS,
				 PeerbehaviorFactory.eINSTANCE.createInternalTransition()));
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
