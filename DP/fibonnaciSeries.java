//solving fibonaci series using DP.O(n)
package DP;
public class fibonnaciSeries {
    public static int fb(int n,int dp[]){
        if(n==0||n==1){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n]=fb(n-1, dp)+fb(n-2, dp);
        return dp[n];
    }
    public static void main(String[] args) {
        int n=6;
        int dp[]=new int[n+1];
        System.out.println(fb(n,dp));
    }
    
}
