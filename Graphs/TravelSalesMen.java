//Travelling salesman problem using Graph time-O(n!)
package Graphs;
import java.util.*;
public class TravelSalesMen {
    static class edge{
        int src;
        int dest;
        int cost;
        edge(int s,int d,int c){
            this.src=s;
            this.dest=d;
            this.cost=c;
        }
    }
    public static void getPath(ArrayList<edge>[] graph ,int src){
            boolean visit[]=new boolean[graph.length];
            int min=Integer.MAX_VALUE;
            System.out.println("minimum cost is:"+TSP(graph,src,src,visit,0,0,min));
    }
    public static int TSP(ArrayList<edge>[] graph,int curr,int src,boolean visit[],int count,int cost,int min){
         if(count==graph.length-1){
            for(edge e:graph[curr]){
                if(e.dest==src){
                    min=Math.min(min,cost+e.cost);
                }
            }
            return min;
        }
            visit[curr]=true;
            
            for(edge e:graph[curr]){
                if(!visit[e.dest]){
                  min=Math.min(min,TSP(graph, e.dest, src, visit, count+1, cost+e.cost, min));
                }
            }
            visit[curr]=false;
            return min;    
        }
      public static void main(String[] args) {
        int cost[][] = {{0, 1000, 5000}, {5000, 0, 1000}, {1000, 5000, 0}};
        @SuppressWarnings("unchecked")
        ArrayList<edge>[] graph=new ArrayList[cost.length];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<cost.length;i++){
            for(int j=0;j<cost[i].length;j++){
                int src=i;
                int dest=j;
                int c=cost[i][j];
                if(c!=0){
                    graph[src].add(new edge(src,dest,c));
                }
            }}
            getPath(graph,0);
    }    
}
