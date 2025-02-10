//interval oVerlap merging.
import java.util.*;
public class IntervalOverlap {
       public static void main(String[] args) {
       int arr[][]={{1,3},{7,8},{6,7},{0,2},{3,4}};
       Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
       int[][] result=new int[arr.length][2];
       int j = 0; 
       for (int i = 1; i < arr.length; i++) {
           // If the intervals overlap
           if (arr[i][0] <= arr[j][1]) {
               // Merge the intervals by taking the min start time and max end time
               result[j][0] = Math.min(arr[j][0], arr[i][0]);  // Take the min start time
               result[j][1] = Math.max(arr[j][1], arr[i][1]);  // Take the max end time
           } else {
               // No overlap, move to the next index in result
               j++;
               result[j][0] = arr[i][0];
               result[j][1] = arr[i][1];
           }
       }
       
       
       for (int i = 0; i <= j; i++) {
        System.out.println(result[i][0] + " " + result[i][1]);
    }
            
}
}

