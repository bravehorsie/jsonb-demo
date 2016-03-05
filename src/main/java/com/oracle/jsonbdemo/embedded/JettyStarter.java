package com.oracle.jsonbdemo.embedded;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.*;

import java.net.URL;
import java.security.ProtectionDomain;

/**
 * Embedded Jetty starter.
 */
public class JettyStarter {
    public static void main(String[] args) throws Exception {

        //a temporary hack for jetty starter, it does not see resources in jar-with-dependencies
//        extractResoruceBase();

        ProtectionDomain domain = JettyStarter.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();

        // Create a web app and configure it to the root context of the server
        WebAppContext webapp = new WebAppContext();
        webapp.setDescriptor("WEB-INF/web.xml");
        webapp.setConfigurations(new Configuration[]{new AnnotationConfiguration(),
                new WebXmlConfiguration(), new WebInfConfiguration(), new MetaInfConfiguration()});
        webapp.setContextPath("/jsonb-demo/");
//        webapp.setResourceBase("./webappresources/webapp");
        webapp.setResourceBase("src/main/webapp");
        webapp.setWar(location.toExternalForm());

        // Starts the embedded server and bind it on 8080 port
        Server server = new Server(8080);
        server.setHandler(webapp);
        server.start();
        server.join();
    }

    private static void extractResoruceBase() throws Exception {
        new UnzipUtility().unzip("./jsonb-demo-jar-with-dependencies.jar", "./webappresources");
    }
}