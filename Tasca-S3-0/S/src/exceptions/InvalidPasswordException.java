package exceptions;

/**
 * Thrown when a password fails format validation.
 */
public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException(String message) {
        super(message);
    }
}
