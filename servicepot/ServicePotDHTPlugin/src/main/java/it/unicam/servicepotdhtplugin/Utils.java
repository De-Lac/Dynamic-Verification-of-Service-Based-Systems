/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unicam.servicepotdhtplugin;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author midhat
 */
public class Utils {
    
    public static String getInquiryEndpoint() 
    {
        try {
            Properties properties = new Properties();
            properties.load(new Utils().getClass().getClassLoader().getResourceAsStream("dhtplugin.properties"));
            return properties.getProperty("UDDI.Endpoint.Inquiry");
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
