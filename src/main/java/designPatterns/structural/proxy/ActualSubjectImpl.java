package designPatterns.structural.proxy;

//ActualSubjectImpl is the implementation of the Subject interface that needs to be hidden behind a proxy
public class ActualSubjectImpl implements Subject{
    @Override
    public void someMethod() throws IllegalAccessException {
        System.out.println("This is the secured method");
    }
}
