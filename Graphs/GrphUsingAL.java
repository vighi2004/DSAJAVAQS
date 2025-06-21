//creating graph using adjacent list.
package Graphs;
import java.util.*;
public class GrphUsingAL {
    static class edge{
        int src;
        int dest;
        int w;

        public edge(int s,int dest,int w){
            this.src=s;
            this.dest=dest;
            this.w=w;
        }
    }

    public static void main(String[] args) {
        //     (5)
        //  0-----1
        //       / \
        //  (1) /   \ (3)
        //     /     \
        //    2-------3
        //    /   (1)
        //   / (1)
        //  4 
        int V=5;
        @SuppressWarnings("unchecked")
        ArrayList<edge>[] graph=new ArrayList[V]; 
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();//creating empty list at particular index
        }
        //0 vertex
        graph[0].add(new edge(0, 1, 5));

        //1 vertex
        graph[1].add(new edge(1, 0, 5));
        graph[1].add(new edge(1, 2, 1));
        graph[1].add(new edge(1, 3, 3));

        //2 vertex
        graph[2].add(new edge(2, 1, 1));
        graph[2].add(new edge(2, 3, 1));
        graph[2].add(new edge(2, 4, 1));

        //3 vertex
        graph[3].add(new edge(3, 2, 1));
        graph[3].add(new edge(3, 1, 3));

        //4 vertex
        graph[4].add(new edge(4, 2, 1));
    
        for(int i=0;i<graph[3].size();i++){
            edge e=graph[3].get(i);
            System.out.println(e.dest);
        }
    
    
    }
}
