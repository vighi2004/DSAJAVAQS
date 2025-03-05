public class RatMaze {
    public static int  grid(int rat[][],int row,int col,int n,int m){
        //base
        if(row==n-1&&col==m-1){
            return 1;
        }
        else if(row==n||col==m||row<0||col<0||rat[row][col]==0){
            return 0;
        }
        rat[row][col]=0;
        int totalWays=grid(rat,row+1,col,n,m)+grid(rat,row,col+1,n,m)+grid(rat,row-1,col,n,m)+grid(rat,row,col-1,n,m);
        rat[row][col]=1;
        return totalWays;

        
    }     
     public static void main(String[] args) {
        int ratmatrix[][]={{1,1,1,1},{0,1,0,1},{1,1,1,1},{1,0,1,1}};
        int n=ratmatrix.length;
        int m=ratmatrix[0].length;
        System.out.println(grid(ratmatrix,0,0,n,m));

    }
    
}
