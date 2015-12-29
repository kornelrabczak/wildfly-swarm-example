package com.thecookiezen.example;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

public class Application {

    public static void main(String[] args) throws Exception {
        Container container = new Container();

        // Start the container
        container.start();

        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
        deployment.addPackage(Application.class.getPackage());
        deployment.addAllDependencies();

        // Deploy your app
        container.deploy(deployment);
    }

}
