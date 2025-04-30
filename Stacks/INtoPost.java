import java.util.*;

public class INtoPost {
    public static String solve(Stack<Character> S, String IN) {
        String POST = "";

        for (int i = 0; i < IN.length(); i++) {
            char ch = IN.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                POST += ch;
            }
            else if (ch == '(') {
                S.push(ch);
            }
            else if (ch == ')') {
                while (!S.isEmpty() && S.peek() != '(') {
                    POST += S.pop();
                }
                if (!S.isEmpty()&&S.peek()=='(') {
                    S.pop(); 
                }
            }

            else {
                while (!S.isEmpty() && S.peek() != '(') {
                    char top = S.peek();
                    if ((ch == '+' || ch == '-') && (top == '+' || top == '-' || top == '*' || top == '/' || top == '^')) {
                        POST += S.pop();
                    } 
                    else if ((ch == '*' || ch == '/') && (top == '*' || top == '/' || top == '^')) {
                        POST += S.pop();
                    } 
                    else if (ch == '^' && top == '^') {
                        break;
                    } 
                    else {
                        break;
                    }
                }
                S.push(ch);
            }
        }

        while (!S.isEmpty()) {
            POST += S.pop();
        }

        return POST;
    }

    public static void main(String[] args) {
        Stack<Character> S = new Stack<>();
        String IN = "A*(B+C)/D";
        String POST = solve(S, IN);
        System.out.println("Postfix: " + POST);
    }
}
