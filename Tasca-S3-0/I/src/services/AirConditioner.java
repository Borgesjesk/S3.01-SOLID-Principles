package services;

import interfaces.Switchable;
import interfaces.TemperatureControl;

/**
 * Air Conditioner implementation of Switchable and TemperatureControl.
 * ISP: only implements interfaces relevant to its capabilities — no wash() forced.
 */
public class AirConditioner implements Switchable, TemperatureControl {

    @Override
    public void turnOn() {
        System.out.println("AirConditioner is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("AirConditioner is OFF");
    }

    @Override
    public void heat() {
        System.out.println("AirConditioner is heating.");
    }

    @Override
    public void cool() {
        System.out.println("AirConditioner is cooling.");
    }

}
