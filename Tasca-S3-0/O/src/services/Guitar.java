package services;

import interfaces.Instrument;

/**
 * Guitar implementation of Instrument.
 * OCP: extends behavior without modifying InstrumentPlayer.
 */
public class Guitar implements Instrument {
    @Override
    public void play() {
        System.out.println("🎸 Strumming the guitar");
    }
}
