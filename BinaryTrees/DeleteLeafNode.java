//deleting leaf nodes of of target value x. 
package BinaryTrees;
import java.util.*;
public class DeleteLeafNode {
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
        public static node delN(node root,int x){
            if(root==null){
                return null;
            }
            root.left=delN(root.left, x);
            root.right=delN(root.right, x);
            if(root.left==null&&root.right==null &&root.data==x){
                return null;
            }
            return root;
        }

    }
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
            //        1
            //      /    \
            //     3      3
            //    / \    
            //   3   2   
        node root=new node(1);
        root.left=new node(3);
        root.right=new node(3);
        root.left.left=new node(3);
        root.left.right=new node(2);
        int x=3;//target x
        tree.delN(root,x);
        tree.levelorder(root);
        
    }
    
}
