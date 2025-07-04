//finding all possibilities of coin chnage with given sum.
package DP;
import java.util.*;
public class CoinChange {
    public static void main(String[] args) {
        int coins[]={1,2,3};
        int sum=4;
        int dp[][]=new int[coins.length+1][sum+1];
        for(int i=0;i<coins.length+1;i++){
           dp[i][0]=1;
        }
        for(int j=1;j<sum+1;j++){
           dp[0][j]=0;
        }
        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<sum+1;j++){
               if(coins[i-1]<=j){
                 //include 
                dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
                System.out.print(" "+dp[i][j]); 
               }
               else{
                dp[i][j]=dp[i-1][j];
                System.out.print(" "+dp[i][j]); 
            
               }
            }
            System.out.println("Total ways are: "+dp[coins.length][sum]);
        }
    }
    
}
