package designPatterns.structural.proxy;

public class ProxyMain {
    public static void main(String[] args) throws IllegalAccessException {
        ProxyImplActual proxy = new ProxyImplActual();

        proxy.someMethod();
    }
}
