//bellaman ford algo.time=O(V*E).
package Graphs;
import java.util.*;
public class BellamanFordAlgo {
    static class edge{
        int src;
        int dest;
        int wt;
        public edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
     public static void srcToAlldest(ArrayList<edge>[] graph,int src){
        int dist[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        int V=graph.length;
        for(int v=0;v<V-1;v++){//then time is O(V*E).
            //for edge time is O(E).
            for(int E=0;E<graph.length;E++){   
                for(int i=0;i<graph[E].size();i++){
                    edge e=graph[E].get(i);
                    int u=e.src;
                    int vi=e.dest;
                    int wt=e.wt;
                    if(dist[u]!=Integer.MAX_VALUE &&dist[u]+wt<dist[vi]){
                         dist[vi]=dist[u]+wt;
                    }
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            System.out.println("0 -> "+i +"= "+dist[i]);
        } 

        }
    public static void main(String[] args) {
        int V=6;
        @SuppressWarnings("unchecked")
        ArrayList<edge>[] graph=new ArrayList[V]; 
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();//creating empty list at particular index
        }
        //0 vertex
        graph[0].add(new edge(0, 1, 2));
        graph[0].add(new edge(0, 2, 4));

        //1 vertex
        graph[1].add(new edge(1, 2, -4));

        //2 vertex
        graph[2].add(new edge(2, 3, 2));

        //3 vertex
        graph[3].add(new edge(3, 4, 4));

        //4 vertex
        graph[4].add(new edge(4, 1, -1));

        srcToAlldest(graph,0);
        
    }    
}
