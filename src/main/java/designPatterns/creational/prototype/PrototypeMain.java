package designPatterns.creational.prototype;

//refer: https://www.youtube.com/watch?v=nZ76x13Nm8Q
public class PrototypeMain {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting Garage1");
        CarGarage garage1 = new CarGarage("garage1");
        garage1.startGarage();
        System.out.println(garage1);

//        This takes the same time to load the same data
        System.out.println("Starting Garage2");
        CarGarage garage2 = new CarGarage("garage1");
        garage2.startGarage();
        System.out.println(garage2);

//        Using prototype of the first class
        CarGarage garageClone = garage1.clone();
        garage1.carsInGarage.remove(3);
        garageClone.garageName = "garageClone";
        System.out.println(garage1);
        System.out.println(garageClone);

    }
}
