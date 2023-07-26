package designPatterns.abstractFactory.ev;

import designPatterns.abstractFactory.Vehicle;

public class SplendorEV implements Vehicle {

    @Override
    public void print() {
        System.out.println("This is EV Splendor");
    }

    @Override
    public String getMileage() {
        return "38 km/Wh";
    }
}
