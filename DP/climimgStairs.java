//climbing stairs using recursion
package DP;
public class climimgStairs {
    //recursion O(2^n)
    public static int stairs(int n){
        if(n==0){
         return 1;
        }
        if(n<0){
            return 0;
        }
        int ways=stairs(n-1)+stairs(n-2);
        return ways;
    }
    //DP(memeoization) O(n)
    public static int stairs1(int n,int dp[]){
        if(n==0){
         return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n]=stairs(n-1)+stairs(n-2);
        return dp[n];
    }
    public static void main(String[] args) {
        int n=3;
        int dp[]=new int[n+1];
        System.out.println(stairs(n));
        System.out.println(stairs1(n,dp));
    }
}
