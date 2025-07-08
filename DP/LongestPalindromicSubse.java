//finding longest palindromic subsequnece
package DP;
public class LongestPalindromicSubse {
    public static  int longestPalindromeSubseq(String s) {
          int dp[][]=new int[s.length()+1][s.length()+1];
          String rev = new StringBuilder(s).reverse().toString();
          for(int i=0;i<s.length()+1;i++){
                dp[i][0]=0;
            }
          for(int i=0;i<s.length()+1;i++){
                dp[0][i]=0;
          }
          for(int i=1;i<s.length()+1;i++){
            for(int j=1;j<s.length()+1;j++){
                if(s.charAt(i-1)==rev.charAt(j-1)){
                   dp[i][j]=dp[i-1][j-1]+1;//diagonal uppere check
                 }
                 //different then compare up and left which is max.
               else{
                  int ans1=dp[i-1][j];
                  int ans2=dp[i][j-1];
                  dp[i][j]=Math.max(ans1,ans2);
            }
          }
        }
       return dp[s.length()][s.length()];
    }
    public static void main(String[] args) {
       String str="bbbab";
       System.out.println("longest palidrome subsequence is: "+longestPalindromeSubseq(str));    
    }
    
}
