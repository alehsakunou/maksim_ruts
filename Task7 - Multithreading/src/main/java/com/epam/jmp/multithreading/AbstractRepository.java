package com.epam.jmp.multithreading;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gambit on 8/20/2016.
 */
public abstract class AbstractRepository implements Repository {
    private static final Logger LOGGER = LogManager.getLogger();
    private final String path;

    public AbstractRepository(String path) {
        this.path = path;
    }

    @Override
    public void loadAsync(String filename, OutputStream os) {
        try {
            File file = getResultFile(filename);
            RepositoryDownloader downloader = new RepositoryDownloader(new FileInputStream(file), os, filename);
            load(downloader);
        } catch (FileNotFoundException e) {
            String message = "Error on load file: " + filename;
            LOGGER.error(message);
            throw new RepositoryException(e, message);
        }
    }

    protected abstract void load(RepositoryDownloader downloader);

    @Override
    public void saveAsync(String filename, InputStream is) {
        try {
            File output = getResultFile(filename);
            RepositoryDownloader downloader = new RepositoryDownloader(is, new FileOutputStream(output), filename);
            save(downloader);
        } catch (FileNotFoundException e) {
            String message = "Error on save file: " + filename;
            LOGGER.error(message);
            throw new RepositoryException(e, message);
        }
    }

    protected abstract void save(RepositoryDownloader downloader);

    @Override
    public List<String> files() {
        List<String> files = new ArrayList<>();
        FileUtils.listFiles(new File(path), null, false).forEach(file -> files.add(file.getName()));
        return files;
    }

    @Override
    public abstract void close();

    protected File getResultFile(String filename) {
        File output;
        output = new File(path + File.separator + filename);
        return output;
    }
}
