//trying.....
public class maxLength {
public static void findLongestPath(int[][] mat,int i,int j,int m,int n){
    if(i>=0&&i<mat.length&&j>=0&&j<=mat[0].length){
    int sum=0;
    if(i==m&&j==n){
        System.out.println(sum);
        return;
    }
    if(mat[i][j]==1){
        boolean move=
        if(cango(mat,int i, int j,int m, int n)){
            sum=sum+1;
        }
    }
}}
public static void main (String[] args) {
    int mat[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                   { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
                   { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
 
    // find longest path with source (0, 0) and
    // destination (1, 7)
    findLongestPath(mat, 0, 0, 1, 7);
 
  }

}
