//finding kth smallest element in tree.
package BST;
public class KthSmallest {
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
    public static void KthSmall(node root,int k){
        if(root==null){
            return;
        }
        KthSmall(root.left,k);
        count++;
        if(count==k){
            System.out.println("Kth smallest element is : "+root.data);
            return;
        }
        KthSmall(root.right, k);
        
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
            int k=5;//target
            KthSmall(root,k);    
    

    }
    
}
