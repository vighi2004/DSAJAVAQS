//finding max value with k size sub array consecutive and storing in queue.
package Queues;
import java.util.*;
public class MaxVal {
    public static void solve(int arr[],int k,int n,Queue<Integer> Q){
        int max=0;
        for(int i=0;i<n-2;i++){
           max=Math.max(arr[i],Math.max(arr[i+1],arr[i+2]));
           Q.add(max);
           max=0;
        }
    }
    public static void main(String[] args) {
        Queue<Integer> Q = new LinkedList<>();
        int arr[]={1,2,3,1,4,5,2,3,6};
        int k=3;
        int n=9;
        solve(arr,k,n,Q);
        System.out.println(Q);
    }
}
