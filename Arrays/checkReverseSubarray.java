//checking reversing subarray makes array sorting or not.Time taken O(nlogn)
import java.util.*;
public class checkReverseSubarray {
    public static void main(String[] args) {
        int arr[]={1,2,5,4,3};
        int sort[]={1,2,5,4,3};       
        Arrays.sort(sort);
        int left=0;
        int right=arr.length-1;
        while(left<arr.length&&arr[left]==sort[left]){
                 left++;              
        }
        while(right>1&&arr[right]==sort[right]){
                right--;
            }
        //reverse
        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        } 
        if (Arrays.equals(arr, sort)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }       
    }
}

