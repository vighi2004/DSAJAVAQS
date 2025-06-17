//finding majority element who appear more than N/3times.
package Hashing;
import java.util.*;
public class MajorityEle {
    public static void main(String[] args) {
        HashMap <Integer,Integer> hm=new HashMap<>();
        int arr[]={1,2};
        int N=arr.length/3;
        for(int i=0;i<arr.length;i++){
            if(!hm.containsKey(arr[i])){
                hm.put(arr[i],1);
            }
            else{
                hm.put(arr[i],hm.get(arr[i])+1);
            }
            //also you can use method of getorDefault.
        }
        for(Integer key:hm.keySet()){
            if(hm.get(key)>N){
                System.out.println("Majority element is: "+key);
            }
        }
    }
    
}
