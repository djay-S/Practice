package designPatterns.creational.builder;

public class RaceCarBuilder implements CarBuilder{

    private Car raceCar = new Car();

    @Override
    public void buildChassis() {
        this.raceCar.chassis = "Carbon Fiber Monocoque";
    }

    @Override
    public void buildPowerTrain() {
        this.raceCar.powerTrain = "V8 + MGU-K";
    }

    @Override
    public void buildSuspension() {
        this.raceCar.suspension = "Double Wishbone";
    }

    @Override
    public void buildSteering() {
        this.raceCar.steering = "Rack and Pinion";
    }

    @Override
    public Car getCar() {
        return this.raceCar;
    }
}
