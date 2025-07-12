//finding Minimum cost for aquiring all coins.
package Greedy_Algo;
import java.util.*;
public class minimumCostAquirAllCoins {
    public static void main(String[] args) {
        int arr[]={100,20,50,10,2,5};
        int k=3;
        int j=arr.length-1;
        Arrays.sort(arr);
        int mincost=0;
        int i=0;
        while(i<=j){
             mincost+=arr[i];
             j-=k;
             i++;
        }
        System.out.println("minimum cost required: "+mincost);
    }
    
}
