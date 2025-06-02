//finding minimum cost to cut chocolated in single square.
package Greedy_Algo;
import java.util.*;
public class chocolaProb {
    public static void main(String[] args) {
        int n=4;
        int m=6;
        Integer verCost[]={2,1,3,1,4};
        Integer horCost[]={4,1,2};
        //in descending order.
        Arrays.sort(verCost,Collections.reverseOrder());
        Arrays.sort(horCost,Collections.reverseOrder());
        int h=0,v=0;//pointer for which cut should be taken.
        int hp=1,vp=1;//cuttend peices.
        int cost=0;
        while(h<horCost.length && v<verCost.length){
            //horizantal cost
            if(horCost[h]>=verCost[v]){
                cost=cost+(horCost[h]*vp);
                h++;
                hp++;
            }
            else{
                 cost=cost+(verCost[v]*hp);
                 v++;
                 vp++;
            }
        }
        //remaining horizantal
        while(h<horCost.length){
             cost=cost+(horCost[h]*vp);
                h++;
                hp++;
        }
         //remaining vertical
        while(v<verCost.length){
             cost=cost+(verCost[v]*hp);
                v++;
                vp++;
        }
        System.out.println("Minimum cost required: "+cost);

    }
    
}
