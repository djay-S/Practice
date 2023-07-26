package designPatterns.factory.professions;

import designPatterns.factory.Profession;

public class Teacher extends ProfessionImpl implements Profession {

    @Override
    public void introduce() {
        System.out.println("This is Teacher");
    }
}
