package designPatterns.creational.builder;

//Director has the responsibility to call builders and return the final object
public class Director {

    private CarBuilder carBuilder;

    public Director(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public Car getFinishedCar() {
        return this.carBuilder.getCar();
    }

    public void buildCar() {
        this.carBuilder.buildChassis();
        this.carBuilder.buildPowerTrain();
        this.carBuilder.buildSuspension();
        this.carBuilder.buildSteering();
    }
}
