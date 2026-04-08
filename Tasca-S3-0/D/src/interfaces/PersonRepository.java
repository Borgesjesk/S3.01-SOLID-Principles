package interfaces;

import model.Person;

/**
 * Abstraction for person persistence operations.
 * DIP: high-level classes depend on this interface, not on concrete implementations.
 */
public interface PersonRepository {
    void savePerson(Person person);
}

