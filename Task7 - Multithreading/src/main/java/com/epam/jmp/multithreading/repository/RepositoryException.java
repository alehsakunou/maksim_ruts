package com.epam.jmp.multithreading.repository;

/**
 * Created by Gambit on 8/21/2016.
 * Repository exception
 */
public class RepositoryException extends RuntimeException {
    public RepositoryException(Throwable cause) {
        super(cause);
    }

    public RepositoryException(Throwable cause, String message) {
        super(message, cause);
    }
}
