//Find if there is a path of more than k weight from a source.
package Graphs;
import java.util.*;
public class PathFindMoreKwt {
     static class edge{
        int src;
        int dest;
        int wt;
        public edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    public static boolean findPath(ArrayList<edge>[] graph,int src,int k){
        boolean visit[]=new boolean[graph.length];
      if(dfs(graph,src,k,0,visit)){
          return true;
      }
      return false;
        

    }
    public static boolean dfs(ArrayList<edge>[] graph,int curr,int k,int ans,boolean[] visit){
        if(ans>k){
            return true;
        }
        visit[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            if(!visit[e.dest]){
               if(dfs(graph, e.dest, k, (ans+e.wt),visit)){
                     return true;
               }
            }
        }
        visit[curr]=false;//backtrack.
        return false;

    }
    public static void main(String[] args) {
        int  source = 0;
        int  k = 62;
        int edgeList[][] = {{0, 1, 4}, {0, 7, 8}, {1, 7, 11}, {1, 2, 8}, {2, 8, 2}, {8, 6, 6}, {6, 7, 1}, {7, 8, 7}, {2, 3, 7}, {2, 5, 4}, {5, 6, 2}, {3, 5, 14}, {3, 4, 9}, {4, 5, 10}};
        @SuppressWarnings("unchecked")
        ArrayList<edge>[] graph=new ArrayList[9];
        for(int i=0;i<9;i++){
		    graph[i]=new ArrayList<>();
		}
        for(int i=0;i<edgeList.length;i++){
            int src=edgeList[i][0];
            int dest=edgeList[i][1];
            int wt=edgeList[i][2];
            graph[src].add(new edge(src, dest, wt));
            graph[dest].add(new edge(dest, src, wt));//undirected making
        }
        System.out.println("is more then weight k path exist? "+findPath(graph,source,k));
    }
    
}
