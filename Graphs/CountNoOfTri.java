//count unique number of triangles in DAG or UNDAD.
package Graphs;
import java.util.*;
public class CountNoOfTri {
    static class edge{
        int src;
        int dest;
        public edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static int triangleCount=0;
    public static boolean isDirected(int digraph[][]){
          for(int i=0;i<digraph.length;i++){
            for(int j=0;j<digraph[0].length;j++){
                if(digraph[i][j]!=digraph[j][i]){
                    return true;//directed graph.
                 }
            }
           }
    return false;//it is undirected then.   
    }
    //for directed graph
    public static int CountDirected( ArrayList<edge>[] graph){
        triangleCount=0;
       for(int i=0;i<graph.length;i++){
            dfs(i,i,1,graph);
       }
       return triangleCount/3;
    }
     //for undirected graph
    public static int CountUnDirected( ArrayList<edge>[] graph){
        triangleCount=0;
       for(int i=0;i<graph.length;i++){
            dfs(i,i,1,graph);
       }
       return triangleCount/6;
    }
    //dfs logic
    public static void dfs(int start,int curr,int depth,ArrayList<edge>[] graph){
        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            if(depth==3&&e.dest==start){
                triangleCount++;
                return;
            }
            if(depth<3){
            dfs(start, e.dest, depth+1, graph);
        }}
    }
    public static void main(String[] args) {
         int V=4;
         int digraph[][] = { {0, 0, 1, 0},
                           {1, 0, 0, 1},
                           {0, 1, 0, 0},
                           {0, 0, 1, 0}
                          };
          @SuppressWarnings("unchecked")
          ArrayList<edge>[] graph=new ArrayList[V]; 
           for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();//creating empty list at particular index
        }
        for(int i=0;i<digraph.length;i++){
            for(int j=0;j<digraph[0].length;j++){
                if(digraph[i][j]==1){
                    graph[i].add(new edge(i, j));
                }
            }
        }
    
        if(isDirected(digraph)){
            System.out.println("This is Directed Graph");
            System.out.println("Triangles possible are:- "+CountDirected(graph));
        }
        else{
           System.out.println("This is UnDirected Graph");
          System.out.println("Triangles possible are:- "+CountUnDirected(graph));
        }
              
    }
    
}
