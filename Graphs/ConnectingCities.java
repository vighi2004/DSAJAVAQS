//finding minimum cost to connect the cities.
package Graphs;
import java.util.*;
public class ConnectingCities {
    static class info implements Comparable<info>{
           int n;
           int cost;
           public info(int n,int c){
           this.n=n;
           this.cost=c;
           }
         @Override
         public int compareTo(info i2){
            return this.cost-i2.cost;
         }
    }
    public static void minCost(int cities[][],int src){
        int c=0;
        boolean visit[]=new boolean[cities.length];
        PriorityQueue <info> PQ=new PriorityQueue<>();
        PQ.add(new info(src, 0));
        while (!PQ.isEmpty()) {
              info curr=PQ.remove();
              if(!visit[curr.n]){
                c=c+curr.cost;
                visit[curr.n]=true;
                for(int i=0;i<cities[curr.n].length;i++){
                    int u=curr.n;
                    int v=i;
                    int val=cities[u][v];
                    if(!visit[v]&&val!=0){
                    PQ.add(new info(v, val));
                }}
              }  
        }
        System.out.println("minimum cost is: "+c);

    }
    public static void main(String[] args) {
        int cities[][]={{0,1,2,3,4},
                        {1,0,5,0,7},
                        {2,5,0,6,0},
                        {3,0,6,0,0},
                        {4,7,0,0,0}};
         minCost(cities, 0);               
    
        


    }
    
}
