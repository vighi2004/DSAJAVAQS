//determine if two string our anargams.
package Strings;

import java.util.Arrays;

public class Anargams {
    public static void main(String[] args) {
        String str="race";
        String str1="care";
        char arr1[]=str.toCharArray();
        char arr2[]=str1.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (Arrays.equals(arr1, arr2)) {
            System.out.println("It is an Anagrams");
        } else {
            System.out.println("Not Anagrams");
        }        
        }
    }
    

