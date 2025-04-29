//solving this sum in brute force appraoch(ArrayList) for efficient we can use min-heap priority queue.
import java.util.*;
public class RopesCost {
    public static void main(String[] args) {
     int cost=0;
     int n=2;
     ArrayList <Integer> arr=new ArrayList<>();
     arr.add(1);
     arr.add(2);
     arr.add(3);
     //arr.add(6);
     for(int i=0;i<=n;i++){
        if(arr.size()>1){
           Collections.sort(arr);
           int tempCost=arr.get(0)+arr.get(1);
           arr.remove(0);
           arr.remove(0);
           arr.add(tempCost);
           cost=cost+tempCost;
        }
        else{
            System.out.println(cost);
            return;
        }
     }
     

    }    
}
