//checking if graph can form Bipartite using colour and BFS approach.
package Graphs;
import java.util.*;
public class BipartiteGrph {
    static class edge{
        int src;
        int dest;

        public edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static boolean isBipartite(ArrayList <edge>[] graph){
        int colorV[]=new int[graph.length];
        for(int i=0;i<colorV.length;i++){
            colorV[i]=-1;//no color.
        }
        Queue <Integer> Q=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
              if(colorV[i]==-1){
                Q.add(i);
                colorV[i]=0;//black
                while(!Q.isEmpty()){
                    int curr=Q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        edge e=graph[curr].get(j);
                        if(colorV[e.dest]==-1){
                            if(curr==0){
                                colorV[e.dest]=1;//white
                            }
                            else{
                                colorV[e.dest]=0;
                            }
                            Q.add(e.dest);
                        }
                        else if(colorV[e.dest]==colorV[curr]){
                            return false;
                        }
                    }       
            }}
        }
        return true;
    }
    public static void main(String[] args) {
        int V=7;
          @SuppressWarnings("unchecked")
        ArrayList<edge>[] graph=new ArrayList[V]; 

        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();//creating empty list at particular index
        }
         //0 vertex
        graph[0].add(new edge(0, 1));
        graph[0].add(new edge(0, 2));

        //1 vertex
        graph[1].add(new edge(1, 0));
        graph[1].add(new edge(1, 3));

        //2 vertex
        graph[2].add(new edge(2, 0));
        graph[2].add(new edge(2, 4));

        //3 vertex
        graph[3].add(new edge(3, 1));
        //graph[3].add(new edge(3, 4));

        //4 vertex
        graph[4].add(new edge(4, 2));
        //graph[4].add(new edge(4, 3));
        System.out.println(isBipartite(graph));
        //if there is no cycle its always Bipartite graph.

    }
    
}
