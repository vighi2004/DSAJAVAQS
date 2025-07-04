//finding catalan's number
package DP;
public class catalanNumber {
    //using recurison
    public static int catalanR(int n){
        if(n==0||n==1){
            return 1;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=catalanR(i)*catalanR(n-i-1);
        }
         return ans;
       
    }
    public static void CatalanT(int n){
        int dp[]=new int[n+1];
        dp[0]=dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        System.out.println("catalan of "+n+" is: "+dp[n]);
    }
    public static void main(String[] args) {
        int n=3;
        System.out.println("catalan of nth number is: "+catalanR(n));
        System.out.println("using tabulation:-");
        CatalanT(n);
    }
    
}
