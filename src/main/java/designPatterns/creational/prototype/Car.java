package designPatterns.creational.prototype;

import lombok.ToString;

@ToString
public class Car implements Cloneable{

    public String modelName;

    public Car(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
