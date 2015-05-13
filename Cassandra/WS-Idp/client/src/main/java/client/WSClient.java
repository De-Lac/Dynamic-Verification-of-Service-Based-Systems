package client;

import it.unicam.cassandra.example.sso.contract.idp.IdpPortType;
import it.unicam.cassandra.example.sso.contract.idp.IdpService;

public class WSClient {
	
	//private static Logger logger = LogManager.getLogger("UserService");

    

    // used by OSGi-hosted client
    public WSClient(IdpPortType portType) {
        makeCalls(portType);
    }

    // used by standalone Java client
    public static void main (String[] args) {
    	IdpService service = new IdpService();
    	IdpPortType port = service.getIdpPort();           
        makeCalls(port);
    } 
    
    private static void makeCalls(IdpPortType port) {
    	authentication(port, "Xfgr44", "daniele_fani", "0000");
        
    }

    public static void authentication(IdpPortType port, String sp_key, String username, String passw) {
    	System.out.println("[Idp_client#authentication] "+username);
        String resp = port.authentication(sp_key, username, passw);
        System.out.println("[Idp_client#authentication] "+resp);
        
    }
}
