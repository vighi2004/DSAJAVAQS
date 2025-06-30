//finding articulation points using Tarjans Algorithm.
package Graphs;
import java.util.*;
public class ArticulationPoint {
    static class edge{
        int src;
        int dest;

        public edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    static int time=0;
     public static void  AP(ArrayList<edge>[] graph){
        boolean visitArr[]=new boolean[graph.length];
        //discovery time
        int dt[]=new int[graph.length];
        //lower time
        int lt[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visitArr[i]){
              dfs(graph,dt,lt,visitArr,i,-1);
            }
        }
    }
    public static void dfs(ArrayList<edge>[] graph,int dt[],int lt[],boolean vis[],int curr,int par){
    int children=0;
    vis[curr]=true;
    dt[curr]=lt[curr]=++time;
    for(int i=0;i<graph[curr].size();i++){
        edge e=graph[curr].get(i);
        if(par==e.dest){
            continue;
        } 
        else if(vis[e.dest]){
               lt[curr]=Math.min(lt[curr], dt[e.dest]);  
        }
        else{
            dfs(graph, dt, lt, vis, e.dest, curr);
            lt[curr]=Math.min(lt[curr],lt[e.dest]);
            if(par!=-1&&dt[curr]<=lt[e.dest]){
               System.out.println("AP is: "+curr);
            }
            children++;
        } 
    }
    if(par==-1&&children>1){
        System.out.println("AP is: "+curr);
    }

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

        AP(graph);
    }
}
