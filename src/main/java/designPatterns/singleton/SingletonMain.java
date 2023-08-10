package designPatterns.singleton;

public class SingletonMain {
    public static void main(String[] args) {
        SingletonClass instance1 = SingletonClass.getInstance();

        System.out.println("Singleton Instance 1" + instance1);

        SingletonClass instance2 = SingletonClass.getInstance();

        System.out.println("Singleton Instance 2" + instance2);

        NormalClass normalClass1 = new NormalClass();

        System.out.println("Normal Class1 : " + normalClass1);

        NormalClass normalClass2 = new NormalClass();

        System.out.println("Normal Class2 : " + normalClass2);
    }
}
