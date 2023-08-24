package designPatterns.creational.abstractFactory;

import designPatterns.creational.abstractFactory.ev.*;

public class EVVehicleAbstractFactory implements VehicleAbstractFactory<Vehicle> {
    @Override
    public Vehicle createVehicle(String vehicleName) {
        if ("Splendor".equalsIgnoreCase(vehicleName))
            return new SplendorEV();
        if ("PassionXpro".equalsIgnoreCase(vehicleName))
            return new PassionXproEV();
        return null;
    }
}
