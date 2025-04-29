//reversing first K elements from queue rest all keeping same order.
import java.util.*;
public class ReverseKELE {
    public static void reverse(Queue<Integer> Q, Stack<Integer> S, int k) {
        int size = Q.size();
        for (int i = 0; i < k; i++) {
            S.push(Q.remove());
        }
        while (!S.isEmpty()) {
            Q.add(S.pop());
        }
        for (int i = 0; i < size - k; i++) {
            Q.add(Q.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> Q = new LinkedList<>();
        Stack<Integer> S = new Stack<>();
        int k = 5;

        Q.add(10);
        Q.add(20);
        Q.add(30);
        Q.add(40);
        Q.add(50);
        Q.add(60);
        Q.add(70);
        Q.add(80);
        Q.add(90);
        Q.add(100);

        reverse(Q, S, k);
        System.out.println(Q);
    }
}
