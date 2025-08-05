//finding smallest missing elemnt in array;
package Hashing;
import java.util.*;
public class SmallPositiveEle {
    public static void main(String[] args) {
        int arr[]={2, -3, 4, 1, 1, 7};
        HashMap <Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
        }
        int i=1;
        int data;
        while(true){
            if(!hm.containsKey(i)){
                data=i;
                break;
            }
            i++;
        }
        System.out.println("smallest positive value: "+data);
    }
    
}
