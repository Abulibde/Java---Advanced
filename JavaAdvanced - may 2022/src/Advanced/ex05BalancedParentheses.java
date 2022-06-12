package Advanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ex05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '{' || line.charAt(i) == '[' || line.charAt(i) == '(') {
                stack.push(line.charAt(i));
            }
            if (stack.size() > 0) {
                if (line.charAt(i) == '}' || line.charAt(i) == ']' || line.charAt(i) == ')') {
                    if (line.charAt(i) == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (line.charAt(i) == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else if (line.charAt(i) == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }
        }
        if (stack.size() == 0 && line.charAt(0) != '}' && line.charAt(0) != ']' && line.charAt(0) != ')') {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
