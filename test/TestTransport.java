package test;
import Boat.*;
import Cars.*;
import Transport.*;
import org.junit.Test;

public class TestTransport {
    @Test
    public void cantMoveWhileTransported() {
        Workshop<Volvo240> ws = new Workshop<>(32);
        Volvo240 car = new Volvo240();
        ws.loadableOn();
        ws.load(car);
        car.gas(1);
        car.move();
        assert(car.getX() == 0);
    }
    @Test
    public void transportMove() {
        CarTransport<PassengerCar> bt = new CarTransport<>();
        Saab95 car = new Saab95();
        bt.lowerRamp();
        bt.load(car);
        bt.raiseRamp();
        bt.gas(1);
        bt.move();
        bt.brake(1);
        bt.lowerRamp();
        bt.unload();
        assert(car.getX() == bt.getX() - 5 * bt.getDirection());
    }
    @Test
    public void unloadableTest(){
        Workshop<PassengerCar> ws = new Workshop<>(32);
        Saab95 car = new Saab95(1,1,1);
        ws.loadableOff();
        ws.load(car);
        assert(!ws.contains(car) && ws.isEmpty());
    }
    @Test
    public void workshopTest(){
        Workshop<PassengerCar> ws = new Workshop<>(32);
        Saab95 car = new Saab95(1,1,1);
        ws.loadableOn();
        ws.load(car);
        ws.updateTransports(0,0,0);
        ws.unload(car);
        assert(car.getX() == 0 && car.getY() == 0 && car.getDirection() == 0 && ws.isEmpty());
    }
    @Test
    public void unloadlastWhenEmpty(){
        CarTransport<PassengerCar> bt = new CarTransport<>(0,0,0, 8);
        bt.lowerRamp();
        assert(!bt.unload());
    }

    @Test
    public void updateTransportsAndContains(){
        CarTransport<PassengerCar> bt = new CarTransport<>(1,1,1,8);
        Volvo240 car = new Volvo240();
        bt.lowerRamp();
        bt.load(car);
        bt.updateTransports(1,1,1);
        assert(bt.contains(car) && car.getX() == 1);
    }
    @Test
    public void someCarTransportStuff(){
        CarTransport<PassengerCar> bt = new CarTransport<>();
        Volvo240 car = new Volvo240();
        bt.gas(1);
        assert(!bt.lowerRamp() && bt.isEmpty() && !bt.unload(car));
    }
    @Test
    public void cantUnload() {
        Workshop<PassengerCar> ferry = new Workshop<>(32);
        Volvo240 car = new Volvo240();
        ferry.loadableOn();
        ferry.load(car);
        ferry.loadableOff();
        ferry.unload(car);
        assert(ferry.contains(car));
    }

}
