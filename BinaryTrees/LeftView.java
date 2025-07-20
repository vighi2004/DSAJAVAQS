//BFS 
package BinaryTrees;
import java.util.*;
public class LeftView {
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
        static int idx=-1;
       public static node BuildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            node newNode=new node(nodes[idx]);
            newNode.left=BuildTree(nodes);
            newNode.right=BuildTree(nodes);
            return newNode;
    }
    public static void levelorder(node root){
        Queue <node> Q=new LinkedList<>();
        Q.add(root);
        Q.add(null);
        int level=0;
        while(!Q.isEmpty()){
               node curr=Q.remove();
               if(curr==null){
                  System.out.println();
                  level=0;
                  if(!Q.isEmpty()) {
                    Q.add(null);
                 }
               }
               else{
                if(level==0){
                System.out.print(curr.data);
                level++;
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
                //   1
                //  / \
                // 2   3
                //  \
                //   4
                //    \
                //     5
                //      \
                //       6
        node root=new node(1);
        root.left=new node(2);
        root.right=new node(3);
        root.left.right=new node(4);
        root.left.right.right=new node(5);
        root.left.right.right.right=new node(6);
        tree.levelorder(root);
    }
}
