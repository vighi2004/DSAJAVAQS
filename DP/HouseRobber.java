//profit by theif robbing house not adjacent one.
package DP;
public class HouseRobber {
    public static int rob(int[] nums,int i) {
        if(i>=nums.length){
            return 0;
        }
        int theif=nums[i]+rob(nums,i+2);//taken
        int notTheif=rob(nums,i+1);//not taken
        return Math.max(theif, notTheif);
    }
    public static void main(String[] args) {
        int nums[]={2,7,9,3,1};
        System.out.println("max profit: "+rob(nums,0));
    }
}
