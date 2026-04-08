package utils;

import interfaces.Validator;
import exceptions.InvalidPasswordException;

/**
 * Validates password strength.
 * SRP: responsible only for checking if a password meets security requirements.
 */
public class PasswordValidator implements Validator {

    @Override
    public void validate(String value) throws InvalidPasswordException {
        if (value == null || value.length() < 8 || !value.matches(".*[A-Z].*")) {
            throw new InvalidPasswordException("Password must be at least 8 characters long and contain an uppercase letter.");
        }
    }
}

