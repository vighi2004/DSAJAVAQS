//Finding minimum possible sum of sub array by taking all possiblee k subarrays and find minimum sum of it.
package Greedy_Algo;
import java.util.*;
public class SplitKSubArr{
    public static int ans=100000000;
    public static void minpossible(int arr[],int n,int k,int index,int sum,int maxsum){
        if(k==1){
            sum=0;
            for(int i=index;i<n;i++){
                sum=sum+arr[i];
            }
            maxsum=Math.max(sum,maxsum);
            ans=Math.min(ans,maxsum);
            return;
        }
        sum=0;//reset
        for(int i=index;i<n;i++){
            sum=sum+arr[i];
            maxsum=Math.max(sum,maxsum);//update
            minpossible(arr, n, k-1, i+1, sum, maxsum);
        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        int n=arr.length;
        int k=3;
        minpossible(arr,n,k,0,0,0);
        System.out.println("Min possible sum is :"+ans);
        
    }
}