//Minimum steps required to reach target for knight.
package Graphs;
import java.util.*;
public class StepsByKnight {
    static class info{
        int i;
        int j;
        int steps;
        public info(int i,int j,int steps){
            this.i=i;
            this.j=j;
            this.steps=steps;
        }
    }
    public static void main(String[] args) {
        int n=6;
        int arr[][]=new int[n+1][n+1];//start 1 indexing  
        int knightPos[]={4,5};
        int target[]={1,1};
        arr[knightPos[0]][knightPos[1]]=1;
        Queue <info> q =new LinkedList<>();
        q.add(new info(knightPos[0],knightPos[1], 0));
        while(!q.isEmpty()){
            info curr=q.poll();
            if(curr.i==target[0]&&curr.j==target[1]){
                System.out.println("Minimum Steps Required: "+curr.steps);
                break;
            }
             //8 position
             int[] di = {-2, -2, -1, -1, 1, 1, 2, 2};
             int[] dj = {-1, 1, -2, 2, -2, 2, -1, 1};

             for(int k = 0; k < 8; k++){
                 int ni = curr.i + di[k];
                 int nj = curr.j + dj[k];

                  // Check bounds and if not visited
                 if(ni >= 1 && ni <= n && nj >= 1 && nj <= n && arr[ni][nj] == 0){
                     arr[ni][nj] = 1; // mark visited
                     q.add(new info(ni, nj, curr.steps + 1));
        }
    }
             
        }
    }
    
}
