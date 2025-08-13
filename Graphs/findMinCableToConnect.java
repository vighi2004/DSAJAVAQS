//finding minimum cables required to connect all computers in network.
package Graphs;
import java.util.*;
public class findMinCableToConnect {
    static class edge{
        int src;
        int dest;
        public edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static int solve(ArrayList<edge>[] graph,int n,int c){
        if(c<n-1){
            System.out.println("Not enough cables to connect all computers.");
            return -1;
        }
        int count=0;
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i,graph,visited);
            }
        }
        return count-1;
    }
    public static void dfs(int curr,ArrayList<edge>[] graph,boolean visited[]){
        visited[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(e.dest, graph, visited);
            }
        }
    }
    public static void main(String[] args) {
        int n=4;
        int connection[][]={{0,1},{0,2},{1,2}};
        @SuppressWarnings("unchecked")
         ArrayList<edge>[] graph=new ArrayList[n]; 
           for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();//creating empty list at particular index
        }
        for(int i=0;i<connection.length;i++){
            int src=connection[i][0];
            int dest=connection[i][1];
            graph[src].add(new edge(src, dest));
            graph[dest].add(new edge(dest, src)); //undirected graph
        }
        System.out.println(solve(graph,n,connection.length));
    }
}
