package easy;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("{}({[]})"));
//        System.out.println(isPair('(', ')'));
    }

    public static boolean isValid(String s) {
        char[] liters = s.toCharArray();
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < liters.length; i++) {
            if (isOpen(liters[i])) {
                charStack.push(liters[i]);
            } else if (!charStack.empty() && isPair(charStack.peek(), liters[i])) {
                charStack.pop();
            } else {
                return false;
            }
        }
        return charStack.empty();
    }

    public static boolean isOpen(char ch) {
        return ch == '{' ||  ch == '(' || ch == '[';
    }

    public static boolean isPair(char open, char close) {
        return (open == '{' && close == '}') ||
                (open == '(' && close == ')') ||
                (open == '[' && close == ']');
    }
}
