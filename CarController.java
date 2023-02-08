import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.lang.System.*;
import Cars.Car;
import Cars.Saab95;
import Cars.Scania;
import Cars.Volvo240;

import static java.lang.System.out;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of actors, modify if needed
    ArrayList<Actor> actors = new ArrayList<>();

    //methods:


    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.actors.add(new Actor(new Volvo240()));
        cc.actors.add(new Actor(new Saab95(0,100,0)));
        cc.actors.add(new Actor(new Scania(0, 200, 0)));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        cc.frame.drawPanel.actors = cc.actors;
        cc.frame.drawPanel.setImages();

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the actors in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Actor actor : actors) {
                invertDirection(actor.car);
                actor.car.move();
                int x = (int) Math.round(actor.car.getX());
                int y = (int) Math.round(actor.car.getY());
                frame.drawPanel.moveit(actor, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    void invertDirection(Car car){
        //out.println(car.getX());
        //out.println(car.getDirection());
        if(car.getX() >= 684 || car.getX() < 0) {
            out.println(car.getDirection());
            car.setDirection((car.getDirection() + Math.PI) % (2 * Math.PI));
        }
    }
    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Actor actor : actors) {
            actor.car.gas(gas);
            //out.println(car.getCurrentSpeed());
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Actor actor : actors) {
            //out.println("hey");
            actor.car.brake(brake);
            //out.println(car.getCurrentSpeed());
        }
    }

    void turboOn() {
        for (Actor actor : actors) {
            if(actor.car instanceof Saab95){
                ((Saab95) actor.car).setTurboOn();
            }
        }
    }
    void turboOff() {
        for (Actor actor : actors) {
            if(actor.car instanceof Saab95){
                ((Saab95) actor.car).setTurboOff();
            }
        }
    }
    void liftUp() {
        for (Actor actor : actors) {
            if(actor.car instanceof Scania){
                ((Scania) actor.car).increaseTiltFlatbed();
            }
        }
    }
    void liftDown() {
        for (Actor actor : actors) {
            if(actor.car instanceof Scania){
                ((Scania) actor.car).decreaseTiltFlatbed();
            }
        }
    }
    void startAll(){
        for(Actor actor: actors){
            actor.car.startEngine();
        }
    }
    void stopAll(){
        for(Actor actor: actors){
            actor.car.stopEngine();
        }
    }
}
