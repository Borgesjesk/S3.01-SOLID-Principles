import interfaces.PersonRepository;
import model.Person;
import repository.MySqlPersonRepository;
import services.ServicePerson;

/**
 * Entry point for the Dependency Inversion Principle exercise.
 * Wires dependencies and demonstrates saving a person via abstraction.
 */
public class MainD {

    public static void main(String[] args) {

        // Abstraction
        PersonRepository repository = new MySqlPersonRepository();

        // Injection
        ServicePerson servicePerson = new ServicePerson(repository);

        Person person = new Person();
        person.setName("Jess");

        servicePerson.savePerson(person);
    }
}
