//flood algorithm.Time-(M*N)
package Graphs;
public class FloodAlgo {
    public static void fill(int fills[][],int sr,int sc,int color,boolean visit[][],int colImg){
         if (sr < 0 || sc < 0 || sr >= fills.length || sc >= fills[0].length || 
            visit[sr][sc] || fills[sr][sc] != colImg) {
            return;
        }

        // Mark and fill
        visit[sr][sc] = true;
        fills[sr][sc] = color;

        // Move in all 4 directions
        fill(fills, sr, sc - 1, color, visit, colImg); // left
        fill(fills, sr, sc + 1, color, visit, colImg); // right
        fill(fills, sr - 1, sc, color, visit, colImg); // up
        fill(fills, sr + 1, sc, color, visit, colImg); // down
    }
    public static int[][] start(int fills[][],int sr,int sc,int color){
        boolean visit[][]=new boolean[fills.length][fills[0].length];
        fill(fills,sr,sc,color,visit,fills[sr][sc]);
        return fills;
    }
    public static void main(String[] args) {
        int fills[][]={ {1,1,1},
                        {1,1,0},
                        {1,0,1},
                      };
        int sr=1;//starting row;
        int sc=1;//starting col 
        int color=2;
         int[][] result = start(fills, sr, sc, color);

        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
