package designPatterns.factory.professions;

import designPatterns.factory.Profession;

public class Engineer extends ProfessionImpl implements Profession {

    @Override
    public void introduce() {
        System.out.println("This is Engineer");
    }
}
