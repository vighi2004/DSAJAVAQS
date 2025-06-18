//finding count of subarray whose sum equal to k.
package Hashing;
import java.util.*;
public class LargestKsum{
    public static void main(String[] args) {
        HashMap <Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);//these should we have to add if sum comes first time.
        int arr[]={1,2,3};
        int ans=0;
        int k=3;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
           if(hm.containsKey(sum-k)){
              ans=ans+hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault(sum, 0)+1);
        }
        System.out.println("Subarray count is: "+ans);

    }
}
