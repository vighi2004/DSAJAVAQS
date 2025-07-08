//finding longest path from source(0,0).
package DP;
public class LongestPath {
    public static int longPath(int i,int j,int m[][],int dp[][]){
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        //down
       int down=0;
        if(i<m.length-1&&m[i+1][j]>m[i][j]){
            down=longPath(i+1, j, m,dp);
        }
        int right=0;
        if(j<m[0].length-1&&m[i][j+1]>m[i][j]){
            right=longPath(i, j+1, m,dp);
        }
        dp[i][j]=1+Math.max(down,right);
        return dp[i][j];

    }
    public static void main(String[] args) {
       int m[][] = { { 1, 2, 3, 4 },
                 { 2, 2, 3, 4 },
                 { 3, 2, 3, 4 },
                 { 4, 5, 6, 7 } };
        int dp[][]=new int[m.length][m[0].length];         
        System.out.println("longest path is: "+longPath(0, 0,m,dp));
        for(int x = 0; x < dp.length; x++) {
           for(int y = 0; y < dp[0].length; y++) {
              System.out.print(dp[x][y] + " ");
           }
           System.out.println();
        }
}
}
