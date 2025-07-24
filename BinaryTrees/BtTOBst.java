//no.of swaps required to convert BT to BST.
package BinaryTrees;
import java.util.Arrays;
public class BtTOBst {
    // Pair class to hold value and its original index
    static class Pair implements Comparable<Pair> {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            return this.value - other.value;
        }
    }

    // Function to calculate minimum number of swaps to sort the array
    public static int checkSwap(int arr[]) {
        int n = arr.length;
        Pair[] pairs = new Pair[n];

        // Step 1: Store value with original index
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i], i);
        }

        // Step 2: Sort the array by value
        Arrays.sort(pairs);

        // Step 3: Create visited array
        boolean[] visited = new boolean[n];
        int swaps = 0;

        // Step 4: Traverse all cycles
        for (int i = 0; i < n; i++) {
            // If already visited or already in correct position
            if (visited[i] || pairs[i].index == i) {
                continue;
            }

            // Compute size of the cycle
            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = pairs[j].index; // move to next index in cycle
                cycleSize++;
            }

            // If cycle size > 1, then (cycleSize - 1) swaps are needed
            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        // Example in-order traversal of binary tree (not BST)
        int arr[] = {5, 6, 7, 8, 9, 10, 11}; // Already sorted => 0 swaps

        System.out.println("Number of swaps required: " + checkSwap(arr));
    }
}
