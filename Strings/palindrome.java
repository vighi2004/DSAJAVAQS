//palindrome string check O(n).
package Strings;
public class palindrome {
    public static void main(String[] args) {
        String str="madam";
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)==str.charAt(str.length()-i-1)){
                System.out.println("string is palindrome");
                break;
            }
            else{
                System.out.println("string is not palindrome");
                break;
            }
        }
    }
    
}
