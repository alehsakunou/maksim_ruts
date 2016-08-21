package com.epam.jmp.multithreading.repository;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Gambit on 8/20/2016.
 */
public interface Repository {
    /**
     * Download file from repository in asynchronous mode
     * @param filename name of file to downloading
     * @param os output stream for downloading
     * @throws RepositoryException if error arise during downloading
     */
    void loadAsync(String filename, OutputStream os);

    /**
     * Upload file to repository in asynchronous mode
     * @param filename name of file to uploading
     * @param is input stream fir uploading
     * @throws RepositoryException if error arise during uploading
     */
    void saveAsync(String filename, InputStream is);

    /**
     * List of files which repository contains
     * @return list of files at repository
     */
    List<String> files();

    /**
     * Close repository
     */
    void close();
}
