//edit string check how many operation required.
package DP;
public class EditDistance {
    public static int solve(String str1,String str2,int n,int m){
        if(n==0){
            return m;
        }
        if(m==0){
            return n;
        }
        if(str1.charAt(n-1)==str2.charAt(m-1)){
            return solve(str1, str2, n-1, m-1);
        }
        else{
            int ans1=1+solve(str1, str2, n, m-1);//add
            int ans2=1+solve(str1, str2, n-1, m-1);//replace
            int ans3=1+solve(str1, str2, n-1, m);//delete
            return Math.min(ans1,Math.min(ans2, ans3));
        }
    }
    //using tabulation
     public static void Tab(String str1,String str2){
        int dp[][]=new int[str1.length()+1][str2.length()+1];
        for(int i=1;i<str1.length();i++){
           dp[i][0]=i;
        }
        for(int i=1;i<str2.length();i++){
             dp[0][i]=i;
        }
        for(int i=1;i<str1.length()+1;i++){
            for(int j=1;j<str2.length()+1;j++){
        if(str1.charAt(i-1)==str2.charAt(j-1)){
            dp[i][j]=dp[i-1][j-1];
        }
        else{
            int ans1=1+dp[i][j-1];//add
            int ans2=1+dp[i-1][j-1];//replace
            int ans3=1+dp[i-1][j];//delete
            dp[i][j]=Math.min(ans1,Math.min(ans2, ans3));
        }
    }
    }
    System.out.println("minimun required OP: "+dp[str1.length()][str2.length()]);
}

    public static void main(String[] args) {
        String str1="intention";
        String str2="execution";
        System.out.println(solve(str1,str2,str1.length(),str2.length()));
        System.out.println("using DP Tabulation: -");
        Tab(str1, str2);
    }
    
}
