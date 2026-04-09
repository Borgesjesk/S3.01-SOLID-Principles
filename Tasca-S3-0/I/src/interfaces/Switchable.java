package interfaces;

/**
 * Defines on/off behavior for all machines.
 * ISP: segregated interface — only implemented by classes that need switching.
 */
public interface Switchable {

    void turnOn();

    void turnOff();
}
