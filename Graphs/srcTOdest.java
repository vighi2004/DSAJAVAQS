//printing all path from source to destination.Time-O(v^v).
package Graphs;
import java.util.*;
public class srcTOdest {
    static class edge{
        int src;
        int dest;

        public edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void path(ArrayList <edge>[] graph,int s,int d,String paths){    
          if(s==d){
            System.out.println(paths+s);
            return;
          }
           for(int i=0;i<graph[s].size();i++){
               edge e=graph[s].get(i);
               path(graph, e.dest, d, paths+s);   
        }
    }
    public static void main(String[] args) {
         int V=6;
        @SuppressWarnings("unchecked")
        ArrayList<edge>[] graph=new ArrayList[V]; 
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();//creating empty list at particular index
        }
         //0 vertex
         graph[0].add(new edge(0, 3));

        //1 vertex

        //2 vertex
        graph[2].add(new edge(2, 3));

        //3 vertex
        graph[3].add(new edge(3, 1));

        //4 vertex
        graph[4].add(new edge(4, 0));
        graph[4].add(new edge(4, 1));

        //5 vertex
        graph[5].add(new edge(5, 0));
        graph[5].add(new edge(5, 2));

        int src=5;
        int dest=1;
        String paths="";
        System.out.println("All paths are:-");
        path(graph,src,dest,paths);
        
    }
}
