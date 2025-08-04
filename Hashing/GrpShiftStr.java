//Group shifting string.
package Hashing;
import java.util.*;
public class GrpShiftStr {
    public static void main(String[] args) {
        HashMap <Integer,List<String>> hm=new HashMap<>();
        String arr[]={"acd", "dfg", "wyz", "yab", "mop", "bdfh", "a", "x", "moqs"};
        for(int i=0;i<arr.length;i++){
            int len=arr[i].length();
            hm.putIfAbsent(len, new ArrayList<>());
            hm.get(len).add(arr[i]);
        }
        for(Integer k:hm.keySet()){
            System.out.print(hm.get(k)+" ");
        }
    }
}
