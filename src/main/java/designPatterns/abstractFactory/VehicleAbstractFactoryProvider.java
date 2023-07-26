package designPatterns.abstractFactory;

public class VehicleAbstractFactoryProvider {
    public static VehicleAbstractFactory<Vehicle> getVehicleAbstractFactory(boolean isVehicleEV) {
        if (isVehicleEV) {
            return new EVVehicleAbstractFactory();
        }
        return new ICVehicleAbstractFactory();
    }
}
