# S — Single Responsibility Principle

## What was wrong?
The original `User.java` violated the Single Responsibility Principle (SRP) because it
handled multiple concerns inside a single `register()` method, giving the class more
than one reason to change.

## Why did it violate the principle?
The `register()` method had at least three distinct responsibilities:
- Email format validation
- Password strength validation
- Sending the registration confirmation email

A class should have only one reason to change. Any modification to validation rules,
email logic, or registration flow would require touching the same class — making it
fragile and hard to maintain.

## What solution was applied and why?
The solution was to split responsibilities into dedicated classes, each with a single purpose:

- **`User`** — pure domain model, responsible only for representing user data
- **`EmailValidator`** and **`PasswordValidator`** — each handles one validation rule only, both implement the `Validator` interface for a consistent contract
- **`UserValidator`** — composes both validators to validate a full `User` object
- **`EmailService`** — handles all email communication, both generic and confirmation emails
- **`RegistrationService`** — orchestrates the registration flow without implementing any of those concerns itself

## Why constructor injection?
Instead of instantiating dependencies inside each class, they are injected via constructor.
This makes the code more flexible, testable, and aligned with the Dependency Inversion
Principle — classes depend on abstractions rather than concrete implementations, and
dependencies can be swapped without modifying the class itself.