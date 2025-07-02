//suing DP tabulation appraoch whether sum exist or not.
package DP;
public class TargetSumSubset {
    public static void main(String[] args) {
        int num[]={4,2,7,1,3};
        int target=10;
        boolean dp[][]=new boolean[num.length+1][target+1];
        for(int i=0;i<num.length+1;i++){
           dp[i][0]=true;
        }
        for(int j=1;j<target+1;j++){
           dp[0][j]=false;
        }
        for(int i=1;i<num.length+1;i++){
            for(int j=1;j<target+1;j++){
               if(num[i-1]<=j){
                //include
                if(dp[i-1][j-num[i-1]]){
                    dp[i][j]=true;
                }
                //exclude
                if(dp[i-1][j]){
                    dp[i][j]=true;
                }
               }
               else{
                if(dp[i-1][j]){
                    dp[i][j]=true;
                }
               }
            }
        }
        if(dp[num.length][target]){
            System.out.println("yes it exist");
        }
        else{
            System.out.println("not exist");
        }
    }

}
