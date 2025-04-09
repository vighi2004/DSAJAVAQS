//Stack using 2 queues.
package Queues;
import java.util.*;
public class StkUsing2Q {
    public static void popy(Queue<Integer> q1,Queue<Integer> q2){
            if (q1.isEmpty()) {
                System.out.println("STACK IS EMPTY");
                return;
            }
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }
        
            // Remove the last element
            q1.remove();
        
            // Move elements back to q1
            while (!q2.isEmpty()) {
                q1.add(q2.remove());
            }
        }
        public static int top(Queue<Integer> q1, Queue<Integer> q2) {
                if (q1.isEmpty()) {
                    System.out.println("STACK IS EMPTY");
                    return -1; // or throw exception
                }
            
                // Move all but last element to q2
                while (q1.size() > 1) {
                    q2.add(q1.remove());
                }
            
                // Get the last element (the top of the stack)
                int topElement = q1.peek();
            
                // Move it
                q2.add(q1.remove());
            
                // Restore everything back to q1
                while (!q2.isEmpty()) {
                    q1.add(q2.remove());
                }
            
                return topElement;
            }
    public static void main(String[] args) {
        Queue<Integer> q1=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        popy(q1, q2);
        popy(q1, q2);
        q1.add(44);
        q1.add(100);
        System.out.println(q1);
        System.out.println(top(q1,q2));
    
    }
}
