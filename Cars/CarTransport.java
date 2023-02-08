package Cars;

import Transport.*;


import java.awt.*;

/**
 * A car transport meant to transport cars.
 * @param <T> Intended for cars but could be any transportable.
 */
public class CarTransport<T extends Transportable> extends Car implements Transporter<T> {
    /**
     * A helper that helps with transporting.
     */
    private final Transporter_Helper<T> transporter;
    /**
     * Represents the transports ramp position.
     */
    private boolean rampDown;

    /**
     * Basic car transport constructor.
     */
    public CarTransport(int nrDoors, Color color, double enginePower, String name,
                        double xPosition, double yPosition, double direction, int capacity) {
        super(nrDoors, color, enginePower, name, xPosition, yPosition, direction);
        transporter = new Transporter_Helper<T>(capacity);
        rampDown = false;
        transporter.loadableOff();
    }

    /**
     * Car transport constructor with default values except for position, direction and capacity.
     */
    public CarTransport(double xPosition, double yPosition, double direction,
                        int capacity) {
        this(2, Color.red, 125, "Biltransport",
                xPosition, yPosition, direction, capacity);
    }

    /**
     * Car transport constructor with default values.
     */
    public CarTransport() {
        this(2, Color.red, 100, "Biltransport"
        , 0, 0, 0, 32);
    }

    /**
     * Loads a given transportable into the transporter, returns true if it succeeds.
     */
    public boolean load(T t) {
        return transporter.load(t);
    }

    /**
     * Unloads the most recently loaded transportable from the transporter, returns true if it succeeds.
     */
    public boolean unload() {
        if (!rampDown) return false;
        double newX = getX() - 5 * getDirection();
        double newY = getY() - 5 * getDirection();
        return transporter.unloadLast(newX, newY, getDirection());
    }

    /**
     * Calls unload().
     */
    public boolean unload(T t) {
        return unload();
    }

    /**
     * Raises the CarTransports ramp, preventing it from loading cars.
     */
    public void raiseRamp() {
        rampDown = false;
        transporter.loadableOff();
    }

    /**
     * Lowers the CarTransports ramp if it is standing still, allowing it to load cars.
     * @return Returns true if it succeeds.
     */
    public boolean lowerRamp() {
        if(getCurrentSpeed() == 0) {
            rampDown = true;
            transporter.loadableOn();
            return true;
        }
        return false;
    }

    /**
     * Returns true if transporter is carrying the given transportable.
     */
    public boolean contains(T t) {
        return transporter.contains(t);
    }

    /**
     * Returns true if transporter isn't carrying anything.
     */
    public boolean isEmpty() {
        return transporter.isEmpty();
    }

    /**
     * Same functionality as parent method but requires that the ramp is down.
     * @param amount Should be between 0 and 1.
     */
    public void gas(double amount) {
        if(!rampDown) {
            incrementSpeed(amount, speedFactor(), getEnginePower());
        }
    }

    /**
     * Used to set the position and direction of all transportables currently being transported.
     */
    public void updateTransports(double xPosition, double yPositon, double direction) {
        transporter.updateTransports(xPosition, yPositon, direction);
    }

    /**
     * Used to calculate movement speed.
     */
    public double speedFactor() {
        return getEnginePower() * 0.01 * 1.25;
    }
}
