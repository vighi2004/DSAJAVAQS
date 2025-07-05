package DP;
public class CountBST {
   public static void countBST(int n){
       int dp[]=new int[n+1];
        dp[0]=dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        System.out.println("BST of "+n+" nodes: "+dp[n]);
   } 
   public static void main(String[] args) {
      int n=3;//nodes
      countBST(n);
      
      
      
   }  
}
