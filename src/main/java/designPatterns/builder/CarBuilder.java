package designPatterns.builder;

//Builder has all the definitions
public interface CarBuilder {
    void buildChassis();

    void buildPowerTrain();

    void buildSuspension();

    void buildSteering();

    Car getCar();
}
