//kth largest elemnt in stream.
package Heaps;
import java.util.*;
public class KLargestEkeStr {
    public static void main(String[] args) {
        int arr[]={10,20,5,15};
        int k=2;
        PriorityQueue <Integer> res=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            res.add(arr[i]);
            if(res.size() > k) {
                res.remove();
            }
            if(res.size() < k) {
                System.out.print("-1 ");
            } else {
                System.out.print(res.peek() + " ");
            }
        }
    }
}
