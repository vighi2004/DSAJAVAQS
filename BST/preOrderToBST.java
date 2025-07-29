//preorder to BST then print postorder.
package BST;
public class preOrderToBST {
    static class node{
        int data;
        node left;
        node right;
        public node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static int index=0;
    public static node buildT(int arr[],int min,int max){
        if(index>=arr.length){
            return null;
        }
        int data=arr[index];
         if (data < min || data > max) return null;
        node newnode=new node(data);
        index++;
        newnode.left=buildT(arr, min, data-1);
        newnode.right=buildT(arr, data+1, max);
        return newnode;
    }
    public static void postOrder(node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(" " + root.data);

    }
    public static void main(String[] args) {
        int arr[]={40,30,35,80,100};
        node root=buildT(arr,Integer.MIN_VALUE,Integer.MAX_VALUE);
        postOrder(root);
    }
}
