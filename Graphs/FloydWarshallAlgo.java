//All pairs shortest path using floyd warshall algorithm.Time-O(V^3).
package Graphs;
public class FloydWarshallAlgo {
    static int V=4;
    static int INF=9999999;
    public static void findPath(int graph[][]){
        int dist[][]=new int[V][V];
        int i, j, k;
        for (i = 0; i < V; i++){
            for (j = 0; j < V; j++){
                dist[i][j] = graph[i][j];
            }}
        for(k=0;k<V;k++){
             for (i = 0; i < V; i++){
                 for (j = 0; j < V; j++){
                    if(dist[i][k]+dist[k][j]<dist[i][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
        }}}
        print(dist);    

    }
    public static void print(int dist[][]){
        System.out.println(
                     "The following matrix shows the shortest "
                    + "distances between every pair of vertices");
         for (int i = 0; i < V; i++){
            for (int j = 0; j < V; j++){
                if (dist[i][j] == INF)
                   System.out.print("INF ");
                else
                  System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int graph[][] = { { 0, 8, INF, 1 },
                          { INF, 0, 1, INF },
                          { 4, INF, 0, INF },
                          { INF,2,9, 0 } };
        findPath(graph);                  
    }
    
}
