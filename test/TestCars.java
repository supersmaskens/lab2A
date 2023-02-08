package test;
import Cars.*;
import org.junit.Test;
import Transport.*;

import java.awt.*;

import Boat.*;


public class TestCars {

    @Test
    public void V240WS() {
        Volvo240 car = new Volvo240();
        Saab95 car2 = new Saab95();
        Workshop<Volvo240> ws = new Workshop<>(10);
        ws.loadableOn();
        ws.load(car);
        //ws.load(car2); // Gives static error.
        assert(ws.contains(car));
    }

    @Test
    public void carModelName() {
        Volvo240 car = new Volvo240();
        assert (car.getModelName().equals("Cars.Volvo240"));
    }

    @Test
    public void carColor() {
        Volvo240 car = new Volvo240();
        car.setColor(Color.red);
        assert (car.getColor() == Color.red);
    }
    @Test
    public void engineStart() {
        Volvo240 car = new Volvo240();
        car.startEngine();
        assert (car.getCurrentSpeed() == 0.1);
    }

    @Test
    public void engineStop() {
        Volvo240 car = new Volvo240();
        car.startEngine();
        car.stopEngine();
        assert (car.getCurrentSpeed() == 0);
    }

    @Test
    public void defaultVolvoTest() {
        Volvo240 car = new Volvo240();
        assert (car.getNrDoors() == 4 && car.getEnginePower() == 100 && car.getX() == 0 && car.getY() == 0);
    }

    @Test
    public void volvoTurnLeftTest() {
        Volvo240 car = new Volvo240();
        car.turnLeft();
        assert (car.getDirection() == Math.PI / 180);
    }

    @Test
    public void volvoTurnLeftCircleTest() {
        Volvo240 car = new Volvo240(0, 0, (Math.PI * 2) - (Math.PI / 180));
        car.turnLeft();
        assert (car.getDirection() == 0);
    }

    @Test
    public void volvoTurnRightTest() {
        Volvo240 car = new Volvo240();
        car.turnRight();
        assert (car.getDirection() == -Math.PI / 180);
    }

    @Test
    public void volvoTurnRightCircleTest() {
        Volvo240 car = new Volvo240(0, 0, -(Math.PI * 2) + (Math.PI / 180));
        car.turnRight();
        assert (car.getDirection() == 0);
    }

    @Test
    public void volvoGasTest() {
        Volvo240 car = new Volvo240();
        car.gas(1);
        assert (car.getCurrentSpeed() == car.speedFactor());
    }

    @Test
    public void volvoBrakeTest() {
        Volvo240 car = new Volvo240();
        car.gas(1);
        car.brake(1);
        assert (car.getCurrentSpeed() == 0);
    }

    @Test
    public void volvoMoveTest() {
        Volvo240 car = new Volvo240();
        car.gas(1);
        car.move();
        assert (car.getX() == car.speedFactor() && car.getY() == 0);
    }

    @Test
    public void saabTurboMoveTest() {
        Saab95 car = new Saab95();
        car.setTurboOn();
        car.gas(1);
        car.move();
        assert (car.getX() == car.speedFactor());
    }

    @Test
    public void saabTurnOffTurboTest() {
        Saab95 car = new Saab95();
        car.setTurboOn();
        car.setTurboOff();
        assert (!car.isTurboOn());
    }
    @Test
    public void scaniaModelName() {
        Scania scania = new Scania();
        assert (scania.getModelName().equals("Cars.Scania"));
    }

    @Test
    public void scaniaColor() {
        Scania scania = new Scania();
        scania.setColor(Color.black);
        assert (scania.getColor() == Color.black);
    }

    @Test
    public void scaniaEngineStart() {
        Scania scania = new Scania();
        scania.startEngine();
        assert (scania.getCurrentSpeed() == 0.1);
    }

    @Test
    public void scaniaEngineStop() {
        Scania scania = new Scania();
        scania.startEngine();
        scania.stopEngine();
        assert (scania.getCurrentSpeed() == 0);
    }

    @Test
    public void defaultScaniaTest() {
        Scania scania = new Scania();
        assert (scania.getNrDoors() == 2 && scania.getEnginePower() == 400 && scania.getX() == 0 && scania.getY() == 0);
    }

    @Test
    public void scaniaTurnLeftTest() {
        Scania scania = new Scania();
        scania.turnLeft();
        assert (scania.getDirection() == Math.PI / 180);
    }

    @Test
    public void scaniaTurnLeftCircleTest() {
        Scania scania = new Scania(0,0,(Math.PI * 2) - (Math.PI / 180));
        scania.turnLeft();
        assert (scania.getDirection() == 0);
    }

    @Test
    public void scaniaTurnRightTest() {
        Scania scania = new Scania();
        scania.turnRight();
        assert (scania.getDirection() == -Math.PI / 180);
    }

    @Test
    public void scaniaTurnRightCircleTest() {
        Scania scania = new Scania(0, 0, -(Math.PI * 2) + (Math.PI / 180));
        scania.turnRight();
        assert (scania.getDirection() == 0);
    }

    @Test
    public void scaniaGasTest() {
        Scania scania = new Scania();
        scania.gas(1);
        assert (scania.getCurrentSpeed() == scania.speedFactor());
    }

    @Test
    public void scaniaBrakeTest() {
        Scania scania = new Scania();
        scania.gas(1);
        scania.brake(1);
        assert (scania.getCurrentSpeed() == 0);
    }

    @Test
    public void scaniaMoveTest() {
        Scania scania = new Scania();
        scania.gas(1);
        scania.move();
        assert (scania.getX() == scania.speedFactor() && scania.getY() == 0);
    }
    @Test
    public void scaniaMoveFlatbedNetural() {
        Scania scania = new Scania();
        scania.increaseTiltFlatbed();
        scania.move();
        assert (scania.getX() == 0 && scania.getY() == 0);
    }
    @Test
    public void scaniaRaiseFlatbedWhileMoving() {
        Scania scania = new Scania();
        scania.startEngine();
        scania.increaseTiltFlatbed();
        assert(scania.getFlatbedPosition()==0);
    }
    @Test
    public void scaniaDecreaseFlatbed(){
        Scania sc = new Scania();
        sc.increaseTiltFlatbed();
        sc.decreaseTiltFlatbed();
        Scania sc2 = new Scania();
        sc2.increaseTiltFlatbed();
        assert(sc.getFlatbedPosition() == 0 && sc2.getFlatbedPosition() == 1);
    }
    @Test
    public void scaniaFailedDecreaseFlatbed(){
        Scania sc = new Scania();
        assert(!sc.decreaseTiltFlatbed());
    }

}
