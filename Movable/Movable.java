package Movable;

/**
 * Interface for movable objects.
 * NOTE: Does not include any required attributes (X position, direction, etc).
 */
public interface Movable {
    /**
     * Should change the objects coordinates.
     */
    void move();

    /**
     * Should shift the objects direction to the left.
     */
    void turnLeft();
    /**
     * Should shift the objects direction to the left.
     */
    void turnRight();

    /**
     * Should update the objects position.
     */
    void updatePosition(double xPosition, double yPosition, double direction);
}
