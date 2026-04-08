package exceptions;

/**
 * Thrown when an email address fails format validation.
 */
public class InvalidEmailException extends RuntimeException {

    public InvalidEmailException(String message) {
        super(message);
    }
}
