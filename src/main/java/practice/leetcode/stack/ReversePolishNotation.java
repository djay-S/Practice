package practice.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
public class ReversePolishNotation {
    public static void main(String[] args) {
        test(new String[]{"2","1","+","3","*"}, 9);
        test(new String[]{"4","13","5","/","+"}, 6);
        test(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}, 22);
        test(new String[]{"18"}, 18);
    }

    private static void test(String[] tokens, int expected) {
        int myAnswer = evalRPN(tokens);
        String finalAnswer = myAnswer == expected ? "✅" : "❌";
        System.out.printf("Tokens: %s, Result: %d, Expected: %d, Final: %s.\n", Arrays.asList(tokens), myAnswer, expected, finalAnswer);
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }
            else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
            else if (token.equals("-")) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                stack.push(b - a);
            }
            else if (token.equals("/")) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                stack.push(b / a);
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static int evalRPNSlow(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int res = Integer.parseInt(tokens[0]);
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                res = compute(Integer.parseInt(stack.pop()), Integer.parseInt(stack.pop()), token);
                stack.add(String.valueOf(res));
            } else {
                stack.add(token);
            }
        }
        return res;
    }

    private static int compute(int b, int a, String operator) {
        if (operator.equals("+")) {
            return a + b;
        }
        if (operator.equals("-")) {
            return a - b;
        }
        if (operator.equals("*")) {
            return a * b;
        }
        else {
            return a / b;
        }
    }
}
