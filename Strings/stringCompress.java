//string compression using stringbuilder data structure O(n);
package Strings;

public class stringCompress {
    public static void main(String[] args) {
        String str="abcddda";
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<str.length();i++){
           Integer count=1;

            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
                     
            }
            sb.append(str.charAt(i));
           
        }
        System.out.println(sb.toString());
    }
    
}
