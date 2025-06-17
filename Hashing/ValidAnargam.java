package Hashing;
import java.util.*;
public class ValidAnargam {
    public static boolean check(String r,HashMap <Character,Integer>hm){
        for(int i=0;i<r.length();i++){
            char ch=r.charAt(i);
            if(hm.get(ch)!=null){
            if(hm.get(ch)==1){
                hm.remove(ch);
            }
            else {
                hm.put(ch,hm.get(ch)-1);
             }
            }
           else{
              return false;
            }
        }
       if(hm.isEmpty()){
        return true;
       }
       else{
          return false;
       }

}
    public static void main(String[] args) {
        HashMap <Character,Integer> hm=new HashMap<>();
        String s="race";
        String r="care";
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i),0)+1);
        }
        if(check(r,hm)){
             System.out.println("TRUE");
        }
        else{
              System.out.println("FALSE");
        }
    }
    
}
