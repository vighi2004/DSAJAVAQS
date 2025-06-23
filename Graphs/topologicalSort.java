//topological sort of DAG(directed acyclic graph).Using DFS
package Graphs;
import java.util.*;
public class topologicalSort {
    static class edge{
        int src;
        int dest;

        public edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void topoSort(ArrayList <edge>[] graph){
            boolean visitArr[]=new boolean[graph.length];
            Stack <Integer> stack=new Stack<>();
           for(int i=0;i<graph.length;i++){
              if(!visitArr[i]){
                  topoSortUtil(graph,i,visitArr,stack);
              }
           }
           System.out.print("Topological sort is: ");
           while(!stack.isEmpty()){
              System.out.print(" "+stack.pop());
           }
    }
    public static void topoSortUtil(ArrayList <edge>[] graph,int curr,boolean visitArr[],Stack <Integer> stack){
        visitArr[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            if(!visitArr[e.dest]){
            topoSortUtil(graph, e.dest, visitArr, stack);
            }
    } 
    stack.push(curr);
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
