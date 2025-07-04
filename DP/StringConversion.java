//convertinf string and finding how many delteions and insertions required.O(n*m).
package DP;
public class StringConversion {
     //using DP tabulation approach O(N*M).
     public static void LCST(String str1,String str2,int n,int m,int dp1[][]){
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
    int del=str1.length()-dp1[str1.length()][str2.length()];
    int ins=str2.length()-dp1[str1.length()][str2.length()];
    System.out.println("LCS(DPT): "+dp1[str1.length()][str2.length()]);
    System.out.println("no. of deletions: "+del);
    System.out.println("no. of insertions: "+ins);
    }
    public static void main(String[] args) {
        String str1="pear";
        String str2="sea";
        int[][] dp=new int[str1.length()+1][str2.length()+1];
          for(int i=0;i<str1.length()+1;i++){
                dp[i][0]=0;
            }
          for(int i=0;i<str2.length()+1;i++){
                dp[0][i]=0;
          }
        LCST(str1, str2, str1.length(), str2.length(), dp);
    }
}
