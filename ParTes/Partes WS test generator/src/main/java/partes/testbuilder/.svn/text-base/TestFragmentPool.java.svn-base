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
 * $Id: TestFragmentPool.java 28/ott/2011 11:59:33 francesco $
 */

package partes.testbuilder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import jdsl.core.api.Position;

/**
 * The Class TestFragmentPool.
 */
public class TestFragmentPool {

	/** The map. */
	private HashMap<Integer, Integer> map;

	/** The list. */
	private List<TestFragment> list;
	
	/**
	 * Instantiates a new test fragment pool.
	 */
	public TestFragmentPool() {
		this.list = new Vector<TestFragment>();
		this.map = new HashMap<Integer, Integer>();
	}
	
	/**
	 * Adds the to pool.
	 * 
	 * @param identifier
	 *            the identifier
	 * @param test
	 *            the test
	 */
	void addToPool(int identifier, TestFragment test){
		list.add(test);
		int i = list.indexOf(test);
		map.put(identifier, i);
		
	}
		
	/**
	 * Gets the from pool.
	 * 
	 * @param identifier
	 *            the identifier
	 * @return the from pool
	 */
	TestFragment getFromPool(int identifier){
		int i = map.get(identifier);
		TestFragment test = list.get(i);
		return test;
	}
		
	/**
	 * Gets the test fragment iterator.
	 * 
	 * @return the test fragment iterator
	 */
	Iterator<TestFragment> getTestFragmentIterator(){
		return list.iterator();
		
	}
	
	/**
	 * Find test fragment.
	 * 
	 * @param position
	 *            the position
	 * @return the test fragment
	 */
	TestFragment findTestFragment(Position position){
		
		Iterator<TestFragment> tfi = list.iterator();
		while (tfi.hasNext()){
			TestFragment tf = tfi.next();
			if (tf.getTree().contains(position)){
				return tf;
			}
			
		}
		return null; //Add an exception here
		
		
	}
	
}
