package services;

import model.Character;

/**
 * Ghost can attack, but can not take physical damage.
 * LSP: safely substitutable for Character but do not implement the Interface.
 */
public class Ghost extends Character {
    public Ghost() {
        super();
    }

    @Override
    public void attack() {
        System.out.println("The ghost casts a spooky spell.");
    }
}
