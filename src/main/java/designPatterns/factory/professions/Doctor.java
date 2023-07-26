package designPatterns.factory.professions;

import designPatterns.factory.Profession;

public class Doctor implements Profession {
    @Override
    public void introduce() {
        System.out.println("This is Doctor");
    }
}
