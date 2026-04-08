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

### 1. `User` — Pure Domain Model
`User` is now responsible only for representing user data (name, email, password).
All registration, validation and email logic was extracted into dedicated classes.

### 2. `EmailValidator` and `PasswordValidator` — Validation Utils
Each class handles one validation rule only.
Both implement the `Validator` interface, ensuring a consistent contract across all validators.

### 3. `UserValidator` — Validation Coordinator
Composes `EmailValidator` and `PasswordValidator` to validate a full `User` object.
Delegates each validation concern to the appropriate class.

### 4. `EmailService` — Email Communication
Responsible only for sending emails. Handles both generic emails and confirmation emails.

### 5. `RegistrationService` — Registration Orchestrator
Acts as the composition root for the registration flow — coordinates validation,
confirmation and email sending without implementing any of those concerns itself.

### 6. `MainS` — Entry Point
Instantiates all components and wires them together via constructor injection,
then demonstrates both valid and invalid registration flows.

## Why constructor injection?
Instead of instantiating dependencies inside each class, they are injected via constructor.
This makes the code more flexible, testable, and aligned with the Dependency Inversion
Principle — classes depend on abstractions rather than concrete implementations, and
dependencies can be swapped without modifying the class itself.