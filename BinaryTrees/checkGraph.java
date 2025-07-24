//check whether graph is tree or not.
package BinaryTrees;
import java.util.*;
public class checkGraph {
    static class edge{
        int src;
        int dest;

        public edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static boolean checkTree(ArrayList<edge>[] graph){
        boolean visited[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(dfs(i,visited,graph,-1)){;
                return false;//means cycle detect no tree form.
            }}
        }
        for(int i=0;i<visited.length;i++){
            if(visited[i]==false){
                return false;//means noot connected
            }
        }
        return true;
    }
    public static boolean dfs(int curr,boolean visited[],ArrayList<edge>[] graph,int par){
      visited[curr]=true;
      for(int i=0;i<graph[curr].size();i++){
        edge e=graph[curr].get(i);
        if(!visited[e.dest]){
            if(dfs(e.dest, visited, graph,curr)){
                return true;
            }
        }
        else if(visited[curr]&&e.dest!=par){
              return true;
        }
    }
    return false;
    }
    public static void main(String[] args) {
         int V=5;
          @SuppressWarnings("unchecked")
        ArrayList<edge>[] graph=new ArrayList[V]; 
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();//creating empty list at particular index
        }

        //     0----3       
        //   / |    |
        //  /  |    |
        // 1   |    4
        //  \  |
        //   \ |
        //     2
         //0 vertex
        graph[0].add(new edge(0, 1));
        graph[0].add(new edge(0, 2));
        graph[0].add(new edge(0, 3));

        //1 vertex
        graph[1].add(new edge(1, 0));
        graph[1].add(new edge(1, 2));

        //2 vertex
        graph[2].add(new edge(2, 0));
        graph[2].add(new edge(2, 1));

        //3 vertex
        graph[3].add(new edge(3, 0));
        graph[3].add(new edge(3, 4));

        //4 vertex
        graph[4].add(new edge(4, 3));
        System.out.println(checkTree(graph));
        
        
    }
}
