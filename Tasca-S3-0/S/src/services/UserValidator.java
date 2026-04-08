package services;

import utils.EmailValidator;
import utils.PasswordValidator;
import model.User;

/**
 * Coordinates user data validation.
 * SRP: responsible only for validating a User object.
 */

public class UserValidator {

    private final EmailValidator emailValidator;
    private final PasswordValidator passwordValidator;

    /**
     * Constructor injection — dependencies provided externally for flexibility and testability.
     */
    public UserValidator(EmailValidator emailValidator, PasswordValidator passwordValidator) {
        this.emailValidator = emailValidator;
        this.passwordValidator = passwordValidator;
    }

    public void validate(User user) {
        emailValidator.validate(user.getEmail());
        passwordValidator.validate(user.getPassword());
    }
}
