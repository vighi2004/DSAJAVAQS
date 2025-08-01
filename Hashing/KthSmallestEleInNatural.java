//finding kth smaleest elemnt in natural number after removing specific element. 
package Hashing;
import java.util.*;
public class KthSmallestEleInNatural {
    public static void main(String[] args) {
    HashSet<Integer> set=new HashSet<>();
    int arr[]={1,3};
    for(int i=0;i<arr.length;i++){
        set.add(arr[i]);
    }
    int k=4;
    int count=0;
    int n=Integer.MAX_VALUE;
    for(int i=1;i<n;i++){
       if(!set.contains(i)){
          count++;
       } 
        if(count==k){
            System.out.print("kth small ele is: "+i);
            break;
        }
    }
}
}
