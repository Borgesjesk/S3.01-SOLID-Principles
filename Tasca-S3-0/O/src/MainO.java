import interfaces.Instrument;
import player.InstrumentPlayer;
import services.Drums;
import services.Guitar;
import services.Piano;

/**
 * Entry point for the Open/Closed Principle exercise.
 * Demonstrates adding new instruments without modifying InstrumentPlayer.
 */
public class MainO {

    public static void main(String[] args) {

        Instrument guitarService = new Guitar();
        Instrument pianoService = new Piano();
        Instrument drumsService = new Drums();

        // Injection
        InstrumentPlayer playGuitarService = new InstrumentPlayer(guitarService);
        InstrumentPlayer playPianoService = new InstrumentPlayer(pianoService);
        InstrumentPlayer playDrumsService = new InstrumentPlayer(drumsService);

        playGuitarService.play();
        playPianoService.play();
        playDrumsService.play();
    }
}

