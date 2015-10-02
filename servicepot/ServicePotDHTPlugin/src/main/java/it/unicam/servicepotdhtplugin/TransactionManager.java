package it.unicam.servicepotdhtplugin;

import java.util.Hashtable;
import java.util.UUID;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author midhat
 */
public class TransactionManager {
    public static Hashtable<Object,Object> stateTable=new Hashtable<Object, Object>();
    
    public static void put(Object key, Object value)
    {
    stateTable.put(key, value);
    }
    
    public static Object get(Object key)
    {
    return stateTable.get(key);
    }
    
    
}
