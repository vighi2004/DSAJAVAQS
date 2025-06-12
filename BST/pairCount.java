//counting pairs of two sum BST where target is given.time-O(N*LOG(M))
//where N is BST1 all search and logm seach one at time.
//by using hashsets and iterative we can acheive O(N+M).
package BST;

public class pairCount {
    static class node{
        int data;
        node left,right;

        node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static int count=0;
    public static int pairCount(node root1,node root2,int x){
          if(root1==null){
            return 0;
          }
          int a=root1.data;
          int target=x-a;
          int b=BST2(root2, target);
          if(a+b==x){
             count++;
          }
          pairCount(root1.left, root2, x);
          pairCount(root1.right, root2, x);
          return count;
    }
    public static int BST2(node root2,int x){
          if(root2==null){
            return 0;
          }
          if(root2.data==x){
            return root2.data;
          }
          if(root2.data>x){
             return BST2(root2.left, x);
          }
          if(root2.data<x){
            return BST2(root2.right, x);
          }
          return 0;
    }
    public static void main(String[] args) {
            //BST 1
            //       5
            //      / \
            //     3   7
            //    / \ / \
            //    2 4 6 8
            node root1=new node(5);
            root1.left=new node(3);
            root1.right=new node(7);
            root1.left.left=new node(2);
            root1.left.right=new node(4);
            root1.right.right=new node(8);
            root1.right.left=new node(6);
            //BST 2
                //      10
                //     /   \
                //    6    15
                //   / \  /  \
                //   3 8 11 18
            node root2=new node(10);
            root2.left=new node(6);
            root2.right=new node(15);
            root2.left.left=new node(3);
            root2.left.right=new node(8);
            root2.right.right=new node(18);
            root2.right.left=new node(11);
            int x=16;
            System.out.println(pairCount(root1,root2,x));

    }
    
}
