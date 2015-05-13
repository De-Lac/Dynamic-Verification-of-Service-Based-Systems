package client;

import it.unicam.cassandra.example.sso.contract.sp.SpPortType;
import it.unicam.cassandra.example.sso.contract.sp.SpService;

public class WSClient {
	
	//private static Logger logger = LogManager.getLogger("SpService");

    

    // used by OSGi-hosted client
    public WSClient(SpPortType portType) {
        makeCalls(portType);
    }

    // used by standalone Java client
    public static void main (String[] args) {
    	SpService service = new SpService();
    	SpPortType port = service.getSpPort();           
        makeCalls(port);
    } 
    
    private static void makeCalls(SpPortType port) {
    	requestResource(port, 10);
        
    }

    public static void requestResource(SpPortType port, int resourceNumber) {
    	System.out.println("[Sp_client#requestResource] ");
        String resp = port.requestResource(resourceNumber);
        System.out.println("[Sp_client#requestResource] "+resp);
        
    }
}
