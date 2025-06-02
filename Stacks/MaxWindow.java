//need to solve ....
import java.util.*;
public class MaxWindow {

    public static void Work(int[] arr, int[] res) {
        Stack<Integer> S1 = new Stack<>();
        int n = arr.length;

        int[] left = new int[n];  // Previous smaller element
        int[] right = new int[n]; // Next smaller element

        // Fill left[]: index of previous smaller
        for (int i = n - 1; i >= 0; i--) {
            while (!S1.isEmpty() && arr[S1.peek()] >= arr[i]) {
                S1.pop();
            }
            if (S1.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = S1.peek();
            }
            S1.push(i);
        }

        // Clear the stack to reuse
        S1.clear();

        // Fill right[]: index of next smaller
        for (int i = 0; i < n; i++) {
            while (!S1.isEmpty() && arr[S1.peek()] >= arr[i]) {
                S1.pop();
            }
            if (S1.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = S1.peek();
            }
            S1.push(i);
        }

        // Initialize result array
        for (int i = 0; i < n; i++) {
            res[i] = Integer.MIN_VALUE;
        }

        // Process all elements to get max of minimums
        for (int i = 0; i < n; i++) {
          int len = right[i] - left[i] - 1;
          if (len >= 1 && len <= res.length) {  // Check len in valid range
              if (res[len - 1] < arr[i]) {
                  res[len - 1] = arr[i];
              }
          }
          
        }

        // Fill remaining with max of next
        for (int i = n - 2; i >= 0; i--) {
            if (res[i] < res[i + 1]) {
                res[i] = res[i + 1];
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {10,20,30};
        int res[] = new int[arr.length];

        Work(arr, res);

        System.out.print("Output: ");
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}
