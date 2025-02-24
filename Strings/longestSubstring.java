//just an brute force approach O(n4).
package Strings;
public class longestSubstring {
    public static void main(String args[]){
        String str ="pwzkew";
        int maxsum=Integer.MIN_VALUE;
    for(int i = 0; i < str.length(); i++) {
        for(int j = i + 1; j <= str.length(); j++) {
             int count=0;
             String str1="";
             str1=str1+str.substring(i, j);
             for(int k=0;k<str1.length();k++){
                 for(int m=k+1;m<str1.length();m++){
                     if(str1.charAt(k)!=str1.charAt(m)){
                        count++; 
                     }
                 }
             }
             if(count == (str1.length() * (str1.length() - 1)) / 2)
            {
                maxsum=Math.max(maxsum,str1.length());
            }
    }
}
System.out.println(maxsum);
}
}