//solving Dijiktras Algorithm using PQ(min hep).
package Graphs;
import java.util.*;
public class DijisktraAlgo {
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
    static class pair implements Comparable<pair>{
        int n;//node
        int path;//distance

        public pair(int n,int p){
            this.n=n;
            this.path=p;
        }
        @Override
        public int compareTo(pair p2){
            return this.path-p2.path;//ascending order.
        }
    }
    public static void srcToAlldest(ArrayList<edge>[] graph,int src){
        int dist[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        boolean visitArr[]=new boolean[graph.length];
        PriorityQueue<pair> PQ=new PriorityQueue<>();
        PQ.add(new pair(src, 0));
        //bfs
        while(!PQ.isEmpty()){
         pair curr=PQ.remove();
         if(!visitArr[curr.n]){
            visitArr[curr.n]=true;
            for(int i=0;i<graph[curr.n].size();i++){
                 edge e=graph[curr.n].get(i);
                 int u=e.src;
                 int v=e.dest;
                 int wt=e.wt;
                 if(dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                    PQ.add(new pair(v, dist[v]));
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
        graph[1].add(new edge(1, 2, 1));
        graph[1].add(new edge(1, 3, 7));

        //2 vertex
        graph[2].add(new edge(2, 4, 3));

        //3 vertex
        graph[3].add(new edge(3, 5, 1));

        //4 vertex
        graph[4].add(new edge(4, 3, 2));
        graph[4].add(new edge(4, 5, 5));

        srcToAlldest(graph,0);
        
    }    
}

