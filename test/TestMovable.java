package test;
import Movable.*;
import Boat.Ferry;
import Cars.*;
import org.junit.Test;


public class TestMovable {

    /**
     * Control if all movables can use move
     */
    @Test
    public void moveCar() {
        Volvo240 car = new Volvo240(0,0,0);
        car.gas(1);
        car.move();
        assert(car.getX() == car.speedFactor() && car.getY() == 0);
    }
    @Test
    public void moveBoat() {
        Ferry<PassengerCar> ferry = new Ferry<PassengerCar>(0,0,0,0);
        ferry.gas(1);
        ferry.move();
        assert((ferry.getX()) == ferry.speedFactor());
    }

    /*
    /**
     * Control if all movables can use turnLeft

    @Test
    public void turnLeftCar() {

    }
    @Test
    public void turnLeftBoat() {

    }
    /**
     * Control if all movables can use turnRight

    @Test
    public void turnRightCar() {

    }
    @Test
    public void turnRightBoat() {

    }*/


    //@Test
    ///**
    // * Control if all movables can use incrementSpeed
    // */
    //@Test
    ///**
    // * Control if all movables can use decrementSpeed
    // */

}
