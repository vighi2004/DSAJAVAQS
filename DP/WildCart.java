//finidng whether pattern matches or not.
package DP;
public class WildCart {
     //using DP tabulation approach O(N*M).
     public static void LCST(String text,String pattern,boolean dp1[][]){
        for(int i=1;i<text.length()+1;i++){
            for(int j=1;j<pattern.length()+1;j++){ 
               if((text.charAt(i-1)==pattern.charAt(j-1)||pattern.charAt(j-1)=='?')){
                   dp1[i][j]=dp1[i-1][j-1];
                 }
                else if(pattern.charAt(j-1)=='*'){
                    dp1[i][j]=dp1[i][j-1]||dp1[i-1][j];
                } 
               else{
                  dp1[i][j]=false;
                }
                System.out.print(" "+dp1[i][j]);
    }
    System.out.println();
    }
    System.out.println("LCS(DPT): "+dp1[text.length()][pattern.length()]);
    }
    public static void main(String[] args) {
        String text="aa";
        String pattern="b*";
        boolean[][] dp=new boolean[text.length()+1][pattern.length()+1];
          //column 
          dp[0][0]=true;
          for(int i=1;i<pattern.length()+1;i++){
            if(pattern.charAt(i-1)=='*'){
                dp[0][i]=dp[0][i-1];
            }    
          }
        LCST(text, pattern,dp);
    }
    
}
