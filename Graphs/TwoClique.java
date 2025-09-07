//check if a graph can be divided into two cliques
package Graphs;
import java.util.*;
public class TwoClique {
    static class edge{
        int src;
        int dest;
        edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static boolean checkBipartite(ArrayList<edge>[] graph){
    int col[] = new int[graph.length];
    Arrays.fill(col, -1);

    for(int i=0; i<graph.length; i++){
        if(col[i] == -1){  // not yet colored → start BFS
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            col[i] = 0; // start with color 0

            while(!q.isEmpty()){
                int curr = q.remove();

                for(edge e : graph[curr]){
                    if(col[e.dest] == -1){
                        if(col[curr] == 0){
                            col[e.dest] = 1;
                        } else {
                            col[e.dest] = 0;
                        }
                        q.add(e.dest);
                    }
                    else if(col[e.dest] == col[curr]){
                        return false; // same color conflict → not bipartite
                    }
                }
            }
        }
    }
    return true;
}

    public static void main(String[] args) {
        int G[][]={{0,1,1,1,0},{1,0,1,0,0},{1,1,0,0,0},{1,0,0,0,1},{0,0,0,1,0}};
        int v=G.length;
        for(int i=0;i<G.length;i++){
            for(int j=0;j<G[i].length;j++){
                if(G[i][j]==0&&i!=j){
                    G[i][j]=1;
                }
                else{
                    G[i][j]=0;
                }
            }
        }
        @SuppressWarnings("unchecked")
        ArrayList<edge>[] graph=new ArrayList[v];//complement graph
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<G.length;i++){
            for(int j=0;j<G[i].length;j++){
                if(G[i][j]==1){
                    graph[i].add(new edge(i,j));
                }
            }
        }
        System.out.println("Do we form 2 cliques?: "+checkBipartite(graph));
    }
    
}
