//finding largest subarray lenght whose sum is 0
package Hashing;
import java.util.*;
public class LargestSubarr0 {
    public static void main(String[] args) {
        HashMap <Integer,Integer> hm=new HashMap<>();
        int arr[]={15,-2,2,-8,1,7,10,23};
        int sum=0;
        int len=0;

        for(int j=0;j<arr.length;j++){
            sum=sum+arr[j];
            if(hm.containsKey(sum)){
                len=Math.max(len, j-hm.get(sum));
            }
            else{
                hm.put(sum,j);
            }
        }
        System.out.println("Largest Subarray length is: "+len);
    }
    
}
