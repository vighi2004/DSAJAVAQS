//prim's algorithm.finidng miminum spanning tree cost.
package Graphs;
import java.util.*;
public class primsAlgo {
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
        int cost;//distance

        public pair(int n,int c){
            this.n=n;
            this.cost=c;
        }
        @Override
        public int compareTo(pair p2){
            return this.cost-p2.cost;//ascending order.
        }
    }
    public static int mincost=0; 
    public static void MST(ArrayList<edge>[] graph,int src){
         boolean visit[]=new boolean[graph.length];
         PriorityQueue <pair> PQ=new PriorityQueue<>();
         PQ.add(new pair(src,0));
         while(!PQ.isEmpty()){
            pair curr=PQ.remove();
            if(!visit[curr.n]){
                mincost=mincost+curr.cost;
                visit[curr.n]=true;
                for(int i=0;i<graph[curr.n].size();i++){
                    edge e=graph[curr.n].get(i);
                    System.out.println(curr.n+"->"+e.dest+"="+e.wt);
                    PQ.add(new pair(e.dest, e.wt));
                }

            }
         }
         System.out.println("min cost is: "+mincost);

    }
    public static void main(String[] args) {
        int V=4;
        @SuppressWarnings("unchecked")
        ArrayList<edge>[] graph=new ArrayList[V]; 
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();//creating empty list at particular index
        }
        //0 vertex
        graph[0].add(new edge(0, 1, 10));
        graph[0].add(new edge(0, 2, 15));
        graph[0].add(new edge(0, 3, 30));

        //1 vertex
        graph[1].add(new edge(1, 0, 10));
        graph[1].add(new edge(1, 3, 40));

        //2 vertex
        graph[2].add(new edge(2, 0, 15));
        graph[2].add(new edge(2, 3, 50));

        //3 vertex
        graph[3].add(new edge(3, 0, 30));
        graph[3].add(new edge(3, 1, 40));
        graph[3].add(new edge(3, 2, 50));

        MST(graph,0);
    }
}
