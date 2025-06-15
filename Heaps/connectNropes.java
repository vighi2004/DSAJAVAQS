//Coonecting N ropes with minimum cost.
package Heaps;
import java.util.*;
public class connectNropes {
    public static void main(String[] args) {
        int arr[]={4,3,2,6};
        PriorityQueue <Integer> PQ=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            PQ.add(arr[i]);
        }
        while(!PQ.isEmpty()&&PQ.size()!=1){
               int a=PQ.remove();
               int b=PQ.remove();
               PQ.add(a+b);
        }
        System.out.println("Minimum cost to connect ropes: "+PQ.peek());

    }
    
}
