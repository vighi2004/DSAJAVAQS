// Longest Valid Parenthesis Substring
import java.util.Stack;
public class ValidParentCount {
    public static int getL(String str) {
        Stack<Integer> S = new Stack<>();
        S.push(-1); 
        int maxLength = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                S.push(i);
            } else {
                S.pop(); 
                if (!S.isEmpty()) {
                    maxLength = Math.max(maxLength, i - S.peek());
                } else {
                    S.push(i); 
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String str = "(((()(()";
        System.out.println(getL(str)); 
    }
}
