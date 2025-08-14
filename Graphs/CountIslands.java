//Counting no.of islands in a matrix.Coutning in form of adajacent.
package Graphs;
public class CountIslands {
    public static int traverse(int [][] grid){
        int r=grid.length;
        int c=grid[0].length;
        int count=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                      count++;
                      dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public static void dfs(int [][] grid,int i,int j){
            int r=grid.length;
            int c=grid[0].length;
            //move 8 directions
            if(i>=0&&i<r&&j>=0&&j<c&&grid[i][j]==1){
                grid[i][j]=0;
               //explore
                dfs(grid,i-1,j);//up
                dfs(grid,i+1,j);//down
                dfs(grid,i,j-1);//left
                dfs(grid,i,j+1);//right
                dfs(grid,i-1,j-1);//up-left
                dfs(grid,i-1,j+1);//up-right
                dfs(grid,i+1,j-1);//down-left
                dfs(grid,i+1,j+1);//down-right
        }}
    
    public static void main(String[] args){
        int[][] grid = {
            {1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 0, 1, 1}
        };
        System.out.println("No. of Islands are:- "+traverse(grid));
    }

}
