package it.unicam.servicepotdhtplugin;

import com.google.appengine.tools.remoteapi.RemoteApiInstaller;
import com.google.appengine.tools.remoteapi.RemoteApiOptions;
import java.io.IOException;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import com.googlecode.objectify.ObjectifyService;
import org.ow2.choreos.registry.plugin.v2.UDDIInquryMonitor;
import org.ow2.choreos.registry.plugin.v2.UDDIPublicationMonitor;

public class Activator implements BundleActivator {

    RemoteApiInstaller installer;

    public Activator() throws IOException {
    }

    public void start(BundleContext context) throws Exception {
        RemoteApiInstaller installer = new RemoteApiInstaller();
        RemoteApiOptions options = new RemoteApiOptions()
                .server("servicepot.appspot.com", 443)
                .credentials("servicepotdht@gmail.com", "ambxxforinhcqqcw");
        installer.install(options);
        ObjectifyService.factory().register(Entry.class);
        installer.uninstall();
        UDDIInquiryHandler inquiryPlugin = new UDDIInquiryHandler();
        UDDIPublishHandler publishPlugin = new UDDIPublishHandler();
        context.registerService(UDDIInquryMonitor.class, inquiryPlugin, null);
        context.registerService(UDDIPublicationMonitor.class, publishPlugin, null);
        
        
    }

    public void stop(BundleContext context) throws Exception {

    }

    private void setupContext() {
    }

    private void tearDownContext() {
    }
}
