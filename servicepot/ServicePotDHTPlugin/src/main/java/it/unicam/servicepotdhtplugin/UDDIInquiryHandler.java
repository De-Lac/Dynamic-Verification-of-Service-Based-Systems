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
import it.unicam.choreos.registry.proxy.UDDIInquiryPortTypeImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor;
import org.ow2.choreos.registry.plugin.v2.Wrapper;
import org.uddi.api_v3.*;

/**
 *
 * @author midhat
 */
public class UDDIInquiryHandler implements UDDIInquryMonitor {

    public void beforeGetBindingDetail(Wrapper<GetBindingDetail> body) {
        
    }

    public void afterGetBindingDetail(Wrapper<BindingDetail> output) {
        
    }

    public void beforeGetServiceDetail(Wrapper<GetServiceDetail> body) {
        
    }

    public void afterGetServiceDetail(Wrapper<ServiceDetail> body) {
        
    }

    public void beforeGetTModelDetail(Wrapper<GetTModelDetail> body) {
        
    }

    public void afterGetTModelDetail(Wrapper<TModelDetail> body) {
        
    }

    public void beforeFindBinding(Wrapper<FindBinding> body) {
        
    }

    public void afterFindBinding(Wrapper<BindingDetail> body) {
        
    }

    public void beforeFindBusiness(Wrapper<FindBusiness> body) {
        
    }

    public void afterFindBusiness(Wrapper<BusinessList> body) {
        
    }

    public void beforeFindRelatedBusinesses(Wrapper<FindRelatedBusinesses> body) {
        
    }

    public void afterFindRelatedBusinesses(Wrapper<RelatedBusinessesList> body) {
        
    }

    public void beforeGetBusinessDetail(Wrapper<GetBusinessDetail> body) {
        
    }

    public void afterGetBusinessDetail(Wrapper<BusinessDetail> body) {
        
    }

    public void beforeFindTModel(Wrapper<FindTModel> body, String opid) {
        TransactionManager.put(opid, body);
    }

    public void afterFindTModel(Wrapper<TModelList> body, String opid) {
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
            FindTModel ftm =  (FindTModel) TransactionManager.get(opid);

            String url = ofy.get(new Key<Entry>(Entry.class, ftm.getName().getValue())).getValue();
            installer.uninstall();
            //if (!url.equals(Utils.getInquiryEndpoint()) && url!=null) {
            if (url != null) {
                if (ftm.getMaxRows() == null || body.getContents().getListDescription().getIncludeCount() < ftm.getMaxRows()) {
                  
                        UDDIInquiryPortTypeImpl inquiryService = null;

                        //do recursive lookup

                        inquiryService = new UDDIInquiryPortTypeImpl(url);
                        if (ftm.getMaxRows() != null) {
                            ftm.setMaxRows(ftm.getMaxRows() - body.getContents().getListDescription().getIncludeCount());
                        }
                        TModelList rfindTModel = inquiryService.findTModel(ftm);
                        body.getContents().getTModelInfos().getTModelInfo().addAll(rfindTModel.getTModelInfos().getTModelInfo());
                        body.getContents().getListDescription().setIncludeCount(body.getContents().getListDescription().getIncludeCount() + rfindTModel.getListDescription().getIncludeCount());
                        body.getContents().getListDescription().setActualCount(body.getContents().getListDescription().getActualCount() + rfindTModel.getListDescription().getActualCount());
                  


                }

            }

        


    }

    public void beforeGetOperationalInfo(Wrapper<GetOperationalInfo> body) {
        
    }

    public void afterGetOperationalInfo(Wrapper<OperationalInfos> body) {
        
    }

    public void beforeFindService(Wrapper<FindService> input) {
        
    }

    public void afterFindService(Wrapper<ServiceList> output) {
        
    }

    public void beforeGetBindingDetail(Wrapper<GetBindingDetail> body, String opid) {
        
    }

    public void afterGetBindingDetail(Wrapper<BindingDetail> output, String opid) {
        
    }

    public void beforeGetServiceDetail(Wrapper<GetServiceDetail> body, String opid) {
        
    }

    public void afterGetServiceDetail(Wrapper<ServiceDetail> body, String opid) {
        
    }

    public void beforeGetTModelDetail(Wrapper<GetTModelDetail> body, String opid) {
        
    }

    public void afterGetTModelDetail(Wrapper<TModelDetail> body, String opid) {
        
    }

    public void beforeFindBinding(Wrapper<FindBinding> body, String opid) {
        
    }

    public void afterFindBinding(Wrapper<BindingDetail> body, String opid) {
        
    }

    public void beforeFindBusiness(Wrapper<FindBusiness> body, String opid) {
        
    }

    public void afterFindBusiness(Wrapper<BusinessList> body, String opid) {
        
    }

    public void beforeFindRelatedBusinesses(Wrapper<FindRelatedBusinesses> body, String opid) {
        
    }

    public void afterFindRelatedBusinesses(Wrapper<RelatedBusinessesList> body, String opid) {
        
    }

    public void beforeGetBusinessDetail(Wrapper<GetBusinessDetail> body, String opid) {
        
    }

    public void afterGetBusinessDetail(Wrapper<BusinessDetail> body, String opid) {
        
    }

    public void beforeGetOperationalInfo(Wrapper<GetOperationalInfo> body, String opid) {
        
    }

    public void afterGetOperationalInfo(Wrapper<OperationalInfos> body, String opid) {
        
    }

    public void beforeFindService(Wrapper<FindService> input, String opid) {
        
    }

    public void afterFindService(Wrapper<ServiceList> output, String opid) {
        
    }
}
