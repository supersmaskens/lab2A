package Transport;

/**
 * Interface for objects that can be transported.
 */
public interface Transportable {
    /**
     * Gives true if the object is currently being transported and false if it isn't.
     * @return Returns a boolean representing an objects transport status.
     */
    boolean beingTransported();

    /**
     * Is supposed to flag an object as being transported.
     * @return Always returns true.
     */
    boolean beTransported();

    /**
     * Is supposed to un-flag an object as being transported.
     * @return Always returns false.
     */
    boolean unTransport();

    /**
     * Allows a transporter to update a transportables position to match its own.
     */
    void updatePosition(double xPosition, double yPosition, double direction);
}
