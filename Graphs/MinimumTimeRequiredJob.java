//Minimum time taken by each job to be completed given by a Directed Acyclic Graph.Time is unit time. 
package Graphs;
import java.util.*;
public class MinimumTimeRequiredJob {
    public static void main(String[] args) {
        int v=7;
        int e=7;
      @SuppressWarnings("unchecked")
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>(v);
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<>());
        }
        int edges[][]={{1,2},{2,3},{2,4},{2,5},{3,6},{4,6},{5,7}};
        for(int i=0;i<e;i++){
            int src=edges[i][0];
            int dest=edges[i][1];
            graph.get(src).add(dest);
        }
        int indegree[]=new int[v];
        for(int i=0;i<v;i++){
            for(int j:graph.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int time[]=new int[v];
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int j:graph.get(curr)){
                indegree[j]--;
                time[j]=Math.max(time[j],time[curr]+1);
                if(indegree[j]==0){
                    q.add(j);
                }
            }
        }
        for(int i=0;i<time.length;i++){
            System.out.print(" "+time[i]);
        }
    }
    
}
