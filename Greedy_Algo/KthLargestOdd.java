//finding kth largest odd number from given range.
package Greedy_Algo;
import java.util.*;
public class KthLargestOdd {
    public static void main(String[] args) {
    int L=-3,R=3;
    ArrayList <Integer> arr=new ArrayList<>();
    int K=6;
    for(int i=L;i<=R;i++){
        if(i%2!=0){
        arr.add(i);
        }
    }
    Collections.sort(arr,Collections.reverseOrder());//descending order.
    //now finding kth largest odd.
    if(K<=arr.size()){
    System.out.println(arr.get(K-1));
    }
    else{
        System.out.println(0);
    }
}
}
