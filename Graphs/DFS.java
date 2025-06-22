//performing DFS.
package Graphs;
import java.util.ArrayList;
public class DFS {
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
    public static void dfs(ArrayList<edge>[] graph,int curr,boolean visitArr[]){//O(V+E)
        System.out.print(curr+" ");
        visitArr[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            if(!visitArr[e.dest]){
                dfs(graph, e.dest, visitArr);
            }
        }
        
    }
    public static void main(String[] args) {
        int V=7;
        boolean visitArr[]=new boolean[V];
          @SuppressWarnings("unchecked")
        ArrayList<edge>[] graph=new ArrayList[V]; 
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();//creating empty list at particular index
        }
         //0 vertex
        graph[0].add(new edge(0, 1, 1));
        graph[0].add(new edge(0, 2, 1));

        //1 vertex
        graph[1].add(new edge(1, 0, 1));
        graph[1].add(new edge(1, 2, 1));
        graph[1].add(new edge(1, 3, 1));

        //2 vertex
        graph[2].add(new edge(2, 0, 1));
        graph[2].add(new edge(2, 1, 1));
        graph[2].add(new edge(2, 4, 1));

        //3 vertex
        graph[3].add(new edge(3, 1, 1));
        graph[3].add(new edge(3, 4, 1));
        graph[3].add(new edge(3, 5, 1));

        //4 vertex
        graph[4].add(new edge(4, 2, 1));
        graph[4].add(new edge(4, 3, 1));
        graph[4].add(new edge(4, 5, 1));

        //5 vertex
        graph[5].add(new edge(5, 3, 1));
        graph[5].add(new edge(5, 4, 1));
        graph[5].add(new edge(5, 6, 1));

        //6 vertex
        graph[6].add(new edge(6, 5, 1));

        dfs(graph,0, visitArr);
    
    }

}

    

