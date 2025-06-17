package Hashing;
import java.util.*;
public class ValidAnargam {
    public static boolean check(String r,HashMap <Character,Integer>hm){
        for(int i=0;i<r.length();i++){
            if(!hm.containsKey(r.charAt(i))){
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        HashMap <Character,Integer> hm=new HashMap<>();
        String s="race";
        String r="care";
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i), 1);
        }
        if(check(r,hm)){
             System.out.println("TRUE");
        }
        else{
              System.out.println("FALSE");
        }
    }
    
}
