package designPatterns.factory.professions;

import designPatterns.factory.Profession;

public class Doctor extends ProfessionImpl implements Profession {
    @Override
    public void introduce() {
        System.out.println("This is Doctor");
    }
}
