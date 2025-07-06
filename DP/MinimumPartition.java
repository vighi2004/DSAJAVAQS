//finding minimum partition difference using 0-1knapsack
package DP;
public class MinimumPartition {
    //using tabulation.O(n*totalsum);
    public static void MP(int dp[][],int capacity,int arr[],int totalSum){
        for(int i=1;i<arr.length+1;i++){
            for(int j=1;j<capacity+1;j++){
                if(arr[i-1]<=j){
                    //include
                    int p1=dp[i][j]=arr[i-1]+dp[i-1][j-arr[i-1]];
                    int p2=dp[i-1][j];//exclude
                    dp[i][j]=Math.max(p1,p2);
                }
                else{
                    dp[i][j]=dp[i-1][j]; 
                }
            }
        }
        int sum1=dp[arr.length][capacity];
        int sum2=totalSum-sum1;
        int diff=Math.abs(sum1-sum2);
        System.out.println("min difference is: "+diff);
    }
    public static void main(String[] args) {
        int arr[]={1,6,11,5};
        int totalSum=0;
        for(int i=0;i<arr.length;i++){
            totalSum+=arr[i];
        }
        int capacity=totalSum/2;
        int dp[][]=new int[arr.length+1][capacity+1];
        for(int i=0;i<arr.length;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<capacity;i++){
            dp[0][i]=0;
        }
        MP(dp,capacity,arr,totalSum);
    }
    
}
