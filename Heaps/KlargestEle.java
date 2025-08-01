//printing k max elments from array.
package Heaps;
import java.util.*;
public class KlargestEle {
    public static void main(String[] args) {
        //O(nlogK)
        int k=3;
        int arr[]={1,23,12,9,30,2,50};
        PriorityQueue <Integer> mh=new PriorityQueue<>(k);
        for(int i=0;i<k;i++){
         mh.add(arr[i]);
    }
    for(int i=k;i<arr.length;i++){
        if(arr[i]>mh.peek()){
            mh.poll();
            mh.add(arr[i]);
        }
    }
    ArrayList <Integer> res=new ArrayList<>();
    while(!mh.isEmpty()){
        res.add(mh.poll());
    }
    Collections.sort(res);
    for(int i=0;i<res.size();i++){
        System.out.print(" "+res.get(i));
    } 
}
}