package it.unicam.servicpot.xsdplugin;

import it.unicam.choreos.registry.proxy.UDDIInquiryPortTypeImpl;
import java.util.ArrayList;
import java.util.List;
import org.ow2.choreos.executable_service_discovery.plugin_manager.AbstractPlugin;
import org.ow2.choreos.executable_service_discovery.plugin_manager.ServiceFilter;
import org.uddi.api_v3.CategoryBag;
import org.uddi.api_v3.FindQualifiers;
import org.uddi.api_v3.FindTModel;
import org.uddi.api_v3.GetTModelDetail;
import org.uddi.api_v3.KeyedReference;
import org.uddi.api_v3.Name;
import org.uddi.api_v3.OverviewDoc;
import org.uddi.api_v3.TModel;
import org.uddi.api_v3.TModelDetail;
import org.uddi.api_v3.TModelInfo;
import org.uddi.api_v3.TModelList;

/**
 * Hello world!
 *
 */
public class ServicePotXSDPlugin extends AbstractPlugin {

    private static final String UID = "it.unicam.servicepot.xsdplugin.ServicePotXSDPlugin";
    private static final String SHORT_NAME = "ServicePot";
    private static final String LONG_NAME = "ServicePot XSD Plugin";
    private static final String DESCRIPTION = "XSD Plugin for ServicePot. Retrieves Services from ServicePot";
    private static final String AUTHOR = "Midhat Ali - University of Cameirno";
    private boolean started = false;

    private String getInquiryURI() {
        return "http://atlantis.isti.cnr.it:8080/juddiv3-war-3.1.0/services/inquiry";
    }

    @Override
    public String getUID() {
        return UID;
    }

    @Override
    public String getShortName() {
        return SHORT_NAME;
    }

    @Override
    public String getLongName() {
        return LONG_NAME;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public String getAuthor() {
        return AUTHOR;
    }

    @Override
    public char getSupportedDiscoveryMode() {
        return ACTIVE_DISCOVERY_MODE;
    }

    @Override
    public String getRegistryURI() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public char getStatus() {
        return started ? STATUS_STARTED : STATUS_STOPPED;
    }

    @Override
    public Object retrieveServices(final ServiceFilter sf) {
        List<String> output = new ArrayList<String>();
        UDDIInquiryPortTypeImpl inquiryService = new UDDIInquiryPortTypeImpl(getInquiryURI());

        FindTModel ftm = new FindTModel();
        ftm.setFindQualifiers(new FindQualifiers());
        ftm.getFindQualifiers().getFindQualifier().add("approximatematch");
        ftm.setName(new Name("%"));
        ftm.setCategoryBag(new CategoryBag());

        KeyedReference wsdlTypeV2 = new KeyedReference();
        wsdlTypeV2.setTModelKey("uuid:6e090afa-33e5-36eb-81b7-1ca18373f457");
        wsdlTypeV2.setKeyName("WSDL Type");

        KeyedReference wsdlTypeV3 = new KeyedReference();
        wsdlTypeV3.setTModelKey("uddi:uddi.org:wsdl:type");
        wsdlTypeV3.setKeyName("WSDL Type");

        ftm.getCategoryBag().getKeyedReference().add(wsdlTypeV2);
        ftm.getCategoryBag().getKeyedReference().add(wsdlTypeV3);
        TModelList tModelList = inquiryService.findTModel(ftm);
        List<TModelInfo> tModelInfos = tModelList.getTModelInfos().getTModelInfo();
        GetTModelDetail gtmd = new GetTModelDetail();

        for (TModelInfo tmi : tModelInfos) {

            gtmd.getTModelKey().add(tmi.getTModelKey());

        }
        TModelDetail tModelDetail = inquiryService.getTModelDetail(gtmd);
        for (TModel tModel : tModelDetail.getTModel()) {
            for (OverviewDoc doc : tModel.getOverviewDoc()) {
                if ("wsdlinteface".equalsIgnoreCase(doc.getOverviewURL().getUseType())) {
                    output.add(doc.getOverviewURL().getValue());
                }
            }
        }
        
        return output;

    }

    @Override
    public void start() {
        started = true;
    }

    @Override
    public void stop() {
        started = false;
    }

    @Override
    public void restart() {
    }
}
