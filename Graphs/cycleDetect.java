//cycle detect using DFS.
package Graphs;
import java.util.*;
public class cycleDetect {
    static class edge{
        int src;
        int dest;
        public edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static boolean detectCycle(ArrayList<edge>[] graph){
           boolean visitArr[]=new boolean[5];
           int currdepth[]=new int[5];
           for(int i=0;i<currdepth.length;i++){
              currdepth[i]=-1;
           }
           for(int i=0;i<graph.length;i++){
              if(!visitArr[i]){
                  if(detectCycleUtil(graph,i,-1,visitArr,currdepth,0)){
                      return true;//if any one component of graph exist cycle.
                  }
              }
           }
           return false;
    }
    public static boolean detectCycleUtil(ArrayList<edge>[] graph,int curr,int par,boolean[] visitArr,int currdepth[],int depth){//O(V+E).
           visitArr[curr]=true;
           currdepth[curr]=depth;
           for(int i=0;i<graph[curr].size();i++){
             edge e=graph[curr].get(i);
             //case 3
             if(!visitArr[e.dest]){
                if(detectCycleUtil(graph, e.dest, curr, visitArr,currdepth,depth+1)){
                 return true;
                }
              }
             //case 1
             else if(visitArr[e.dest]&&e.dest!=par){
                int dp=currdepth[curr]-currdepth[e.dest]+1;
                System.out.println("cycle length: "+dp);              
                return true;
             }
             //case 2- continue do nothing.  
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
        //graph[0].add(new edge(0, 2));
        graph[0].add(new edge(0, 3));

        //1 vertex
        graph[1].add(new edge(1, 0));
        graph[1].add(new edge(1, 2));

        //2 vertex
        //graph[2].add(new edge(2, 0));
        graph[2].add(new edge(2, 1));

        //3 vertex
        graph[3].add(new edge(3, 0));
        graph[3].add(new edge(3, 4));

        //4 vertex
        graph[4].add(new edge(4, 3));


        System.out.println(detectCycle(graph));
        
    }
    
}
