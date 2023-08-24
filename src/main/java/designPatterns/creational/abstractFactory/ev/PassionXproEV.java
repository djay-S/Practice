package designPatterns.creational.abstractFactory.ev;

import designPatterns.creational.abstractFactory.Vehicle;

public class PassionXproEV implements Vehicle {

    @Override
    public void print() {
        System.out.println("This is EV Passion Xpro");
    }

    @Override
    public String getMileage() {
        return "30 km/Wh";
    }
}
