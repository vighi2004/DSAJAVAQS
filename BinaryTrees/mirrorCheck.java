//transfroming to sum of tree
package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class mirrorCheck{
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
        public static void levelorder(node root){
        Queue <node> Q=new LinkedList<>();
        Q.add(root);
        Q.add(null);
        while(!Q.isEmpty()){
               node curr=Q.remove();
               if(curr==null){
                  System.out.println();
                  if(!Q.isEmpty()) {
                   Q.add(null);
                 }
               }
               else{
                System.out.print(" "+curr.data);
               if(curr.left!=null){
                 Q.add(curr.left);
               }
               if(curr.right!=null){
                  Q.add(curr.right);
               }
               }
        }
       }
        public static void mirror(node root){
           if(root==null){
            return;
           }
            node temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirror(root.left);
            mirror(root.right);
           }
           public static boolean compare(node root,node rootm){
            //check like preorder.
            if(root==null||rootm==null){
                return true;
            }
            if(root.data!=rootm.data){
                return false;
            }
            return compare(root.left,rootm.left) && compare(root.right,rootm.right);
        }
        }
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
            //        1
            //      /    \
            //     2      3
            //    / \    / \
            //   4   5   6  7
        node root=new node(1);
        root.left=new node(2);
        root.right=new node(3);
        root.left.left=new node(4);
        root.left.right=new node(5);
        root.right.left=new node(6);
        root.right.right=new node(7);

                    //         1
                    //       /   \
                    //      3     2   mirror tree
                    //     / \   / \ 
                    //    7   6 5   4
        node rootm=new node(1);
        rootm.left=new node(3);
        rootm.right=new node(2);
        root.left.left=new node(7);
        root.left.right=new node(6);
        root.right.left=new node(5);
        root.right.right=new node(4);           
        tree.mirror(root);//making mirror of 1st tree 
        //compare treee of root and rootm.
        if(tree.compare(root,rootm)){
            System.out.println("Both Tree are mirror of each other");
        }
        else{
            System.out.println("NO mirror Tree");
        }
    }
    
}
