//rearrange characters in a String such that no two adjacent characters are same
package Greedy_Algo;
import java.util.*;
public class RearrangeChar {
    public static void check(String str,boolean done[],String res){
        res+=str.charAt(0);
        done[0]=true;
        while(true){
           boolean flag=false;
          for(int i=1;i<str.length();i++){
            if(res.charAt(res.length()-1)==str.charAt(i)&&done[i]==false){
                done[i]=true;
                res+=str.charAt(i);
                flag=true;
                break;
            }
          }
          if(res.length()==str.length()){
            System.out.println(res);
            return;
          }
          if(flag==false){
             System.out.println("empty string");
             return;
          }

        }
    }
    public static void main(String[] args) {
        String str="aaabc";
        boolean done[]=new boolean[str.length()];
        String res="";
        check(str,done,res);
    }
    
}
