package interfaces;

/**
 * Contract for characters that can take physical damage.
 * Ghosts don't take damage, so this stays separate — LSP.
 */
public interface Damageable {
    void takeDamage(int points);
}
