//check whether tree is balaced by height lesser than 1 should be there.
package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BalanceTree {
    static class node{
        int data;
        node left;
        node right;
        public node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
     public static node buildTree(String[] arr) {
        if (arr.length == 0 || arr[0].equals("N")) return null;

        node root = new node(Integer.parseInt(arr[0]));
        Queue<node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            node current = queue.poll();

            // Left child
            if (!arr[i].equals("N")) {
                current.left = new node(Integer.parseInt(arr[i]));
                queue.add(current.left);
            }
            i++;
            if (i >= arr.length) break;

            // Right child
            if (!arr[i].equals("N")) {
                current.right = new node(Integer.parseInt(arr[i]));
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
    public static boolean isBalanced(node root){
        return check(root)!=-1;
    }
    public static int check(node root){
            if(root==null){
                return 0;
            }
            int LN=check(root.left);//left node
            if(LN==-1){
                return -1;
            }
            int RN=check(root.right);//right node
            if(RN==-1){
                return -1;
            }
            if(Math.abs(LN-RN)>1){
                return -1;
            }
            return Math.max(LN,RN)+1;
    }
    public static void main(String[] args) {
         String[] input = {"10", "20", "30", "40", "3"};
        node root = buildTree(input);
        System.out.println(isBalanced(root));
    }
    
}
