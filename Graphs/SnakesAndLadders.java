//snakes and ladders game .
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
        boolean visit[][]=new boolean[n][n];
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(board[n-1][0],0));
        visit[n-1][0]=true;
        while(!q.isEmpty()){
            pair curr=q.poll();
            int position=curr.position;
            if(position==n*n){
                return curr.step;
            }
            for(int i=1;i<6;i++){
                int nextpos=position+i;
                if(board[(nextpos)/n][(nextpos)%n]!=-1){
                     nextpos=board[(nextpos)/n][(nextpos)%n];
                    q.add(new pair(nextpos, curr.step + 1));
                    visit[(nextpos)/n][(nextpos)%n]=true;
                }
                else{
                    if(nextpos<=n*n && !visit[(nextpos)/n][(nextpos)%n]){
                        q.add(new pair(nextpos, curr.step + 1));
                        visit[(nextpos)/n][(nextpos)%n]=true;
                    }
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
