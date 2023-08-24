package designPatterns.creational.abstractFactory.ic;

import designPatterns.creational.abstractFactory.Vehicle;

public class PassionXproIC implements Vehicle {

    @Override
    public void print() {
        System.out.println("This is IC Passion Xpro");
    }

    @Override
    public String getMileage() {
        return "34 km/l";
    }
}
