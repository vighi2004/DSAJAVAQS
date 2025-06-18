//findinf indices that sum is equal to K.
package Hashing;
import java.util.*;
public class KSumInArr {
    public static void main(String[] args) {
        HashMap <Integer,Integer> hm=new HashMap<>();
        int arr[]={2,7,111,15};
        int k=9;
        for(int i=0;i<arr.length;i++){
           if(hm.containsKey(k-arr[i])){
                System.out.println("indices are: "+hm.get(k-arr[i])+","+i);
                break;
            }
            hm.put(arr[i],i);
        }
    }
    
}
