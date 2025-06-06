//checking whetehr subroot tree their in main tree return true/false.
package BinaryTrees;

import BinaryTrees.SubtreeOfAnother.BinaryTree;
public class SubtreeOfAnother {
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
        public static boolean isIdentical(node root,node subroot){
            if(root==null&&subroot==null){
                return true;
            }
            if(root==null||subroot==null){
                return false;
            }
            if(root.data!=subroot.data){
                return false;
            }
            return isIdentical(root.left, subroot.left) && isIdentical(root.right, subroot.right);
        }    
        public static boolean check(node root,node root1){
            if(root==null){
                return false;
            }
            if(isIdentical(root,root1)){
                 return true;
            }
            return check(root.left, root1)||check(root.right, root1);
        }
    }
    public static void main(String[] args) {
        //     1          2
        //   /  \        / \
        //  2    3      4   5
        // / \    \
        // 4 5     6
        BinaryTree tree=new BinaryTree();
        node root=new node(1);
        root.left=new node(2);
        root.right=new node(3);
        root.left.left=new node(4);
        root.left.right=new node(5);
        root.right.right=new node(6);

        node root1=new node(2);
        root1.left=new node(4);
        root1.right=new node(5);
        System.out.println("check: "+tree.check(root,root1));

    }
    
}
