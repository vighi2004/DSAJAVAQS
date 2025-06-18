//finding intersection and union element in java.
package Hashing;
import java.util.*;
public class UnionAndIntersect {
    public static void main(String[] args) {
        HashMap <Integer,Integer> hm=new HashMap<>();
        int arr1[]={7,3,9};
        int arr2[]={6,3,9,2,9,4};
        for(int i=0;i<arr1.length;i++){
                hm.put(arr1[i],hm.getOrDefault(arr1[i],0)+1);
        }
         for(int i=0;i<arr2.length;i++){
                hm.put(arr2[i],hm.getOrDefault(arr2[i],0)+1);
        }
        System.out.print("Intersetion elemenst are:");
        for(Integer k:hm.keySet()){
            if(hm.get(k)>1){
                System.out.print("  "+k);
            }
        }
        System.out.println();
        System.out.print("Union elements are:- ");
        for(Integer k:hm.keySet()){
            System.out.print("  "+k);
        }
        
    }
    
}
