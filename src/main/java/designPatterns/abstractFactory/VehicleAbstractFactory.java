package designPatterns.abstractFactory;

public interface VehicleAbstractFactory<T> {
    T createVehicle(String vehicleName);
}
