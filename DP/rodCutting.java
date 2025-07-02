//finding max value by cutting rod
package DP;
public class rodCutting {
    public static void main(String[] args) {
        int length[]={1,2,3,4,5,6,7,8};
        int[] prices={1,5,8,9,10,17,17,20};
        int rodlength=8;
        int dp[][]=new int[length.length+1][rodlength+1];
        //i=total items,j=weight.
        for(int i=0;i<length.length+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<rodlength+1;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<length.length+1;i++){
           for(int j=1;j<rodlength+1;j++){
            if(length[i-1]<=j){
                //include 
                int profit1=prices[i-1]+dp[i][j-length[i-1]];
                //exclude
                int profit2=dp[i-1][j];
                dp[i][j]=Math.max(profit1,profit2);
            }
            else{
                dp[i][j]=dp[i-1][j];
            }
           }
        }
        System.out.println(dp[length.length][rodlength]);
    }
    }
