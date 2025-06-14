//operations performing using Arraylist.
package Heaps;
import java.util.*;
public class heapsOperations {
     static class heap{
        ArrayList <Integer> arr=new ArrayList<>();
        public void insert(int data){   
             arr.add(data);
             int x=arr.size()-1;//child index
             int par=(x-1)/2;//parent index

             while(arr.get(x)<arr.get(par)){//(logn) bassically height of tree.
                //swap
                 int temp=arr.get(x);
                 arr.set(x,arr.get(par));
                 arr.set(par,temp);
                 x=par;
                 par=(x-1)/2;
               }
               System.out.println(arr);
        }
     }
     public static void main(String[] args) {
        heap hp=new heap();
        hp.insert(2);
        hp.insert(3);
        hp.insert(4);
        hp.insert(5);
        hp.insert(10);
        hp.insert(1);
        System.out.println();
        
     }
}
