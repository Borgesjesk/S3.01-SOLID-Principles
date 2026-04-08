package model;

/**
 * Represents a person in the system.
 * DIP: pure domain model, no dependencies on concrete implementations.
 */
public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
