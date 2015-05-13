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
 * $Id: PartesConf.java 21-giu-2012 19.02.50 francesco $
 */
package partes.utils;

import java.io.File;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import partes.service.PartesMain;

/**
 * The Class PartesConf.
 */
public class PartesConf {
	
	/** The Constant BUNDLE_NAME. */
	private static final String BUNDLE_NAME = "partes"; //$NON-NLS-1$

	/** The Constant RESOURCE_BUNDLE. */
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	/**
	 * Instantiates a new partes conf.
	 */
	private PartesConf() {
	}

	/**
	 * Gets the string.
	 *
	 * @param key the key
	 * @return the string
	 */
	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key)+File.separator+PartesMain.instance.choreographyTModelKey+File.separator;
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
