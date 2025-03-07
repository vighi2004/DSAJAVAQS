//counting triplet whose their addition  is lesser than than sum in time O(n^2).
import java.util.*;
public class CountTriplet {
    public static void main(String[] args) {
        int arr[]={5,1,3,4,7};
        int count=0;
        int sum=12;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            int left=i+1;
            int right=arr.length-1;
            while(left<=right)
             {
                if(arr[i]+arr[left]+arr[right]<sum){
                    System.out.println("(" + arr[i] + ", " + arr[left] + ", " + arr[right] + ")");
                    count++;  
                    left++;
                }
                else{
                    right--;

                }
                
                }
            }
        
        System.out.println(count);
        }
    }
