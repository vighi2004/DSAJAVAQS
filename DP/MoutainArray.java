package DP;

import java.util.Collections;
import java.util.TreeSet;

public class MoutainArray {
    public static int minimumMountainRemovals(int[] nums) {
        int maxlength=0;
        int length=1;
        TreeSet <Integer> set=new TreeSet<>();
        TreeSet <Integer> set2=new TreeSet<>(Collections.reverseOrder());
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                int peak = i;
                for(int j=0;j<peak;j++){
                    set.add(nums[j]);
                }
                int inarr[]=new int[set.size()];
                int idx = 0;
                for (int val : set) {
                    inarr[idx++] = val;
                }
                for(int j=peak-1;j<nums.length;j++){
                    set2.add(nums[j]);
                }
                int decarr[]=new int[set2.size()];
                int idx1 = 0;
                for (int val : set2) {
                    decarr[idx1++] = val;
                }
                int left=LIS(nums,inarr, peak);
                int right=LDS(nums,decarr,peak);
                maxlength=Math.max(maxlength, left+right+1);
            }
            else{
                continue;
            }
        }
        return nums.length-maxlength;
    }
     public static int LIS(int[] arr, int[] arr1,int peak) {
         int dp[][]=new int[peak+2][arr1.length+1];
        for(int i=0;i<peak+2;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<arr1.length;i++){
            dp[0][i]=0;
        }
        for (int i = 1; i <= peak+1; i++) {
            for (int j = 1; j <= arr1.length; j++) {
                if (arr[i - 1] == arr1[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // diagonal match
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // max from left or top
                }
            }
        }
         return dp[peak+1][arr1.length];
    }
     public static int LDS(int[] arr, int[] arr1,int peak) {
        int dp[][]=new int[peak+2][arr1.length+1];
        for(int i=0;i<peak+2;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<arr1.length;i++){
            dp[0][i]=0;
        }
        for (int i = 1; i <= peak+1; i++) {
            for (int j = 1; j <= arr1.length; j++) {
                if (arr[i - 1] == arr1[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // diagonal match
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // max from left or top
                }
            }
        }
        return dp[peak+1][arr1.length];
    }
    public static void main(String[] args) {
        int nums[] = {1, 3, 2, 4, 3, 5, 4, 6, 1};
        System.out.println("minimum deleteions required: "+minimumMountainRemovals(nums));
    }
}
