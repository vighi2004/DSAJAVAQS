//finding rows with weakest soldiers.
package Heaps;
import java.util.*;
public class WeakestSoldiers {
    static class Rows implements Comparable<Rows>{
          int count;
          int idx;
          public Rows(int count,int idx){
             this.count=count;
             this.idx=idx;
          }
          @Override
          public int  compareTo(Rows R2){
            if(this.count==R2.count){
                return this.idx-R2.idx;
            }
            else{
            return this.count-R2.count;
          }}
    }
    public static void main(String[] args) {
        int arr[][]={{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int k=2;
        PriorityQueue <Rows> PQ=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            int count=0;
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1){
                    count++;
                }
            }
            PQ.add(new Rows(count,i));
        }
        for(int i=0;i<k;i++){
            System.out.println("ROW"+PQ.remove().idx);
        }
    }
    
}
