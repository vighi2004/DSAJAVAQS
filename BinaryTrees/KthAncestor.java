//finding kth ancestor of particular node;
package BinaryTrees;
import java.util.*;
public class KthAncestor {
     static class node{
        int data;
        node left;
        node right;
        node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree{
       public static int kthAncestor(node root, int n, int k) {
    if (root == null) return -1;
    if (root.data == n) return 0;

    int leftDist = kthAncestor(root.left, n, k);
    int rightDist = kthAncestor(root.right, n, k);

    if (leftDist != -1) {
        if (leftDist + 1 == k) System.out.println("Kth ancestor is: " + root.data);
        return leftDist + 1;
    }

    if (rightDist != -1) {
        if (rightDist + 1 == k) System.out.println("Kth ancestor is: " + root.data);
        return rightDist + 1;
    }

    return -1;
}

    }

    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
            //        1
            //      /    \
            //     2      3
            //    / \    / \
            //   4   5   6  7
        int n=5;
        int k=1;
        node root=new node(1);
        root.left=new node(2);
        root.right=new node(3);
        root.left.left=new node(4);
        root.left.right=new node(5);
        root.right.left=new node(6);
        root.right.right=new node(7);
        tree.kthAncestor(root,n,k);
        
    }
    
}
