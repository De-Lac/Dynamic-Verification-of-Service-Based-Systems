/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unicam.choreos.registry.proxy;

import it.unicam.choreos.registry.util.OSGIWorker;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.ow2.choreos.registry.plugin.v2.AbortException;

/**
 *
 * @author midhat
 */
public abstract class ServicePotUDDIService {

    protected String uddiURL;
    protected BundleContext bc;

    public ServicePotUDDIService(String uddiURL) {
        this.uddiURL = uddiURL;
    }

    public ServicePotUDDIService() {
    }

    public ServicePotUDDIService(BundleContext bc) {
        this.bc = bc;
    }

    public ServicePotUDDIService(String uddiURL, BundleContext bc) {
        this.uddiURL = uddiURL;
        this.bc = bc;
    }

    protected <P> void callPlugins(Class<P> clas, String methodName, Object... body) {

        if (bc == null) {
            //No Bundle Context. Nothing to do here. Probably not running in an OSGi Container
            return;

        }

        Collection<ServiceReference<P>> serviceReferences = null;
        serviceReferences = OSGIWorker.getPlugins(clas, bc);

        Class[] classes = new Class[body.length];
        for (int i = 0; i < body.length; i++) {
            classes[i] = body[i].getClass();
        }
        if (serviceReferences != null) {
            for (ServiceReference<P> sr : serviceReferences) {
                try {
                    P plugin = bc.getService(sr);
                    Method meth = plugin.getClass().getMethod(methodName, classes);
                    meth.invoke(plugin, body);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    if (ex.getCause() instanceof AbortException) {
                        throw (AbortException) (ex.getCause());
                    }
                    Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SecurityException ex) {
                    Logger.getLogger(UDDIInquiryPortTypeImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
