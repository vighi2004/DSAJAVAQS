//return true or false hether the graph is m-colourable or not.
package Graphs;
import java.util.*;
public class MColourGR {
    static class edge{
        int src;
        int dest;
        int colour;
        public edge(int src, int dest){
            this.src = src;
            this.dest = dest;
            this.colour=-1;
        }
    }
    public static boolean isMColourable(ArrayList<edge>[] graph) {
        boolean visit[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visit[i]){
                if(!dfs(graph, visit, i, 0, 3)) {
                    return false; // If any component is not m-colourable
                }
            }
        }
        return true; // All components are m-colourable
    }
    public static boolean dfs(ArrayList<edge>[] graph, boolean[] visit, int curr, int colour, int m) {
        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            if (e.colour == -1) { // If the edge is not coloured
                e.colour = colour; // Colour the edge
            } else if (e.colour == colour) { // If the edge is already coloured with the same colour
                return false; // Not m-colourable
            }
            if (!visit[e.dest]) {
                if (!dfs(graph, visit, e.dest, (colour + 1) % m, m)) {
                    return false; // If any adjacent node cannot be coloured properly
                }
            }
        }
        return true; // Successfully coloured the component
    }
    public static void main(String[] args) {
        int n = 4; // number of vertices
        int m = 3; // number of colours
        int edges[][] = {
            {0, 1}, {1, 3}, {2, 3}, {3, 0}, {0, 2}};
          @SuppressWarnings("unchecked")
        ArrayList<edge>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();//creating empty list at particular index
        }
        for(int i=0;i<edges.length;i++){
           int src=edges[i][0];
           int dest=edges[i][1];
           graph[src].add(new edge(src, dest));
           graph[dest].add(new edge(dest, src)); // since it's undirected graph
        }
        System.out.println("Is the graph m-colourable? " + isMColourable(graph));
    }}

        
       
      