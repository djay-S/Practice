package designPatterns.creational.prototype;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class CarGarage implements Cloneable{

    public String garageName;

    public List<Car> carsInGarage;

    public CarGarage(String garageName) {
        this.garageName = garageName;
    }

    public void startGarage() throws InterruptedException {
//        to simulate data loading
        Thread.sleep(2000);
        this.carsInGarage = CarList.loadCars();
    }

    @Override
    public CarGarage clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
//            return (CarGarage) super.clone();
//            to allow deep copy
            CarGarage clonedGarage = (CarGarage) super.clone();
            clonedGarage.carsInGarage = new ArrayList<>(this.carsInGarage);
            return clonedGarage;

        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
