//checking isophormism if possible.
package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class isophormism {
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
    public static boolean checkIso(Node root1,Node root2){
        if(root1==null&&root2==null){
            return true;
        }
        if(root1==null||root2==null){
            return false;
        }
        if(root1.data!=root2.data){
            return false;
        }
        return (
        (checkIso(root1.left, root2.left) && checkIso(root1.right, root2.right)) || 
       (checkIso(root1.left, root2.right) && checkIso(root1.right, root2.left))
       );

    }
    public static void main(String[] args) {
        String[] input1 = {"1", "2", "3", "4"};
        Node root1 = buildTree(input1);
        String[] input2 = {"1", "3", "2", "N","N","N","4"};
        Node root2 = buildTree(input2);
        System.out.println(checkIso(root1,root2));
    }
    
}
