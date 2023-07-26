package designPatterns.factory.professions;

import designPatterns.factory.Profession;

public class ProfessionImpl implements Profession {

    @Override
    public void introduce() {
        System.out.println("This if ProfessionObj");
    }
}
