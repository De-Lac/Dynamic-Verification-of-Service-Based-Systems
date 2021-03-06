package it.unicam.cassandra.example.sso.contract.user;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.1
 * 2015-01-22T15:56:23.122+01:00
 * Generated source version: 3.0.1
 * 
 */
@WebServiceClient(name = "UserService", 
                  wsdlLocation = "classpath:User.wsdl",
                  targetNamespace = "http://www.unicam.it/cassandra/example/sso/contract/User") 
public class UserService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.unicam.it/cassandra/example/sso/contract/User", "UserService");
    public final static QName UserPort = new QName("http://www.unicam.it/cassandra/example/sso/contract/User", "UserPort");
    static {
        URL url = UserService.class.getClassLoader().getResource("User.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(UserService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "classpath:User.wsdl");
        }       
        WSDL_LOCATION = url;   
    }

    public UserService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public UserService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public UserService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public UserService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public UserService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns UserPortType
     */
    @WebEndpoint(name = "UserPort")
    public UserPortType getUserPort() {
        return super.getPort(UserPort, UserPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UserPortType
     */
    @WebEndpoint(name = "UserPort")
    public UserPortType getUserPort(WebServiceFeature... features) {
        return super.getPort(UserPort, UserPortType.class, features);
    }

}
