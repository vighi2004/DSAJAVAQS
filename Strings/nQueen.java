package Strings;

public class nQueen {
    public static boolean isSafe(String[][] board,int row,int col) {
        //vertical
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=="Q"){
                return false;
            }
        }
        //diagonal left up
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=="Q"){
                return false;
            }   
        }
        //diagonal right up
        for(int i=row-1,j=col+1;i>=0&&j<board.length;i--,j++){
            if(board[i][j]=="Q"){
                return false;
            } 
        }
        return true;
        
    }
    public static void queen(String[][] board,int row) {
        //base
        if(row==board.length){
            System.out.println("----chessboard------");
            for(int i=0;i<row;i++){
                for(int j=0;j<row;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }
        
        //recursion
        for(int k=0;k<board.length;k++){
           if(isSafe(board,row,k)){ 
              board[row][k]="Q";
              queen(board,row+1);
              board[row][k]=".";
        }
    }

        
    }
    public static void main(String[] args) {
        int n=4;
        String chessBoard[][]=new String[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chessBoard[i][j]=".";
            }
        }
        queen(chessBoard,0);

    }
    
}
