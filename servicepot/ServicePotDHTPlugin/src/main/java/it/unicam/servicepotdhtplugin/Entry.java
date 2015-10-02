/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unicam.servicepotdhtplugin;

import javax.persistence.Id;

/**
 *
 * @author midhat
 */

public class Entry {
    @Id String key;
    String value;

    public Entry() {
    }

    public Entry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
