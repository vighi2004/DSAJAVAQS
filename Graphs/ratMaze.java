//Rat maze problem using dfs.time=O(N*M),space same.
package Graphs;
public class ratMaze {
    public static void fill(int fills[][],int sr,int sc,String str,boolean visit[][]){
         if (sr < 0 || sc < 0 || sr >= fills.length || sc >= fills[0].length || 
            visit[sr][sc] || fills[sr][sc] != 1) {
            return;
        }
         if (sr == fills.length - 1 && sc == fills[0].length - 1) {
           System.out.println("Path: " + str);
            return;
        }
          visit[sr][sc] = true;

        // Move in all 4 directions
        fill(fills, sr, sc - 1, str + "L", visit);
        fill(fills, sr, sc + 1, str + "R", visit);
        fill(fills, sr - 1, sc, str + "U", visit);
        fill(fills, sr + 1, sc, str + "D", visit);
        visit[sr][sc] = false;//backtrack
    }
    public static void start(int fills[][],int sr,int sc,String str){
        boolean visit[][]=new boolean[fills.length][fills[0].length];
        fill(fills, sr, sc, str, visit);
    }
    public static void main(String[] args) {
        int fills[][]={ {1,0,0,0},
                        {1,1,0,0},
                        {1,1,0,0},
                        {0,1,1,1}
                      };
        int sr=0;//starting row;
        int sc=0;//starting col;
        String str="";
        start(fills, sr, sc, str);

}    
}
