//determine if two string our anargams.
package Strings;

public class Anargams {
    public static void main(String[] args) {
        String str="race";
        String str1="care";
        int count=0;
        for(int i=0;i<str.length();i++){
            for(int j=0;j<str1.length();j++){
                if(str.charAt(i)==str1.charAt(j)){
                    count++;
                }
            }
           
            }
            if(count==str.length()){
                System.out.println("Two strings are Anargams");
            }
            else{
                System.out.println("Not Anargams");
            }
        }
    }
    

