package client;

import it.unicam.cassandra.example.sso.contract.user.UserPortType;
import it.unicam.cassandra.example.sso.contract.user.UserService;

public class WSClient {
	
	//private static Logger logger = LogManager.getLogger("UserService");

    

    // used by OSGi-hosted client
    public WSClient(UserPortType portType) {
        makeCalls(portType);
    }

    // used by standalone Java client
    public static void main (String[] args) {
    	UserService service = new UserService();
    	UserPortType port = service.getUserPort();           
        makeCalls(port);
    } 
    
    private static void makeCalls(UserPortType port) {
    	startRequestResource(port, 10, "http://localhost:6969/sp_role");
        
    }

    public static void startRequestResource(UserPortType port, int resourceId, String serverSP) {
    	System.out.println("[User_client#startRequestResource] ");
        String resp = port.startRequestResource(resourceId, serverSP);
        System.out.println("[User_client#startRequestResource] "+resp);
        
    }
}
