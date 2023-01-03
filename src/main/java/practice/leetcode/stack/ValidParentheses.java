package practice.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        test("()", true);
        test("[]", true);
        test("{}", true);
        test("{)", false);
        test(")(", false);
        test("(){}[]", true);
        test("([{}])", true);
        test("([{}]", false);
        test("()()([)]", false);
        test("()()([]{})", true);
    }

    private static void test(String s, boolean expected) {
        boolean myAnswer = isValid(s);
        String finalAnswer = myAnswer == expected ? "✅" : "❌";
        System.out.printf("String: %s, Result: %s, Expected: %s, Final: %s.\n", s, myAnswer, expected, finalAnswer);
    }

    public static boolean isValid(String s) {
        if (s.length() %2 != 0) {
            return false;
        }

        Map<Character, Character> parenthesesPair = new HashMap<>();
        parenthesesPair.put(')', '(');
        parenthesesPair.put('}', '{');
        parenthesesPair.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.add(ch);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character stackPeek = stack.peek();
                if (stackPeek.equals(parenthesesPair.get(ch))) {
                    stack.pop();
                }
                else {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }
}
