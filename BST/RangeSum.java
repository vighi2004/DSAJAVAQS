//range in given sum that all nodes which lie in range.
package BST;
public class RangeSum {
    static class node{
        int data;
        node left,right;

        node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static int sum=0;
    public static int RangeSum(node root,int l,int r){
        if(root==null){
            return 0;
        }
        //skip left
        if (root.data < l) return RangeSum(root.right, l, r);

       // Skip right subtree
        if (root.data > r) return RangeSum(root.left, l, r);

       return root.data + RangeSum(root.left, l, r) + RangeSum(root.right, l, r);

    }
    public static void main(String[] args) {
            //     8
            //    /  \
            //   5    11
            //  / \    \
            // 3   6    20
            node root=new node(8);
            root.left=new node(5);
            root.right=new node(11);
            root.left.left=new node(3);
            root.left.right=new node(6);
            root.right.right=new node(20);
            int L=5;
            int R=11;
            System.out.println(RangeSum(root,L,R));
    }
}
