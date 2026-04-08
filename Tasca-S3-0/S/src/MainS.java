import exceptions.InvalidPasswordException;
import model.User;
import services.RegistrationService;

/**
 * Entry point for the Single Responsibility Principle exercise.
 * Demonstrates valid and invalid user registration flows.
 */
public class MainS {

    public static void main(String[] args) {

        RegistrationService registrationService = new RegistrationService();

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
