//finding longest common subtring continuous.
package DP;
public class LCSubstring {
    static int max=Integer.MIN_VALUE;
    public static void solve(String str1,String str2,int n,int m,int count){
        if(n==0||m==0){
            return;
        }
        if(str1.charAt(n-1)==str2.charAt(m-1)){
          solve(str1, str2, n-1, m-1,count+1);
          max=Math.max(max, count);
        }
        else{
             solve(str1, str2, n, m-1,0);
             solve(str1, str2, n-1, m,0);
        }
    }
    //using tabulation
    public static void LCST(String str1,String str2,int n,int m,int dp1[][]){
        int maxlen=0;
        int endidx=-1;
        for(int i=1;i<str1.length()+1;i++){
            for(int j=1;j<str2.length()+1;j++){ 
               if(str1.charAt(i-1)==str2.charAt(j-1)){
                   dp1[i][j]=dp1[i-1][j-1]+1;//diagonal uppere check
                   if(dp1[i][j]>maxlen){
                    maxlen=dp1[i][j];
                    endidx=i;
                   }
                }
                 //different then compare up and left which is max.
               else{
                  dp1[i][j]=0;
        }}
    }
    if(endidx!=-1){
    System.out.println("Longest Common Substring Length: " + maxlen);
    System.out.println("Longest Common Substring: " + str1.substring(endidx - maxlen, endidx));
    }
    else{
        System.out.println("not found");
    }
    }
    public static void main(String[] args) {
        String str1="abcdgh";
        String str2="acdghr";
        solve(str1, str2,str1.length(),str2.length(),0);
        System.out.println("using recursion: "+max);
        System.out.println("using tabulation");
        int dp[][]=new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<str1.length()+1;i++){
                dp[i][0]=0;
            }
          for(int i=0;i<str2.length()+1;i++){
                dp[0][i]=0;
          }
        LCST(str1,str2,str1.length(),str2.length(),dp);

    }
    
}
