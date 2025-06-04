//finding string which of length N and sum of K.
package Greedy_Algo;
public class smallString {
    public static void main(String[] args) {
        int N = 5, K = 42;

        char[] result = new char[N];
        // Start with all 'a'
        for (int i = 0; i < N; i++) {
            result[i] = 'a';
        }
        int remaining = K - N;

        // Fill from end to start
        int index = N - 1;
        while (remaining > 0 && index >= 0) {
            int add = Math.min(25, remaining); 
            result[index] = (char) (result[index] + add);
            remaining -= add;
            index--;
        }

        System.out.println(new String(result));
    }
}
