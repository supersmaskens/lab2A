package Transport;

/**
 * Interface for transporters.
 * @param <T> Any transportable.
 */

public interface Transporter<T extends Transportable> {
    /**
     * Returns true if transporter is carrying the given transportable.
     */
    boolean contains(T t);

    /**
     * Loads a given transportable into the transporter, returns true if it succeeds.
     */
    boolean load(T t);
    /**
     * Unloads a given transportable from the transporter, returns true if it succeeds.
     */
    boolean unload(T t);

    /**
     * Returns true if transporter isn't carrying anything.
     */
    boolean isEmpty();

    /**
     * Used to set the position and direction of all transportables currently being transported.
     */
    void updateTransports(double xPosition, double yPosition, double direction);

}
