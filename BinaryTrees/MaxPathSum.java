//finding maximum path sum in BT.
package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxPathSum {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node buildTree(String[] arr) {
        if (arr.length == 0 || arr[0].equals("N")) return null;

        Node root = new Node(Integer.parseInt(arr[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();

            // Left child
            if (!arr[i].equals("N")) {
                current.left = new Node(Integer.parseInt(arr[i]));
                queue.add(current.left);
            }
            i++;
            if (i >= arr.length) break;

            // Right child
            if (!arr[i].equals("N")) {
                current.right = new Node(Integer.parseInt(arr[i]));
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
    public static int maxsum=Integer.MIN_VALUE;
    public static int maxPath(Node root){
        if(root==null){
            return 0;
        }
        int leftSum=Math.max(0,maxPath(root.left));
        int rightSum=Math.max(0,maxPath(root.right));
        maxsum=Math.max(maxsum,root.data+leftSum+rightSum);
        return root.data+Math.max(leftSum, rightSum);
    }   
    public static void main(String[] args) {
        String nodes[]={"-10","9","20","N","N","15","7"};
        Node root=buildTree(nodes);
        maxPath(root);
        System.out.println("max path is: "+maxsum);
        
    }
    
}
