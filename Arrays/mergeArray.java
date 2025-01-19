//merge two array and sort it O(n^2).
import java.util.*;
public class mergeArray{
        public static void main(String args[]){
        int arr[]={5,4,2,3,1};
        int arr1[]={8,7,6,9,10};
        int n=arr.length+arr1.length;
        int merge[]=new int[n];
        for(int i=0;i<arr.length;i++){
         merge[i]=arr[i];
         for(int j=i+5;j<n;j++){
             merge[j]=arr1[i];
         }
        }
        Arrays.sort(merge);
        for(int i=0;i<n;i++){
            System.out.print(" "+merge[i]);
        }
    }
}
