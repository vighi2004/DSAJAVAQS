//Topological sorting using kahn's algorithm for BFS.
package Graphs;
import java.util.*;
public class topoSortBFS {
     static class edge{
        int src;
        int dest;

        public edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void calculateIndegree(ArrayList <edge>[] graph,int indegree[]){
        for(int i=0;i<graph.length;i++){
            int V=i;
            for(int j=0;j<graph[V].size();j++){
                edge e=graph[V].get(j);
                indegree[e.dest]++;
            }
        }
    }
    public static void topoSort(ArrayList <edge>[] graph){
            int indegree[]=new int[graph.length];
            calculateIndegree(graph,indegree);
            Queue <Integer> Q=new LinkedList<>();
            for (int i = 0; i < indegree.length; i++) {
               if (indegree[i] == 0) {
                  Q.add(i);
               }
            }
           System.out.print("Topological sort is: ");
           //BFS
           while(!Q.isEmpty()){
              int curr=Q.remove();
              System.out.print(" "+curr);
              for(int i=0;i<graph[curr].size();i++){
                edge e=graph[curr].get(i);
                 indegree[e.dest]--;
                 if(indegree[e.dest]==0){
                    Q.add(e.dest);
                 }
              }
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

        //1 vertex

        //2 vertex
        graph[2].add(new edge(2, 3));

        //3 vertex
        graph[3].add(new edge(3, 1));

        //4 vertex
        graph[4].add(new edge(4, 0));
        graph[4].add(new edge(4, 1));

        //5 vertex
        graph[5].add(new edge(5, 0));
        graph[5].add(new edge(5, 2));

        topoSort(graph);
        
    }    
}
