//BFS 
package BinaryTrees;
import java.util.*;
public class LevelOrder {
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
        while(!Q.isEmpty()){
               node curr=Q.remove();
               if(curr==null){
                  System.out.println();
                  if(!Q.isEmpty()) {
                   Q.add(null);
                 }
               }
               else{
                System.out.print(curr.data);
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
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();
        node root=tree.BuildTree(nodes);
        tree.levelorder(root);
    }
}
