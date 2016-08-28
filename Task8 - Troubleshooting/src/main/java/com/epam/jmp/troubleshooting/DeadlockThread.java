package com.epam.jmp.troubleshooting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Semaphore;

/**
 * Created by Gambit on 8/28/2016.
 * Thread for deadlock imitation
 */
public class DeadlockThread implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger();
    private Semaphore firstResource;
    private Semaphore secondResource;

    public DeadlockThread(Semaphore secondResource, Semaphore firstResource) {
        this.secondResource = secondResource;
        this.firstResource = firstResource;
    }

    public void run() {
        try {
            LOGGER.info("wait for " + firstResource);
            firstResource.acquire();
            LOGGER.info("done!");
            LOGGER.info("sleep...");
            Thread.sleep(100);
            LOGGER.info("wait for " + secondResource);
            secondResource.acquire();
            LOGGER.info("done!");
        } catch (InterruptedException e) {
            LOGGER.error("Oops... interrupted!!");
        }
    }
}
