package DP;
import java.util.*;
public class BBTCounter {
    public static int CountBBT(int h){
        if(h==0 || h==1){
            return 1;
        }
        int count=CountBBT(h-1)*CountBBT(h-1)+CountBBT(h-2)*CountBBT(h-1)+CountBBT(h-1)*CountBBT(h-2);
        return count;
    }
    //tabulation
    public static int CountBBTT(int h,int dp[]){
         dp[0]=1;
         dp[1]=1;

         for(int i=2;i<=h;i++){
            dp[i]=dp[i-1]*dp[i-1]+dp[i-2]*dp[i-1]+dp[i-1]*dp[i-2];
         }
         return dp[h];
    }
    public static void main(String args[]){
        int h=3;
        int dp[]=new int[h+1];
        System.out.println("Possible trees are :-"+CountBBT(h));
        System.out.println(CountBBTT(h,dp));
    }
}
