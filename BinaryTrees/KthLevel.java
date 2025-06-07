//printing kth level uisng iterative way O(n).
package BinaryTrees;
import java.util.*;
public class KthLevel {
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
        public static void kthLevel(node root,int k){
           Queue <node> Q=new LinkedList<>();
           Q.add(root);
           Q.add(null);
           k--;
           while(!Q.isEmpty()){
             node curr=Q.remove();
             if(curr==null){
                k--;
                if(!Q.isEmpty()){
                    Q.add(null);
                }
             }
             else{
                if(k==0){
                System.out.print(curr.data);
                } 
               if(curr.left!=null){
                 Q.add(curr.left);
               }
               if(curr.right!=null){
                  Q.add(curr.right);
               }
            }
               
           }


        }
    }
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
            //        1
            //      /    \
            //     2      3
            //    / \    / \
            //   4   5   6  7
        int k=3;
        node root=new node(1);
        root.left=new node(2);
        root.right=new node(3);
        root.left.left=new node(4);
        root.left.right=new node(5);
        root.right.left=new node(6);
        root.right.right=new node(7);
        tree.kthLevel(root,k);
    }
    
}
