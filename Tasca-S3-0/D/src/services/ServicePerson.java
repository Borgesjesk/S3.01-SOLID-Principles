package services;

import interfaces.PersonRepository;
import model.Person;

/**
 * High-level service for person operations.
 * DIP: depends on PersonRepository abstraction, not on any concrete implementation.
 */
public class ServicePerson {

    private final PersonRepository personRepository;

    /**
     * Constructor injection — repository provided externally for flexibility and testability.
     */
    public ServicePerson(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void savePerson(Person person) {
        personRepository.savePerson(person);
    }
}

