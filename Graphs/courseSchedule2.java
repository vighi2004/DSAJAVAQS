//Course scheduled 2 problem of leetcode.
package Graphs;
import java.util.*;
public class courseSchedule2 {
    static class edge{
        int src;
        int dest;

        public edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        @SuppressWarnings("unchecked")
        ArrayList<edge>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        } 
          int result[]=new int[numCourses];
          int indegree[]=new int[numCourses];
          for (int[] pair : prerequisites) {
            int to = pair[0];
            int from = pair[1];
            graph[from].add(new edge(from, to));
            indegree[to]++;
        }
          Queue <Integer> Q=new LinkedList<>();
          for(int i=0;i<numCourses;i++){
             if(indegree[i]==0){
                Q.add(i);
             }
          }
          //bfs
          int i=0;
          while (!Q.isEmpty()) {
               int curr=Q.remove();
               result[i++]=curr;
               for(int k=0;k<graph[curr].size();k++){
                  edge e=graph[curr].get(k);
                  indegree[e.dest]--;
                 if(indegree[e.dest]==0){
                    Q.add(e.dest);
                 }
               }
          }
          if (i != numCourses) return new int[0];
        return result;   
     }
    public static void main(String[] args) {
        int numcourses=4;
        int[][] prerequisites = {
                                 {1, 0},
                                  {2, 0},
                                  {3, 1},
                                  {3, 2}
                                 };

        int res[]=findOrder(numcourses,prerequisites);
        for(int i=0;i<res.length;i++){
            System.out.print(" "+res[i]);
        }


    }
    
}
