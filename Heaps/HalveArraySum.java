//Minimum operation to halve Array sum;Time-O(K.logn)
package Heaps;
import java.util.*;
public class HalveArraySum {
    public static void main(String[] args) {
        PriorityQueue <Double> PQ=new PriorityQueue<>(Comparator.reverseOrder());
        int op=0;
        double arr[]={1,5,8,19};
        for(int i=0;i<arr.length;i++){
            PQ.add(arr[i]);
        }
        double Totalsum=0;
        for(int i=0;i<arr.length;i++){
           Totalsum=Totalsum+arr[i];
        }
        double currsum=Totalsum;
        double TargetSum=Totalsum/2;
        while(currsum>TargetSum){
             double num=PQ.remove();
             double val=num/2;
             PQ.add(val);
             currsum=currsum-val;
             System.out.println(currsum);
             op++;
        }
        System.out.println("Operation required: "+op);
    }
}
