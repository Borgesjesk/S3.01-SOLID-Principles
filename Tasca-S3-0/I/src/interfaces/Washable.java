package interfaces;

/**
 * Defines washing behavior for washable machines.
 * ISP: segregated interface — only implemented by classes that need washing.
 */
public interface Washable {

    void wash();
}
