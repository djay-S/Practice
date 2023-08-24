package designPatterns.creational.abstractFactory;

public interface VehicleAbstractFactory<T> {
    T createVehicle(String vehicleName);
}
