//printin longest prefix.
package Strings;

public class longestprefix {
    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        for (int j = 0; j < strs[0].length(); j++) {
            char c = strs[0].charAt(j);
           
            for (int i = 1; i < strs.length; i++) {
            
                if (j >= strs[i].length() || strs[i].charAt(j) != c) {
                     System.out.println(strs[0].substring(0, j));
                     return;
                }
            
            }
        }
    }}
