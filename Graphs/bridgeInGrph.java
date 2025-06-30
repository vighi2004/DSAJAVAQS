//finding bridge in graph.0(V+E)
package Graphs;
import java.util.*;
public class bridgeInGrph {
    static class edge{
        int src;
        int dest;

        public edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    static int time=0;
    public static void  dfs(ArrayList<edge>[] graph){
        boolean visitArr[]=new boolean[graph.length];
        //discovery time
        int dt[]=new int[graph.length];
        //lower time
        int lt[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visitArr[i]){
              TarjanALgo(graph,dt,lt,visitArr,i,-1);
            }
        }
    }
    //modified dfs
    public static void TarjanALgo(ArrayList<edge>[] graph,int dt[],int lt[],boolean vis[],int curr,int par){
         vis[curr]=true;
        dt[curr] = lt[curr] = ++time;
         for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            if(e.dest==par){
                continue;//ignoring this case because this tells extra path is their to go so no brideg form.
            }
            else if(!vis[e.dest]){
                TarjanALgo(graph, dt, lt, vis,e.dest,curr);
                lt[curr]=Math.min(lt[curr], lt[e.dest]);
                if(dt[curr]<lt[e.dest]){
                    Bridge(curr, e.dest);
                }
            }
            else {
                    lt[curr]=Math.min(lt[curr],dt[e.dest]);//back edge means is any other bridge is link.(neighbor is already visited but not the parent) 
                }
            
         }
   } 
    public static void Bridge(int curr,int dest){
        System.out.println("Bridge in form between:  "+curr+"----"+dest);
        
    }
    public static void main(String[] args) {
        int V=6;
        @SuppressWarnings("unchecked")
        ArrayList<edge>[] graph=new ArrayList[V];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
          //0 vertex
        graph[0].add(new edge(0, 1));
        graph[0].add(new edge(0, 2));
        graph[0].add(new edge(0, 3));

        //1 vertex
        graph[1].add(new edge(1, 0));
        graph[1].add(new edge(1, 2));
    
        //2 vertex
        graph[2].add(new edge(2, 1));
        graph[2].add(new edge(2, 0));

        //3 vertex
        graph[3].add(new edge(3, 0));
        graph[3].add(new edge(3, 4));
        //graph[3].add(new edge(3, 5));

        //4 vertex
        graph[4].add(new edge(4, 3));
        //graph[4].add(new edge(4, 5));

        // //5 vertex
        // graph[5].add(new edge(5, 3));
        // graph[5].add(new edge(5, 4));
        dfs(graph);

    }
    
}
