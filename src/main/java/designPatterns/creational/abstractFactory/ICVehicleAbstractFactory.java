package designPatterns.creational.abstractFactory;

import designPatterns.creational.abstractFactory.ic.*;

public class ICVehicleAbstractFactory implements VehicleAbstractFactory<Vehicle> {
    @Override
    public Vehicle createVehicle(String vehicleName) {
        if ("Splendor".equalsIgnoreCase(vehicleName))
            return new SplendorIC();
        if ("PassionXpro".equalsIgnoreCase(vehicleName))
            return new PassionXproIC();
        return null;
    }
}
