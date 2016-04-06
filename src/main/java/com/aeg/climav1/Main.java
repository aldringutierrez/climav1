/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeg.climav1;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.glassfish.embeddable.Deployer;
import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishException;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;

/**
 *
 * @author aeg
 */
public class Main {

    public static void main(String[] args) {

        String port = System.getenv("PORT");
        GlassFishProperties gfProps = new GlassFishProperties();
        gfProps.setPort("http-listener", Integer.parseInt(port));
        GlassFish glassfish;
        try {
            glassfish = GlassFishRuntime.bootstrap().newGlassFish(gfProps);
            glassfish.start();
            Deployer deployer = glassfish.getDeployer();
            File file = new File("climav1-1.0-SNAPSHOT.war");
            deployer.deploy(file);
        } catch (GlassFishException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
