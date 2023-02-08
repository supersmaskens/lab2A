package Transport;

import java.util.ArrayList;
import java.util.List;

/**
 * A helper that can be used by transporters for transporting.
 * @param <T> Any transportable.
 */

public class Transporter_Helper<T extends Transportable> implements Transporter<T>{
    /**
     * List of transportables currently being transported.
     */
    private final List<T> currentTransports;

    /**
     * Amount of transportables able to be carried at once.
     */
    private final int capacity;
    /**
     * A flag representing whether a transporter is able to load new transportables.
     */
    private boolean canLoad;

    /**
     * Flags 'canLoad' as true.
     */
    public void loadableOn() {
        canLoad = true;
    }
    /**
     * Flags 'canLoad' as false.
     */
    public void loadableOff() {
        canLoad = false;
    }

    /**
     * Basic constructor, 'int' parameter decides capacity.
     */
    public Transporter_Helper(int capacity) {
        currentTransports = new ArrayList<>();
        this.capacity = capacity;
    }

    /**
     * Checks if a given transportable can be loaded.
     */
    public boolean canTransport(T t) {
        return canLoad && !t.beingTransported();
    }

    /**
     * Loads a given transportable into the transporter, returns true if it succeeds.
     */
    public boolean load(T t) {
        if(canTransport(t) && !contains(t)
                && currentTransports.size() < capacity){
            t.beTransported();
            return currentTransports.add(t);
        }
        return false;
    }

    /**
     * Unloads a given transportable from the transporter, returns true if it succeeds.
     */
    public boolean unload(T t) {
        if (canLoad) return currentTransports.remove(t);
        return false;
    }

    /**
     * Unloads the transportable that was loaded first.
     */
    public boolean unloadFirst(double xPosition, double yPositon, double direction) {
        if (currentTransports.isEmpty() || !canLoad) {
            return false;
        }
        currentTransports.get(0).unTransport();
        updateTransport(currentTransports.get(0), xPosition, yPositon, direction);
        currentTransports.remove(0);
        return true;
    }

    /**
     * Unloads the most recently loaded transportable from the transporter, returns true if it succeeds.
     */
    public boolean unloadLast(double xPosition, double yPositon, double direction) {
        if (currentTransports.isEmpty() || !canLoad) {
            return false;
        }
        currentTransports.get(currentTransports.size()-1).unTransport();
        updateTransport(currentTransports.get(currentTransports.size()-1), xPosition, yPositon, direction);
        currentTransports.remove(currentTransports.size()-1);
        return true;
    }

    /**
     * Returns true if transporter is carrying the given transportable.
     */
    public boolean contains(T t)  {
        return currentTransports.contains(t);
    }

    /**
     * Updates the position of a specific transportable.
     */
    public void updateTransport(T t, double xPosition, double yPosition, double direction) {
        if(currentTransports.contains(t)) {
            t.updatePosition(xPosition, yPosition, direction);
        }
    }

    /**
     * Returns true if transporter isn't carrying anything.
     */
    public boolean isEmpty() {
        return currentTransports.isEmpty();
    }

    /**
     * Used to set the position and direction of all transportables currently being transported.
     */
    public void updateTransports(double xPosition, double yPosition, double direction) {
        for (T t : currentTransports) {
            updateTransport(t, xPosition, yPosition, direction);
        }
    }
}

