//finding largest minimum distance required to place cows in stalls,Time required O(nlogn).
import java.util.*;
public class AgrresiveCows {
      public static boolean canPlaceCows(int[] arr ,int cows,int mid){
           int cowplace=arr[0];
           cows--;
           for(int i=1;i<arr.length;i++){
               if(arr[i]-cowplace>=mid){
                 cowplace=arr[i];
                 cows--;
                }
                if(cows==0){
                  return true;
                }
              }
              return false;
              
      }
      public static void main(String[] args) {
        int cows=3;
        int max=0;
        int arr[]={1,2,4,8,9};
        Arrays.sort(arr);
        int lowD=1;
        int highD=arr[arr.length-1]-arr[0];
        while(lowD<=highD){
          int mid=(lowD+highD)/2;
          if (canPlaceCows(arr, cows, mid)) {  // Check if we can place cows with this `mid`
             max=mid;
            lowD = mid + 1;  // Try for a larger distance
        } else {
            highD = mid - 1; // Reduce distance
        }
        }
        System.out.println(max);

        
      }
      
    
}