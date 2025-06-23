//detecting cycle on directed graph using stack.Time=O(V+E)
package Graphs;
import java.util.*;
public class cycleDetectDirectG {
    static class edge{
        int src;
        int dest;

        public edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static boolean isCycle(ArrayList <edge>[] graph){
            boolean visitArr[]=new boolean[graph.length];
            boolean stack[]=new boolean[graph.length];
           for(int i=0;i<graph.length;i++){
              if(!visitArr[i]){
                  if(detectCycleUtil(graph,i,visitArr,stack)){
                      return true;//if any one component of graph exist cycle.
                  }
              }
           }
           return false;
    }
    public static boolean detectCycleUtil(ArrayList <edge>[] graph,int curr,boolean visitArr[],boolean stack[]){
        visitArr[curr]=true;
        stack[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            else if(!visitArr[e.dest]&&detectCycleUtil(graph, e.dest, visitArr, stack)){
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }
    public static void main(String[] args) {
        int V=4;

        // 1----->0<----3
        //        |     ^
        //        |    /
        //        |   /  cycle is form.
        //        V  /
        //        2 /
        @SuppressWarnings("unchecked")
        ArrayList<edge>[] graph=new ArrayList[V]; 
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();//creating empty list at particular index
        }
         //0 vertex
        graph[0].add(new edge(0,2));

        //1 vertex
        graph[1].add(new edge(1, 0));

        //2 vertex
        graph[2].add(new edge(2, 3));

        //3 vertex
        graph[3].add(new edge(3, 0));

        System.out.println(isCycle(graph));
    }
}
