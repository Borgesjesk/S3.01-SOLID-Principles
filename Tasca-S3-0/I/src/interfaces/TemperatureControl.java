package interfaces;

/**
 * Defines temperature behavior for machines.
 * ISP: segregated interface — only implemented by classes that need temperature control.
 */
public interface TemperatureControl {

    void heat();

    void cool();

}
