package by.epam.jmp.patterns.dao;

/**
 * Created by Gambit on 7/25/2016.
 */
public class PersistenceException extends RuntimeException {
    private Throwable cause;
    private String message;

    public PersistenceException(Throwable cause) {
        this.cause = cause;
    }

    public PersistenceException(String message) {

        this.message = message;
    }

    public Throwable getCause() {
        return cause;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
