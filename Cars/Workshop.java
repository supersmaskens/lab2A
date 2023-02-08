package Cars;
import Transport.*;

/**
 * A workshop for transportables.
 * @param <T>
 */
public class Workshop<T extends Transportable> implements Transporter<T> {
    /**
     * The name says it all.
     */
    private final Transporter_Helper<T> transporter;

    /**
     * Basic constructor for a workshop.
     * @param capacity The total amount of transportables able to be "transported" at a time
     */
    public Workshop(int capacity) {
        transporter = new Transporter_Helper<>(capacity);
    }

    /**
     * Allows the workshop to load and unload transportables.
     */
    public void loadableOn() {
        transporter.loadableOn();
    }

    /**
     * Prevents the worklshop from loading and unloading transportables.
     */
    public void loadableOff() {
        transporter.loadableOff();
    }

    /**
     * Checks if the workshop contains a given transportable.
     */
    public boolean contains(T t) {
        return transporter.contains(t);
    }

    /**
     * Checks if the workshop is empty.
     */
    public boolean isEmpty() {
        return transporter.isEmpty();
    }

    /**
     * Loads a given transportable into the workshop.
     */
    public boolean load(T t) {
        return transporter.load(t);
    }

    /**
     * unloads a given transportable from the workshop.
     */
    public boolean unload(T t) {
        return transporter.unload(t);
    }

    /**
     * Updates the position of all transportables that are currently held by the workshop.
     */
    public void updateTransports(double xPosition, double yPosition, double direction) {
        transporter.updateTransports(xPosition, yPosition, direction);
    }
}