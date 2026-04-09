package services;

import interfaces.Damageable;
import model.Character;

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
