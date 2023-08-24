package designPatterns.creational.singleton;

public class SingletonClass {

    private static SingletonClass singletonClass = null;

    private SingletonClass(){}

    public static synchronized SingletonClass getInstance() {
        if (singletonClass == null) {
            singletonClass = new SingletonClass();
        }
        return singletonClass;
    }
}
