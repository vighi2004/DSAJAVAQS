//implementation of kruskal's algorithm using greedy appraoch.Time=O(V+ELOGE)
package Graphs;
import java.util.*;
public class kruskalLAlgo {
    static class edge implements Comparable<edge>{
        int src;
        int dest;
        int wt;
        public edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
        @Override
        public int compareTo(edge e2){
            return this.wt-e2.wt;
        }
    }
      static int n=4;//vertices
      static int par[]=new int[n];
      static int rank[]=new int[n];
      public static void init(){
        for(int i=0;i<n;i++){
            par[i]=i;
        }
      }
      public static int find(int x){
        if(x==par[x]){
            return x;
        }
        return par[x]=find(par[x]);
    }
    public static void union(int a,int b){
         int parA=find(a);
         int parB=find(b);

         if(rank[parA]==rank[parB]){
            par[parB]=parA;
            rank[parA]++;
         }
         else if(rank[parA]>rank[parB]){
            par[parB]=parA;
         }
         else{
            par[parA]=parB;
         }
    }
    public static int  kruskalMST(ArrayList<edge> edges,int V){
         init();
         Collections.sort(edges);//O(ELOGE)
         int count=0;
         int mincost=0;
         for(int i=0;count<V-1;i++){//O(V)
            edge e=edges.get(i);
            int parA=find(e.src);
            int parB=find(e.dest);
            if(parA!=parB){//no cycle condition
              union(e.src, e.dest);
              mincost+=e.wt;
              count++;
            }
        }
        return mincost;
             
         }
    public static void main(String[] args) {
        int V=4;//vertices
        ArrayList<edge> edges=new ArrayList<>(); 
        edges.add(new edge(0, 1, 10));
        edges.add(new edge(0, 2, 15));
        edges.add(new edge(0, 3, 30));
        edges.add(new edge(1, 3, 40));
        edges.add(new edge(2, 3, 50));
        

        System.out.println("min cost is: "+kruskalMST(edges, V));  
    }
    
}
