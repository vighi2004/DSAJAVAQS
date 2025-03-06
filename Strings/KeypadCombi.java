//keypad combining using backtrack.
package Strings;

public class KeypadCombi {
    public static void keypad(String ans,String digits, int index, String[] mapping) {
        if (index==digits.length()) {
            System.out.println(ans);
            return;
        }
        char ch=digits.charAt(index);
        int num = Character.getNumericValue(ch);
        String letters = mapping[num];
        for (int i = 0; i < letters.length(); i++) {
            keypad(ans + letters.charAt(i),digits, index+1, mapping);
        }
    }
    
    public static void main(String[] args) {
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String digits = "234";
        
        keypad("", digits, 0,mapping);
    }
}