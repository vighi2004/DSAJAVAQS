//snakes and ladders game.
package Graphs;
import java.util.*;
public class SnakesAndLadders {
    static class pair{
        int position;
        int step;
        public  pair(int position,int step){
            this.position=position;
            this.step=step;
        }
    }
    public static int getMinDiceThrows(int board[][]){
       int n=board.length;
       int L2R=1;
       int game[]=new int[n*n];
       boolean visited[]=new boolean[n*n];
       Arrays.fill(game,-1);
       int index=0;
       //lets connvert the 2d array to 1d array.
       for(int row=n-1;row>=0;row--){
          if(L2R%2!=0){
             //left to right
             for(int col=0;col<n;col++){
                if(board[row][col]!=-1){
                    game[index]=board[row][col];
                }
                index++;
             }
          }
          else{
            //right to left
             for(int col=n-1;col>=0;col--){
                if(board[row][col]!=-1){
                    game[index]=board[row][col];
                }
                index++;
             }
            }
            L2R++;
       }
       //lets play game and check the minimum number of steps required to reach the end.
       Queue<pair> q=new LinkedList<>();
       q.add(new pair(0, 0));
       visited[0]=true;
       while(!q.isEmpty()){
        pair curr=q.poll();
        int pos=curr.position;
        if(pos==n*n-1){
          return curr.step;
        }
        for(int dice=1;dice<7;dice++){
            int nextpos=pos+dice;
            if(nextpos>=n*n){
                break;
            }
            if(game[nextpos]!=-1){
                nextpos=game[nextpos];
            }
            if(!visited[nextpos]){
                visited[nextpos]=true;
                q.add(new pair(nextpos, curr.step + 1));
            }
        }
       }
       return -1;
               
    }
    public static void main(String[] args) {
        int  board[][] = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        System.out.println("Minimum number of dice throws required is " + getMinDiceThrows(board));
    }
    
}
