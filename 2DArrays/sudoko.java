//solving sudoku using backtracking.
public class sudoko {
    public static boolean isSafe(int[][] sudoko,int row,int col,int k) {
      //horizantal
      for(int i=0;i<sudoko.length;i++){
        if(sudoko[row][i]==k){
            return false;
        }
    }
    //vertical
    for(int i=0;i<sudoko.length;i++){
        if(sudoko[i][col]==k){
            return false;
        }
    }
    //3 grid check
    int startRow = (row / 3) * 3;
    int startCol = (col / 3) * 3;

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (sudoko[startRow + i][startCol + j] == k) {
                return false;
            }
        }
    }    
    return true;

        
    }
    public static void sudo(int[][] sudoko,int row,int col) {
        //base
        if(row==sudoko.length){
            print(sudoko);
            return;
        }
        if(sudoko[row][col] != 0){
            if(col == sudoko.length - 1){
                sudo(sudoko, row + 1, 0);
            } else {
                sudo(sudoko, row, col + 1);
            }
            return;
        }

        //recusion
        for (int k = 1; k <= 9; k++) {
            if (isSafe(sudoko, row, col, k)) {
                sudoko[row][col] = k;  // Place the number
    
                // Move forward
                if (col == 8) {
                    sudo(sudoko, row + 1, 0);  // Move to next row
                } else {
                    sudo(sudoko, row, col + 1);  
                }
    
                sudoko[row][col] = 0;  
            }
        
     }
            
    }
    
    public static void print(int[][] sudoko) {
        for(int i=0;i<sudoko.length;i++){
            for(int j=0;j<sudoko.length;j++){
                System.out.print(sudoko[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    public static void main(String[] args) {
        int sudoko[][]={{0,0,8,0,0,0,0,0,0},
                        {4,9,0,1,5,7,0,0,2},
                        {0,0,3,0,0,4,1,9,0},
                        {1,8,5,0,6,0,0,2,0},
                        {0,0,0,0,2,0,0,6,0},
                        {9,6,0,4,0,5,3,0,0},
                        {0,3,0,0,7,2,0,0,4},
                        {0,4,9,0,3,0,0,5,7},
                        {8,2,7,0,0,9,0,1,3}};
    sudo(sudoko,0,0);                    
}
    } 
