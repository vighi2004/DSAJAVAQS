//Find the longest path in a directed acyclic graph
package Graphs;
import java.util.*;
public class FindLongPath{
    static class edge{
        int src;
        int dest;
        int wt;
        edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void longestPath(ArrayList<edge>[] graph,int src){
        int dist[]=new int[graph.length];
        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i]=Integer.MIN_VALUE;
            }
        }
        int Indegree[]=new int[graph.length];
        topologicalSort(graph,Indegree);
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<Indegree.length;i++){
            if(Indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
              int curr=q.remove();
              for(edge e:graph[curr]){
                  if(dist[curr]+e.wt>dist[e.dest]){
                        dist[e.dest]=dist[curr]+e.wt;
                   }
                     Indegree[e.dest]--;
                        if(Indegree[e.dest]==0){
                            q.add(e.dest);
                        } 
              }
        }
        for(int i=0;i<dist.length;i++){
            System.out.println(src+" --> "+i+" : "+dist[i]);
        }
    }
    public static void topologicalSort(ArrayList<edge>[] graph,int Indegree[]){
        for(int i=0;i<graph.length;i++){
            for(edge e:graph[i]){
                Indegree[e.dest]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<Indegree.length;i++){
            if(Indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.remove();
            System.out.print(curr+" ");
            for(edge e:graph[curr]){
                Indegree[e.dest]--;
                if(Indegree[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args) {
        int n=6;
        @SuppressWarnings("unchecked")
        ArrayList<edge>[] graph=new ArrayList[n];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new edge(0,1,5));
        graph[0].add(new edge(0,2,3));
        graph[1].add(new edge(1,3,6));
        graph[1].add(new edge(1,2,2));
        graph[2].add(new edge(2,4,4));
        graph[2].add(new edge(2,5,2));
        graph[2].add(new edge(2,3,7));
        graph[3].add(new edge(3,5,-1));
        graph[4].add(new edge(4,5,-2));
         int s=1;
         System.out.print("Following are longest distances from source vertex "+ s + " \n" );
         longestPath(graph,s); 
    }
}