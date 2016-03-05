package com.oracle.jsonbdemo.embedded;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.*;

/**
 * Embedded Jetty starter.
 */
public class JettyStarter {
    public static void main(String[] args) throws Exception {

        WebAppContext ctx = new WebAppContext();
        ctx.setDescriptor("WEB-INF/web.xml");
        ctx.setConfigurations(new Configuration[]{new AnnotationConfiguration(),
                new WebXmlConfiguration(), new WebInfConfiguration(), new MetaInfConfiguration()});
        ctx.setResourceBase("src/main/webapp");
        ctx.setContextPath("/jsonb-demo");


        Server server = new Server(8080);

        // Starts the embedded server and bind it on 8080 port
        server.setHandler(ctx);
        server.start();
        server.join();
    }
}