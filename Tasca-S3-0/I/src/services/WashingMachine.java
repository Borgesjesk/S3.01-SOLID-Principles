package services;

import interfaces.Switchable;
import interfaces.Washable;

/**
 * Washing Machine implementation of Switchable and Washable.
 * ISP: only implements interfaces relevant to its capabilities — no heat() or cool() forced.
 */
public class WashingMachine implements Switchable, Washable {

    @Override
    public void turnOn() {
        System.out.println("WashingMachine is ON.");
    }

    @Override
    public void turnOff() {
        System.out.println("WashingMachine is OFF.");
    }

    @Override
    public void wash() {
        System.out.println("WashingMachine is washing clothes.");
    }

}
