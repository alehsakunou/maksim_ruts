package com.epam.jmp.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

/**
 * Created by Gambit on 8/20/2016.
 */
public class RepositoryDownloader implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger();
    private final InputStream is;
    private final OutputStream os;
    private String filename;

    public RepositoryDownloader(InputStream is, OutputStream os, String filename) {
        this.is = is;
        this.os = os;
        this.filename = filename;
    }

    public void run() {
        try {
            LOGGER.info("Start processing of file: " + filename);
            int result;
            while ((result = is.read()) != -1) {
                os.write(result);
            }
            os.flush();
            is.close();
            os.close();
            LOGGER.info("Completed processing of file: " + filename);
        } catch (IOException e) {
            LOGGER.error("error during processing of file: " + filename);
        }
    }
}
