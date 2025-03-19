//working ...
public class MinimumPages {
    public static int minimumpage(int[] arr, int start, int n, int k) {
        // Base Cases
        if (n == k) { // Each student gets exactly one book
            int maxPages = 0;
            for (int i = start; i < start + n; i++) {
                maxPages = Math.max(maxPages, arr[i]); 
            }
            return maxPages;
        } 
        if (k == 1) { // One student left, assign all remaining books
            int totalPages = 0;
            for (int i = start; i < start + n; i++) {
                totalPages += arr[i];
            }
            return totalPages;
        }
        if (k > n) return -1; // More students than books, not possible

        // Recursive Partitioning
        int sum = 0;
        int minPage = Integer.MAX_VALUE; // Initialize to track minimum of max pages

        for (int i = start; i < start + n - 1; i++) { // Loop until `n - 1`
            sum += arr[i]; // Assign books to first student
            int remainingPages = minimumpage(arr, i + 1, n - (i - start + 1), k - 1); // Recur for remaining books
            int maxPages = Math.max(sum, remainingPages); // Max pages assigned in this split
            minPage = Math.min(minPage, maxPages); // Track minimum of all valid partitions
        }

        return minPage;
    }

    public static void main(String[] args) {
        int arr[] = {12, 34, 67, 90};
        int k = 2;
        int n = arr.length;
        System.out.println(minimumpage(arr, 0, n, k)); // Output: 113
    }
}
