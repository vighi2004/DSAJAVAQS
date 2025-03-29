//rateMaze problem..
package Backtracking;
public class RatMaze {
    public static String ways(int[][] arr,int m,int n,int i, String s){
        if(m>=0&&n>=0&&m<i&&n<i){
        if(m==i-1&&n==i-1){
             return s;
        }
        if(arr[m][n]==0){
            return "";
        }
         String total=ways(arr, m+1, n,i,s+"D")+ways(arr, m, n+1,i,s+"R");
         return total;
    }
        return "";
}
    public static void main(String[] args) {
      int arr[][]={{1,0,0,0},{1,1,0,1},{0,1,0,0},{1,1,1,1}};
      int i=arr.length;
      System.out.println(ways(arr,0,0,i,""));
    }
    
}
