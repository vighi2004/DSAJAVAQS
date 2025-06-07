//Lowest common ancester between two nodes given in O(n).
package BinaryTrees;
import java.util.*;
public class LCA {
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
        public static boolean getPath(node root,int n, ArrayList<node> path){
            if(root==null){
                return false;
            }
            path.add(root);
            if(root.data==n){
                return true;
            }
            boolean foundLeft=getPath(root.left, n, path);
            boolean foundRight=getPath(root.right, n, path);
            if(foundLeft||foundRight){
                return true;
            }
            path.remove(path.size()-1);
            return false;

        }
        //first approach.O(N)-time and O(N)-space.
        public static node LCA(node root,int n1,int n2){
            ArrayList <node> path1=new ArrayList<>();
            ArrayList <node> path2=new ArrayList<>();
            getPath(root,n1,path1);
            getPath(root,n2,path2);
            //last ancestor.
            int i=0;
            for(;i<path1.size() && i<path2.size();i++){
               if(path1.get(i)!=path2.get(i)){
                break;
               }
            }
            //last equal node
            node LCA=path1.get(i-1);
            return LCA; 
        }
        public static node LCA1(node root,int n1,int n2){
            if(root==null||root.data==n1||root.data==n2){
                return root;
            }
            node leftlca=LCA1(root.left, n1, n2);
            node rightlca=LCA1(root.right, n1, n2);
            if(rightlca==null){
                return leftlca;
            }
            if(leftlca==null){
                return rightlca;
            }
            return root;

        }

    }
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
            //        1
            //      /    \
            //     2      3
            //    / \    / \
            //   4   5   6  7
        int n1=4;
        int n2=5;
        node root=new node(1);
        root.left=new node(2);
        root.right=new node(3);
        root.left.left=new node(4);
        root.left.right=new node(5);
        root.right.left=new node(6);
        root.right.right=new node(7);
        System.out.println(tree.LCA(root,n1,n2).data);
         System.out.println(tree.LCA1(root,n1,n2).data);
    }
    
}
