package services;

/**
 * Handles all email communication with users.
 * SRP: responsible only for sending emails.
 */
public class EmailService {

    public void sendEmail(String email, String subject, String body) {
        System.out.println("📧 Sending email to " + email);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }

    public void sendConfirmationEmail(String email) {
        System.out.println("📧 Sending confirmation email to: " + email);
    }
}
