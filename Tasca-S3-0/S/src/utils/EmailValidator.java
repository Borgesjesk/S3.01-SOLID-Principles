package utils;

import interfaces.Validator;
import exceptions.InvalidEmailException;

public class EmailValidator implements Validator {

    @Override
    public void validate(String value) throws InvalidEmailException {
        if (value == null || !value.contains("@") || !value.contains(".")) {
            throw new InvalidEmailException("Invalid email address.");
        }
    }
}

