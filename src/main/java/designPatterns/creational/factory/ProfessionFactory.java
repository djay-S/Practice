package designPatterns.creational.factory;

import designPatterns.creational.factory.professions.Doctor;
import designPatterns.creational.factory.professions.Engineer;
import designPatterns.creational.factory.professions.Teacher;

public class ProfessionFactory {

    static Profession getProfession(String professionName) {
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
            return getProfession();
    }

    private static Profession getProfession() {
        return new Profession() {
            @Override
            public void introduce() {
                System.out.println("This is Profession.");
            }
        };
    }

}
