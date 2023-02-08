package Boat;

import java.awt.*;

import Movable.*;

/**
 * Abstract class representing a boat.
 */

public abstract class Boat extends Mover{

    /**
     * Color of the boat.
     */
    private Color color;
    /**
     * Engine power of the boat.
     */
    private final double enginePower;
    /**
     * The boat model name.
     */
    private final String modelName;

    /**
     * Basic constructor for a boat.
     */
    public Boat(Color color, double enginePower, String name,
                double xPosition, double yPosition, double direction) {
        super(xPosition, yPosition, direction);
        this.color = color;
        this.enginePower = enginePower;
        modelName = name;

    }

    /**
     * Gives the boats engine power.
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Gives the name of the model.
     *
     * @return Name of the cars model.
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Gives the color of the car.
     *
     * @return The cars current color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets a new color for the car.
     *
     * @param clr The new color.
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * Sets the current speed to 0.1.
     */
    public void startEngine() {
        setCurrentSpeed(0.1);
    }

    /**
     * Sets the current speed to 0.
     */
    public void stopEngine() {
        setCurrentSpeed(0);
    }


    /**
     * SpeedFactor is used by each subclass to calculate speed when moving.
     */
    abstract double speedFactor();

    /**
     * Increases the currentSpeed value.
     * Calls incrementSpeed with a value between 0 and 1.
     *
     * @param amount Should be between 0 and 1.
     */
    public void gas(double amount) {
        incrementSpeed(amount, speedFactor(), enginePower);
    }

    /**
     * Decreases the currentSpeed value.
     * Calls decrementSpeed with a value between 0 and 1.
     *
     * @param amount Should be between 0 and 1.
     */
    public void brake(double amount) {
        decrementSpeed(amount, speedFactor(), enginePower);
    }
}