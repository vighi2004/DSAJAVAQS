// Surpasser Count of Each Element in Array using BST
package Heaps;

public class SuprassarCountEle {

    static class Node {
        int data;
        int rightCount; 
        Node left, right;

        Node(int data) {
            this.data = data;
            this.rightCount = 0;
            this.left = null;
            this.right = null;
        }
    }
    public static int insert(Node root, int data) {
        int count = 0;
        Node curr = root;

        while (true) {
            if (data < curr.data) {
                count += curr.rightCount + 1;

                if (curr.left == null) {
                    curr.left = new Node(data);
                    break;
                } else {
                    curr = curr.left;
                }
            } else {
                curr.rightCount++;

                if (curr.right == null) {
                    curr.right = new Node(data);
                    break;
                } else {
                    curr = curr.right;
                }
            }
        }
        return count;
    }

    // Driver
    public static void main(String[] args) {
        int arr[] = {2, 7, 5, 3, 8, 1};
        int n = arr.length;
        int[] res = new int[n];

        // build from right to left
        Node root = new Node(arr[n - 1]); // last element
        res[n - 1] = 0; // last element has no surpassers

        for (int i = n - 2; i >= 0; i--) {
            res[i] = insert(root, arr[i]);
        }

        // Print result
        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}
