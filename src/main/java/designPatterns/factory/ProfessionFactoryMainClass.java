package designPatterns.factory;

public class ProfessionFactoryMainClass {
    public static void main(String[] args) {
        Profession doctor = ProfessionFactory.getProfession("doctor");
        doctor.introduce();

        Profession engg = ProfessionFactory.getProfession("engineer");
        engg.introduce();

        Profession lawyer = ProfessionFactory.getProfession("teacher");
        lawyer.introduce();

        Profession other = ProfessionFactory.getProfession("other");
        other.introduce();

        Profession error = ProfessionFactory.getProfession("");
        error.introduce();
    }
}
