package designPatterns.factory;

import designPatterns.factory.professions.ProfessionImpl;

public class ProfessionFactoryMainClass {
    public static void main(String[] args) {
        ProfessionImpl doctor = ProfessionFactory.getProfession("doctor");
        doctor.introduce();

        ProfessionImpl engg = ProfessionFactory.getProfession("engineer");
        engg.introduce();

        ProfessionImpl lawyer = ProfessionFactory.getProfession("teacher");
        lawyer.introduce();

        ProfessionImpl other = ProfessionFactory.getProfession("other");
        other.introduce();

        ProfessionImpl error = ProfessionFactory.getProfession("");
        error.introduce();
    }
}
