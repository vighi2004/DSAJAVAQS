//find minimum jumps.
package DP;
public class minJumps {
    public static void solve(int arr[],int n,int dp[]){
        for(int i=n-2;i>=0;i--){
            int steps=arr[i];
            int ans=Integer.MAX_VALUE;
            for(int j=i+1;j<n&&j<=i+steps;j++){
               if(dp[j]!=-1){
                ans=Math.min(ans,dp[j]+1);
               }
            }
            dp[i]=ans;
        }
        System.out.println("minimum jumps : "+dp[0]);
    }
    public static void main(String[] args) {
        int arr[]={2,3,1,1,4};
        int dp[]=new int[arr.length];
        for(int i=0;i<dp.length-1;i++){
            dp[i]=-1;   
        }
        solve(arr,arr.length,dp);
    }
}
