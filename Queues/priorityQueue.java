//printing queue.
package Queues;
import java.util.*;
public class priorityQueue{
    public static void main(String[] args) {
        PriorityQueue<Integer> PQ=new PriorityQueue<>();
        PQ.add(4);
        PQ.add(5);
        PQ.add(3);
        PQ.add(1);
        PQ.add(2);

        while(!PQ.isEmpty()){
            System.out.println(PQ.peek());
            PQ.remove();
        }
    }
}
