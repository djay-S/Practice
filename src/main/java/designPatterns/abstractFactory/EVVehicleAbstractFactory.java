package designPatterns.abstractFactory;

import designPatterns.abstractFactory.ev.*;

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
