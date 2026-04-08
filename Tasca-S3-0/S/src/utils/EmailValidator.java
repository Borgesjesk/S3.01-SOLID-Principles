package utils;

import interfaces.Validator;
import exceptions.InvalidEmailException;

/**
 * Validates email format.
 * SRP: responsible only for checking if an email address is valid.
 */
public class EmailValidator implements Validator {

    @Override
    public void validate(String value) throws InvalidEmailException {
        if (value == null || !value.contains("@") || !value.contains(".")) {
            throw new InvalidEmailException("Invalid email address.");
        }
    }
}

