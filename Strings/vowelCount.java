//count lowercase vowels in string.
package Strings;

import java.util.Scanner;

public class vowelCount {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count=0;
        System.out.println("give string");
        String str=sc.nextLine();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                count++;
            }
        }
        System.out.println("vowels count in lowercase string is:"+count);

    }
    
}
