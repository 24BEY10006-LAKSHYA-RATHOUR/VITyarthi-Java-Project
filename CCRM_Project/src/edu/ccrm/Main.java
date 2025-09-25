package edu.ccrm;

import edu.ccrm.cli.CliManager;

/**
 * Main entry point for the Campus Course & Records Manager (CCRM) application.
 * This class is responsible for initializing the application and starting the
 * command-line interface.
 */
public class Main {

    /**
     * The main method that starts the Java application.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Campus Course & Records Manager!");
        
        // The AppConfig singleton is initialized automatically when first accessed.
        // We create the CliManager which will get its services from the AppConfig.
        CliManager cliManager = new CliManager();

        // Start the command-line interface loop.
        // The method is called run(), not start(). This is the fix.
        cliManager.run();
    }
}
