import interfaces.Damageable;
import model.Character;
import services.Ghost;
import services.Warrior;

/**
 * Entry point for the Liskov Substitution Principle exercise.
 * Demonstrates that Ghost and Warrior are safely substitutable for Character.
 */
public class MainL {
    public static void main(String[] args) {


        Damageable wDamage = new Warrior();
        Character warriorService = new Warrior();
        Character ghostService = new Ghost();

        wDamage.takeDamage(5);
        warriorService.attack();
        ghostService.attack();

    }
}
