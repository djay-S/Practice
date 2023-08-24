package designPatterns.structural.proxy;

//ProxyClass hides the object by extending it and clients communicate to real object via the proxy
public class ProxyImplActual extends ActualSubjectImpl {
    @Override
    public void someMethod() throws IllegalAccessException {
        System.out.println("This is the Proxy. This will first authenticate the session");

        int num = (int)(Math.random() * 10);
        boolean isAuthorized = num % 4 != 0;

        if (isAuthorized) {
            System.out.println("Authorized");
            super.someMethod();
        }
        else {
            throw new IllegalAccessException("You Are Not Authorized!!!");
        }
    }
}
