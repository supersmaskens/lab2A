package Cars;

import Transport.*;

import java.awt.*;

/**
 * An abstract class meant to be used by passenger cars, allows them to be transported.
 */

public abstract class PassengerCar extends Car implements Transportable{
    /**
     * Represents whether the car is being transported.
     */
    private boolean isTransported;

    /**
     * Basic constructor for a passenger car.
     */
    public PassengerCar(int nrDoors, Color color, double enginePower, String name, double xPosition, double yPosition, double direction) {
        super(nrDoors, color, enginePower, name, xPosition, yPosition, direction);
        isTransported = false;
    }

    /**
     * Checks if the car is currently being transported.
     */
    public boolean beingTransported(){
        return isTransported;
    }

    /**
     * Sets the car as being transported so that it can't be picked up by anything else.
     */
    public boolean beTransported(){
        isTransported = true;
        return true;
    }

    /**
     * Sets the car as not being transported allowing it to be transported.
     */
    public boolean unTransport(){
        isTransported = false;
        return false;
    }
    /**
     * Changes the current X and Y coordinates based on objects currentSpeed value and direction.
     */
    public void move() {
        if(!isTransported) {
            super.move();
        }
    }

    /**
     * Changes direction by one degree (PI / 180) to the left.
     */
    public void turnLeft(){
        if(!isTransported) {
            setDirection((getDirection() + (Math.PI / 180)) % (Math.PI * 2));
        }
    }
    /**
     * Changes direction by one degree (PI / 180) to the right.
     */
    public void turnRight(){
        if(!isTransported) {
            setDirection((getDirection() - (Math.PI / 180)) % (Math.PI * 2));
        }
    }

}
