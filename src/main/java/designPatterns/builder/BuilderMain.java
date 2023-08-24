package designPatterns.builder;

/*
Main will initialise the director. The director then builds the car and handle all the complexities
associated with building the car object. Then it would return the car object.
*/
public class BuilderMain {

    public static void main(String[] args) {
        EVCarBuilder evCarBuilder = new EVCarBuilder();
        Director director = new Director(evCarBuilder);
        director.buildCar();

        Car finishedEvCar = director.getFinishedCar();
        System.out.println(finishedEvCar);

        RaceCarBuilder raceCarBuilder = new RaceCarBuilder();
        director = new Director(raceCarBuilder);
        director.buildCar();

        Car finishedRaceCar = director.getFinishedCar();
        System.out.println(finishedRaceCar);
    }

}
