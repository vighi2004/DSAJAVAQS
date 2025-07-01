package DP;
public class Knapsack01 {
    public static int solve(int val[],int wt[],int weight,int n){
         if(weight==0||n==0){
            return 0;
         }
         if(wt[n-1]<=weight){
            //include
            int ans1=val[n-1]+solve(val, wt, weight-wt[n-1], n-1);
            //exclude
            int ans2=solve(val, wt, weight, n-1);
            return Math.max(ans1, ans2);
         }
         else{
            return solve(val, wt, weight, n-1);
         }
    }
    //memeozation appraoch O(n*w)
    public static int DPM(int val[],int wt[],int weight,int n,int dp[][]){
           if(weight==0||n==0){
            return 0;
         }
         if(dp[n][weight]!=0){
                return dp[n][weight];
            }
         if(wt[n-1]<=weight){
            //include
            int ans1=val[n-1]+DPM(val, wt, weight-wt[n-1], n-1,dp);
            //exclude
            int ans2=DPM(val, wt, weight, n-1,dp);
            dp[n][weight]=Math.max(ans1,ans2);
            return dp[n][weight];
         }
         else{
              dp[n][weight]=DPM(val, wt, weight, n-1,dp);
                return dp[n][weight];
         }
    }
    //tabulation 
    public static int DPT(int val[],int wt[],int weight){
        int dp[][]=new int[val.length+1][weight+1];
        //i=total items,j=weight.
        for(int i=0;i<val.length+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<weight+1;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<wt.length+1;i++){
           for(int j=1;j<weight+1;j++){
            if(wt[i-1]<=j){
                //include 
                int profit1=val[i-1]+dp[i-1][j-wt[i-1]];
                //exclude
                int profit2=dp[i-1][j];
                dp[i][j]=Math.max(profit1,profit2);
            }
            else{
                dp[i][j]=dp[i-1][j];
            }
           }
        }
        return dp[val.length][weight];
    }
    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int weight=7;
        int dp[][]=new int[val.length+1][weight+1];
        System.out.println("max profit is: "+solve(val, wt, weight,wt.length));
        System.out.println("max profit using DPM: "+DPM(val, wt, weight,val.length,dp));
        System.out.println("max profit using DPT: "+DPT(val, wt, weight));
        
    }
}
