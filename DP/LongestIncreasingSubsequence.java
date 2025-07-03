package DP;
import java.util.*;

public class LongestIncreasingSubsequence {
    public static void LCST(int[] arr, int[] arr1, int[][] dp) {
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= arr1.length; j++) {
                if (arr[i - 1] == arr1[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // diagonal match
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // max from left or top
                }
            }
        }
        System.out.println("LCS(DPT): " + dp[arr.length][arr1.length]);
    }

    public static void main(String[] args) {
        int arr[] = {50, 3, 10, 7, 40, 80};

        // Create sorted unique array
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int[] arr1 = new int[set.size()];
        int idx = 0;
        for (int val : set) {
            arr1[idx++] = val;
        }

        int[][] dp = new int[arr.length + 1][arr1.length + 1];
        LCST(arr, arr1, dp);
    }
}
