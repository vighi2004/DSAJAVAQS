//printing Quad Array of particular target wit best time O(n3)+Space O(1).Using =(sorting + pair + two pointer).
import java.util.*;
public class QuadSumArray {
    public static void main(String[] args) {
        int arr[]={10, 2, 3, 4, 5, 7, 8}; 
        int target = 23;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                int left=j+1;
                int right=arr.length-1;
                while(left<right){
                    if(arr[i]+arr[j]+arr[left]+arr[right]==target){
                        System.out.println("["+arr[i]+","+arr[j]+","+arr[left]+","+arr[right]+"]");
                        break;
                    }
                    else if(arr[i]+arr[j]+arr[left]+arr[right]<target){
                           left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        } 
    }
    
}
