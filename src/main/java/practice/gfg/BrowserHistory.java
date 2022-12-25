package practice.gfg;

import java.util.Stack;

//https://www.geeksforgeeks.org/design-custom-browser-history-based-on-given-operations/
public class BrowserHistory {
    public static void main(String[] args) {
        test2();
        test1();
    }

    private static void test2() {
        Browser browser = new Browser("geeksforgeeks.org");

        browser.visit("amazon.com");
        browser.back(2);
        System.out.printf("Landed on page: %s.\n", browser.getCurrentPage());
    }

    private static void test1() {
        Browser browser = new Browser("gfg.org");

        browser.visit("google.com");
        browser.visit("facebook.com");
        browser.visit("youtube.com");
        browser.back(1);
        browser.back(1);
        browser.forward(1);
        browser.visit("lindekin.com");
        browser.forward(2);
        browser.back(2);
        browser.back(7);
        System.out.printf("Landed on page: %s.\n", browser.getCurrentPage());

    }
}
class Browser {
    private String homePage = "";
    private String currentPage = "";
    private Stack<String> backStack = null;
    private Stack<String> forwardStack = null;

    public Browser(String homePage) {
        this.homePage = homePage;
        currentPage = homePage;
        backStack = new Stack<>();
        forwardStack = new Stack<>();
    }

    public void visit(String page) {
        backStack.push(currentPage);
        forwardStack = new Stack<>();
        currentPage = page;
        System.out.println(currentPage);
    }

    public void back(int stepCount) {
        if (stepCount > backStack.size()) {
            currentPage = homePage;
            backStack = new Stack<>();
            System.out.println(currentPage);
            return;
        }
        int count = 0;
        while (count < stepCount) {
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
            count++;
        }
        System.out.println(currentPage);
    }

    public void forward(int stepCount) {
        if (stepCount > forwardStack.size()) {
            currentPage = homePage;
            forwardStack = new Stack<>();
            System.out.println(currentPage);
            return;
        }
        int count = 0;
        while (count < stepCount) {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
            count++;
        }
        System.out.println(currentPage);
    }

    public String getCurrentPage() {
        return currentPage;
    }
}