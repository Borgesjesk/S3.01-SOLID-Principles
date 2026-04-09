import interfaces.Damageable;
import model.Character;
import services.Ghost;
import services.Warrior;

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
