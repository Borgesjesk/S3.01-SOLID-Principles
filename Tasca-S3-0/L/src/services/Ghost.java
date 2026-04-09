package services;

import model.Character;

public class Ghost extends Character {
    public Ghost() {
        super();
    }

    @Override
    public void attack() {
        System.out.println("The ghost casts a spooky spell.");
    }
}
