package services;

import utils.EmailValidator;
import utils.PasswordValidator;
import model.User;

/**
 * Coordinates user data validation.
 * SRP: responsible only for validating a User object.
 */

public class UserValidator {

        private final EmailValidator emailValidator = new EmailValidator();
        private final PasswordValidator passwordValidator = new PasswordValidator();

        public void validate(User user) {
            emailValidator.validate(user.getEmail());
            passwordValidator.validate(user.getPassword());
    }
}
