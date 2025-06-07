//transfroming to sum of tree
package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class Sumtree {
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
        public static int sum(node root){
           if(root==null){
            return 0;
           }
           int leftsum=sum(root.left);
           int rightsum=sum(root.right);
           int data=root.data;
           if(root.left!=null&&root.right!=null){
           root.data=root.left.data+leftsum+root.right.data+rightsum;
           }else{
            root.data=leftsum+rightsum;
           }
           return data;

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
        tree.sum(root);
        tree.levelorder(root);
    }
    
}
