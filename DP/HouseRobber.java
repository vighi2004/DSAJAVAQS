//profit by theif robbing house not adjacent one.
package DP;
public class HouseRobber {
    public static int rob(int[] nums,int i,int dp[]) {
        if(i>=nums.length){
            return 0;
        }
        if(dp[i]!=0){
            return dp[i];
        }
        int theif=nums[i]+rob(nums,i+2,dp);//taken
        int notTheif=rob(nums,i+1,dp);//not taken
        return dp[i]= Math.max(theif, notTheif);
    }
    //using tabulation
    public static void robT(int[] nums){
     int n = nums.length;

    if (n == 0) {
        System.out.println("Max profit: 0");
        return;
    }
    if (n == 1) {
        System.out.println("Max profit: " + nums[0]);
        return;
    }

    int[] dp = new int[n];
    dp[n-1] = nums[n-1];
    dp[n-2] = Math.max(nums[n-2], nums[n-1]);

    for (int i = n - 3; i >= 0; i--) {
        dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
    }

    System.out.println("Max profit using tabulation: " + dp[0]);
    }
    public static void main(String[] args) {
        int nums[]={2,7,9,3,1};
        int dp[]=new int[nums.length];
        System.out.println("max profit: "+rob(nums,0,dp));
        System.out.println("using tabulationL:");
        robT(nums);
    }
}
