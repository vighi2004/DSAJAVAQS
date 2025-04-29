//reverse Queue.
import java.util.*;
public class Qreverse {
    public static void reverse(Queue<Integer> Q) {
        if (Q.isEmpty()) {
            return;
        }
        int temp = Q.remove();
        reverse(Q);
        Q.add(temp);
    }

    public static void main(String[] args) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(1);
        Q.add(2);
        Q.add(3);
        Q.add(4);
        Q.add(5);
        reverse(Q);
        System.out.println(Q);
    }
}
