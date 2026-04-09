package services;

import interfaces.Damageable;
import model.Character;

/**
 * Warrior can attack and take physical damage.
 * LSP: safely substitutable for Character — no broken promises.
 */
public class Warrior extends Character implements Damageable {

    public Warrior() {
        super();
    }

    @Override
    public void attack() {
        System.out.println("The warrior strikes with a sword.");
    }

    @Override
    public void takeDamage(int points) {
        System.out.println("The warrior resists and only takes " + (points / 2) + " points of damage.");
    }

}
