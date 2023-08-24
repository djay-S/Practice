package designPatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    public static List<Car> loadCars() {
        List<Car> cars = new ArrayList<>();

        for (int i = 0 ; i < 5; i++) {
            Car car = new Car("Car" + i);

            cars.add(car);
        }

        return cars;
    }
}
