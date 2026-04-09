package interfaces;

/**
 * Abstraction for all instruments.
 * OCP: new instruments can be added without modifying existing code.
 */
public interface Instrument {
    void play();
}
