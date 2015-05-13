/**
 * <copyright>
 * This file is part of Partes project.
 *
 * This program and the accompanying materials are made available under 
 * the terms of the  GPL license (the "GNU PUBLIC LICENSE") which 
 * accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * </copyright>
 *
 * $Id: Interaction.java 28/ott/2009 11:59:33 francesco $
 */

package partes.refactorRunner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

/**
 * The Class Interaction.
 */
public class Interaction {

	
	/** The method. */
	private String method;

	/** The method class. */
	private String methodClass;

	/** The ret value. */
	private String retValue;
	
	/** The ret values. */
	private Vector<String> retValues;

	/**
	 * Gets the ret value.
	 * 
	 * @return the ret value
	 */
	public String getRetValue() {
		return retValue;
	}

	/**
	 * Sets the ret value.
	 * 
	 * @param retValue
	 *            the new ret value
	 */
	public void setRetValue(String retValue) {
		this.retValue = retValue;
	}
	
	/**
	 * Adds the ret value.
	 * 
	 * @param retValue
	 *            the ret value
	 */
	public void addRetValue(String retValue) {
		this.retValues.add(retValue);
	}
	
	/**
	 * Gets the all ret values.
	 * 
	 * @return the all ret values
	 */
	public String getAllRetValues() {
		String result="[";
		Iterator<String> it = this.retValues.iterator();
		while (it.hasNext()){
			result+="#";
			result+=it.next();
			result+="#";
		}
		result+="]";
		return result;
	}
	
	

	/**
	 * Gets the method class.
	 * 
	 * @return the method class
	 */
	public String getMethodClass() {
		return methodClass;
	}

	/**
	 * Sets the method class.
	 * 
	 * @param methodClass
	 *            the new method class
	 */
	public void setMethodClass(String methodClass) {
		this.methodClass = methodClass;
	}

	/** The params. */
	private HashMap<String, String> params;

	/**
	 * Instantiates a new interaction. If <i>methodClass</i> is <i>null</i>, the String "methodClass" is choosen as default value.
	 * Params can be added later.
	 * 
	 * @param methodClass
	 *            the method class
	 * @param method
	 *            the method
	 * @param params
	 *            the params of the method as HashMap(String name, String value)
	 */
	public Interaction(String methodClass, String method, HashMap<String, String> params) {
		if (params==null)
			{
			 if (methodClass==null)
			 	{
				 new Interaction(method);
				 return;
			 	}
			 new Interaction(methodClass, method);
			 return;
			}
		this.methodClass = methodClass;
		this.method = method;
		this.params = params;
		this.retValues = new Vector<String>();
	}

	/**
	 * Instantiates a new interaction.
	 * 
	 * @param methodClass
	 *            the method class
	 * @param method
	 *            the method
	 */
	public Interaction(String methodClass, String method) {
		this.methodClass = methodClass;
		this.method = method;
		this.params = new HashMap<String, String>();
		this.retValues = new Vector<String>();
	}

	/**
	 * Instantiates a new interaction.
	 * 
	 * @param method
	 *            the method
	 */
	public Interaction(String method) {
		this.methodClass = "methodClass";
		this.method = method;
		this.params = new HashMap<String, String>();
		this.retValues = new Vector<String>();
	}

	/**
	 * Instantiates a new interaction.
	 */
	public Interaction() {
		this.method = "methodname";
		this.methodClass = "methodclass";
		this.params = new HashMap<String, String>();
		this.retValues = new Vector<String>();
	}

	/**
	 * Gets the method.
	 * 
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * Sets the method.
	 * 
	 * @param method
	 *            the new method
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * Sets the param.
	 * 
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 */
	public void setParam(String name, String value) {
		this.params.put(name, value);
	}

	/**
	 * Gets the param.
	 * 
	 * @param name
	 *            the name
	 * @return the param
	 */
	public String getParam(String name) {
		return this.params.get(name);
	}
	
	/**
	 * Gets the all params.
	 * 
	 * @return the all params
	 */
	public String getAllParams() {
		Set<String> p = this.params.keySet();
		Iterator<String> pi = p.iterator();
		String str = "";
		while (pi.hasNext()) {
			str = str + this.params.get(pi.next()) + ", ";
		}
		str = str.trim();
		if (str.endsWith(",")) {
			str = str.substring(0, str.lastIndexOf(","));
		}
		return str;
	}

	/**
	 * Show interaction.
	 * 
	 * @return the string
	 */
	public String showInteraction() {
		Set<String> p = this.params.keySet();
		Iterator<String> pi = p.iterator();
		String str = "";
		while (pi.hasNext()) {
			str = str + this.params.get(pi.next()) + ", ";
		}
		str = str.trim();
		if (str.endsWith(",")) {
			str = str.substring(0, str.lastIndexOf(","));
		}
		
		//System.out.println("[Interaction] str = " + str);
		
		//return this.method + "(" + str + ") = " + this.getRetValue();
		return this.method + "(" + str + ") = " + this.getAllRetValues();
	}

	/**
	 * Show method with params.
	 * 
	 * @return the string
	 */
	public String showMethodWithParams() {
		Set<String> p = this.params.keySet();
		Iterator<String> pi = p.iterator();
		String str = "";
		while (pi.hasNext()) {
			str = str + this.params.get(pi.next()) + ", ";
		}
		str = str.trim();
		if (str.endsWith(",")) {
			str = str.substring(0, str.lastIndexOf(","));
		}

		return this.method + "(" + str + ")";
	}

	/**
	 * Show params.
	 * 
	 * @return the string
	 */
	public String showParams() {
		Set<String> p = this.params.keySet();
		Iterator<String> pi = p.iterator();
		String str = "";
		while (pi.hasNext()) {
			str = str + this.params.get(pi.next()) + ", ";
		}
		str = str.trim();
		if (str.endsWith(",")) {
			str = str.substring(0, str.lastIndexOf(","));
		}

		return str;
	}
	

}
