//printing first letter capital;
package Strings;
public class FirstLetter {
    public static void main(String[] args) {
        String str = "hi, i am vighnesh takke"; 
        StringBuilder sb = new StringBuilder();


        char first = Character.toUpperCase(str.charAt(0));
        sb.append(first);

     
        for (int i = 1; i < str.length(); i++) {
         

            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i)); 
                i++; 
               
                if (i < str.length()) {
                    sb.append(Character.toUpperCase(str.charAt(i)));
                }
            } else {
                sb.append(str.charAt(i)); 
            }
        }

        
        System.out.println(sb.toString());
    }
}
