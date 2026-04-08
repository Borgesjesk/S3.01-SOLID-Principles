package interfaces;

/**
 * Generic contract for all validators.
 * SRP: each implementing class validates one thing only.
 */
public interface Validator {
    void validate(String value);
}
