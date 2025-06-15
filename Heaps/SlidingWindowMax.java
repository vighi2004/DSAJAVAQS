//finding max number from particular window;
package Heaps;
import java.util.*;

public class SlidingWindowMax {
    static class Pair implements Comparable<Pair> {
        int val, idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            return p2.val - this.val; // Max-heap
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // First window
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        System.out.print("Max in windows: " + pq.peek().val);

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            // Remove elements outside the window
            while (!pq.isEmpty() && pq.peek().idx <= i - k) {
                pq.remove();
            }

            pq.add(new Pair(arr[i], i));
            System.out.print(" " + pq.peek().val);
        }
    }
}
