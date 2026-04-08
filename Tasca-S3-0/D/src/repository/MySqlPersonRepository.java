package repository;

import interfaces.PersonRepository;
import model.Person;

/**
 * MySQL implementation of PersonRepository.
 * DIP: concrete implementation of the PersonRepository abstraction.
 */
public class MySqlPersonRepository implements PersonRepository {

    @Override
    public void savePerson(Person person) {
        System.out.println("Save person ok...");
    }
}
