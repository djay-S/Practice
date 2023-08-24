package designPatterns.creational.factory.professions;

import designPatterns.creational.factory.Profession;

public class Engineer implements Profession {

    @Override
    public void introduce() {
        System.out.println("This is Engineer");
    }
}
