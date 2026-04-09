package services;

import interfaces.Instrument;

/**
 * Piano implementation of Instrument.
 * OCP: extends behavior without modifying InstrumentPlayer.
 */
public class Piano implements Instrument {
    @Override
    public void play() {
        System.out.println("🎹 Playing the piano");
    }
}
