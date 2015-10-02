/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unicam.servicepotdhtplugin;

import com.google.appengine.tools.remoteapi.RemoteApiInstaller;
import com.google.appengine.tools.remoteapi.RemoteApiOptions;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.Holder;
import org.ow2.choreos.registry.plugin.v2.UDDIPublicationMonitor;
import org.ow2.choreos.registry.plugin.v2.Wrapper;
import org.uddi.api_v3.*;

/**
 *
 * @author midhat
 */
public class UDDIPublishHandler implements UDDIPublicationMonitor {

    public void beforeDeleteBinding(Wrapper<DeleteBinding> body, String opid) {
        
    }

    public void afterDeleteBinding(String opid) {
        
    }

    public void beforeSaveTModel(Wrapper<SaveTModel> body, String opid) {
       
        
    }

    public void afterSaveTModel(Wrapper<TModelDetail> body, String opid) {
                 RemoteApiInstaller installer = new RemoteApiInstaller();
        RemoteApiOptions options = new RemoteApiOptions()
                .server("servicepot.appspot.com", 443)
                .credentials("servicepotdht@gmail.com", "ambxxforinhcqqcw");
        try {
            installer.install(options);
        } catch (IOException ex) {
            Logger.getLogger(UDDIPublishHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Objectify ofy = ObjectifyService.begin();
        for (TModel tMod : body.getContents().getTModel()) {
        /*
            Boolean continu = true;
            List<KeyedReference> keyedReferences = tMod.getCategoryBag().getKeyedReference();

            for (KeyedReference kr : keyedReferences) {
                if (kr.getTModelKey().equals("uddi:choreos.eu:types")) {

                    continu = false;
                }
            }
            if (continu) {
                continue;
            }*/

            ArrayList<Entry> entries = new ArrayList<Entry>();

            entries.add(new Entry(tMod.getTModelKey(), Utils.getInquiryEndpoint()));
            entries.add(new Entry(tMod.getName().getValue(), Utils.getInquiryEndpoint()));
            ofy.put(entries);

            //ofy.getTxn().commit();
            installer.uninstall();

        }
    }

    public void beforeAddPublisherAssertions(Wrapper<AddPublisherAssertions> body, String opid) {
        
    }

    public void afterAddPublisherAssertions(String opid) {
        
    }

    public void beforeDeleteBusiness(Wrapper<DeleteBusiness> body, String opid) {
        
    }

    public void afterDeleteBusiness(String opid) {
        
    }

    public void beforeSaveService(Wrapper<SaveService> body, String opid) {
        
    }

    public void afterSaveService(Wrapper<ServiceDetail> body, String opid) {
Objectify ofy = ObjectifyService.beginTransaction();
        List<BusinessService> businessServices = body.getContents().getBusinessService();

        ArrayList<Entry> entries = new ArrayList<Entry>();

        for (BusinessService bs : businessServices) {


            entries.add(new Entry(bs.getServiceKey(), Utils.getInquiryEndpoint()));
            for (Name name : bs.getName()) {

                entries.add(new Entry(bs.getServiceKey(), Utils.getInquiryEndpoint()));

            }

            List<KeyedReference> keyedReferences = bs.getCategoryBag().getKeyedReference();
            for (KeyedReference kr : keyedReferences) {
                if (kr.getTModelKey().equals("uddi:choreos.eu:role")) {

                    entries.add(new Entry(kr.getKeyValue(), Utils.getInquiryEndpoint()));

                }
            }
        }
        ofy.put(entries);
        ofy.getTxn().commit();        
    }

    public void beforeDeletePublisherAssertions(Wrapper<DeletePublisherAssertions> body, String opid) {
        
    }

    public void afterDeletePublisherAssertions(String opid) {
        
    }

    public void beforeSetPublisherAssertions(Wrapper<String> authInfo, Wrapper<Holder<List<PublisherAssertion>>> publisherAssertion, String opid) {
        
    }

    public void afterSetPublisherAssertions(String opid) {
        
    }

    public void beforeGetPublisherAssertions(Wrapper<String> authInfo, String opid) {
        
    }

    public void afterGetPublisherAssertions(Wrapper<List<PublisherAssertion>> body, String opid) {
        
    }

    public void beforeDeleteService(Wrapper<DeleteService> body, String opid) {
        
    }

    public void afterDeleteService(String opid) {
        
    }

    public void beforeSaveBinding(SaveBinding body, String opid) {
        
    }

    public void afterSaveBinding(BindingDetail body, String opid) {
        
    }

    public void beforeSaveBusiness(SaveBusiness body, String opid) {
        
    }

    public void afterSaveBusiness(BusinessDetail body, String opid) {
        
    }

    public void beforeGetRegisteredInfo(GetRegisteredInfo body, String opid) {
        
    }

    public void afterGetRegisteredInfo(RegisteredInfo body, String opid) {
        
    }

    public void beforeGetAssertionStatusReport(String authInfo, CompletionStatus completionStatus, String opid) {
        
    }

    public void afterGetAssertionStatusReport(List<AssertionStatusItem> body, String opid) {
        
    }

    public void beforeDeleteTModel(DeleteTModel body, String opid) {
        
    }

    public void afterDeleteTModel(String opid) {
        
    }


}
