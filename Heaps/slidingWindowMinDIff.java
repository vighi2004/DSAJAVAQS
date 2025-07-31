//finding minimum distance from m elemnts using sliding window min diff is max diff of m elements(last-fisrt).
package Heaps;
import java.util.*;
public class slidingWindowMinDIff {
    public static void main(String[] args) {
       int arr[]={7, 3, 2, 4, 9, 12, 56};
       Arrays.sort(arr);
       int min=Integer.MAX_VALUE;
       int m=5;
       for(int i=0;i<arr.length-m;i++){
          min=Math.min(min,arr[i+m-1]-arr[i]);
       }
       System.out.println("min diff is: "+min);        
    }
}
