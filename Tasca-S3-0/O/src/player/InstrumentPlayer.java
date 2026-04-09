package player;

import interfaces.Instrument;

/**
 * Plays any instrument without knowing the concrete implementation.
 * OCP: open for extension — new instruments can be added without modifying this class.
 */
public class InstrumentPlayer {

    private final Instrument instrument;

    /**
     * Constructor injection — instrument provided externally for flexibility.
     */
    public InstrumentPlayer(Instrument instrument) {
        this.instrument = instrument;
    }

    public void play() {
        instrument.play();
    }

}
