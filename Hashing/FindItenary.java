//finding itenary from Tickets.
package Hashing;
import java.util.*;
public class FindItenary {
    public static void main(String[] args) {
        HashMap <String,String> hm=new HashMap<>();
        hm.put("Chennai", "Bengaluru");
        hm.put("Mumbai", "Delhi");
        hm.put("Goa", "Chennai");
        hm.put("Delhi", "Goa");
        String source="";
        //finding source 
        for(String k:hm.keySet()){
            if(!hm.containsValue(k)){
                source=k;
                break;
            }
        }
        System.out.print(source);
        while(hm.containsKey(source)){
              System.out.print("->"+hm.get(source));
              source=hm.get(source);
           }
        }   
    }
