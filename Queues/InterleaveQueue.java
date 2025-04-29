//Interleave 2 Halves of Queues(even length).
import java.util.*;
public class InterleaveQueue {
     public static void merge( Queue <Integer> Half1, Queue <Integer> Half2){
            int count=0;
            while(count<=((Half2.size())/2)+1){
                Half1.add(Half2.peek());
                Half2.remove();
                count++;
            }
            while(!Half1.isEmpty() && !Half2.isEmpty()){
                  Half2.add(Half1.peek());
                  Half2.add(Half2.peek());
                  Half1.remove();
                  Half2.remove();
            }     
     }
     public static void main(String[] args) {
        Queue <Integer> Half1=new LinkedList<>();
        Queue <Integer> Half2=new LinkedList<>();//In this intial Queue is their.12345678910
        Half2.add(1);
        Half2.add(2);
        Half2.add(3);
        Half2.add(4);
        Half2.add(5);
        Half2.add(6);
        Half2.add(7);
        Half2.add(8);
        Half2.add(9);
        Half2.add(10);
        merge(Half1,Half2);
        System.out.println(Half2);
     }   
}
