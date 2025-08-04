//Counting distinct element at particular k range.
package Hashing;
import java.util.*;
public class CountDistinctEleK{
    public static void main(String[] args) {
        ArrayList <Integer> res=new ArrayList<>();
        HashMap <Integer,Integer> hm=new HashMap<>();
        int k=4;
        int arr[]={1,2,1,3,4,2,3};
        for(int i=0;i<k;i++){
           hm.put(arr[i], hm.getOrDefault(arr[i],0)+1);        
        }
        res.add(hm.size());
        for(int i=k;i<arr.length;i++){
            int delete=arr[i-k];
            hm.put(delete,hm.get(delete)-1);
            if(hm.get(delete)==0){
                hm.remove(delete);
            }
            int insert=arr[i];
            hm.put(insert,hm.getOrDefault(insert, 0)+1);
            res.add(hm.size());
        }
        System.out.println(res);
}
}