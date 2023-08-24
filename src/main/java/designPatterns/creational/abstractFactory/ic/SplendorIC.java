package designPatterns.creational.abstractFactory.ic;

import designPatterns.creational.abstractFactory.Vehicle;

public class SplendorIC implements Vehicle {

    @Override
    public void print() {
        System.out.println("This is IC Splendor");
    }

    @Override
    public String getMileage() {
        return "40 km/l";
    }
}
