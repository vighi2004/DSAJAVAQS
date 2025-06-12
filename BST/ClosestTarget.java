//finding closest target integer in tree.
package BST;
public class ClosestTarget {
     static class node{
        int data;
        node left,right;

        node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
  public static int getDifference(node root, int x) {
    if (root == null) {
        return Integer.MAX_VALUE;
    }
    int currDiff = Math.abs(x - root.data);
    if (x < root.data) {
        return Math.min(currDiff, getDifference(root.left, x));
    } else if (x > root.data) {
        return Math.min(currDiff, getDifference(root.right, x));
    } else {
        return 0;
    }
}

    public static node ClosestNode(node root,int x,int diff){
           if(root==null){
            return null;
           }
           if(Math.abs(root.data-x)==diff){
              return root;
           }
           if(root.data>=x){
             return ClosestNode(root.left, x,diff);
              }
           if(root.data<=x){
              return ClosestNode(root.right, x,diff);
              }
            return root;  
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
            int x=5;//target
            int diff=getDifference(root,x);
            System.out.println(ClosestNode(root, x,diff).data);
        
    }
}
