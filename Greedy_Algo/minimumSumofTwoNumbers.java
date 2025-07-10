//minimum sum of two numbers formed y digits array.solved uisng min heap(PQ).
package Greedy_Algo;

import java.util.PriorityQueue;

import javax.print.DocFlavor.STRING;

public class minimumSumofTwoNumbers {
    public static void main(String[] args) {
        int arr[]={6,8,4,5,2,3};
        PriorityQueue<Integer> PQ=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            PQ.add(arr[i]);
        }
        long num1=0;
        long num2=0;
        while(!PQ.isEmpty()){
            num1=num1*10+PQ.remove();
            if(!PQ.isEmpty()){
              num2=num2*10+PQ.remove();
            }
            else{
                break;
            }
        }
        long minSum=num1+num2;
        System.out.println("minimum sum is: "+minSum);
    }
    
}
