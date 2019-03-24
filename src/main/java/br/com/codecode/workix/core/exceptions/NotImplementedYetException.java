package br.com.codecode.workix.core.exceptions;

/**
 * Exception for Not Implemented Functions
 *
 * @author felipe
 * @version 1.1
 * @since 1.0
 */
public final class NotImplementedYetException extends Exception {


    private static final long serialVersionUID = 3725069176156035494L;

    /**
     * Default Constructor
     */
    public NotImplementedYetException() {
        super();
    }

    /**
     * @param message Message to Forward through Exception
     */
    public NotImplementedYetException(String message) {
        super(message);
    }

}
