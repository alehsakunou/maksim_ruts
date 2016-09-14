package com.epam.jmp.jbdc;

/**
 * DatabaseTransactionException
 * Created by Gambit on 9/15/2016.
 */
public class DatabaseTransactionException extends RuntimeException {
    public DatabaseTransactionException(Throwable ex) {
        super(ex);
    }
}
