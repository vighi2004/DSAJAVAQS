//matric chain multiplication
package DP;
import java.util.Arrays;
public class MCM {
    //using recursion.eponentional O(n^3)
    public static int mcm(int arr[],int i,int j){
        if(i==j){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        //spliting
        for(int k=i;k<j;k++){
            int cost1=mcm(arr, i, k);
            int cost2=mcm(arr, k+1, j);
            int cost3=arr[i-1]*arr[k]*arr[j];
            int finalcost=cost1+cost2+cost3;
            ans= Math.min(ans,finalcost);
        }
        return ans;

    }
     //using memoization
     public static int mcmT(int arr[],int i,int j,int dp[][]){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        //spliting
        for(int k=i;k<j;k++){
            int cost1=mcm(arr, i, k);
            int cost2=mcm(arr, k+1, j);
            int cost3=arr[i-1]*arr[k]*arr[j];
            int finalcost=cost1+cost2+cost3;
            ans= Math.min(ans,finalcost);
        }
        return dp[i][j]=ans;

    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,3};
        int n=arr.length;
        System.out.println("min cost is: "+mcm(arr, 1, n-1));
        System.out.println("using memoization:-");
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
           Arrays.fill(dp[i], -1);//rowise all -1;
        }
        System.out.println("mcmT: "+mcmT(arr, 1, n-1,dp));
}
    
}
