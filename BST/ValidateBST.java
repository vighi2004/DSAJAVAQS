//checking whether tree is BST.
package BST;

import java.util.ArrayList;

public class ValidateBST {
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
        public static boolean validCheck(node root,int min,int max){
            if(root==null){
                return true;
            }
            if (root.data <= min || root.data >= max) {
                return false;
               }
            return validCheck(root.left,min,root.data)&&validCheck(root.right,root.data,max);
           }
       }
       public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
            //        1
            //      /    \
            //     2      3
            //    / \    / \
            //   4   5   6  7
        node root=new node(8);
        root.left=new node(4);
        root.right=new node(10);
        root.left.left=new node(3);
        root.left.right=new node(5);
        root.right.left=new node(9);
        root.right.right=new node(11);
        if(tree.validCheck(root,Integer.MIN_VALUE, Integer.MAX_VALUE)){
            System.out.println("This is BST!");
        }
        else{
            System.out.println("This is not BST!");
        }
       }    
}
