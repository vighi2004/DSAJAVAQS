//cheapest flight at k stops find cost.
package Graphs;
import java.util.*;
public class cheapestFlight {
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
    static class info implements Comparable<info>{
        int n;//node
        int path;//distance
        int stop;

        public info(int n,int p,int s){
            this.n=n;
            this.path=p;
            this.stop=s;
        }
        @Override
        public int compareTo(info p2){
            return this.stop-p2.stop;//ascending order.
        }
    }
    public static void cost(ArrayList<edge>[] graph,int src,int dest,int k){
        int dist[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        Queue<info> Q=new LinkedList<>();
        Q.add(new info(src, 0,0));
        //bfs
        while(!Q.isEmpty()){
         info curr=Q.remove();
         if(curr.stop>k){
            break;
         }
            for(int i=0;i<graph[curr.n].size();i++){
                 edge e=graph[curr.n].get(i);
                 int u=e.src;
                 int v=e.dest;
                 int wt=e.wt;
                 if(dist[u]!=Integer.MAX_VALUE&&curr.path+wt<dist[v]&&curr.stop<=k){
                    dist[v]=curr.path+wt;
                    Q.add(new info(v, dist[v],curr.stop+1));
                 }
            }
         }
        if(dist[dest]==Integer.MAX_VALUE){
            System.out.println("not found");
            return;
        }
        else{
            System.out.println("0 -> "+dest +"= "+dist[dest]);
            return;
        }
    }
    public static void main(String[] args) {
        int flights[][]={{0,1,100},{1,2,100},{0,2,500}};
        int V=flights.length;
         @SuppressWarnings("unchecked")
        ArrayList<edge>[] graph=new ArrayList[V]; 
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();//creating empty list at particular index
        }
        for(int i=0;i<V;i++){
            int from=flights[i][0];
            int to=flights[i][1];
            int cost=flights[i][2];
            graph[from].add(new edge(from, to, cost));

        }

        int src=0;
        int dest=2;
        int k=1;
        cost(graph,src,dest,k);
        
    }    
}

