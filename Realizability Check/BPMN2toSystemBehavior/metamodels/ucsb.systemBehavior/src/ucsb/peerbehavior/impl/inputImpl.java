/**
 */
package ucsb.peerbehavior.impl;

import org.eclipse.emf.ecore.EClass;

import ucsb.peerbehavior.PeerbehaviorPackage;
import ucsb.peerbehavior.input;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class inputImpl extends MessageImpl implements input {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected inputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PeerbehaviorPackage.Literals.INPUT;
	}

	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setName(String newName) 
	{

		String oldName = name;
		if (oldName==null || oldName.startsWith("?"))
		{
			if (! newName.startsWith("?"))
			{newName = "?"+newName;}
		}
		else
		{
			if (newName.startsWith("?"))
			{newName = newName.substring(1);}
		}
		super.setName(newName);
	}	
	
	

} //inputImpl
