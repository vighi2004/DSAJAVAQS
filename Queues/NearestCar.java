package Queues;
import java.util.*;
public class NearestCar {
    static class points implements Comparable<points>{
        int x;
        int y;
        int C;//car point
        int distSq;
        
        public points(int x,int y,int distSq,int C){
            this.x=x;
            this.y=y;
            this.distSq=distSq;
            this.C=C;
        }
    @Override
    public int compareTo(points p2){
        return this.distSq-p2.distSq;
    }    
    }

     public static void main(String[] args) {
        int arr[][]={{3,3},{5,-1},{2,4}};
        int k=2;
        PriorityQueue <points> PQ=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            int distSq=arr[i][0]*arr[i][0]+arr[i][1]*arr[i][1];
            PQ.add(new points(arr[i][0],arr[i][0],distSq,i));
        }
        for(int i=0;i<k;i++){
        System.out.println("Car point C"+PQ.peek().C+"->"+PQ.peek().distSq);
        PQ.remove();
        }

        
     }
    

}
