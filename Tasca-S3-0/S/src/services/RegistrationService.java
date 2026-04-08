package services;

import model.User;

/**
 * Orchestrates the user registration flow.
 * SRP: responsible only for coordinating registration steps.
 */
public class RegistrationService {

    private final EmailService emailService;
    private final UserValidator userValidator;

    /**
     * Constructor injection — dependencies provided externally for flexibility and testability.
     */
    public RegistrationService(EmailService emailService, UserValidator userValidator) {
        this.emailService = emailService;
        this.userValidator = userValidator;
    }

    public void register(User user) {
        userValidator.validate(user);

        boolean userConfirmed = true;
        if (!userConfirmed) {
            System.out.println("⚠️ User did not confirm registration.");
            return;
        }
        emailService.sendConfirmationEmail(user.getEmail());
    }
}

