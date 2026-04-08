import exceptions.InvalidPasswordException;
import model.User;
import services.EmailService;
import services.RegistrationService;
import services.UserValidator;
import utils.EmailValidator;
import utils.PasswordValidator;

/**
 * Entry point for the Single Responsibility Principle exercise.
 * Demonstrates valid and invalid user registration flows.
 */
public class MainS {

    public static void main(String[] args) {

        EmailValidator emailValidator = new EmailValidator();
        PasswordValidator passwordValidator = new PasswordValidator();
        UserValidator userValidator = new UserValidator(emailValidator, passwordValidator);
        EmailService emailService = new EmailService();
        RegistrationService registrationService = new RegistrationService(emailService, userValidator);

        // Invalid user - should throw exception
        User user1 = new User("James", "jamesj@gmail.com", "admin3210");
        try {
            registrationService.register(user1);
        } catch (InvalidPasswordException e) {
            System.out.println("❌ Registration failed: " + e.getMessage());
        }

        // Valid user - should succed
        User user2 = new User("Jonas", "jonasj@gmail.com", "Admin0123");
        registrationService.register(user2);
    }
}
