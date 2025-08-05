//finding median from array data stream.
package Heaps;
import java.util.*;
public class FindMeadian {
    public static PriorityQueue <Integer> pqR=new PriorityQueue<>();//right heap(min heap)
    public static PriorityQueue<Integer> pqL= new PriorityQueue<Integer>(Collections.reverseOrder());//left heap(max heap); 
    public static double findMedian(){
        if((pqL.size()+pqR.size())%2==0){
            double a=(pqL.peek()+pqR.peek())/2.0;
            return a;
        }
        else{
            if(pqL.size()>pqR.size()){
                return pqL.peek();
            }
            else{
                return pqR.peek();
            }
        }

    }
    public static void add(int data){
        if(pqL.isEmpty()){
            pqL.add(data);
        }
        else{
            if(data<=pqL.peek()){
                pqL.add(data);
            }
            else{
                pqR.add(data);
            }
        }
        if(Math.abs(pqL.size()-pqR.size())>1){
             if(pqL.size()>pqR.size()){
                pqR.add(pqL.remove());
             }
             else{
                pqL.add(pqR.remove());
             }
        }
         if(!pqL.isEmpty()&&!pqR.isEmpty()&&pqL.peek()>pqR.peek()){
             //swap
             pqL.add(pqR.remove());
            pqR.add(pqL.remove());
         }
    }
    public static void main(String[] args) {      
           String arr[]={"MedianFinder","addNum","addNum","findMedian","addNum","findMedian"};
           int in[][]={{},{1},{2},{},{3},{}};
           for(int i=0;i<arr.length;i++){
            if(arr[i].equals("MedianFinder")){
                 System.out.print("null"+" ");
            }
            else if((arr[i].equals("addNum"))){
                 for(int j=0;j<in[i].length;j++){
                     add(in[i][j]);
                 }
                 System.out.print("null"+" ");
            }
            else{
                System.out.print(findMedian()+" ");
            }
           }    
        }
    
}
