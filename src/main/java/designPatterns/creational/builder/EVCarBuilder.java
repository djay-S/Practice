package designPatterns.creational.builder;

public class EVCarBuilder implements CarBuilder{

    private Car evCar = new Car();

    @Override
    public void buildChassis() {
        this.evCar.chassis = "Ladder Frame";
    }

    @Override
    public void buildPowerTrain() {
        this.evCar.powerTrain = "DC Motor";
    }

    @Override
    public void buildSuspension() {
        this.evCar.suspension = "Rigid";
    }

    @Override
    public void buildSteering() {
        this.evCar.steering = "Rack and Pinion";
    }

    @Override
    public Car getCar() {
        return this.evCar;
    }
}
