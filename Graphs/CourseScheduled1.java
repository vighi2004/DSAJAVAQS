//Check if it is possible to finish all task from given dependencies (Course Schedule I)
package Graphs;
import java.util.*;
public class CourseScheduled1 {
    static class edge{
        int src;
        int dest;
        public edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void  solve(ArrayList <edge>[] graph){
              int i=0;
               for(int j=0;j<graph[i].size();j++){
                     edge e=graph[i].get(j);
                     if(e.dest==i){
                        System.out.println("cycle detect it is impossible to complete task");
                        return;
                     }
               }
               System.out.println("It is possible to do all task");
               return;
          }
    public static void main(String[] args) {
        int task[][]={{1,0},{2,1},{3,2}};
        int n=4;
        @SuppressWarnings("unchecked")
        ArrayList<edge>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();//creating empty list at particular index
        }
        for(int i=0;i<task.length;i++){
           int src=task[i][1];
           int dest=task[i][0];
           graph[src].add(new edge(src, dest));
        }
        solve(graph);

    }
    
}
