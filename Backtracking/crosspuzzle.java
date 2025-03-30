package Backtracking;

public class crosspuzzle {
    public static void solve(char[][] grid,char[][] word,int i,int j){
        if(j==word[i].length){
             return;
        }
        if(grid[i][j]=='-'){
            grid[i][j]=word[i][j];
        }
        solve(grid,word,i,j+1);



    }
    public static void main(String[] args) {
        char[][] grid = {
            {'+', '+', '+', '+', '+', '+', '+', '+', '+', '+'},
            {'+', '-', '-', '-', '-', '-', '+', '+', '+', '+'},
            {'+', '+', '+', '-', '+', '+', '+', '+', '+', '+'},
            {'+', '+', '+', '-', '+', '+', '+', '+', '+', '+'},
            {'+', '+', '+', '-', '-', '-', '-', '-', '+', '+'},
            {'+', '+', '+', '-', '+', '+', '-', '+', '+', '+'},
            {'+', '+', '+', '+', '+', '+', '-', '+', '+', '+'},
            {'+', '+', '+', '+', '+', '+', '-', '+', '+', '+'},
            {'+', '+', '+', '+', '+', '+', '-', '+', '+', '+'},
            {'+', '+', '+', '+', '+', '+', '+', '+', '+', '+'}
        };

        // Initialize words as char[][] directly
        char[][] words = {
            {'P', 'O', 'L', 'A', 'N', 'D'},
            {'L', 'H', 'A', 'S', 'A'},
            {'S', 'P', 'A', 'I', 'N'},
            {'I', 'N', 'D', 'I', 'A'}
        };
        solve(grid,words,0,0);
        for(int i=0;i<grid[i].length;i++){
            System.out.println(grid[i]);
        }
    }
}
