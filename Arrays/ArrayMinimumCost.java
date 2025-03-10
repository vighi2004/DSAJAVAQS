//Finding minimum cos in array by time O(nlogn).
import java.util.*;
public class ArrayMinimumCost {
    public static void main(String[] args) {
        int arr[]={1,2,9,10,11};
        Arrays.sort(arr);
        int median=arr[arr.length/2];
        int cost=0;
        for(int i=0;i<arr.length;i++){
           cost=cost+Math.abs(arr[i]-median);
        }
        System.out.println(cost);
    }
}