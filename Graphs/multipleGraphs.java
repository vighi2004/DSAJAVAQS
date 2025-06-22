//performing BFS,DFS operation on multiple graph component.
package Graphs;
import java.util.*;
public class multipleGraphs {
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
    public static void bfs(ArrayList<edge>[] graph){
         boolean visitArr[]=new boolean[graph.length];
         for(int i=0;i<graph.length;i++){
            if(!visitArr[i]){
                bfsUtil(graph, visitArr);
            }
         }
    }
    //BFS helper function
    public static void bfsUtil(ArrayList<edge>[] graph,boolean visitArr[]){//O(V+E)
        Queue <Integer> Q=new LinkedList<>();
        Q.add(graph[0].get(0).src);
        while(!Q.isEmpty()){
            int curr=Q.remove();
            if(visitArr[curr]==false){
                System.out.print(" "+curr);
                visitArr[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                   edge e=graph[curr].get(i);
                   Q.add(e.dest);
                }
            }
        }
    }
    public static void dfsUtil(ArrayList<edge>[] graph,int curr,boolean visitArr[]){//O(V+E)
        System.out.print(curr+" ");
        visitArr[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            if(!visitArr[e.dest]){
                dfsUtil(graph, e.dest, visitArr);
            }
        }
        
    }
    public static void main(String[] args) {
        
    }
    
}
