package Strings;

public class grid {
    public static int  grid(int row,int col,int n,int m){
        //base
        if(row==n-1&&col==m-1){
            return 1;
        }
        else if(row==n||col==m){
            return 0;
        }
        int totalWays=grid(row+1,col,n,m)+grid(row,col+1,n,m);
        return totalWays;
    }     
     public static void main(String[] args) {
        int n=3;
        int m=3;
        System.out.println(grid(0,0,n,m));

    }
    
}

