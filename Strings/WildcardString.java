// Wildcard string mactching with strings function O(n^2).
package Strings;

public class WildcardString {
    public static boolean check(int i,int j,String wild,String pattern) {
        if(i<0&&j<0){
            return true;
        }
        if(i>=0&&j<0){
            for(int k=0;k<=i;k++){
                if(wild.charAt(k)!='*'){
                    return false;
                }
            }
            return true;
            
        }
        if(j>=0&&i<0){
            return false;
        }
        if(wild.charAt(i)=='?'||pattern.charAt(j)==wild.charAt(i)){
            return check(i-1,j-1,wild,pattern);
        }
        if(wild.charAt(i)=='*'){
            return check(i-1, j, wild, pattern) || check(i, j-1, wild, pattern);
        }
        return false;
    }
    public static void main(String[] args) {
    String wild="ge?ks*";
    String pattern="geeksforgeeks";
    System.out.println(check(wild.length()-1,pattern.length()-1,wild,pattern));   
    }
}