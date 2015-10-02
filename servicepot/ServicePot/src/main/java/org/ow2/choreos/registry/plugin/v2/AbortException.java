/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ow2.choreos.registry.plugin.v2;

/**
 * Used to abort an operation
 * @author midhat
 */
public class AbortException extends RuntimeException{

    public AbortException() {
    }

    public AbortException(String message) {
        super(message);
    }

    public AbortException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbortException(Throwable cause) {
        super(cause);
    }

 
    
    
    
}
