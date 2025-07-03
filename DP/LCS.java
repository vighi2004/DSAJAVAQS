//finding longest common subsequence.
package DP;
public class LCS {
    //using recursion O(2^mn)
    public static int LCS(String str1,String str2,int n,int m){
        if(n==0||m==0){
            return 0;
        }
        if(str1.charAt(n-1)==str2.charAt(m-1)){
           return 1+LCS(str1, str2, n-1, m-1);
        }
        else{
            int ans1=LCS(str1, str2, n-1, m);
            int ans2=LCS(str1, str2, n, m-1);
            return Math.max(ans1,ans2);
        }
    }
    //using DP memiozation approach O(N*M).
     public static int LCSM(String str1,String str2,int n,int m,int dp[][]){
        if(n==0||m==0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(str1.charAt(n-1)==str2.charAt(m-1)){
           return dp[n][m]=1+LCSM(str1, str2, n-1, m-1,dp);
        }
        else{
            int ans1=LCSM(str1, str2, n-1, m,dp);
            int ans2=LCSM(str1, str2, n, m-1,dp);
            return dp[n][m]=Math.max(ans1,ans2);
        }
    }
    //using DP memiozation approach O(N*M).
     public static void LCST(String str1,String str2,int n,int m,int dp1[][]){
        StringBuilder lcs=new StringBuilder("");
        for(int i=1;i<str1.length()+1;i++){
            for(int j=1;j<str2.length()+1;j++){ 
               if(str1.charAt(i-1)==str2.charAt(j-1)){
                   dp1[i][j]=dp1[i-1][j-1]+1;//diagonal uppere check
                 }
                 //different then compare up and left which is max.
               else{
                  int ans1=dp1[i-1][j];
                  int ans2=dp1[i][j-1];
                  dp1[i][j]=Math.max(ans1,ans2);
        }}
    }
    System.out.println("LCS(DPT): "+dp1[str1.length()][str2.length()]);
    }
    public static void main(String[] args) {
        String str1="abcde";
        String str2="ace";
        System.out.println("LCS is: "+LCS(str1,str2,str1.length(),str2.length()));
        System.out.println("using DP memiozation");
        int dp[][]=new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<str1.length()+1;i++){
            for(int j=0;j<str2.length()+1;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println("LCS(DPM): "+LCSM(str1, str2, str1.length(), str2.length(),dp));
        System.out.println("using tabulation:-");
        int[][] dp1=new int[str1.length()+1][str2.length()+1];
          for(int i=0;i<str1.length()+1;i++){
                dp[i][0]=0;
            }
          for(int i=0;i<str2.length()+1;i++){
                dp[0][i]=0;
          }
        LCST(str1, str2, str1.length(), str2.length(), dp1);
    }
}
