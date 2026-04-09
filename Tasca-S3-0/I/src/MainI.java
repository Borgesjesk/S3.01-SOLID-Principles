import interfaces.Switchable;
import interfaces.TemperatureControl;
import interfaces.Washable;
import services.AirConditioner;
import services.WashingMachine;

/**
 * Entry point for the Interface Segregation Principle exercise.
 * Demonstrates each machine only implementing the interfaces it needs.
 */
public class MainI {
    public static void main(String[] args) {

        Switchable acSwitch = new AirConditioner();
        Switchable wmSwitch = new WashingMachine();
        TemperatureControl tempControl = new AirConditioner();
        Washable wmWash = new WashingMachine();

        acSwitch.turnOn();
        tempControl.heat();
        tempControl.cool();
        acSwitch.turnOff();

        wmSwitch.turnOn();
        wmWash.wash();
        wmSwitch.turnOff();

    }

}
