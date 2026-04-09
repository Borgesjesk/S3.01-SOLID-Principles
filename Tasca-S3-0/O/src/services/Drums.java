package services;

import interfaces.Instrument;

/**
 * Drums implementation of Instrument.
 * OCP: extends behavior without modifying InstrumentPlayer.
 */
public class Drums implements Instrument {
    @Override
    public void play() {
        System.out.println("🥁 Beating the drums");
    }
}
