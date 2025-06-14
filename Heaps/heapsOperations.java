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
        public int peek(){
             if(arr.size()>0){
             return arr.get(0);
             }
             return 0;
        }
        private void heapify(int i){
            int left=2*i+1;
            int right=2*i+2;
            int minIdx=i;
            if(left<arr.size()&&arr.get(minIdx)>arr.get(left)){
                minIdx=left;
            }
            if(right<arr.size()&&arr.get(minIdx)>arr.get(right)){
                minIdx=right;
            }
            if(minIdx!=i){
                //swap 
                int temp=arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx,temp);
                heapify(minIdx);
            }
            
        }
        //In minHeap we delete root beacuse it is minimun.
        public int delete(){
            int temp=arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);
            if(arr.size()>0){
                arr.remove(arr.size()-1);
                heapify(0);
                return temp;
            }
            return 0;
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
        System.out.println(hp.peek());
        System.out.println("Element deleted root is: "+hp.delete());
        
     }
}
