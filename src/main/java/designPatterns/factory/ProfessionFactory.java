package designPatterns.factory;

import designPatterns.factory.professions.Doctor;
import designPatterns.factory.professions.Engineer;
import designPatterns.factory.professions.ProfessionImpl;
import designPatterns.factory.professions.Teacher;

public class ProfessionFactory {

    static ProfessionImpl getProfession(String professionName) {
        if (professionName == null || professionName.isBlank()) {
            throw new RuntimeException("Profession name not provided");
        }
        if (professionName.equalsIgnoreCase("doctor"))
            return new Doctor();
        if (professionName.equalsIgnoreCase("engineer"))
            return new Engineer();
        if (professionName.equalsIgnoreCase("teacher"))
            return new Teacher();
        else
            return new ProfessionImpl();
    }

}
