//finding minimum distance between two nodes.
package BinaryTrees;
import java.util.ArrayList;
public class minDist {
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
            public static int minDis(node root,int n1,int n2){ 
                node lca=LCA1(root,n1,n2);
                int dist1=lcaDis(lca,n1);
                int dist2=lcaDis(lca,n2);
                return dist1+dist2;
            }
            public static int lcaDis(node root,int n){
                  if(root==null){
                      return -1;
                  }
                  if(root.data==n){
                      return 0;
                  }
                 int left=lcaDis(root.left, n);
                 int right=lcaDis(root.right, n);
                 if(left!=-1){
                    return left+1;
                 }
                 if(right!=-1){
                    return right+1;
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
        int n1=4;
        int n2=5;
        node root=new node(1);
        root.left=new node(2);
        root.right=new node(3);
        root.left.left=new node(4);
        root.left.right=new node(5);
        root.right.left=new node(6);
        root.right.right=new node(7);
        System.out.println("Distance between two nodes is: "+tree.minDis(root, n1, n2));

        }
    }
    
