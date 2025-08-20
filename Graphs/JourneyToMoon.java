//The member states of the UN are planning to send  people to the moon. They want them to be from different countries. You will be given a list of pairs of astronaut ID's. Each pair is made of astronauts from the same country. Determine how many pairs of astronauts from different countries they can choose from.
package Graphs;
import java.util.*;
public class JourneyToMoon {
    static class edge{
        int src;
        int dest;
        public edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public static int countPairs(ArrayList<edge>[] graph,int n){
        boolean visit[]=new boolean[n];
        ArrayList<Integer> sizes = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!visit[i]){
                int size=dfs(graph, visit, i);
                sizes.add(size);
            }
        }
        int valid_pairs=n*(n-1)/2;
        int same_pairs=0;
        for(int size:sizes){
            same_pairs+=size*(size-1)/2;
        }
        int totalpairs=valid_pairs-same_pairs;
        return totalpairs;
    }
    public static int dfs(ArrayList<edge>[] graph,boolean[] visit,int curr){
       visit[curr]=true;
        int size=1;
        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            if(!visit[e.dest]){
                size+=dfs(graph, visit,e.dest);
            }
        }
        return size;
    }
    public static void main(String[] args) {
        int n=5;
        int[][] astronaut = {{0, 1}, {2, 3}, {0, 4}};
        //making graph
        @SuppressWarnings("unchecked")
        ArrayList<edge>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();//creating empty list at particular index
        }
        for(int i=0;i<astronaut.length;i++){
           int src=astronaut[i][0];
           int dest=astronaut[i][1];
           graph[src].add(new edge(src, dest));
           graph[dest].add(new edge(dest, src)); // since it's undirected graph
        }
        System.out.println("Total pairs of astronauts from different countries: " + countPairs(graph, n));

    }
    
}
