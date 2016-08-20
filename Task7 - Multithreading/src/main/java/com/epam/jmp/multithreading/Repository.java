package com.epam.jmp.multithreading;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Gambit on 8/20/2016.
 */
public interface Repository {
    void loadAsync(String filename, OutputStream os);
    void saveAsync(String filename, InputStream is);
    List<String> files();
    void close();
}
