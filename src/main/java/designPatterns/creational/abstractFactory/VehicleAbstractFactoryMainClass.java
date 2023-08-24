package designPatterns.creational.abstractFactory;

public class VehicleAbstractFactoryMainClass {
    public static void main(String[] args) {
        VehicleAbstractFactory<Vehicle> icVehicle = VehicleAbstractFactoryProvider.getVehicleAbstractFactory(false);
        Vehicle splendor = icVehicle.createVehicle("splendor");
        System.out.println("Mileage is: " + splendor.getMileage());

        Vehicle passionxpro = icVehicle.createVehicle("passionxpro");
        System.out.println("Mileage is: " + passionxpro.getMileage());
    }
}
