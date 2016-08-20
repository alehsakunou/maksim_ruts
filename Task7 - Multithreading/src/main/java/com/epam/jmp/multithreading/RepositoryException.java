package com.epam.jmp.multithreading;

/**
 * Created by Gambit on 8/21/2016.
 */
public class RepositoryException extends RuntimeException {
    public RepositoryException(Throwable cause) {
        super(cause);
    }

    public RepositoryException(Throwable cause, String message) {
        super(message, cause);
    }
}
