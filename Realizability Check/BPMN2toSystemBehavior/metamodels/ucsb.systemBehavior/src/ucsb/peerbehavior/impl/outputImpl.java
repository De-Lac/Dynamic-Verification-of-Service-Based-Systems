/**
 */
package ucsb.peerbehavior.impl;

import org.eclipse.emf.ecore.EClass;

import ucsb.peerbehavior.PeerbehaviorPackage;
import ucsb.peerbehavior.output;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>output</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class outputImpl extends MessageImpl implements output {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected outputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PeerbehaviorPackage.Literals.OUTPUT;
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
		if (oldName==null || oldName.startsWith("!"))
		{
			if (! newName.startsWith("!"))
			{newName = "!"+newName;}
		}
		else
		{
			if (newName.startsWith("!"))
			{newName = newName.substring(1);}
		}
		super.setName(newName);
	}

} //outputImpl
